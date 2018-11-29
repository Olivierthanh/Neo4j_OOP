package objects;

import java.util.Date;
/**
 * Thực thể tổ chức
 * @author tt
 *
 */
public class Organization {
	String id;
	String name;
	String active;
	String link;
	Date timeGet;
	String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
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
	public void setTimeGet(Date timeGet) {
		this.timeGet = timeGet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Organization(String id, String name, String active, String link, Date timeGet,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.link = link;
		this.timeGet = timeGet;
		this.description = description;
	}
	
}
