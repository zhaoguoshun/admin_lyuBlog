package com.wanou.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author txh
 * @date 2021/7/27 16:38
 * STS实体类
 */
@Data
public class STSEntity implements Serializable {
    private static final long serialVersionUID = 5410916834659669831L;

    private String accessKeyId;
    private String accessKeySecret;
    private String securityToken;
    private String region;
    private String bucketName;
}
