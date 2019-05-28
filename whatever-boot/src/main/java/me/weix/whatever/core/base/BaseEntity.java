package me.weix.whatever.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author weix
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建人
     */
    @TableField("create_by")
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("update_by")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @TableField("update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 有效状态
     */
    private Integer status;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer deleted;

}
