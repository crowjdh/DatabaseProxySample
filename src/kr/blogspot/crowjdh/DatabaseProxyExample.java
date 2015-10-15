package kr.blogspot.crowjdh;

import kr.blogspot.crowjdh.model.database.Database;
import kr.blogspot.crowjdh.model.database.proxy.DatabaseProxy;

public class DatabaseProxyExample {
	public static void main(String[] args) {
		DatabaseProxy db = Database.getInstance();
		for (int i = 0; i < 10000; i++) {
			db.save("James");
			System.out.println(db.load());
		}
	}
}
