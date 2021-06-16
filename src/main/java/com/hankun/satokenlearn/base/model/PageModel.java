package com.hankun.satokenlearn.base.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageModel {

    @TableField(exist = false)
    @ApiModelProperty(value = "当前页面", notes = "默认1", example = "1")
    private long current = 1;

    @TableField(exist = false)
    @ApiModelProperty(value = "每页显示条数", notes = "默认30", example = "30")
    private long size = 30;

    @TableField(exist = false)
    @ApiModelProperty(value = "排序字段", notes = "对于model字段")
    private String sort;

    @TableField(exist = false)
    @ApiModelProperty(value = "排序类型", notes = "asc 或者 desc", allowableValues = "asc,desc")
    private String order;
}
