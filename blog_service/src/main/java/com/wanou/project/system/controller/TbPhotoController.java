package com.wanou.project.system.controller;

import java.util.List;

import com.wanou.project.system.domain.vo.PhotoVO;
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
import com.wanou.project.system.domain.TbPhoto;
import com.wanou.project.system.service.ITbPhotoService;
import com.wanou.framework.web.controller.BaseController;
import com.wanou.framework.web.domain.AjaxResult;
import com.wanou.common.utils.poi.ExcelUtil;
import com.wanou.framework.web.page.TableDataInfo;

/**
 * 照片Controller
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@RestController
@RequestMapping("/system/photo")
public class TbPhotoController extends BaseController
{
    @Autowired
    private ITbPhotoService tbPhotoService;

    /**
     * 查询照片列表
     */
    @PreAuthorize("@ss.hasPermi('system:photo:list')")
    @GetMapping("/list")
    public TableDataInfo list()
    {
        startPage();
        List<TbPhoto> list = tbPhotoService.selectTbPhotoList (TbPhoto.builder().build());
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:photo:list')")
    @GetMapping("/list/{id}")
    public TableDataInfo listId(@PathVariable Integer id)
    {
        startPage();
        TbPhoto.TbPhotoBuilder builder = TbPhoto.builder();
        builder.albumId(id);
        List<TbPhoto> list = tbPhotoService.selectTbPhotoList (builder.build());
        return getDataTable(list);
    }

    /**
     * 导出照片列表
     */
    @PreAuthorize("@ss.hasPermi('system:photo:export')")
    @Log(title = "照片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TbPhoto tbPhoto)
    {
        List<TbPhoto> list = tbPhotoService.selectTbPhotoList(TbPhoto.builder().build());
        ExcelUtil<TbPhoto> util = new ExcelUtil<TbPhoto>(TbPhoto.class);
        return util.exportExcel(list, "照片数据");
    }

    /**
     * 获取照片详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:photo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tbPhotoService.selectTbPhotoById(id));
    }

    /**
     * 新增照片
     */
    @PreAuthorize("@ss.hasPermi('system:photo:add')")
    @Log(title = "照片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PhotoVO tbPhoto)
    {
        return toAjax(tbPhotoService.insertTbPhoto(tbPhoto));
    }

    /**
     * 修改照片
     */
    @PreAuthorize("@ss.hasPermi('system:photo:edit')")
    @Log(title = "照片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbPhoto tbPhoto)
    {
        return toAjax(tbPhotoService.updateTbPhoto(tbPhoto));
    }

    /**
     * 删除照片
     */
    @PreAuthorize("@ss.hasPermi('system:photo:remove')")
    @Log(title = "照片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbPhotoService.deleteTbPhotoByIds(ids));
    }
}
