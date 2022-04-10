package com.wanou.project.system.domain.vo;

import lombok.Data;

@Data
public class TxDevicesVoPage {
    private String stats;
    private String location;
    private Long deptId;
    private Integer index;
    private Integer size;
}
