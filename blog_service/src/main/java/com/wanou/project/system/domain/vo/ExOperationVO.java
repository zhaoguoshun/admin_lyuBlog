package com.wanou.project.system.domain.vo;

import lombok.Data;

import java.util.Date;
@Data
public class ExOperationVO {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 学生id */
    private Long studentId;

    /** 实验id */
    private Long enterId;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date stopTime;

    /** 分数 */
    private String score;
}
