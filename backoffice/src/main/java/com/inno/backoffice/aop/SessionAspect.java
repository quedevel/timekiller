package com.inno.backoffice.aop;

import com.inno.backoffice.admin.vo.AdminVO;
import com.inno.backoffice.security.vo.InnoUser;
import com.inno.common.constant.CommonConstants;
import com.inno.common.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Aspect
@Component
public class SessionAspect {

    @Before( "execution(* com.inno.backoffice..*Mapper.insert*(..))"
            + " || execution(* com.inno.backoffice..*Mapper.update*(..))"
            + " || execution(* com.inno.backoffice..*Mapper.delete*(..))"
            + " || execution(* com.inno.common..*Mapper.insert*(..))"
            + " || execution(* com.inno.common..*Mapper.update*(..))"
            + " || execution(* com.inno.common..*Mapper.delete*(..))")
    public void setVO(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        if(SecurityContextHolder.getContext().getAuthentication()!= null) {
            InnoUser user = (InnoUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            AdminVO vo = user.getAdminVO();
            for (Object o : objects) {
                Method[] methods = o.getClass().getMethods();
                Optional<Method> setRegDtime = Arrays.stream(methods).filter(e -> e.getName().equals("setRegDate")).findFirst();
                Optional<Method> setModDtime = Arrays.stream(methods).filter(e -> e.getName().equals("setModDate")).findFirst();
                Optional<Method> setRegSn = Arrays.stream(methods).filter(e -> e.getName().equals("setRegSn")).findFirst();
                Optional<Method> setModSn = Arrays.stream(methods).filter(e -> e.getName().equals("setModSn")).findFirst();
                Optional<Method> getRegSn = Arrays.stream(methods).filter(e -> e.getName().equals("getRegSn")).findFirst();
                Optional<Method> getModSn = Arrays.stream(methods).filter(e -> e.getName().equals("getModSn")).findFirst();
                Date now = new Date();
                try {
                    if (joinPoint.getSignature().getName().startsWith("insert")) {
                        if (setRegDtime.isPresent()) {
                            setRegDtime.get().invoke(o, now);
                        }
                        if (setRegSn.isPresent()) {
                            if (CommonConstants.EMPTY.getValue().equals(StringUtil.null2void((String) getRegSn.get().invoke(o)))) {
                                setRegSn.get().invoke(o, vo.getAdminSn());
                            }
                        }
                    }
                    if (setModDtime.isPresent()) {
                        setModDtime.get().invoke(o, now);
                    }
                    if (setModSn.isPresent()) {
                        if (CommonConstants.EMPTY.getValue().equals(StringUtil.null2void((String) getModSn.get().invoke(o)))) {
                            setModSn.get().invoke(o, vo.getAdminSn());
                        }
                    }
                } catch (Exception e) {
                    //todo
                }
            }
        }

    }
}
