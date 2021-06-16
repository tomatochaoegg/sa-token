package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Dept;
import com.hankun.satokenlearn.service.impl.DeptServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/dept")
@Api(value = "DeptController", tags = {"部门表操作接口"})
public class DeptController extends BaseController<DeptServiceImpl,Dept> {

}
