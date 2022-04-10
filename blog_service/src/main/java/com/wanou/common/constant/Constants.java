package com.wanou.common.constant;

import io.jsonwebtoken.Claims;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi://";

    /**
     * 设备操作任务key前缀
     */
    public static final String DEV_TASK_DEV_REQUEST_KEY = "device_task_dev_request_";

    /**
     * 人员操作任务key前缀
     */
    public static final String DEV_TASK_PERSON_REQUEST_KEY = "device_task_person_request_";

    /**
     * 设备任务是否需要延迟执行标记
     */
    public static final String DEVICE_TASK_DELAY_FLAG = "device_task_delay_flag_";
    /**
     * 部门缓存
     */
    public static final String SYS_DEPT_CACHE = "sys_dept_cache";
    /**
     * 人员任务列表前缀
     */
    public static final String PERSON_TASK_LIST_PREFIX = "person_task_list_prefix_";

    /**
     * 员工人脸通行
     */
    public static final String MEETING_RECORD_STAFF = "meeting_record_staff_";

    /**
     * 陌生人人脸通行
     */
    public static final String MEETING_RECORD_STRANGER = "meeting_record_stranger_";

    /**
     * 识别记录
     */
    public static final String MEETING_RECORD = "meeting_record_";

    /**
     * 设备心跳
     */
    public static final String DEVICE_HEARTBEAT = "device_heartbeat";
    /**
     * 全部设备列表
     */
    public static final String DEVICE_LIST = "device_list";

    /**
     * 全部部门列表
     */
    public static final String DEPT_LIST = "dept_list";

    /**
     * 小程序登录token缓存key
     */
    public static final String MINI_USER_LOGIN = "mini_user_login:";

    /**
     * 人员与小程序用户绑定缓存
     */
    public static final String PERSON_BIND_CODE = "person_bind_code:";
}
