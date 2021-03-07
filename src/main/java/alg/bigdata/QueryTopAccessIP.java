package alg.bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QueryTopAccessIP {
	String dataPath = "D:\\bigdata";

	String fileName = "topip.datas.txt";

	public static void main(String[] args) {
		QueryTopAccessIP queryIp = new QueryTopAccessIP();
		queryIp.solution(false);
	}

	private void solution(boolean deleteOnExists) {
		File file = new File(dataPath + File.separator + fileName);
		if (!file.exists()) {
			System.out.println("The file not exists.");
			return;
		}
		queryTopAccessIP(file);
	}

	private void queryTopAccessIP(File file) {
		long startTime = System.currentTimeMillis() / 1000;

		Map<String, IpWrapper> ipHash = new HashMap<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String ip = line.split(",")[2];
				if (ipHash.containsKey(ip)) {
					ipHash.get(ip).incNum();
				} else {
					ipHash.put(ip, new IpWrapper(ip));
				}
			}

			System.out.println("ipHash.size:" + ipHash.size());
			IpWrapper[] ipArray = ipHash.values().toArray(new IpWrapper[ipHash.size()]);
			heapSort(ipArray, 10);

			for (int i = 0; i < 11; i++) {
				System.out.println(ipArray[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		long endTime = System.currentTimeMillis() / 1000;
		System.out.println("query top access ip used:" + (endTime - startTime) + "s");
	}

	private void heapSort(IpWrapper[] datas, int k) {
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(datas, i, k);
		}

		for (int j = k; j <= datas.length - 1; j++) {
			if (datas[0].getAccessNum() < datas[j].getAccessNum()) {
				IpWrapper temp = datas[0];
				datas[0] = datas[j];
				datas[j] = temp;
			}
			adjustHeap(datas, 0, k);
		}
	}

	private void adjustHeap(IpWrapper[] datas, int i, int length) {
		IpWrapper temp = datas[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && datas[k].getAccessNum() > datas[k + 1].getAccessNum()) {
				k = k + 1;
			}
			if (datas[k].getAccessNum() < temp.getAccessNum()) {
				datas[i] = datas[k];
				i = k;
			} else {
				break;
			}
		}
		datas[i] = temp;
	}
}