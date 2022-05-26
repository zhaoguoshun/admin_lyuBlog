package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbPhoto;
import com.wanou.project.system.domain.vo.PhotoVO;

/**
 * 照片Service接口
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public interface ITbPhotoService
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
    public List<TbPhoto> selectTbPhotoList(TbPhoto photo);

    /**
     * 新增照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    public int insertTbPhoto(PhotoVO tbPhoto);

    /**
     * 修改照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    public int updateTbPhoto(TbPhoto tbPhoto);

    /**
     * 批量删除照片
     *
     * @param ids 需要删除的照片主键集合
     * @return 结果
     */
    public int deleteTbPhotoByIds(Long[] ids);

    /**
     * 删除照片信息
     *
     * @param id 照片主键
     * @return 结果
     */
    public int deleteTbPhotoById(Long id);
}
