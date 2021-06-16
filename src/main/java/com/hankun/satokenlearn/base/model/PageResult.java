package com.hankun.satokenlearn.base.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "PageResult", description = "分页信息返回结果")
public class PageResult<DTO> {

    @ApiModelProperty(value = "当前页")
    private long current;

    @ApiModelProperty(value = "总页数")
    private long pages;

    @ApiModelProperty(value = "每页显示条数")
    private long size;

    @ApiModelProperty(value = "当前满足条件总行数")
    private long total;

    @ApiModelProperty(value = "分页记录列表")
    private List<DTO> records;

    /**
     *  根据IPage<T> 转换 PageResult<DTO>
     * @param iPage
     * @param list
     * @param <DTO>
     * @param <T>
     * @return
     */
    public static <DTO,T> PageResult<DTO> toPageDTO(IPage<T> iPage, List<DTO> list){
        PageResult<DTO> pageResult = new PageResult<>();
        pageResult.setCurrent(iPage.getCurrent());
        pageResult.setPages(iPage.getPages());
        pageResult.setSize(iPage.getSize());
        pageResult.setTotal(iPage.getTotal());
        pageResult.setRecords(list);
        return pageResult;
    }

}
