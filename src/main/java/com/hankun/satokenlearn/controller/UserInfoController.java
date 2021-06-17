package com.hankun.satokenlearn.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.io.IoUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.hankun.satokenlearn.base.controller.BaseController;
import com.hankun.satokenlearn.constant.Constant;
import com.hankun.satokenlearn.constant.R;
import com.hankun.satokenlearn.constant.ReturnCode;
import com.hankun.satokenlearn.entity.UserInfo;
import com.hankun.satokenlearn.service.impl.UserInfoServiceImpl;
import com.hankun.satokenlearn.util.BPwdEncoderUtil;
import com.hankun.satokenlearn.util.RequestIpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/user-info")
@Api(value = "UserInfoController", tags = {"用户表操作接口"})
@Slf4j
public class UserInfoController extends BaseController<UserInfoServiceImpl,UserInfo> {

    /**
     * 登录
     *
     * @param loginInputDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiOperationSupport(order = 1, author = "dcy")
    public R<String> login(@Validated @ApiParam @RequestBody UserInfo loginInputDTO) {
        // ----------------可以不调用------------------------
        UserInfo userInfo = baseService.getUserInfoByUsername(loginInputDTO.getUsername());
        if (userInfo == null) {
            return R.error(ReturnCode.USER_PASSWORD_ERROR);
        }
        if (Constant.ONE.equals(userInfo.getUserStatus())) {
            return R.error(ReturnCode.USER_LOCKED_ERROR);
        }
        if (!BPwdEncoderUtil.matches(loginInputDTO.getPassword(), userInfo.getPassword().replace("{bcrypt}", ""))) {
            return R.error(ReturnCode.USER_PASSWORD_ERROR);
        }
//        LoginOutputDTO loginOutputDTO = mUserInfoMapper.userInfoToLoginOutputDTO(userInfo);
//        // 设置权限
//        loginOutputDTO.setResources(authService.getAuthRoleAndResourceByUserId(userInfo.getId()));
//        if (StrUtil.isNotBlank(userInfo.getDeptId())) {
//            loginOutputDTO.setDeptName(deptService.getById(userInfo.getDeptId()).getName());
//        }
//        List<Role> authRoleListByUserId = baseService.getAuthRoleListByUserId(userInfo.getId());
//        if (CollUtil.isNotEmpty(authRoleListByUserId)) {
//            loginOutputDTO.setRoleName(CollUtil.join(authRoleListByUserId.stream().map(Role::getRoleName).collect(Collectors.toList()), ","));
//        }
        // sa-token 登录 此处有多个api 基本满足所有的登录需求 很实用
        StpUtil.login(userInfo.getId());
        // 获取token
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 获取session
        SaSession saSession = StpUtil.getSession();
        // 设置用户信息
        saSession.setAttribute(Constant.SESSION_USER_KEY, "权限菜单信息");
        return success(tokenInfo.getTokenValue());
    }

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    @ApiOperationSupport(order = 10, author = "dcy")
    public R<String> test() {
        log.info("---------");
        return success("成功");
    }


    @PostMapping("/logout")
    @ApiOperation(value = "用户退出")
    @ApiOperationSupport(order = 10, author = "dcy")
    public R<String> logout() {
        StpUtil.logout();
        return success("退出成功");
    }
}
