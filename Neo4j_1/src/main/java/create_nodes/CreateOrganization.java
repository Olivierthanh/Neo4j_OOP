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

import objects.Organization;

public class CreateOrganization {
	// sinh ngau nhien thuc the
	private ArrayList <Organization> createOrganization(String fileName){
		String[] listLinks = { "https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
				"https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/" };
		ArrayList<Organization> listOrganization = new ArrayList<>();
		Random rand = new Random();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

			String str;
			Organization organization = null;
			Date timeGet = new Date();
			int i = 0;
			while ((str = in.readLine()) != null) {
				String s[] = str.split("\\|");  // đọc dữ liệu trong notepad ngăn cách nhau bởi dấu |
				String name = s[0];
				String active = s[1];
				String description = s[2];
				String id = "Organ" + i;
				organization  = new Organization(id, name, active, listLinks[rand.nextInt(listLinks.length)], timeGet, description);
				listOrganization.add(organization);
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
		
		return listOrganization;
	}
	

	// ghi ra file
public void writeFile(String inFileName, String outFileName) throws IOException {

	try {

		File fileDir = new File(inFileName);

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF-8"));
		out.write("");
		ArrayList<Organization> listOrganization = createOrganization(inFileName);
		for (Organization o : listOrganization) {
			out.append(o.getId() + ",");
			out.append(o.getName() + ",");
			out.append(o.getActive() + ",");
			out.append(o.getDescription() + ",");
			out.append(o.getLink() + ",");
			out.append(o.getTimeGet().toString());
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
	String inFileName = "OrganizationTest.txt";
	String outFileName = "CreateEvent.csv";
	CreateOrganization ce = new CreateOrganization();
	try {

		ce.writeFile(inFileName,outFileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("lỗi");
		e.printStackTrace();
	}
}

}
