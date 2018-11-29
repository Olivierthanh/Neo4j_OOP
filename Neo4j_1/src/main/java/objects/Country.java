package objects;

import java.util.Date;

/**
 * Thực thể quốc gia
 * @author tt
 *
 */

public class Country {
//    private String countryCode;
    private String countryName;
//    private int population;
    private int isoNumeric;
//    private double north;
//    private double south;
//    private double east;
//    private double west;
    private String capital;
    private String continentName;
//    private double area;
//    private String languages;
//    private int geonameId;
    private String link;
    private Date timeGet;


    //constructor
    public Country( String countryName, int isoNumeric,
                   String capital, String continentName, String link, Date timeGet) {
//        this.setCountryCode(countryCode);
        this.setCountryName(countryName);
//        this.setPopulation(population);
        this.setIsoNumeric(isoNumeric);
        this.setCapital(capital);
        this.setContinentName(continentName);
//        this.setArea(area);
//        this.setLanguages(languages);
        this.setLink(link);
        this.setGetTime(timeGet);
    }

    //getter and setter
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }



    public int getIsoNumeric() {
        return isoNumeric;
    }

    public void setIsoNumeric(int isoNumeric) {
        this.isoNumeric = isoNumeric;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getTimeGet() {
        return timeGet;
    }

    public void setGetTime(Date timeGet) {
        this.timeGet = timeGet;
    }
}
