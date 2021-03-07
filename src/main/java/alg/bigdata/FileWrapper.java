package alg.bigdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrapper {
	private static final int MAX_LINE_SIZE = 10000;
	private static final String LINE_SEPERATOR = "\n";
	private BufferedWriter bufWriter;
	int lineSize;

	public void addLineData(String lineData) throws IOException {
		if (lineSize >= MAX_LINE_SIZE) {
			bufWriter.flush();
			lineSize = 0;
		}
		bufWriter.append(lineData + LINE_SEPERATOR);
		lineSize++;
	}

	public BufferedWriter getBufWriter() {
		return bufWriter;
	}

	public void setBufWriter(BufferedWriter bufWriter) {
		this.bufWriter = bufWriter;
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}

	public static FileWrapper craeteFileWrapper(String fileName) throws IOException {
		File f =new File(fileName) ;
		if(f.exists()){
			f.delete();
		}
		FileWrapper fw = new FileWrapper();
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		fw.setBufWriter(bw);
		fw.setLineSize(0);
		return fw;
	}

	public void close() throws IOException {
		bufWriter.close();
	}
}