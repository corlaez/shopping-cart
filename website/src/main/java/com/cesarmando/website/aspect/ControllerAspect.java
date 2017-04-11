package com.cesarmando.website.aspect;

import com.cesarmando.website.viewmodel.MyAjaxResponse;
import com.google.gson.Gson;
import lombok.experimental.var;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jarma on 4/11/2017.
 */
@Aspect
@Component
public class ControllerAspect {
    @Autowired
    Gson gson;

    //Pointcut: los puntos de corte definen el momento en el q se ejecurá una acción definida como Advice
    @Pointcut("execution(String *(..))")
    private void stringMethod() {}

    @Pointcut("execution(public String *(..))")
    private void publicStringMethod() {}

    @Pointcut("within(com.cesarmando.website.controller..*)")
    private void withinController() {}

    @Pointcut("within(com.cesarmando.website.controllerSys..*)")
    private void withinControllerSys() {}

    @Pointcut("stringMethod() || publicStringMethod()")
    private void openStrings() {}

    @Pointcut("withinController() || withinControllerSys()")
    private void allControllers() {}

    @Pointcut("openStrings() && allControllers()")
    private void pcAroundAnyControllerOpenString() {}

    //Advice: este advice se ejecuta alrededor de cualquier metodo string con acceso default o public q sea controller
    /** Advice for metrics and error handling */
    @Around("pcAroundAnyControllerOpenString()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = null;
        try {
            //todo meter
            retVal = pjp.proceed();
            return retVal;
        }
        catch(Throwable th) {//todo imnplement other catchs.
            var ar = MyAjaxResponse.errorMsg("Lo sentimos hubo un error.");
            th.printStackTrace();
            return gson.toJson(ar);
        }
    }

}
