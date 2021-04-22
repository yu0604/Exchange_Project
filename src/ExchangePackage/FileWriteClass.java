package ExchangePackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriteClass {
	private FileWriter fw;
	boolean isFileExist;

	public FileWriteClass() {
		try {
			File file = new File("C:\\Users\\kopo\\Desktop\\exchange.csv");
			if (file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter("C:\\Users\\kopo\\Desktop\\exchange.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileClose() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void headerWrite() throws IOException {
		if (isFileExist == false) {
			String head = "��¥," + "ȯ�����," + "�ݾ�," + "ȯ�����," + "�Ž�����" + "\n";
			fw.write(head);
		}
	}

	public void dataWrite(ExchangeType exType) throws IOException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		String result = sdf.format(c.getTime()) + "," + exType.exchange_type + "," + exType.w + "," + exType.w / exType.ex_rate + "," + exType.returnwon + "\n";
		fw.write(result);
	}

}
