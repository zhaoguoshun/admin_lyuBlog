package com.wanou.project.system.service.impl;

import java.util.List;
import java.util.Objects;

import com.alibaba.fastjson.JSON;
import com.wanou.common.utils.DateUtils;
import com.wanou.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbTalkMapper;
import com.wanou.project.system.domain.TbTalk;
import com.wanou.project.system.service.ITbTalkService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-10
 */
@Service
public class TbTalkServiceImpl implements ITbTalkService
{
    @Autowired
    private TbTalkMapper tbTalkMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TbTalk selectTbTalkById(Long id)
    {
        return tbTalkMapper.selectTbTalkById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tbTalk 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TbTalk> selectTbTalkList(TbTalk tbTalk)
    {
        List<TbTalk> tbTalks = tbTalkMapper.selectTbTalkList(tbTalk);

        tbTalks.forEach(t ->{
            if (Objects.nonNull(t.getImages())) {
                t.setImgList(JSON.parseObject(t.getImages(), List.class));
            }
        });

        return tbTalks;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tbTalk 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTbTalk(TbTalk tbTalk)
    {
        tbTalk.setCreateTime(DateUtils.getNowDate());
        tbTalk.setUserId(SecurityUtils.getUserId());
        return tbTalkMapper.insertTbTalk(tbTalk);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tbTalk 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTbTalk(TbTalk tbTalk)
    {
        tbTalk.setUpdateTime(DateUtils.getNowDate());
        return tbTalkMapper.updateTbTalk(tbTalk);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTbTalkByIds(Long[] ids)
    {
        return tbTalkMapper.deleteTbTalkByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTbTalkById(Long id)
    {
        return tbTalkMapper.deleteTbTalkById(id);
    }
}
