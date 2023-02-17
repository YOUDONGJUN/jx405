package com.example.utils;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
/**
 * HttpSession객체에 속성을 저장, 삭제, 조회하는 기능을 제공하는 유틸클래스다.
 * 실제로 프로젝트에서는 얘를 더 많이 사용할 것이다. 
 * @author lion3
 *
 */
public class SessionUtils {

	/**
	 * 속성명, 속성(객체)를 전달받아서 HttpSession객체에 저장한다. 
	 * @param name 속성명
	 * @param value 객체
	 */
	public static void addAttribute(String name, Object value) {
		/*
		 * RequestContextHolder
		 * 		+ 스프링에서 제공하는 유틸클래스이다.
		 * 		+ 요청객체와 세션객체의 속성에 접근할 수 있는 기능을 제공한다. 
		 * 		+ RequestContextHolder.getRequestAttributes()는 RequestAttributes 객체를 반환한다. 
		 * 		+ RequestAttributes가 제공하는 
		 * 			setAttribute(name, value, scope))
		 * 			removeAttribute(name, scope)
		 * 			getAttribute(name, scope)
		 * 		메소드를 활용하면 요청객체 혹은 세션객체에 속성을 추가, 삭제, 조회할 수 있다. 
		 * 		+메소드의 scope자리에 RequestAttributes.SCOPE_REQUEST, RequestAttributes.SCOPE_SESSION를 지정해서 
		 * 		요청객체/ 세션객체를 구분해서 속성을 관리할 수 있다. 
		 */
		RequestContextHolder.getRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
		//RequestContextHolder 스프링에서 제공해주는 유틸리티, 클라이언트가 보낸 메세지를 꺼내려면 httpServlet을 사용해야하지만, jsp,Controller에서만 
		//꺼낼 수 있기 때문에 사용할 수 있는 유틸리티객체를 만들었다. getRequestAttributes
	}
	/**
	 * 속성명을 전달받아서 HttpSession객체에 해당 속성명으로 저장된 속성(객체)을 삭제한다.
	 * @param name 삭제할 속성의 이름
	 */
	public static void removeAttribute(String name) {
		RequestContextHolder.getRequestAttributes().removeAttribute(name,RequestAttributes.SCOPE_SESSION);
	}
	/**
	 * 속성명을 전달받아서 HttpSession객체에 해당 속성명으로 저장된 속성(객체)을 반환한다. 
	 * @param name 조회할 속성명
	 * @return HttpSession객체에 저장된 속성
	 */
	public static Object getAttribute(String name) {
		return RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	public static void sessionInvalidate() {
		((HttpSession)RequestContextHolder.getRequestAttributes().getSessionMutex()).invalidate();
	}
}