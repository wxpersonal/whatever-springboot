package me.weix.whatever.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import me.weix.whatever.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_file")
public class SysFile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 附件id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
