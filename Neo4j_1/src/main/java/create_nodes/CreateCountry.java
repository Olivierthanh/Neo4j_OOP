package create_nodes;

import objects.Country;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.lang.String;
import org.json.*;

public class CreateCountry {
    private String[] listLinks = {"https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
            "https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/"};

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void createCountry(String fr, String fw) throws IOException {
        try {
            FileWriter out = new FileWriter(fw);
            String jsonText = readFile(fr, Charset.forName("utf-8"));

//        ArrayList<Country> countries = new ArrayList<>();
            JSONObject obj = new JSONObject(jsonText);
            JSONArray jsonArray = obj.getJSONObject("countries").getJSONArray("country");
            out.write("id,name,capital,continent,link,timeGet");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                Country country = new Country( json.getString("countryName"), json.getInt("isoNumeric"),
                        json.getString("capital"), json.getString("continentName"),
                        listLinks[new Random().nextInt(listLinks.length)], new Date());

                out.write(String.valueOf(country.getIsoNumeric()) + ",");
                out.write(country.getCountryName() + ",");
//                out.write(country.getCountryCode() + ",");
                out.write(country.getCapital() + ",");
                out.write(country.getContinentName() + ",");
//                out.write(country.getLanguages() + ",");
//                out.write(String.valueOf(country.getArea()) + ",");
//                out.write(String.valueOf(country.getPopulation()) + ",");
                out.write(country.getLink() + ",");
                out.write(String.valueOf(country.getTimeGet()) + ",");
                out.write("\n");
//                countries.add(country);
            }

            if(out != null) out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Parse xong");
    }
    public static void main(String[] args) throws IOException {
        CreateCountry p = new CreateCountry();
        p.createCountry("countries.json.txt","Countries.csv");
    }
}
