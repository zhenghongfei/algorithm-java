package alg.bigdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QueryMaxAccessIP {
	String dataPath = "D:\\bigdata";

	String fileName = "ip.datas.txt";

	public static void main(String[] args) {
		QueryMaxAccessIP queryIp = new QueryMaxAccessIP();
		queryIp.solution(false);
	}

	private void solution(boolean deleteOnExists) {
		File file = new File(dataPath + File.separator + fileName);
		if (!file.exists()) {
			System.out.println("The file not exists.");
			return;
		}

		int fileSize = 1000;
		if (deleteOnExists) {
			splitFile(file, fileSize);
		}

		queryMaxAccessIP(fileSize);
	}

	private void queryMaxAccessIP(int fileSize) {
		long startTime = System.currentTimeMillis() / 1000;
		String globalMaxAccessIp = null;
		int globalMaxAccessIpNum = 0;
		for (int i = 0; i < fileSize; i++) {
			File smallFile = new File(dataPath + File.separator + "ip.data." + i + ".txt");
			if (!smallFile.exists()) {
				continue;
			}

			Map<String, AtomicInteger> ipHash = new TreeMap<>();
			BufferedReader br = null;
			String maxAccessIp = null;
			int maxAccessIpNum = 0;
			try {
				br = new BufferedReader(new FileReader(smallFile));
				String ip = null;
				while ((ip = br.readLine()) != null) {
					if (ipHash.containsKey(ip)) {
						ipHash.get(ip).incrementAndGet();
					} else {
						ipHash.put(ip, new AtomicInteger(1));
					}

					if (ipHash.get(ip).get() > maxAccessIpNum) {
						maxAccessIpNum = ipHash.get(ip).get();
						maxAccessIp = ip;
					}
				}
				// System.out.println(ipHash.size() + ",maxAccessIp:" + maxAccessIp +
				// ",maxAccessIpNum:" + maxAccessIpNum);

				if (maxAccessIpNum > globalMaxAccessIpNum) {
					globalMaxAccessIpNum = maxAccessIpNum;
					globalMaxAccessIp = maxAccessIp;
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
		}

		System.out.println("globalMaxAccessIp:" + globalMaxAccessIp + ",globalMaxAccessIpNum:" + globalMaxAccessIpNum);

		long endTime = System.currentTimeMillis() / 1000;
		System.out.println("query max access ip used:" + (endTime - startTime) + "s");
	}

	private void splitFile(File file, int fileSize) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			int num = 0;
			String line = null;
			long startTime = System.currentTimeMillis() / 1000;
			FileWrapper[] fileWrappers = new FileWrapper[fileSize];
			while ((line = br.readLine()) != null) {
				num++;
				String ip = line.split(",")[2];
				int mod = Math.abs(ip.hashCode()) % fileSize;
				if (fileWrappers[mod] == null) {
					fileWrappers[mod] = FileWrapper
							.craeteFileWrapper(dataPath + File.separator + "ip.data." + mod + ".txt");
				}
				fileWrappers[mod].addLineData(ip);
			}

			for (FileWrapper fw : fileWrappers) {
				fw.close();
			}
			long endTime = System.currentTimeMillis() / 1000;
			System.out.println("split files used:" + (endTime - startTime) + "s" + ",num:" + num);
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
	}
}