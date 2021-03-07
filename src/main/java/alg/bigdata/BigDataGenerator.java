package alg.bigdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BigDataGenerator {

	String dataPath = "D:\\bigdata";

	public static void main(String[] args) {
		BigDataGenerator dataGen = new BigDataGenerator();
//		dataGen.genIpDatas("ip.datas.txt", true, 200000000, 2000000);
		dataGen.genIpDatas("topip.datas.txt", true, 10000000, 3000000);
	}

	/**
	 * 生成IP地址文件
	 * 
	 * @param count
	 *            文件条数
	 */
	private void genIpDatas(String fileName, boolean deleteOnExists, int recoredNum, int ipNum) {
		File file = new File(dataPath + File.separator + fileName);
		if (file.exists()) {
			if (deleteOnExists) {
				file.delete();
			} else {
				return;
			}
		}

		Random genRandom = new Random();
		String[] ipArray = new String[ipNum];
		for (int i = 0; i < ipArray.length; i++) {
			byte[] ip = new byte[4];
			genRandom.nextBytes(ip);

			String ipAddr = bytesToIp(ip);
			ipArray[i] = ipAddr;
		}

		Random queryRandom = new Random(ipNum);
		BufferedWriter bw = null;
		try {
			int num = 0;
			bw = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < recoredNum; i++) {
				String line = String.join(",", "name" + i, "age" + i, ipArray[Math.abs(queryRandom.nextInt(ipNum - 1))],
						"\n");
				bw.write(line);
				num++;
				if (num >= 10000) {
					bw.flush();
					num = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String bytesToIp(byte[] src) {
		return (src[0] & 0xff) + "." + (src[1] & 0xff) + "." + (src[2] & 0xff) + "." + (src[3] & 0xff);
	}
}