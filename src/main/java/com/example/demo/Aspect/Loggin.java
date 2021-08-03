package com.example.demo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@Aspect
public class Loggin {
	
	Logger log=LoggerFactory.getLogger(Loggin.class);
	
	
	@Pointcut(value= "execution(* com.example.demo.Service.*.*(..))")
	public void myPointCut() {
		
	}
	
	
	@Around("myPointCut()")
	public Object AppLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] arg=pjp.getArgs();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
		
		log.info("user : "+ username+" method invoked "+className+" : "+methodName+"()"
		          +"arguments : "+mapper.writeValueAsString(arg));
		Object object =pjp.proceed();
		
		log.info("user : "+ username+"  "+className+" : "+methodName+"()"
		          +"Response : "+mapper.writeValueAsString(object));
		return object;
	}

}
