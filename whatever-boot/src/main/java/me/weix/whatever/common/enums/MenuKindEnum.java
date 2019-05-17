package me.weix.whatever.common.enums;

import lombok.Getter;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 菜单类型
 */
@Getter
public enum MenuKindEnum {

    /**
     * 非叶子菜单
     */
    LEAF(0, "叶子菜单"),

    /**
     * 叶子菜单，无子菜单
     */
    NOT_LEAF(1, "非叶子菜单");

    Integer code;
    String message;

    MenuKindEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
