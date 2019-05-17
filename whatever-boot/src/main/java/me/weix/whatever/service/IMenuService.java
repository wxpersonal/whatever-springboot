package me.weix.whatever.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.weix.whatever.entity.Menu;
import me.weix.whatever.mapper.MenuMapper;
import me.weix.whatever.model.MenuDto;

import javax.annotation.Resource;

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
}
