package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Job;
import com.hankun.satokenlearn.service.impl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 定时任务调度表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/job")
@Api(value = "JobController", tags = {"定时任务调度表操作接口"})
public class JobController extends BaseController<JobServiceImpl,Job> {

}
