package me.weix.whatever.core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : weixiang
 * create at:  2019-05-22
 * @description: 通用返回结果
 */
@Data
public class JsonResult implements Serializable {

    private Boolean success;

    private String message;

    private Object data;

    public JsonResult(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public JsonResult(Boolean success) {
        this.success = success;
    }

}
