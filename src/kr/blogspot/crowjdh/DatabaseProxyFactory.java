package kr.blogspot.crowjdh;

import java.lang.reflect.Proxy;

public abstract class DatabaseProxyFactory {
	public static DatabaseProxy newInstance(Database car) {
		return (DatabaseProxy)Proxy.newProxyInstance(car.getClass().getClassLoader(),
				new Class<?>[] { DatabaseProxy.class }, new DatabaseInvocationHandler(car));
	}
}
