package com.hopoong.jpa.config.aop

import com.hopoong.jpa.util.TimeUtil
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

//@Component
//@Aspect
class LoggerAspect {

    private val log = LoggerFactory.getLogger(this::class.java)


    @Pointcut(
        "within(@org.springframework.web.bind.annotation.RestController *)"
    )
    fun setPointcut() {
    }

    @Around("setPointcut()")
    @Throws(Throwable::class)
    fun logging(joinPoint: ProceedingJoinPoint): Any? {
        val result: Any = joinPoint.proceed()
        val request: HttpServletRequest =
            (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request // request 정보를 가져온다.
        val params = mutableMapOf<String, Any>()

        try {
            params["controller"] = joinPoint.signature.declaringType.simpleName
            params["method"] = joinPoint.signature.name
//            params["methodParameter"] = ObjectMapper().writeValueAsString(joinPoint.args)
            params["log_time"] = TimeUtil().getFormattedTimestamp()
            params["request_uri"] = request.requestURI
            params["http_method"] = request.method
        } catch (e: Exception) {
            log.error("LoggerAspect error", e)
        }
        log.info("params : {}", params);
        return result
    }
}