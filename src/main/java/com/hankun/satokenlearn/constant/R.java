package com.hankun.satokenlearn.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author：hankun
 * @Description: 返回给前台的通用包装
 * @Date: 2021/6/4
 */
@Getter
@Setter
@ApiModel(value = "R", description = "返回数据包装")
public class R<T> {

    @ApiModelProperty(value = "响应状态码", notes = "成功1，失败0")
    private Integer code;

    @ApiModelProperty(value = "响应信息")
    private String msg;

    @ApiModelProperty(value = "响应对象")
    private T data;

    public R() {

    }

    public R(ReturnCode returnCode, T data) {
        this.code = returnCode.getCode();
        this.msg = returnCode.getMsg();
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<T>(ReturnCode.SUCCESS, null);
    }

    public static <T> R<T> success(T object) {
        return new R<T>(ReturnCode.SUCCESS, object);
    }

    public static <T> R<T> success(ReturnCode returnCode, T object) {
        return new R<T>(returnCode, object);
    }

    public static <T> R<T> error() {
        return new R<T>(ReturnCode.ERROR, null);
    }

    public static <T> R<T> error(ReturnCode returnCode) {
        return new R<T>(returnCode, null);
    }

    public static <T> R<T> error(Integer code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> error(ReturnCode returnCode, T object) {
        return new <T>R<T>(returnCode, object);
    }
}
