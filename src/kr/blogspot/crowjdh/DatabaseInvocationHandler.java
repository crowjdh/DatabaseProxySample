package kr.blogspot.crowjdh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DatabaseInvocationHandler implements InvocationHandler {
	private Object mCaller;
	
	public DatabaseInvocationHandler(Object caller) {
		mCaller = caller;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		try {
			if (method.getName().contains("save")) {
				System.out.println("Begin transaction");
				result = method.invoke(mCaller, args);
				System.out.println("End transaction");
			} else {
				result = method.invoke(mCaller, args);
			}
		} catch (Exception ignored) { }
		return result;
	}

}
