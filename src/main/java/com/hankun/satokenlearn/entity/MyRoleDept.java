package com.hankun.satokenlearn.entity;

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
 * 
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@Data
@Accessors(chain = true)
@ApiModel(value="MyRoleDept对象", description="")
public class MyRoleDept  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Integer roleId;

    @ApiModelProperty(value = "部门id")
    private Integer deptId;


}
