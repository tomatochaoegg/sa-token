package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Log;
import com.hankun.satokenlearn.service.impl.LogServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/log")
@Api(value = "LogController", tags = {"日志表操作接口"})
public class LogController extends BaseController<LogServiceImpl,Log> {

}
