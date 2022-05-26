package com.wanou.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wanou.framework.aspectj.lang.annotation.Log;
import com.wanou.framework.aspectj.lang.enums.BusinessType;
import com.wanou.project.system.domain.TbPhotoAlbum;
import com.wanou.project.system.service.ITbPhotoAlbumService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 相册Controller
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@RestController
@RequestMapping("/system/album")
public class TbPhotoAlbumController extends BaseController
{
    @Autowired
    private ITbPhotoAlbumService tbPhotoAlbumService;

    /**
     * 查询相册列表
     */
    @PreAuthorize("@ss.hasPermi('system:album:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbPhotoAlbum tbPhotoAlbum)
    {
        startPage();
        List<TbPhotoAlbum> list = tbPhotoAlbumService.selectTbPhotoAlbumList(tbPhotoAlbum);
        return getDataTable(list);
    }

    /**
     * 导出相册列表
     */
    @PreAuthorize("@ss.hasPermi('system:album:export')")
    @Log(title = "相册", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbPhotoAlbum tbPhotoAlbum)
    {
        List<TbPhotoAlbum> list = tbPhotoAlbumService.selectTbPhotoAlbumList(tbPhotoAlbum);
        ExcelUtil<TbPhotoAlbum> util = new ExcelUtil<TbPhotoAlbum>(TbPhotoAlbum.class);
        return util.exportExcel(list, "相册数据");
    }

    /**
     * 获取相册详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:album:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbPhotoAlbumService.selectTbPhotoAlbumById(id));
    }

    /**
     * 新增相册
     */
    @PreAuthorize("@ss.hasPermi('system:album:add')")
    @Log(title = "相册", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbPhotoAlbum tbPhotoAlbum)
    {
        return toAjax(tbPhotoAlbumService.insertTbPhotoAlbum(tbPhotoAlbum));
    }

    /**
     * 修改相册
     */
    @PreAuthorize("@ss.hasPermi('system:album:edit')")
    @Log(title = "相册", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbPhotoAlbum tbPhotoAlbum)
    {
        return toAjax(tbPhotoAlbumService.updateTbPhotoAlbum(tbPhotoAlbum));
    }

    /**
     * 删除相册
     */
    @PreAuthorize("@ss.hasPermi('system:album:remove')")
    @Log(title = "相册", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbPhotoAlbumService.deleteTbPhotoAlbumByIds(ids));
    }
}
