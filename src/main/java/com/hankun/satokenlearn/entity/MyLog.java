package com.hankun.satokenlearn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.hankun.satokenlearn.base.model.BaseModel;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@Data
@Accessors(chain = true)
@ApiModel(value="MyLog对象", description="")
public class MyLog  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id值")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "请求ip")
    private String ip;

    @ApiModelProperty(value = "操作描述")
    private String description;

    @ApiModelProperty(value = "参数值")
    private String params;

    @ApiModelProperty(value = "浏览器")
    private String browser;

    @ApiModelProperty(value = "执行时间")
    private Long time;

    @ApiModelProperty(value = "日志类型")
    private String type;

    @ApiModelProperty(value = "执行方法")
    private String method;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "异常详细信息")
    private String exceptionDetail;


}
