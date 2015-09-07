package com.hand.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		String result = invocation.invoke();
		if(com.hand.action.LoginAction.username.equals(null)){return "fail";}
		else{return result;}	
	}
}
