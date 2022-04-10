package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbTalk;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-04-10
 */
public interface ITbTalkService
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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTbTalkByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTbTalkById(Long id);
}
