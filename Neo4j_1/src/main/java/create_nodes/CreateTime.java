package createNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import objects.Event;
import objects.Time;

public class CreateTime extends CreateNode {
	
	ArrayList<Time> listTime = new ArrayList<>();
 	public CreateTime(int maxNode) {
		super(365);
		
	}

	@Override
	public void createToCSV(String fileName) {
		Random rand = new Random();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/data/Time.txt"), "UTF-8"));
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			String str;
			Time time = null;
			Date timeGet = new Date();
			int i = 0;
			while ((str = in.readLine()) != null) {
				String s[] = str.split("\\|");
				String name = s[0];
				String description = s[1];
				int id = 500000000 + i;
				time = new Time(id, name, description, listLinks[rand.nextInt(listLinks.length)], timeGet);
				listTime.add(time);
				i++;
			}

			out.write("");

			out.append("idNode" + ",");
			out.append("name" + ",");
			out.append("description" + ",");
			out.append("link" + ",");
			out.append("timeGet" + "");
			out.append("\r\n");

			for (Time e : listTime) {
				out.append(e.getIdNode() + ",");
				out.append(e.getName() + ",");
				out.append(e.getDescription() + ",");
				out.append(e.getLink() + ",");
				out.append(e.getTimeGet().toString());
				out.append("\r\n");
				out.flush();
			}

			out.flush();
			out.close();
			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		long begin = Calendar.getInstance().getTimeInMillis();
		// some code.....

		CreateTime cp = new CreateTime(365);
		cp.createToCSV("src/database/CreateTime.csv");
		System.out.println("Sinh thanh cong");

		//
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("time to run: " + (end - begin) + " ms!");

	}
	

	
}
