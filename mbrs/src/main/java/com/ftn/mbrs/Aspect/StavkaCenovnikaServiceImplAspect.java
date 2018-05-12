package com.ftn.mbrs.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ftn.mbrs.ValidationException.WrongPriceException;
import com.ftn.mbrs.ValidationException.WrongTaxException;
import com.ftn.mbrs.model.StavkaCenovnika;

@Component
@Aspect
public class StavkaCenovnikaServiceImplAspect {
	
	@Before("execution(* com.ftn.mbrs.service.impl.StavkaCenovnikaServiceImpl.save(..))&& args(stavkaCenovnika, tipPrikljuckaId, cenovnikId)")
	public void StavkaCenovnikaControllerBeforeSaveAdvice(JoinPoint joinPoint, StavkaCenovnika stavkaCenovnika, Long tipPrikljuckaId, Long cenovnikId) throws Throwable {
		if (stavkaCenovnika.getCena() <= 0)
		{
			throw new WrongPriceException("Cena mora biti veca od 0.");
		}
		
		if (stavkaCenovnika.getPorez() < 0)
		{
			throw new WrongTaxException("Porez mora biti veci ili jednak 0.");
		}
	}
	
	@Before("execution(* com.ftn.mbrs.service.impl.StavkaCenovnikaServiceImpl.update(..))&& args(stavkaCenovnika)")
	public void StavkaCenovnikaControllerBeforeUpdateAdvice(JoinPoint joinPoint, StavkaCenovnika stavkaCenovnika) throws Throwable {
		if (stavkaCenovnika.getCena() <= 0)
		{
			throw new WrongPriceException("Cena mora biti veca od 0.");
		}
		
		if (stavkaCenovnika.getPorez() < 0)
		{
			throw new WrongTaxException("Porez mora biti veci ili jednak 0.");
		}
	}
}
