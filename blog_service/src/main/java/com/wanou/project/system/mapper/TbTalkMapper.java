package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TbTalk;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-10
 */
public interface TbTalkMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TbTalk selectTbTalkById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tbTalk 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TbTalk> selectTbTalkList(TbTalk tbTalk);

    /**
     * 新增【请填写功能名称】
     *
     * @param tbTalk 【请填写功能名称】
     * @return 结果
     */
    public int insertTbTalk(TbTalk tbTalk);

    /**
     * 修改【请填写功能名称】
     *
     * @param tbTalk 【请填写功能名称】
     * @return 结果
     */
    public int updateTbTalk(TbTalk tbTalk);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTbTalkById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbTalkByIds(Long[] ids);
}
