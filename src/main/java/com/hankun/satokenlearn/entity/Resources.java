package com.hankun.satokenlearn.entity;

import java.math.BigDecimal;
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
 * 资源表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_resources")
@ApiModel(value="Resources对象", description="资源表")
public class Resources extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "父级id")
    private String parentId;

    @ApiModelProperty(value = "父级ids")
    private String parentIds;

    @ApiModelProperty(value = "资源名称")
    private String resName;

    @ApiModelProperty(value = "资源code")
    private String resCode;

    @ApiModelProperty(value = "资源path")
    private String resPath;

    @ApiModelProperty(value = "请求方式")
    private String httpMethod;

    @ApiModelProperty(value = "状态（0、正常；1、禁用）")
    private String resStatus;

    @ApiModelProperty(value = "类型（0、模块；1、链接）")
    private String resType;

    @ApiModelProperty(value = "排序")
    private BigDecimal resSort;


}
