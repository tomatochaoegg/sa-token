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
 * 参数配置表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_config")
@ApiModel(value="Config对象", description="参数配置表")
public class Config extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "参数名称")
    private String configName;

    @ApiModelProperty(value = "参数键名")
    private String configKey;

    @ApiModelProperty(value = "参数键值")
    private String configValue;

    @ApiModelProperty(value = "系统内置")
    private String configType;


}
