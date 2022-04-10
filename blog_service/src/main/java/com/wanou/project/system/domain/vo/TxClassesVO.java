package com.wanou.project.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class TxClassesVO {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long typr;

    private String startTime;

    private String stopTime;

    private Long upLate;

    private String up;

    private String down;

    private Long downLeave;

    private String earliestTime;

    private String latestTime;

    private Integer absenteeism;

    private Integer isUpClockin;

    private Integer isDownClockin;

    private String restName1;

    private String restStarTime1;

    private Integer isRestClockin1;

    private String restStopTime1;

    private Integer restGreater1;

    private Integer ressLess1;

    private String restName2;

    private String restStart1;

    private String restStop1;

    private String restStarTime2;

    private Integer restInterval1;

    private Integer isRestClockin2;

    private Integer restGreater2;

    private Long ressLess2;

    private Date gmtCreate;

    private String restStopTime2;

    private String restStart2;

    private String restStop2;

    private Integer restInterval2;

    private String totalTime;
}
