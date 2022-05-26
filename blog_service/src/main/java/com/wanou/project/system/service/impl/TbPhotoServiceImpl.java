package com.wanou.project.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.wanou.common.utils.DateUtils;
import com.wanou.project.system.domain.vo.PhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbPhotoMapper;
import com.wanou.project.system.domain.TbPhoto;
import com.wanou.project.system.service.ITbPhotoService;

/**
 * 照片Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class TbPhotoServiceImpl implements ITbPhotoService
{
    @Autowired
    private TbPhotoMapper tbPhotoMapper;

    /**
     * 查询照片
     *
     * @param id 照片主键
     * @return 照片
     */
    @Override
    public TbPhoto selectTbPhotoById(Long id)
    {
        return tbPhotoMapper.selectTbPhotoById(id);
    }






    /**
     * 查询照片列表
     *
     * @param  照片
     * @return 照片
     */
    @Override
    public List<TbPhoto> selectTbPhotoList(TbPhoto tbPhoto)
    {
        return tbPhotoMapper.selectTbPhotoList(tbPhoto);
    }

    /**
     * 新增照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    @Override
    public int insertTbPhoto(PhotoVO tbPhoto)
    {

        List<TbPhoto> photoList = tbPhoto.getPhotoUrlList().stream().map(item -> TbPhoto.builder()
                        .albumId(tbPhoto.getAlbumId())
                        .photoName("dd")
                        .photoSrc(item)

                        .build())
                .collect(Collectors.toList());

        for (TbPhoto photo : photoList) {
            tbPhotoMapper.insertTbPhoto(photo);
        }
        return 1;
    }

    /**
     * 修改照片
     *
     * @param tbPhoto 照片
     * @return 结果
     */
    @Override
    public int updateTbPhoto(TbPhoto tbPhoto)
    {
        tbPhoto.setUpdateTime(DateUtils.getNowDate());
        return tbPhotoMapper.updateTbPhoto(tbPhoto);
    }

    /**
     * 批量删除照片
     *
     * @param ids 需要删除的照片主键
     * @return 结果
     */
    @Override
    public int deleteTbPhotoByIds(Long[] ids)
    {
        return tbPhotoMapper.deleteTbPhotoByIds(ids);
    }

    /**
     * 删除照片信息
     *
     * @param id 照片主键
     * @return 结果
     */
    @Override
    public int deleteTbPhotoById(Long id)
    {
        return tbPhotoMapper.deleteTbPhotoById(id);
    }
}
