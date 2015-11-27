package kr.blogspot.crowjdh.model.database;

import kr.blogspot.crowjdh.model.database.proxy.DatabaseProxy;
import kr.blogspot.crowjdh.model.database.proxy.DatabaseProxyFactory;

public class Database implements DatabaseProxy {
    private volatile static DatabaseProxy instance;
    private String mName;

    public static DatabaseProxy getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = DatabaseProxyFactory.newInstance(new Database());
                }
            }
        }
        return instance;
    }

    private Database() { }

	@Override
	public void save(String name) {
		System.out.println("saving: " + name);
		mName = name;
		somePrivateMethod();
	}

	@Override
	public String load() {
		System.out.println("Loading...");
		somePrivateMethod();
		return mName;
	}
	
	private void somePrivateMethod() {
		System.out.println("This method is not wrapped by it's own transaction.");
	}
}
