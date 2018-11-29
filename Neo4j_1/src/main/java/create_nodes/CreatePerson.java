package create_nodes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import objects.Person;

import java.io.BufferedWriter;
import java.io.File;


public class CreatePerson {
	private int total;

	CreatePerson(int n){
		this.total=n;
	}
	private String[] lastName={"Nguyễn","Trần","Lê","Phạm","Hoàng","Phan","Vũ","Đặng","Bùi","Đỗ","Hồ","Dương","Lý"};
	private String []listJob ={"Sinh viên","Giám đốc","Bảo vệ","Kỹ sư","Bác sĩ","Công nhân","Y tá","Nhân viên","Thanh tra","Luật sư"};
	private String[] listLinks={"https://dantri.com.vn/","vnexpress.net","tuoitre.vn","http://vietnamnet.vn/","https://www.vietnamplus.vn/","https://vtc.vn/","https://www.24h.com.vn/","http://kenh14.vn/"};
	private  List<String> manName = new ArrayList <String>();
	private  List<String> womanName = new ArrayList <String>();

	//đọc file
	public  void readFile(String fileName,List<String> list){
		try {


			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName), "UTF-8"));

			String str;

			while ((str = in.readLine()) != null) {
				list.add(str);
			}

			in.close();
		}
		catch (UnsupportedEncodingException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//ghi ra file
	public void writeFile(String fileName) throws IOException{

		try {
			readFile("man.txt",manName);
			readFile("woman.txt",womanName);
			Random rd =new Random();
			File fileDir = new File(fileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			objects.Person p = new Person();
			for (int i = 0; i < total; i++) {
				//sinh ngẫu nhiên 1 đối tượng

				p.setId(100000000+i);
				p.setAge(rd.nextInt(52)+18);
				p.setJob(listJob[ rd.nextInt(listJob.length)]);
				p.setLink(listLinks[ rd.nextInt(listLinks.length)]);
				p.setTimeget(new Date());
				p.setMan(rd.nextBoolean());
				if(p.isMan()){
					p.setName(lastName[rd.nextInt(lastName.length)]+" "+manName.get(rd.nextInt(manName.size())));
				}else
					p.setName(lastName[rd.nextInt(lastName.length)]+" "+womanName.get(rd.nextInt(womanName.size())));
				//ghi đối tượng ra file
				out.append(
						String.valueOf(p.getId())+",");
				out.append(
						p.getName()+",");
				out.append(
						String.valueOf(p.isMan())+",");
				out.append(
						p.getAge()+",");
				out.append(
						p.getJob()+",");
				out.append(
						p.getLink()+",");
				out.append(
						p.getTimeget().toString());
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
	//sinh ngẫu nhiên thực thể người
//	private Person createPerson(int id){
//		Random rd =new Random();
//		readFile("C:\\Users\\tt270\\workspace\\Neo4j\\src\\createNode\\man.txt",manName);
//		readFile("C:\\Users\\tt270\\workspace\\Neo4j\\src\\createNode\\woman.txt",womanName);
//		int man = manName.size();
//		int woman =womanName.size();
//		int l=lastName.length;
//		String name="";
//		boolean isMan=rd.nextBoolean();
//		if(isMan){
//			name=lastName[rd.nextInt(l)]+" "+manName.get(rd.nextInt(man));
//		}else
//			name=lastName[rd.nextInt(l)]+" "+womanName.get(rd.nextInt(woman));
//		int age=rd.nextInt(52)+18;
//		String job= listJob[ rd.nextInt(listJob.length)];
//		String link=listLinks[ rd.nextInt(listLinks.length)];
//		Date timeget= new Date();
//		Person p =new Person(id, name, isMan, age, job, link, timeget);
//		return p;
//	}


	public static void main(String[] args) {
		CreatePerson cp =new CreatePerson(100);
		try {

			cp.writeFile("CreatePersion.csv");
			System.out.println("ĐÃ tạo giả lập");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("lỗi");
			e.printStackTrace();
		}
	}
}
