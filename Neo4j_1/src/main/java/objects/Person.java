package objects;

import java.util.Date;
/**
 *
 * @author tt
 * Thực thể người
 */
public class Person {
	private int id;
	private String name;
	private boolean man;
	private int age;
	private String job;
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
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
//	public Person(int id, String name, boolean man, int age, String job, String link, Date timeget) {
//		super();
//		setId(id);
//		setName( name );
//		setMan( man );
//		setAge( age );
//		setJob( job );
//		setLink( link );
//		setTimeget( timeget );
//	}
}
