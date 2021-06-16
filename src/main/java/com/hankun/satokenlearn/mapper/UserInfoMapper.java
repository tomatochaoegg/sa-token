package com.hankun.satokenlearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hankun.satokenlearn.entity.Role;
import com.hankun.satokenlearn.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * 根据用户id 查询已授权角色列表
     *
     * @param userId
     * @return
     */
    List<Role> getAuthRoleListByUserId(@Param("userId") String userId);

    /**
     * 根据用户id 查询已授权角色列表
     *
     * @param userId
     * @return
     */
    Set<String> getAuthRoleKeyByUserId(@Param("userId") String userId);

    /**
     * 根据userId 查询权限
     *
     * @param userId
     * @return
     */
    Set<String> getResourcesCodeByUserId(@Param("userId") String userId);
}
