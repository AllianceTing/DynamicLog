package com.example.dynamiclog.Aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.constant.Constable;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PROJECT_NAME AspectJWare
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/17~20:02
 */
@Component
@Aspect
public class AspectJWare {
@Pointcut("@annotation(com.example.dynamiclog.Aop.Log)")
public void pointcut(){}
@Around(value = "pointcut()")
public Object doLogPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    StopWatch stopWatch =new StopWatch();
    // do start compute Time
    stopWatch.start();
    // do get method Name
    var methodName = proceedingJoinPoint.getSignature().getName();
    ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    assert  ra != null;
    HttpServletRequest request = ra.getRequest();
    MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
    var annotationValue = signature.getMethod().getAnnotation(Log.class).value();
    ConcurrentHashMap<String,Integer> ROLE_HASH = new ConcurrentHashMap<String,Integer>();
    if (ROLE_HASH.contains(annotationValue));
    else throw new SecurityException("信息异常--- > 终止放行");
    Constable remoteUser = request.getRemoteUser();
    var requestMethod = request.getMethod().toUpperCase(Locale.ROOT);
    Constable ToCqueryParms = request.getQueryString().trim();
    Map<String, String[]> requestParameterMap = request.getParameterMap();
    Constable contextPath = request.getContextPath();
    var requestProtocol = request.getProtocol();
    String[] ToBparameterNames = signature.getParameterNames();
    stopWatch.stop();
    long watchTotalTimeNanos = stopWatch.getTotalTimeNanos();
    return proceedingJoinPoint.proceed();
}
}


