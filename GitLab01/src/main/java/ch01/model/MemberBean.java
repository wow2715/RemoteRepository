package ch01.model;

public class MemberBean {
	
	int pk;
	String id;
	String pswd;
	String name;
	
	public MemberBean() {
		super();
	}
	public MemberBean(String id, String pswd, String name) {
		super();
		this.id = id;
		this.pswd = pswd;
		this.name = name;
	}
	
	public MemberBean(int pk, String id, String pswd, String name) {
		super();
		this.pk = pk;
		this.id = id;
		this.pswd = pswd;
		this.name = name;
	}
	public MemberBean(int ipk) {
		this.pk = ipk;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
