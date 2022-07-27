package model.bean;

import java.util.Date;

public class DanhSachBanBe {

	private int fl_id;
	private int fid;
	private String preview_text;
	private Date date_create;
	private String flname;
	private int count_number;
	private String detail;
	public DanhSachBanBe(int fl_id, int fid, String preview_text, Date date_create, String flname, int count_number,
			String detail) {
		super();
		this.fl_id = fl_id;
		this.fid = fid;
		this.preview_text = preview_text;
		this.date_create = date_create;
		this.flname = flname;
		this.count_number = count_number;
		this.detail = detail;
	}
	public DanhSachBanBe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFl_id() {
		return fl_id;
	}
	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getPreview_text() {
		return preview_text;
	}
	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public int getCount_number() {
		return count_number;
	}
	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}
	public String getDetail() {
		return detail;
	}
	@Override
	public String toString() {
		return "DanhSachBanBe [fl_id=" + fl_id + ", fid=" + fid + ", preview_text=" + preview_text + ", date_create="
				+ date_create + ", flname=" + flname + ", count_number=" + count_number + ", detail=" + detail + "]";
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
