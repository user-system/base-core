package com.ld.base.core.aop;

import com.ld.base.core.enums.httpstate.ResultEnum;
import com.ld.base.core.exception.CoreException;
import com.ld.base.core.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常处理配置类
 *
 * @author 王海龙
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandleAdvice {

    /**
     * 捕获异常信息
     *
     * @param request 请求体
     * @param e       异常信息
     * @return 处理结果
     */
    @ExceptionHandler({Exception.class})
    public <T> ResultVo<T> handler(HttpServletRequest request, Exception e) {
        log.warn("URL : " + request.getRequestURL().toString());
        log.warn("HTTP_METHOD : " + request.getMethod());
        log.warn("IP : " + request.getRemoteAddr());
        log.warn("请求类型: " + request.getContentType());
        log.warn("异常类型: {}", e.toString());

        ResultVo<T> resultVo = new ResultVo<>();

        if (e instanceof MethodArgumentNotValidException) {

            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                log.warn("异常实体：{},异常字段: {},异常值: {},异常信息: {}", error.getObjectName(), error.getField(),
                        error.getRejectedValue(), error.getDefaultMessage());
                resultVo.setCode(ResultEnum.ERROR_VALID.getCode());
                resultVo.setMsg(error.getDefaultMessage());
                return resultVo;
            }
        } else if (e instanceof CoreException) {
            resultVo.setCode(((CoreException) e).getCode());
            resultVo.setMsg(e.getMessage());
        } else {
            resultVo.setCode(ResultEnum.FAILED.getCode());
            resultVo.setMsg(ResultEnum.FAILED.getMessage());
        }

        return resultVo;
    }

}
