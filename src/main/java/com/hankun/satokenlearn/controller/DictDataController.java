package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.DictData;
import com.hankun.satokenlearn.service.impl.DictDataServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/dict-data")
@Api(value = "DictDataController", tags = {"字典数据表操作接口"})
public class DictDataController extends BaseController<DictDataServiceImpl,DictData> {

}
