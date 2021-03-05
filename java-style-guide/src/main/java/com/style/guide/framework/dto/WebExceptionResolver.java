package com.style.guide.framework.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 异常拦截
 *
 * @author chenjw
 * @date 2020/8/7
 **/
@ControllerAdvice
@Component
public class WebExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(WebExceptionResolver.class);

    /**
     * JSR303 数据校验不通过错误拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result dataBindException(BindException e) {
        return Result.set(ResultStatus.Failure,
                e.getFieldError().getField() + e.getFieldError().getDefaultMessage());
    }

    /**
     * HTTP Status 500 Method Not Support
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result methodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return Result.set(ResultStatus.Method_Not_Allowed, "不支持该请求方法");
    }

    /**
     * 400 Bad Request
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public Result requestParameterException(MissingServletRequestParameterException e) {
//        log.info("Bad Request", e);
        return Result.failure("请求参数不正确，缺少" + e.getParameterName());
    }

    /**
     * 缺少请求体异常处理器
     *
     * @param e 缺少请求体异常
     * @return ResponseResult
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        return Result.failure("请求体数据不可读异常");
    }

    /**
     * 数据库主键重复异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public Result duplicateKeyException(DuplicateKeyException e) {
        log.warn("主键重复", e);
        return Result.failure("数据重复了啊");
    }

    /**
     * 数据库主键重复异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public Result dtaIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("数据长度超长", e);
        return Result.failure("数据长度超长了，请重新输入");
    }

    /**
     * 全局未知异常拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result globalException(Exception e) {
        log.error("未知异常", e);
        return Result.error("服务器内部异常");
    }

    /**
     * 参数效验异常处理器
     *
     * @param e 参数验证异常
     * @return ResponseInfo
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Result paramExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return Result.failure(fieldError.getField() + fieldError.getDefaultMessage());
            }
        }
        return Result.failure("请求参数错误");
    }


}