package com.wanou.common.core.domain.service.impl;

import com.wanou.common.component.OSS.OSSComponent;
import com.wanou.common.core.domain.service.OSSService;
import com.wanou.common.domain.STSEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author txh
 * @date 2021/7/27 16:13
 */
@Service
public class OSSServiceImpl implements OSSService {

    @Autowired
    private OSSComponent ossComponent;
    /**
     * 获取STS Token
     * @return
     */
    @Override
    public STSEntity getSTSToken() {
        return ossComponent.getSTSToken();
    }

    @Override
    public List<String> getSignUrlBatch(List<String> objectNameList) {
        return ossComponent.generateSignUrlBatch(objectNameList);
    }

    @Override
    public String getSignUrl(String objectName) {
        return ossComponent.generateSignUrl(objectName);
    }
}
