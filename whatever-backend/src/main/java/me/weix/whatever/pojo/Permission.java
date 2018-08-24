/*
*
* Permission.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Permission extends BasePojo {
    private Integer id;

    private Integer pId;

    private Integer systemId;

    private String code;

    private String desc;

    private String url;

    private Integer orders;

}