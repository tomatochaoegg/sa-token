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
 * 文件表
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_file_info")
@ApiModel(value="FileInfo对象", description="文件表")
public class FileInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件md5")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "物理路径")
    private String path;

    @ApiModelProperty(value = "url地址")
    private String url;

    @ApiModelProperty(value = "来源")
    private String source;


}
