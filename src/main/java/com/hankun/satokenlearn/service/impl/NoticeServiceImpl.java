package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Notice;
import com.hankun.satokenlearn.mapper.NoticeMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class NoticeServiceImpl extends BaseService<NoticeMapper, Notice> implements NoticeService {

    /**
     * 获取表格数据
     *
     * @param notice
     * @return
     */
    public IPage<Notice> getPageListByEntity(Notice notice) {
        LambdaQueryWrapper<Notice> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(notice.getNoticeTitle()), Notice::getNoticeTitle, notice.getNoticeTitle());
        queryWrapper.like(StrUtil.isNotBlank(notice.getNoticeType()), Notice::getNoticeType, notice.getNoticeType());
        queryWrapper.like(StrUtil.isNotBlank(notice.getNoticeContent()), Notice::getNoticeContent, notice.getNoticeContent());
        queryWrapper.like(StrUtil.isNotBlank(notice.getNoticeStatus()), Notice::getNoticeStatus, notice.getNoticeStatus());
        return super.page(notice, queryWrapper);
    }

}
