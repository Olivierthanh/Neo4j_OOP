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

import objects.Location;

import java.io.BufferedWriter;
import java.io.File;



public class CreateLocation {
	private int total;
	CreateLocation(int n){
		this.total = n;
	}
	private String[] listLinks = {"https://dulich.vnexpress.net/","https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
            "https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/"
	};
	private String[] country = {"VietNam"};
	private  List<String> TheLocation = new ArrayList <String>();


	public  void readFile(String file,List<String> list){

		try {BufferedReader in = new BufferedReader(
				   new InputStreamReader(
		                      new FileInputStream(file), "Unicode"));
		 
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
public void writeFile(String fileName) throws IOException{
		
		try {
			
			File fileDir = new File(fileName);
			
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "Unicode"));
			out.write("");
			for (int i = 0; i < total; i++) {
				objects.Location p =createLocation(100000+i);
				out.append(
						String.valueOf(p.getId())+",");
				out.append(
						p.getName()+",");				

				out.append(
						p.getCountry()+",");
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
private objects.Location createLocation(int id){
	Random rd =new Random();
	readFile("Location.txt",TheLocation);
	int diadiem = TheLocation.size();
	String name = TheLocation.get(rd.nextInt(diadiem));
	String link=country[ rd.nextInt(country.length)];
	String link2=listLinks[ rd.nextInt(listLinks.length)];
	Date timeget= new Date();
	
	objects.Location p =new objects.Location(id,name,link,link2, timeget); 
	return p;
}


public static void main(String[] args) {
	CreateLocation cl =new CreateLocation(20);
	try {

		cl.writeFile("Location.csv");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("lỗi");
		e.printStackTrace();
	}
}


}

	
