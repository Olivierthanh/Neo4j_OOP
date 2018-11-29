package objects;

import java.util.Date;

public class Event {
	private String id;
	private String name;
	private String description;
	private String link;
	private Date timeGet;
	
	public Event(String id, String name, String description, String link, Date timeGet) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.link = link;
		this.timeGet = timeGet;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
}
