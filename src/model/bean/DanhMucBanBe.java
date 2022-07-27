package model.bean;

public class DanhMucBanBe {

	private int fl_id;
	private String flname;
	public DanhMucBanBe(int fl_id, String flname) {
		super();
		this.fl_id = fl_id;
		this.flname = flname;
	}
	public DanhMucBanBe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DanhMucBanBe [fl_id=" + fl_id + ", flname=" + flname + "]";
	}
	public int getFl_id() {
		return fl_id;
	}
	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
}
