package com.wanou.project.common;

import com.wanou.common.core.domain.AjaxResult;
import com.wanou.common.core.domain.service.OSSService;
import com.wanou.common.domain.STSEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author txh
 * @date 2021/7/27 15:33
 */
@RequestMapping("/sts")
@RestController
public class STSController {
    @Autowired
    private OSSService ossService;

    /**
     * 获取阿里云STS临时授权令牌service
     * @return
     */
    @GetMapping
    public AjaxResult getSTSToken(){
        STSEntity stsEntity = ossService.getSTSToken();
        return AjaxResult.success("获取成功",stsEntity);
    }
}
