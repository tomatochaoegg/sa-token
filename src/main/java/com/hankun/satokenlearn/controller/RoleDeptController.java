package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.RoleDept;
import com.hankun.satokenlearn.service.impl.RoleDeptServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/role-dept")
@Api(value = "RoleDeptController", tags = {"操作接口"})
public class RoleDeptController extends BaseController<RoleDeptServiceImpl,RoleDept> {

}
