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
 * 字典数据表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_data")
@ApiModel(value="DictData对象", description="字典数据表")
public class DictData extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "父级id")
    private String parentId;

    @ApiModelProperty(value = "字典标签")
    private String dictLabel;

    @ApiModelProperty(value = "字典键值")
    private String dictValue;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "字典排序")
    private Integer dictSort;

    @ApiModelProperty(value = "样式属性（其他样式扩展）")
    private String cssClass;

    @ApiModelProperty(value = "表格回显样式")
    private String listClass;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String dictStatus;


}
