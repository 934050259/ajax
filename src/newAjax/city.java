package newAjax;

public class city {
	private String city;
	private String cityid;

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCityid() {
		return cityid;
	}


	public void setCityid(String cityid) {
		this.cityid = cityid;
	}


	public city(String city, String cityid) {
		super();
		this.city = city;
		this.cityid = cityid;
	}


	public city() {
		super();
	}


	@Override
	public String toString() {
		return "city [city=" + city + ", cityid=" + cityid + "]";
	}

}
