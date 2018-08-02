/*
*
* SysCode.java
* @date 2018-08-02
*/
package me.weix.whatever.pojo;

import lombok.Data;
import me.weix.whatever.base.BasePojo;

@Data
public class SysCode extends BasePojo {
    private String code;

    private String pCode;

    private String name;

    private String desc;

}