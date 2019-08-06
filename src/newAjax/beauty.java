package newAjax;

//表结构和类对应
public class beauty {
	private Integer id;
	private String name ;  
	private String sex;
	private Integer boyfriend_id;
		
	public beauty(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public beauty(Integer id, String name, String sex, Integer boyfriend_id) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.boyfriend_id = boyfriend_id;
	}

	public beauty() {
		super();
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getBoyfriend_id() {
		return boyfriend_id;
	}


	public void setBoyfriend_id(Integer boyfriend_id) {
		this.boyfriend_id = boyfriend_id;
	}


	@Override
	public String toString() {
		return "beauty [id=" + id + ", name=" + name + ", sex=" + sex + ", boyfriend_id=" + boyfriend_id + "]";
	}

}
