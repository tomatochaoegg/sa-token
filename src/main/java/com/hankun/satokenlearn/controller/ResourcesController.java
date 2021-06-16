package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Resources;
import com.hankun.satokenlearn.service.impl.ResourcesServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/resources")
@Api(value = "ResourcesController", tags = {"资源表操作接口"})
public class ResourcesController extends BaseController<ResourcesServiceImpl,Resources> {

}
