package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyMenu;
import com.hankun.satokenlearn.service.impl.MyMenuServiceImpl;
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
@RequestMapping("/my-menu")
@Api(value = "MyMenuController", tags = {"操作接口"})
public class MyMenuController extends BaseController<MyMenuServiceImpl,MyMenu> {

}
