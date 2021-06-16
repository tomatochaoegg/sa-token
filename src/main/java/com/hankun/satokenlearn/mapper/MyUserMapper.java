package com.hankun.satokenlearn.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hankun.satokenlearn.entity.MyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@DS(value = "db1")
public interface MyUserMapper extends BaseMapper<MyUser> {


    Set<String> getPermissionByUserId(Integer userId);

    Set<String> getRoleByUserId(Integer userId);

}
