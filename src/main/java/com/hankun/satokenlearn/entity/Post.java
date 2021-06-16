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
 * 岗位表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_post")
@ApiModel(value="Post对象", description="岗位表")
public class Post extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "岗位ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "岗位编码")
    private String postCode;

    @ApiModelProperty(value = "岗位名称")
    private String postName;

    @ApiModelProperty(value = "显示顺序")
    private BigDecimal postSort;

    @ApiModelProperty(value = "岗位状态（0、正常；1、停用）")
    private String postStatus;


}
