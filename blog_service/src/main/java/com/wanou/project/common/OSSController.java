package com.wanou.project.common;

import com.wanou.common.component.OSS.OSSComponent;
import com.wanou.framework.web.domain.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author txh
 * @date 2021/11/10 17:33
 */
@RestController
@RequestMapping("/oss")
public class OSSController {

    @Autowired
    private OSSComponent ossComponent;

    @GetMapping("/isExist")
    public AjaxResult isExist(String objectName){
        if(StringUtils.isBlank(objectName)){
            return AjaxResult.error("参数异常");
        }
        //todo 前端判断是否已经存在  继续优化
        boolean exist = ossComponent.isExist(objectName);
        return AjaxResult.success(exist);
    }
}
