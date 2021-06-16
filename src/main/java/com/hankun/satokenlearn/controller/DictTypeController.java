package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.DictType;
import com.hankun.satokenlearn.service.impl.DictTypeServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/dict-type")
@Api(value = "DictTypeController", tags = {"字典类型表操作接口"})
public class DictTypeController extends BaseController<DictTypeServiceImpl,DictType> {

}
