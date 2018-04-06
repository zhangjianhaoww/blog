package tech.bilian.myblog.dao.split;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect {


    @Before("execution(* tech.bilian.myblog.service.serviceimpl.*.*(..))")
    public void before(JoinPoint joinPoint) throws Exception{
        String methodName = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        Class<?>[] classzz = target.getClass().getInterfaces();
        Class<?>[] paramesType = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
        Method method = classzz[0].getMethod(methodName, paramesType);
        DataSource dataSource;

        if(method != null && method.isAnnotationPresent(DataSource.class)){
            dataSource = method.getAnnotation(DataSource.class);
            if(dataSource.value().equals("slave")){
                DynamicDatasourceHolder.setDbType(DynamicDatasourceHolder.DB_SLAVE);
            }else {
                DynamicDatasourceHolder.setDbType(DynamicDatasourceHolder.DB_MASTER);
            }
        }else {
            DynamicDatasourceHolder.setDbType(DynamicDatasourceHolder.DB_MASTER);
        }
    }
}
