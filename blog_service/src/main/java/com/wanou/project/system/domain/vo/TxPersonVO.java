package com.wanou.project.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

import java.util.Date;


@Data
public class TxPersonVO {

    private static final long serialVersionUID = 1L;

    private Long staffid;

    private String mobile;

    private String imgBase64;

    private String name;

    private Long departmentId;

    private String icno;

    private Integer pType;

    private String licenseImage;

    private Integer sex;

    private Long stationId;

    private Long classesId;

    private String nation;

    private String addJoinTime;

    private Integer isBecome;

    private String address;

    private String certificate;

    private Long stationMoney;
    @Excel(name = "身份有效期开始", width = 30, dateFormat = "yyyy-MM-dd")
    private String validityStar;

    private Long dutyMoney;


    @Excel(name = "身份有效期截至", width = 30, dateFormat = "yyyy-MM-dd")
    private String validityStop;

    private Long skillMoney;

    private String idCard;

    private Long totalMoney;

    private Integer isMedicineSubsidy;

    private String nativePlace;

    private Integer isRubbishSubsidy;

    private Integer isTempSubsidy;


    private String introduce;

    private Integer isNightSubsidy;

    private String education;

    private Integer getMarried;

    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String compactTimeStart;

    @Excel(name = "合同结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String compactTimeStop;

    private String school;

    private String subject;

    private String flowType;

    /**
     * 出生日期
     */
    private String birthday;

    /** 离职日期 */
    private String leaveTime;

    /** 离职原因 */
    private String leaveSum;

    /** 备注 */
    private String comment;

    /** 试用期 */
    private String tryUse;

    /** 转正日期 */
    private String becomeTime;
    private String yearNumber;

    /** 体检日期 */
    private Date healthTime;

    private Long healthChange;

    private String healthResult;

    private String insuranceType;

    /** 购买的保险日期 */
    private String buyInsuranceTime;

    /** 退保日期'; */
    private String delInsuranceTime;

    private Integer dataCollection;

    private Integer isRegister;

    private Integer isIdcardAccessory;

    private Integer labourCompact;

    private Integer healthTable;

    private Integer becomeContent;

    private Integer graduateAccessory;

    private Integer extraSige;

    private Integer secureBook;

    private Integer takeBook;

    private Integer advanceTable;

    private Integer phsitionTable;

    private String bankType;

    private String bankNum;

    private String bankNickname;

    private String bankContact;

    /** 转正说明 */
    @Excel(name = "转正说明")
    private String becomeRemark;

    /** 离职说明 */
    @Excel(name = "离职说明")
    private String leaveRemark;

    /** 调动说明 */
    @Excel(name = "调动说明")
    private String removeRemark;
}
