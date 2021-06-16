package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Notice;
import com.hankun.satokenlearn.service.impl.NoticeServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 通知公告表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/notice")
@Api(value = "NoticeController", tags = {"通知公告表操作接口"})
public class NoticeController extends BaseController<NoticeServiceImpl,Notice> {

}
