package com.ftn.mbrs.Aspect;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.validation.Valid;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.patterns.Declare;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.mbrs.ValidationException.WrongDateException;
import com.ftn.mbrs.model.Cenovnik;

@Component
@Aspect
public class CenovnikServiceImplAspect {

	@Before("execution(* com.ftn.mbrs.service.impl.CenovnikServiceImpl.save(..))&& args(cenovnik)")
	public void CenovnikControllerBeforeSaveAdvice(JoinPoint joinPoint, Cenovnik cenovnik) throws Throwable {
		if (cenovnik.getDatum().before(new Date()))
			{
				throw new WrongDateException("Date is older than current date.");
			}
	}
	
	@Before("execution(* com.ftn.mbrs.service.impl.CenovnikServiceImpl.update(..))&& args(cenovnik)")
	public void CenovnikControllerBeforeUpdateAdvice(JoinPoint joinPoint, Cenovnik cenovnik) throws Throwable {
		if (cenovnik.getDatum().before(new Date()))
			{
				throw new WrongDateException("Date is older than current date.");
			}
	}
}
