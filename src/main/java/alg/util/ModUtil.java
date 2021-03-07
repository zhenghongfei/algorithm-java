package alg.util;

public class ModUtil {
	public static void main(String[] args) {
		new ModUtil().testMod();
	}

	void testMod() {
		int length = 9;
		for (int i = 0; i <= 30; i++) {
			System.out.println("Number:" + i + ",商:" + i / length + ",余数：" + i % length);
		}
	}
}
