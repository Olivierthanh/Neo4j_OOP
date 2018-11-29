package create_nodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import objects.Time;

public class CreateTime {
	// Create Time
	private ArrayList<Time> createTime(String fileName) {
		String[] listLinks = {"https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
				"https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/"};
		ArrayList<Time> listTime = new ArrayList<>();
		Random rand = new Random();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

			String str;
			Time time = null;
			Date timeGet = new Date();
			int i = 0;
			while ((str = in.readLine()) != null) {
				String s[] = str.split("\\|");
				String name = s[0];
				String description = s[1];
				String id = "TME" + i;
				time = new Time(id, name, description, listLinks[rand.nextInt(listLinks.length)], timeGet);
				listTime.add(time);
				i++;
			}

			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listTime;
	}

	// Write file
	public void writeFile(String inFileName, String outFileName) throws IOException {

		try {

			File fileDir = new File(outFileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			ArrayList<Time> listTime = createTime(inFileName);
			for (Time e : listTime) {
				out.append(e.getId() + ",");
				out.append(e.getName() + ",");
				out.append(e.getDescription() + ",");
				out.append(e.getLink() + ",");
				out.append(e.getTimeGet().toString());
				out.append("\r\n");
				out.flush();
			}

			out.flush();
			out.close();

		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		String inFileName = "Time.txt";
		String outFileName = "CreateTime.csv";
		CreateTime ce = new CreateTime();
		try {

			ce.writeFile(inFileName, outFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("lỗi");
			e.printStackTrace();
		}
	}
}
