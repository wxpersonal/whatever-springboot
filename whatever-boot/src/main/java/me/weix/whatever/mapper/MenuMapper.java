package me.weix.whatever.mapper;

import me.weix.whatever.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.weix.whatever.model.TreeNode;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
public interface MenuMapper extends BaseMapper<Menu> {

    void test();

    /**
     * 获取菜单列表树
     *
     * @return
     * @date 2017年2月19日 下午1:33:51
     */
    List<TreeNode> menuTreeList();

    /**
     * 根据角色获取菜单
     * @param roleIds
     * @return
     */
    List<Menu> getMenusByRoleIds(List<Integer> roleIds);
}
