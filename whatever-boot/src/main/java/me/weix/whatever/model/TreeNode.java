package me.weix.whatever.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeNode implements Serializable {


    /**
     * 节点id
     */
    private Long id;

    /**
     * 父节点id
     */
    private Long pId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 是否打开节点
     */
    private Boolean open;

    /**
     * 是否被选中
     */
    private Boolean checked;

    /**
     * 节点图标  single or group
     */
    private String icon;

}
