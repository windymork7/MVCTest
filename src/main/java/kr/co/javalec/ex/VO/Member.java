package kr.co.javalec.ex.VO;

public class Member
{
	private String name;
	private String id;
	private String pw;
	private String email;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "클래스명 : [Member], 필드[name : " + name + ", id : " + id + ", pw : " + pw + ", email : " + email + "]";
	}

}
