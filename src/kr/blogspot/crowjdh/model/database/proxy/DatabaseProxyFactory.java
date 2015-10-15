package kr.blogspot.crowjdh.model.database.proxy;

import java.lang.reflect.Proxy;

import kr.blogspot.crowjdh.model.database.Database;

public abstract class DatabaseProxyFactory {
	public static DatabaseProxy newInstance(Database car) {
		return (DatabaseProxy)Proxy.newProxyInstance(car.getClass().getClassLoader(),
				new Class<?>[] { DatabaseProxy.class }, new DatabaseInvocationHandler(car));
	}
}
