package project.edupm.projectmanage.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EduTeacherImportRecord {
	
	private Integer id;
	private String year;
	private String optDate;
	private String name;
	private String address;
	private Integer total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getOptDate() {
		
		return optDate;
	}
	public void setOptDate(String optDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			optDate = sdf.format(sdf.parse(optDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.optDate = optDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
