package com.hankun.satokenlearn.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.URLUtil;
import com.hankun.satokenlearn.entity.MyMenu;
import com.hankun.satokenlearn.entity.Resources;
import com.hankun.satokenlearn.service.MyMenuService;
import com.hankun.satokenlearn.service.ResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * @Author hankun
 * @Description 配置全局拦截器
 * @Date 2021/6/4
 * @Version 1.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private MyMenuService myMenuService;

    @Value("${ignored}")
    private List<String> ignored;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new SaRouteInterceptor(
                        ((saRequest, saResponse, o) -> {
                            String path = URLUtil.getPath(saRequest.getRequestPath());
                            //要求拦截的路径 先检测是否登录 多账号体系 可以通过添加路径前缀区分
                            //第一种用户体系
                            if (!path.startsWith("/my")){
                                SaRouterUtil.match("/**", StpUtil::checkLogin);
                                //检测权限 利用缓存机制 不用每次查询
                                List<Resources> routerList = resourcesService.getRouterList();
                                for (Resources resources : routerList) {
                                    // 如果URL匹配成功就不循环了，直接退出循环
                                    // 如果匹配不成功就匹配 /** URL路径了
                                    if (antPathMatcher.match(resources.getResPath(), path) &&
                                            saRequest.getMethod().equalsIgnoreCase(resources.getHttpMethod())) {
                                        SaRouterUtil.match(Collections.singletonList(resources.getResPath()), () -> {
                                            StpUtil.checkPermission(resources.getResCode());
                                        });
                                        break;
                                    }
                                }
                            }else {
                                //第二种认证体系
                                SaRouterUtil.match("/**", StpUserUtil::checkLogin);
                                List<MyMenu> list = myMenuService.list();
                                for (MyMenu resources : list) {
                                    if (StringUtils.isNotBlank(resources.getUrl())){
                                        //查询当前路径是否需要鉴权
                                        if (antPathMatcher.match(resources.getUrl(),path)&& StringUtils.isNotBlank(resources.getPermission())){
                                            StpUserUtil.checkPermission(resources.getPermission());
                                            break;
                                        }
                                    }
                                }
                            }
                        })
                )
        ).excludePathPatterns(ignored).addPathPatterns("/**");
    }
}
