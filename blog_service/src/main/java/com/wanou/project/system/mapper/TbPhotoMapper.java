package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TbPhoto;

/**
 * 照片Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public interface TbPhotoMapper
{
    /**
     * 查询照片
     *
     * @param id 照片主键
     * @return 照片
     */
    public TbPhoto selectTbPhotoById(Long id);

    /**
     * 查询照片列表
     *
     * @param tbPhoto 照片
     * @return 照片集合
     */
    public List<TbPhoto> selectTbPhotoList(TbPhoto tbPhoto);

    /**
     * 新增照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    public int insertTbPhoto(TbPhoto tbPhoto);

    /**
     * 修改照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    public int updateTbPhoto(TbPhoto tbPhoto);

    /**
     * 删除照片
     *
     * @param id 照片主键
     * @return 结果
     */
    public int deleteTbPhotoById(Long id);

    /**
     * 批量删除照片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbPhotoByIds(Long[] ids);
}
