package egovframework.gettingstart.aop;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * TODO [Step 3-1] Advice 클래스 확인
 * Advice는 여러 클래스의 비지니스 로직 상에 분산되어 처리되는 
 * 공통 관심사(Crosscutting concerns)에 대한 처리부분임
 */
public class AdviceUsingXML {
	private Logger logger = Logger.getLogger(this.getClass());	// Logger 처리

	@SuppressWarnings("unchecked")
	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		logger.debug("================================================================================\n");
		logger.debug("AdviceUsingXML.beforeTargetMethod executed.");

		@SuppressWarnings("unused")
		Class clazz = thisJoinPoint.getTarget().getClass();
		String className = thisJoinPoint.getTarget().getClass().getSimpleName();
		String methodName = thisJoinPoint.getSignature().getName();

		// 현재 class, method 정보 및 method arguments 로깅
		StringBuffer buf = new StringBuffer();
		buf.append("\n== AdviceUsingXML.beforeTargetMethod : [" + className	+ "." + methodName + "()] ==");
		Object[] arguments = thisJoinPoint.getArgs();
		int argCount = 0;
		for (Object obj : arguments) {
			buf.append("\n - arg ");
			buf.append(argCount++);
			buf.append(" : ");
			// commons-lang 의 ToStringBuilder를 통해(reflection 을 이용)한 VO 정보 출력
			buf.append(ToStringBuilder.reflectionToString(obj));
		}

		// 대상 클래스의 logger 를 사용하여 method arguments 로깅
		// 하였음.
		if (logger.isDebugEnabled())
			logger.debug(buf.toString());

	}

	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		logger.debug("================================================================================\n");
		logger.debug("AdviceUsingXML.afterTargetMethod executed.");
	}

	@SuppressWarnings("unchecked")
	public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
		logger.debug("================================================================================\n");
		logger.debug("AdviceUsingXML.afterReturningTargetMethod executed.");

		@SuppressWarnings("unused")
		Class clazz = thisJoinPoint.getTarget().getClass();
		String className = thisJoinPoint.getTarget().getClass().getSimpleName();
		String methodName = thisJoinPoint.getSignature().getName();

		// 현재 class, method 정보 및 method arguments 로깅
		StringBuffer buf = new StringBuffer();
		buf.append("\n== AdviceUsingXML.afterReturningTargetMethod : ["	+ className + "." + methodName + "()] ==");

		buf.append("\n");

		// 결과값이 List 이면 size 와 전체 List 데이터를 풀어 reflection 으로 출력 - 성능상 사용않는 것이 좋음
		if (retVal instanceof List) {
			List resultList = (List) retVal;
			buf.append("resultList size : " + resultList.size() + "\n");
			for (Object oneRow : resultList) {
				buf.append(ToStringBuilder.reflectionToString(oneRow));
				buf.append("\n");
			}
		} else {
			buf.append(ToStringBuilder.reflectionToString(retVal));
		}

		// 대상 클래스의 logger 를 사용하여 결과값 로깅  하였음.
		if (logger.isDebugEnabled())
			logger.debug(buf.toString());

		// return value 의 변경은 불가함에 유의!
	}

	public void afterThrowingTargetMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception {
		logger.debug("================================================================================\n");
		logger.debug("AdviceUsingXML.afterThrowingTargetMethod executed.");
		logger.error("Exception occured.", exception);

		// 원본 exception 을 wrapping 하고 user-friendly 한 메시지를 설정하여 새로운 Exception 으로 re-throw
		throw new Exception("Exception occured.", exception);
	}

	public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		logger.debug("================================================================================\n");
		logger.debug("AdviceUsingXML.aroundTargetMethod start.");
		long time1 = System.currentTimeMillis();

		Object retVal = thisJoinPoint.proceed();

		// Around advice 의 경우 결과값을 변경할 수도 있음!
		// 위의 retVal 을 가공하거나 심지어 전혀 다른 결과값을 대체하여  caller 에 되돌려줄 수 있음

		long time2 = System.currentTimeMillis();
		logger.debug("AdviceUsingXML.aroundTargetMethod end. Time("	+ (time2 - time1) + ")");

		return retVal;
	}
}
