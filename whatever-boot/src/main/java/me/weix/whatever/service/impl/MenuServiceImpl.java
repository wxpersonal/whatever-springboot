package me.weix.whatever.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private MenuMapper menuMapper;

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
        Integer count = menuMapper.selectCount(condition);

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
        menuMapper.deleteById(menuId);

        //删除关联信息
        QueryWrapper<RoleMenu> condition = new QueryWrapper<>();
        condition.eq("menu_id", menuId);
        roleMenuMapper.delete(condition);
    }


    /**
     * 根据条件查询菜单
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    public IPage listMenus(String menuName, ) {

        QueryWrapper<Menu> condition = new QueryWrapper<>();
        condition.like("name", menuName);
        Page<Menu> page = new Page<>();
        IPage<Menu> pageInfo = this.page(page, condition);
        return pageInfo;
    }

    /**
     * 根据条件查询菜单
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    public List<Long> getMenuIdsByRoleId(Long roleId) {
        return this.baseMapper.getMenuIdsByRoleId(roleId);
    }

    /**
     * 获取菜单列表树
     *
     * @return
     * @date 2017年2月19日 下午1:33:51
     */
    public List<ZTreeNode> menuTreeList() {
        return this.baseMapper.menuTreeList();
    }

    /**
     * 获取菜单列表树
     *
     * @return
     * @date 2017年2月19日 下午1:33:51
     */
    public List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds) {
        return this.baseMapper.menuTreeListByMenuIds(menuIds);
    }

    /**
     * 删除menu关联的relation
     *
     * @param menuId
     * @return
     * @date 2017年2月19日 下午4:10:59
     */
    public int deleteRelationByMenu(Long menuId) {
        return this.baseMapper.deleteRelationByMenu(menuId);
    }

    /**
     * 获取资源url通过角色id
     *
     * @param roleId
     * @return
     * @date 2017年2月19日 下午7:12:38
     */
    public List<String> getResUrlsByRoleId(Long roleId) {
        return this.baseMapper.getResUrlsByRoleId(roleId);
    }

    /**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     * @date 2017年2月19日 下午10:35:40
     */
    public List<MenuNode> getMenusByRoleIds(List<Long> roleIds) {
        List<MenuNode> menus = this.baseMapper.getMenusByRoleIds(roleIds);

        //给所有的菜单url加上ctxPath
        for (MenuNode menuItem : menus) {
            menuItem.setUrl(ConfigListener.getConf().get("contextPath") + menuItem.getUrl());
        }

        return menus;
    }

    /**
     * 根据code查询菜单
     *
     * @author fengshuonan
     * @Date 2018/12/20 21:54
     */
    public Menu selectByCode(String code) {
        Menu menu = new Menu();
        menu.setCode(code);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>(menu);
        return this.baseMapper.selectOne(queryWrapper);
    }

    /**
     * 根据请求的父级菜单编号设置pcode和层级
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:54 PM
     */
    public Menu menuSetPcode(MenuDto menuParam) {

        Menu resultMenu = new Menu();
        BeanUtil.copyProperties(menuParam, resultMenu);

        if (ToolUtil.isEmpty(menuParam.getPid()) || menuParam.getPid().equals(0L)) {
            resultMenu.setPcode("0");
            resultMenu.setPcodes("[0],");
            resultMenu.setLevels(1);
        } else {
            Long pid = menuParam.getPid();
            Menu pMenu = this.getById(pid);
            Integer pLevels = pMenu.getLevels();
            resultMenu.setPcode(pMenu.getCode());

            //如果编号和父编号一致会导致无限递归
            if (menuParam.getCode().equals(menuParam.getPcode())) {
                throw new ServiceException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
            }

            resultMenu.setLevels(pLevels + 1);
            resultMenu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }

        return resultMenu;
    }

    /**
     * 获取菜单树形列表
     *
     * @author fengshuonan
     * @Date 2019/2/23 22:02
     */
    public List<Map<String, Object>> selectMenuTree(String condition, String level) {
        List<Map<String, Object>> maps = this.baseMapper.selectMenuTree(condition, level);

        if (maps == null) {
            maps = new ArrayList<>();
        }

        //创建根节点
        Menu menu = new Menu();
        menu.setMenuId(-1L);
        menu.setName("根节点");
        menu.setCode("0");
        menu.setPcode("-2");

        maps.add(BeanUtil.beanToMap(menu));

        return maps;
    }
}
