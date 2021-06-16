package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Config;
import com.hankun.satokenlearn.service.impl.ConfigServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/config")
@Api(value = "ConfigController", tags = {"参数配置表操作接口"})
public class ConfigController extends BaseController<ConfigServiceImpl,Config> {

}
