package alg.interview;

public class RoateString {

	public static void main(String[] args) {
		String input = "    ab    cd    ef    gh   ";
		String result = roateString(input);
		System.out.println(result.equals("   gh    ef    cd    ab    "));
	}

	public static String roateString(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		char[] ch = input.toCharArray();
		roate(ch, 0, ch.length - 1);

		int start = 0;
		int end = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				if (start != 0) {
					end = i - 1;
					roate(ch, start, end);
					start = 0;
					end = 0;
				}
				continue;
			}

			if (start == 0) {
				start = i;
			}
		}
		return new String(ch);
	}

	private static void roate(char[] datas, int low, int high) {
		while (low < high) {
			char temp = datas[low];
			datas[low++] = datas[high];
			datas[high--] = temp;
		}
	}
}