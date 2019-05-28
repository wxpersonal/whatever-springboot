package me.weix.whatever.core.enums;

import lombok.Getter;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 菜单类型
 */
@Getter
public enum MenuKindEnum {

    /**
     * 普通菜单
     */
    NODE(0, "普通菜单"),

    /**
     * 叶子菜单
     */
    LEAF(1, "叶子菜单");



        Integer code;
        String message;

        MenuKindEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
    }
}
