
public class TestUser {
	
	String id;
	String pwd;
	String name;
	String gen;
	String hire;
	
	public TestUser(String id, String pwd, String name, String gen, String hire) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gen = gen;
		this.hire = hire;
	}
	public TestUser() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getHire() {
		return hire;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}	
}
