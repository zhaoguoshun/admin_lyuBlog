package com.wanou.common.core.domain.service;

import com.wanou.common.domain.STSEntity;

import java.util.List;

/**
 * @author txh
 * @date 2021/7/27 15:35
 */
public interface OSSService {

    STSEntity getSTSToken();

    List<String> getSignUrlBatch(List<String> objectNameList);

    String getSignUrl(String objectName);
}
