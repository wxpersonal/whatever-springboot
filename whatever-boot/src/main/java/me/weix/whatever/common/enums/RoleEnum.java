package me.weix.whatever.common.enums;

import lombok.Getter;

/**
 * @author weix
 * 角色枚举
 */
@Getter
public enum RoleEnum {

    /**
     * admin
     */
    ADMIN("admin", "超级管理员");

    RoleEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
}
