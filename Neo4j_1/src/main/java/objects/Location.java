package objects;

import java.util.Date;

/**
 * Thực thể địa danh
 * @author tt
 *
 */

public class Location {
	private int id;
	private String name;
	private String country;
	private String link;
	private Date timeget;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getTimeget() {
		return timeget;
	}
	public void setTimeget(Date timeget) {
		this.timeget = timeget;
	}
	public Location(int id, String name, String country, String link, Date timeget) {
		super();
		this.id = id;
		this.name = name;

		this.country = country;
		this.link = link;
		this.timeget = timeget;
	}

}
