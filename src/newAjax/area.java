package newAjax;

public class area {
	private String areaid;
	private String area;
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public area(String areaid, String area) {
		super();
		this.areaid = areaid;
		this.area = area;
	}
	public area() {
		super();
	}
	@Override
	public String toString() {
		return "area [areaid=" + areaid + ", area=" + area + "]";
	}

}
