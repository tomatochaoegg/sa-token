package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.JobLog;
import com.hankun.satokenlearn.service.impl.JobLogServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 定时任务调度日志表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/job-log")
@Api(value = "JobLogController", tags = {"定时任务调度日志表操作接口"})
public class JobLogController extends BaseController<JobLogServiceImpl,JobLog> {

}
