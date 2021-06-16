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
 * 字典类型表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_type")
@ApiModel(value="DictType对象", description="字典类型表")
public class DictType extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String dictStatus;


}
