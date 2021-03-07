package alg.bigdata;

public class IpWrapper {
	private String ip;
	private int accessNum;

	public IpWrapper(String ip) {
		this.ip = ip;
		accessNum++;
	}

	public void incNum() {
		accessNum++;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(int accessNum) {
		this.accessNum = accessNum;
	}

	@Override
	public String toString() {
		return "IpWrapper [ip=" + ip + ", accessNum=" + accessNum + "]";
	}
}