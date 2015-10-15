package kr.blogspot.crowjdh;

public class Asdf {
	public static void main(String[] args) {
		DatabaseProxy db = Database.getInstance();
		for (int i = 0; i < 10000; i++) {
			db.save("James");
			System.out.println(db.load());
		}
	}
}
