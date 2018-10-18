/*
*
* SysFile.java
* @date 2018-08-02
*/
package me.weix.whatever.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SysFile extends BaseEntity {
    /**
     * 附件id
     */
    private Integer id;

    /**
     * 所属对象id
     */
    private Integer objectid;

    private Integer objecttype;

    /**
     * 附件类型
     */
    private Integer type;

    /**
     * 附件原名称
     */
    private String oldname;

    /**
     * 附件新名称
     */
    private String newname;

    /**
     * 附件大小
     */
    private Integer size;

    /**
     * 存放路径
     */
    private String path;

    /**
     * 相对路径
     */
    private String relativepath;

}