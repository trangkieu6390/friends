package model.bean;

public class LienHe {

	private String name;
	private String email;
	private String phone;
	private String content;
	@Override
	public String toString() {
		return "LienHe [name=" + name + ", email=" + email + ", phone=" + phone + ", content=" + content + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LienHe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LienHe(String name, String email, String phone, String content) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.content = content;
	}
	
}