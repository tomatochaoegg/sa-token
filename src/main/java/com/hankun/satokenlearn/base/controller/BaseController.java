package com.hankun.satokenlearn.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hankun.satokenlearn.base.model.PageResult;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.constant.R;
import com.hankun.satokenlearn.constant.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class BaseController<M extends BaseService, T> {

    @Autowired
    protected M baseService;

    /**
     * 转换page
     *
     * @param iPage model分页数据
     * @param list  dto数据
     * @return
     */
    protected <DTO, T> PageResult<DTO> toPageDTO(IPage<T> iPage, List<DTO> list) {
        return PageResult.toPageDTO(iPage, list);
    }

    protected <T> R<T> success() {
        return R.success();
    }

    protected <T> R<T> success(ReturnCode returnCode, T obj) {
        return R.success(returnCode, obj);
    }

    protected <T> R<T> success(T obj) {
        return R.success(obj);
    }

    protected <T> R<T> error() {
        return R.error();
    }

    protected <T> R<T> error(ReturnCode returnCode, T obj) {
        return R.error(returnCode, obj);
    }

    protected <T> R<T> error(Integer code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    protected <T> R<T> error(ReturnCode returnCode) {
        return R.error(returnCode);
    }

}
