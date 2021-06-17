package com.hankun.satokenlearn.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.hankun.satokenlearn.config.AuthService;
import com.hankun.satokenlearn.config.StpUserUtil;
import com.hankun.satokenlearn.constant.Constant;
import com.hankun.satokenlearn.constant.R;
import com.hankun.satokenlearn.constant.ReturnCode;
import com.hankun.satokenlearn.entity.UserInfo;
import com.hankun.satokenlearn.util.BPwdEncoderUtil;
import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyUser;
import com.hankun.satokenlearn.service.impl.MyUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@RestController
@RequestMapping("/my-user")
@Api(value = "MyUserController", tags = {"操作接口"})
@DS("db1")
@Slf4j
public class MyUserController extends BaseController<MyUserServiceImpl,MyUser> {

    @Autowired
    private AuthService authService;

    /**
     * 登录
     *
     * @param myUser
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiOperationSupport(order = 1, author = "dcy")
    public R<String> login(@Validated @ApiParam @RequestBody MyUser myUser) {
        // ----------------可以不调用------------------------
        MyUser userInfo = baseService.getUserInfoByUsername(myUser.getUserName());
        if (userInfo == null) {
            return R.error(ReturnCode.USER_PASSWORD_ERROR);
        }
        if (Constant.ZERO.equals(userInfo.getStatus())) {
            return R.error(ReturnCode.USER_LOCKED_ERROR);
        }
        if (!BPwdEncoderUtil.matches(myUser.getPassword(), userInfo.getPassword().replace("{bcrypt}", ""))) {
            return R.error(ReturnCode.USER_PASSWORD_ERROR);
        }
        // sa-token 登录 此处有多个api 基本满足所有的登录需求 很实用
        StpUserUtil.login(userInfo.getUserId());
        // 获取token
        SaTokenInfo tokenInfo = StpUserUtil.getTokenInfo();
        // 获取session
        SaSession saSession = StpUserUtil.getSession();
        // 设置用户信息 根据实际场景返回数据
        saSession.setAttribute(Constant.SESSION_USER_KEY, authService.getPermissionByUserId(userInfo.getUserId()));
        return success(tokenInfo.getTokenValue());
    }

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    @ApiOperationSupport(order = 10, author = "dcy")
    public R<String> test() {
        log.info("---------");
        return success("成功");
    }
}
