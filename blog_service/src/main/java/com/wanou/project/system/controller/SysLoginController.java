package com.wanou.project.system.controller;

import java.util.List;
import java.util.Set;

import cn.hutool.core.bean.BeanUtil;
import com.wanou.framework.redis.RedisCache;
import com.wanou.project.system.domain.SysDept;
import com.wanou.project.system.service.ISysDeptService;
import com.wanou.project.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.wanou.common.constant.Constants;
import com.wanou.common.utils.SecurityUtils;
import com.wanou.common.utils.ServletUtils;
import com.wanou.framework.security.LoginBody;
import com.wanou.framework.security.LoginUser;
import com.wanou.framework.security.service.SysLoginService;
import com.wanou.framework.security.service.SysPermissionService;
import com.wanou.framework.security.service.TokenService;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.project.system.domain.SysMenu;
import com.wanou.project.system.domain.SysUser;
import com.wanou.project.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        //获取部门(公司名称)
        SysDept dept = sysDeptService.selectDeptById(user.getDeptId());
        String ancestors = dept.getAncestors();
        String[] ancestorsSplit = ancestors.split(",");
        String enterpriseName = null;
        if(ancestorsSplit.length < 3){
            Object deptCacheObj = redisCache.getCacheMapBound(Constants.SYS_DEPT_CACHE, String.valueOf(dept.getDeptId()));
            SysDept sysDeptInCache = BeanUtil.toBean(deptCacheObj, SysDept.class);
            enterpriseName = sysDeptInCache.getDeptName();
        }else {
            Object deptCacheObj = redisCache.getCacheMapBound(Constants.SYS_DEPT_CACHE, ancestorsSplit[2]);
            SysDept sysDeptInCache = BeanUtil.toBean(deptCacheObj, SysDept.class);
            enterpriseName = sysDeptInCache.getDeptName();
        }

        ajax.put("enterprise",enterpriseName);
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
