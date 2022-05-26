package com.wanou.project.system.domain;

import lombok.Builder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 照片对象 tb_photo
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@Builder
public class TbPhoto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 相册id */
    @Excel(name = "相册id")
    private Integer albumId;

    /** 照片名 */
    @Excel(name = "照片名")
    private String photoName;

    /** 照片描述 */
    @Excel(name = "照片描述")
    private String photoDesc;

    /** 照片地址 */
    @Excel(name = "照片地址")
    private String photoSrc;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDelete;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setAlbumId(Integer albumId)
    {
        this.albumId = albumId;
    }

    public Integer getAlbumId()
    {
        return albumId;
    }
    public void setPhotoName(String photoName)
    {
        this.photoName = photoName;
    }

    public String getPhotoName()
    {
        return photoName;
    }
    public void setPhotoDesc(String photoDesc)
    {
        this.photoDesc = photoDesc;
    }

    public String getPhotoDesc()
    {
        return photoDesc;
    }
    public void setPhotoSrc(String photoSrc)
    {
        this.photoSrc = photoSrc;
    }

    public String getPhotoSrc()
    {
        return photoSrc;
    }
    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("albumId", getAlbumId())
                .append("photoName", getPhotoName())
                .append("photoDesc", getPhotoDesc())
                .append("photoSrc", getPhotoSrc())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
