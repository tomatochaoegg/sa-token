package com.hankun.satokenlearn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.hankun.satokenlearn.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_info")
@ApiModel(value="UserInfo对象", description="用户表")
public class UserInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "部门id")
    private String deptId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户类型（0、管理员；1、普通用户）")
    private String userType;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "性别（0、男；1、女）")
    private String sex;

    @ApiModelProperty(value = "头像")
    private String avatarPath;

    @ApiModelProperty(value = "帐号状态（0、正常；1、禁用）")
    private String userStatus;


}
