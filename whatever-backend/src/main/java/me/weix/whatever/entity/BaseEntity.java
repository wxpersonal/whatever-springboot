package me.weix.whatever.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value="创建人id")
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间", example = "2018-08-30 12:00:00")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("update_by")
    @ApiModelProperty(value="修改人id")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @TableField("update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间", example = "2018-08-30 12:00:00")
    private Date updateTime;

    /**
     * 有效状态
     */
    @ApiModelProperty(value="有效状态 1有效 0无效")
    private Integer status;

    /**
     * 删除标记
     */

    @TableLogic
    @ApiModelProperty(value="逻辑删除标记 1已删除 0未删除")
    private Integer deleted;

}
