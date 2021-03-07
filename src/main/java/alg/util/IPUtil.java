package alg.util;

public class IPUtil {
	public static void main(String[] args) {
		String ipStr = "192.168.1.1";
		long ipLong = ip2Long(ipStr);
		System.out.println(ipLong);
		System.out.println(long2Ip(ipLong));
	}

	public static long ip2Long(String ipStr) {
		String[] ipArr = ipStr.split("\\.");
		long ip = Long.parseLong(ipArr[3]) & 0xFF;
		ip |= (Long.parseLong(ipArr[2]) << 8) & 0xFF00;
		ip |= (Long.parseLong(ipArr[1]) << 16) & 0xFF0000;
		ip |= (Long.parseLong(ipArr[0]) << 24) & 0xFF000000;
		return ip;
	}

	public static String long2Ip(long ip) {
		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
	}
}
