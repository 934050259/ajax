package newAjax;

public class province {
	private Integer provinceid;
	private String province;
	public Integer getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public province(Integer provinceid, String province) {
		super();
		this.provinceid = provinceid;
		this.province = province;
	}
	public province() {
		super();
	}
	@Override
	public String toString() {
		return "province [province=" + province + ", provinceid=" + province + "]";
	}

}
