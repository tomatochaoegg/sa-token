package com.hankun.satokenlearn.base.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hankun.satokenlearn.base.model.PageModel;

import java.util.List;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    private static final String ORDER_ASC = "asc";

    /**
     * 分页查询 根据model查询
     *
     * @param entity       实体类（需要继承 PageModel）
     * @param queryWrapper 条件构造
     * @param <T1>
     * @return
     */
    public <T1> IPage<T1> page(T1 entity, Wrapper<T1> queryWrapper) {
        return (IPage<T1>) page(getPagePlusInfo(entity), (Wrapper<T>) queryWrapper);
    }

    /**
     * 分页查询 根据分页参数查询
     *
     * @param pageModel    分页参数
     * @param queryWrapper 条件构造
     * @param <T1>
     * @return
     */
    public <T1> IPage<T1> pageList(PageModel pageModel, Wrapper<T1> queryWrapper) {
        return (IPage<T1>) page(getPagePlusInfo(pageModel), (Wrapper<T>) queryWrapper);
    }

    /**
     * 获取分页参数
     *
     * @param entity
     * @return
     */
    protected IPage<T> getPagePlusInfo(Object entity) {
        PageModel pageModel = (PageModel) entity;
        Page<T> pagePlus = new Page<>();
        pagePlus.setCurrent(pageModel.getCurrent());
        pagePlus.setSize(pageModel.getSize());
        if (StrUtil.isNotBlank(pageModel.getOrder()) && StrUtil.isNotBlank(pageModel.getSort())) {
            List<OrderItem> orderItems = CollUtil.newArrayList();
            OrderItem orderItem = new OrderItem();
            // 驼峰式转换下划线方式
            orderItem.setColumn(StrUtil.toUnderlineCase(pageModel.getSort()));
            orderItem.setAsc(ORDER_ASC.equalsIgnoreCase(pageModel.getOrder()));
            orderItems.add(orderItem);
            // 添加排序字段
            pagePlus.addOrder(orderItems);
        }
        return pagePlus;
    }
}
