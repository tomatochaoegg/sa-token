package com.hankun.satokenlearn.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseModel extends PageModel implements Serializable {
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private Date createDate;

    /**
     * 更新者
     */
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true)
    private Date updateDate;

    /**
     * 删除标识（0：正常；1：已删除）
     */
    @TableLogic
    @ApiModelProperty(hidden = true)
    private String delFlag;

    /**
     * 备注
     */
    private String remark;
}
