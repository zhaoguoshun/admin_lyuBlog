package com.wanou.framework.web.exception;

import com.wanou.common.exception.*;
import org.aspectj.weaver.loadtime.Aj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.wanou.common.constant.HttpStatus;
import com.wanou.common.utils.StringUtils;
import com.wanou.framework.web.domain.AjaxResult;

/**
 * 全局异常处理器
 *
 * @author ruoyi
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult baseException(BaseException e)
    {
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(CustomException.class)
    public AjaxResult businessException(CustomException e)
    {
        if (StringUtils.isNull(e.getCode()))
        {
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public AjaxResult handlerNoFoundException(Exception e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(HttpStatus.NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public AjaxResult handleAuthorizationException(AccessDeniedException e)
    {
        log.error(e.getMessage());
        return AjaxResult.error(HttpStatus.FORBIDDEN, "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(AccountExpiredException.class)
    public AjaxResult handleAccountExpiredException(AccountExpiredException e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public AjaxResult handleUsernameNotFoundException(UsernameNotFoundException e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult validatedBindException(BindException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 演示模式异常
     */
    @ExceptionHandler(DemoModeException.class)
    public AjaxResult demoModeException(DemoModeException e)
    {
        return AjaxResult.error("演示模式，不允许操作");
    }

    /**
     *换取openid异常
     */
    @ExceptionHandler(OpenIdException.class)
    public AjaxResult openidException(OpenIdException e){
        return AjaxResult.error(e.getMessage());
    }

    /**
     *小程序用户未绑定信息
     */
    @ExceptionHandler(NoBindMiniUserException.class)
    public AjaxResult noMiniUserException(NoBindMiniUserException e){
        return AjaxResult.error(HttpStatus.MINI_USER_NO_BIND,e.getOpenid());
    }

    /**
     * 小程序用户未找到异常
     * @param e
     * @return
     */
    @ExceptionHandler(MiniUserNotFoundException.class)
    public AjaxResult miniUserNotFoundException(MiniUserNotFoundException e){
        return AjaxResult.error(HttpStatus.UNAUTHORIZED,e.getMessage());
    }

    /**
     * 小程序用户未登录或登录过期异常
     * @param e
     * @return
     */
    @ExceptionHandler(MiniUserLoginException.class)
    public AjaxResult miniUserLoginException(MiniUserLoginException e){
        return AjaxResult.error(HttpStatus.UNAUTHORIZED,e.getMessage());
    }

    /**
     * 小程序无权限异常
     * @param e
     * @return
     */
    @ExceptionHandler(MiniNoAccessException.class)
    public AjaxResult miniNoAccessException(MiniNoAccessException e){
        return AjaxResult.error(HttpStatus.ERROR,e.getMessage());
    }
}
