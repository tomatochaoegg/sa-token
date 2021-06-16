package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyUserJob;
import com.hankun.satokenlearn.service.impl.MyUserJobServiceImpl;
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
@RequestMapping("/my-user-job")
@Api(value = "MyUserJobController", tags = {"操作接口"})
public class MyUserJobController extends BaseController<MyUserJobServiceImpl,MyUserJob> {

}
