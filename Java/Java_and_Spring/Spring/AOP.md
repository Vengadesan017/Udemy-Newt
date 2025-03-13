# Aspect oriented Programming
- focus the business logic
- mantain the log(Before , After), security, Validation Exception
- so create seperate class and call auto matically
- concept
  - join point - when
  - advice - what
  - Aspect - where-Conceptio
  - pointcut - where operational
  - targerobject - whom
  - weaving - how
  - Proxy - the double
- time
  - before
  - join point
  - after .... same type
### Step
1. create aop package
2. inside this create LoggingAspect class and mention as @COmponent, @Aspect
3. in the class create the obj of loggerfactor with static final
4. call info("..") from logger in function and mention as @Before("execution(*)")
5. inside (*) define the return type ,full class name, method name, args  
```

@Aspect
@Component
public class LoggingAspect {

	public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
	

	@Before("execution (* com.telusko.springbootrest.service.JobService.*(..))")
	public void logMethodCall() {
		LOGGER.info("Method Called ");
	}
}

--Joinpoint
	@Before("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called "+jp.getSignature().getName());
	}
	
	
	-- after
	@After("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed "+jp.getSignature().getName());
	}
	
	
	@AfterThrowing("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method has some issues "+jp.getSignature().getName());
	}
	
	
	
	@AfterReturning("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodExecutedSuccess(JoinPoint jp) {
		LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
	}
```
### performance Aspect
- by calculating the start time and end time
```
@Component
@Aspect
public class PerformanceMonitorAspect {

	public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	
	
	
	@Around("execution (* com.telusko.springbootrest.service.JobService.*(..))")
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		
		long start=System.currentTimeMillis();
		
		Object obj= jp.proceed();
		long end=System.currentTimeMillis();
		
		LOGGER.info("Time taken by: "+jp.getSignature().getName()+" "+(end-start)+" ms");
		return obj;
	}
}
```
### Validate the data
- return the positive value when the negative value is enterd
```
@Component
@Aspect
public class ValidationAspect {

	
	public static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);
	
	
	@Around("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) && args(postId)")
	public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
	if (postId<0) {
		LOGGER.info("PostId is negative, updating it");
		
		postId=-postId;
		LOGGER.info("new Value "+postId);
	}
	
	Object obj=jp.proceed(new Object[] {postId});
		
		
		
		return obj;
	}
}
```
