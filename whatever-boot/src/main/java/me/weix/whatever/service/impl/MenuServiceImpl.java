package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import me.weix.whatever.common.enums.ExceptionRemindMsg;
import me.weix.whatever.common.enums.MenuKindEnum;
import me.weix.whatever.common.enums.StatusEnum;
import me.weix.whatever.entity.Menu;
import me.weix.whatever.entity.RoleMenu;
import me.weix.whatever.mapper.MenuMapper;
import me.weix.whatever.mapper.RoleMenuMapper;
import me.weix.whatever.model.MenuDto;
import me.weix.whatever.service.IMenuService;
import me.weix.whatever.util.ValidateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weix
 * @since 2019-05-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenu(MenuDto menuDto) {

        Assert.isTrue(ValidateUtil.noEmpty(menuDto, menuDto.getKind(), menuDto.getName(), menuDto.getPid(), menuDto.getUrl()),
                ExceptionRemindMsg.INCOMPLETE_PARAM.getMessage());

        //判断是否已经存在该菜单
        QueryWrapper<Menu> condition = new QueryWrapper<>();
        condition.eq("pid", menuDto.getPid()).eq("name", menuDto.getName());
        Integer count = baseMapper.selectCount(condition);

        if (null != count && count.intValue() > 0) {
            throw new RuntimeException("该菜单已存在");
        }

        //组装属性，设置父级菜单编号
        Menu menuInsert = new Menu();
        BeanUtils.copyProperties(menuDto, menuInsert);
        menuInsert.setStatus(StatusEnum.ENABLE.getCode());
        this.save(menuInsert);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuDto menuDto) {

        //如果菜单为空
        Assert.isTrue(ValidateUtil.noEmpty(menuDto, menuDto.getId()), ExceptionRemindMsg.INCOMPLETE_PARAM.getMessage());
        //获取旧的菜单
        Integer id = menuDto.getId();
        Menu menu = this.getById(id);

        if (menu == null) {
            throw new RuntimeException(ExceptionRemindMsg.DATA_CHANGED.getMessage());
        }

        //设置父级菜单编号
        Menu resultMenu = new Menu();
        BeanUtils.copyProperties(menuDto, resultMenu);
        this.updateById(resultMenu);
    }


    /**
     * 删除菜单
     */
    @Transactional(rollbackFor = Exception.class)
    public void delMenu(Long menuId) {

        Menu menu = this.getById(menuId);
        if (menu.getKind().intValue() == MenuKindEnum.NOT_LEAF.getCode()) {
            throw new RuntimeException("只能删除叶子叶子菜单");
        }

        //删除菜单
        baseMapper.deleteById(menuId);

        //删除关联信息
        QueryWrapper<RoleMenu> condition = new QueryWrapper<>();
        condition.eq("menu_id", menuId);
        roleMenuMapper.delete(condition);
    }

    @Override
    public IPage listMenus(String menuName) {

        QueryWrapper<Menu> condition = new QueryWrapper<>();
        condition.like("name", menuName);
        Page<Menu> page = new Page<>();
        IPage<Menu> pageInfo = this.page(page, condition);
        return pageInfo;
    }

    public int deleteRelationByMenu(Long menuId) {
        //删除关联信息
        QueryWrapper<RoleMenu> condition = new QueryWrapper<>();
        condition.eq("menu_id", menuId);
        return roleMenuMapper.delete(condition);
    }

    public List<Menu> getMenusByRoleIds(List<Integer> roleIds) {
        List<Menu> menus = baseMapper.getMenusByRoleIds(roleIds);
        //查子菜单
        getChildren(menus);
        return menus;
    }

    private List<Menu> getChildren(List<Menu> menus){

        List<Integer> ids = Lists.newArrayList();
        for (Menu menu : menus) {
            ids.add(menu.getId());
        }
        QueryWrapper<Menu> wrapper = new QueryWrapper();
        wrapper.in("pid", ids);
        List<Menu> subNodes = baseMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(subNodes)) {
            return null;
        }
        for (Menu menu : menus) {
            List<Menu> children = Lists.newArrayList();
            for (Menu subNode : subNodes) {
                if(subNode.getPid().intValue() == menu.getId().intValue()) {
                    children.add(subNode);
                }
            }
            menu.setChildren(children);
        }
        getChildren(subNodes);
        return menus;
    }

}
