package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbPhotoAlbum;

/**
 * 相册Service接口
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public interface ITbPhotoAlbumService
{
    /**
     * 查询相册
     *
     * @param id 相册主键
     * @return 相册
     */
    public TbPhotoAlbum selectTbPhotoAlbumById(Long id);

    /**
     * 查询相册列表
     *
     * @param tbPhotoAlbum 相册
     * @return 相册集合
     */
    public List<TbPhotoAlbum> selectTbPhotoAlbumList(TbPhotoAlbum tbPhotoAlbum);

    /**
     * 新增相册
     *
     * @param tbPhotoAlbum 相册
     * @return 结果
     */
    public int insertTbPhotoAlbum(TbPhotoAlbum tbPhotoAlbum);

    /**
     * 修改相册
     *
     * @param tbPhotoAlbum 相册
     * @return 结果
     */
    public int updateTbPhotoAlbum(TbPhotoAlbum tbPhotoAlbum);

    /**
     * 批量删除相册
     *
     * @param ids 需要删除的相册主键集合
     * @return 结果
     */
    public int deleteTbPhotoAlbumByIds(Long[] ids);

    /**
     * 删除相册信息
     *
     * @param id 相册主键
     * @return 结果
     */
    public int deleteTbPhotoAlbumById(Long id);
}
