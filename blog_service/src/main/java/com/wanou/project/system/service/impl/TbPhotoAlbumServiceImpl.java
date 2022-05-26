package com.wanou.project.system.service.impl;

import java.util.List;
import com.wanou.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbPhotoAlbumMapper;
import com.wanou.project.system.domain.TbPhotoAlbum;
import com.wanou.project.system.service.ITbPhotoAlbumService;

/**
 * 相册Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class TbPhotoAlbumServiceImpl implements ITbPhotoAlbumService
{
    @Autowired
    private TbPhotoAlbumMapper tbPhotoAlbumMapper;

    /**
     * 查询相册
     *
     * @param id 相册主键
     * @return 相册
     */
    @Override
    public TbPhotoAlbum selectTbPhotoAlbumById(Long id)
    {
        return tbPhotoAlbumMapper.selectTbPhotoAlbumById(id);
    }

    /**
     * 查询相册列表
     *
     * @param tbPhotoAlbum 相册
     * @return 相册
     */
    @Override
    public List<TbPhotoAlbum> selectTbPhotoAlbumList(TbPhotoAlbum tbPhotoAlbum)
    {
        return tbPhotoAlbumMapper.selectTbPhotoAlbumList(tbPhotoAlbum);
    }

    /**
     * 新增相册
     *
     * @param tbPhotoAlbum 相册
     * @return 结果
     */
    @Override
    public int insertTbPhotoAlbum(TbPhotoAlbum tbPhotoAlbum)
    {
        tbPhotoAlbum.setCreateTime(DateUtils.getNowDate());
        return tbPhotoAlbumMapper.insertTbPhotoAlbum(tbPhotoAlbum);
    }

    /**
     * 修改相册
     *
     * @param tbPhotoAlbum 相册
     * @return 结果
     */
    @Override
    public int updateTbPhotoAlbum(TbPhotoAlbum tbPhotoAlbum)
    {
        tbPhotoAlbum.setUpdateTime(DateUtils.getNowDate());
        return tbPhotoAlbumMapper.updateTbPhotoAlbum(tbPhotoAlbum);
    }

    /**
     * 批量删除相册
     *
     * @param ids 需要删除的相册主键
     * @return 结果
     */
    @Override
    public int deleteTbPhotoAlbumByIds(Long[] ids)
    {
        return tbPhotoAlbumMapper.deleteTbPhotoAlbumByIds(ids);
    }

    /**
     * 删除相册信息
     *
     * @param id 相册主键
     * @return 结果
     */
    @Override
    public int deleteTbPhotoAlbumById(Long id)
    {
        return tbPhotoAlbumMapper.deleteTbPhotoAlbumById(id);
    }
}
