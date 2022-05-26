package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 相册对象 tb_photo_album
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public class TbPhotoAlbum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 相册名 */
    @Excel(name = "相册名")
    private String albumName;

    /** 相册描述 */
    @Excel(name = "相册描述")
    private String albumDesc;

    /** 相册封面 */
    @Excel(name = "相册封面")
    private String albumCover;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDelete;

    /** 状态值 1公开 2私密 */
    @Excel(name = "状态值 1公开 2私密")
    private Integer status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAlbumName(String albumName)
    {
        this.albumName = albumName;
    }

    public String getAlbumName()
    {
        return albumName;
    }
    public void setAlbumDesc(String albumDesc)
    {
        this.albumDesc = albumDesc;
    }

    public String getAlbumDesc()
    {
        return albumDesc;
    }
    public void setAlbumCover(String albumCover)
    {
        this.albumCover = albumCover;
    }

    public String getAlbumCover()
    {
        return albumCover;
    }
    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("albumName", getAlbumName())
                .append("albumDesc", getAlbumDesc())
                .append("albumCover", getAlbumCover())
                .append("isDelete", getIsDelete())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
