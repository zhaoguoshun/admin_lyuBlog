package com.wanou.project.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxDevicesMeetVo implements Serializable {
    private String[] date;
    private String name;
    private String deviceId;
    private String beforeDate;
    private String afterDate;
    private long deptId;

}
