package alg.bigdata;

public class BitMap {

	byte[] bits;

	public BitMap(int size) {
		bits = new byte[getIndex(size) + 1];
	}

	public void add(int num) {
		bits[getIndex(num)] |= 1 << getPos(num);
	}

	public boolean exists(int num) {
		return (bits[getIndex(num)] & 1 << getPos(num)) != 0;
	}

	public int getIndex(int num) {
		return num >> 3;
	}

	public int getPos(int num) {
		return num & 0x07;
	}

	public void clear(int num) {
		bits[getIndex(num)] &= ~(1 << getPos(num));
	}

	public static void main(String[] args) {
		int size = 1000;
		BitMap bitMap = new BitMap(size);
		for (int i = 0; i <= size; i++) {
			bitMap.add(i);
		}
		System.out.println(bitMap.exists(0));
		System.out.println(bitMap.exists(11));
		System.out.println(bitMap.exists(1000));
		System.out.println(bitMap.exists(1001));
	}
}