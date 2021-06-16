package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.FileInfo;
import com.hankun.satokenlearn.service.impl.FileInfoServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 文件表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/file-info")
@Api(value = "FileInfoController", tags = {"文件表操作接口"})
public class FileInfoController extends BaseController<FileInfoServiceImpl,FileInfo> {

}
