package com.wanou.project.system.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author txh
 * @date 2021/11/9 22:21
 */
@Data
public class TxPersonExcelImportResultVO implements Serializable {
    private static final long serialVersionUID = -5047827161595678568L;

    private String personName;
    private String statusMessage;
    private int status; //导入状态 1=成功 0=失败
}
