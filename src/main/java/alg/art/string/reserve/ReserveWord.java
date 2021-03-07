package alg.art.string.reserve;

/**
 * 单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变， 句子中单词以空格符隔开。
 * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
 */
public class ReserveWord {
	public static void main(String[] args) {
		System.out.println(reserveWord("I Love You."));
		System.out.println(reserveWord("I am a Student."));
	}

	public static String reserveWord(String str) {
		char[] ch = str.toCharArray();
		reserve(ch, 0, ch.length - 1);
		int index = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				reserve(ch, index, i - 1);
				index = i + 1;
			}
		}
		return new String(ch);
	}

	static void reserve(char[] ch, int lo, int hi) {
		while (lo < hi) {
			char temp = ch[lo];
			ch[lo++] = ch[hi];
			ch[hi--] = temp;
		}
	}
}
