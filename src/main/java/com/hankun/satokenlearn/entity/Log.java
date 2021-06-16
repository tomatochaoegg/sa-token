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
 * 日志表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_log")
@ApiModel(value="Log对象", description="日志表")
public class Log extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "操作人员")
    private String operName;

    @ApiModelProperty(value = "请求参数")
    private String operParam;

    @ApiModelProperty(value = "请求地址")
    private String url;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "业务模块名称")
    private String businessName;

    @ApiModelProperty(value = "方法名")
    private String method;

    @ApiModelProperty(value = "返回结果")
    private String result;

    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    private String logStatus;

    @ApiModelProperty(value = "错误信息")
    private String error;


}
