package me.weix.whatever.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import me.weix.whatever.entity.Menu;
import me.weix.whatever.model.MenuDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 添加菜单
     * @param menuDto
     */
    void addMenu(MenuDto menuDto);

    /**
     * 更新菜单
     * @param menuDto
     */
    void updateMenu(MenuDto menuDto);

    /**
     * 删除菜单
     * @param menuId
     */
    void delMenu(Long menuId);

    /**
     * 根据条件查询菜单
     *
     * @return
     */
    IPage listMenus(String menuName);

    /**
     * 删除menu关联的relation
     *
     * @param menuId
     * @return
     */
    int deleteRelationByMenu(Long menuId);

    /**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     */
    List<Menu> getMenusByRoleIds(List<Integer> roleIds);
}
