package com.matcha.mall.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 22:42
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */

@Aspect
public class LoginUserAop {

    @Pointcut("execution(public * com.matcha.mall.*.*(..))")
    public void loginAop() {
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("loginAop()")
    public Object aroundLoginAop(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            System.out.println(request.getRequestURL());
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            Object o = pjp.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
