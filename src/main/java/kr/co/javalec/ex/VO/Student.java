package kr.co.javalec.ex.VO;

public class Student
{
	private String name;
	private int age;
	private int classNum;
	private int gradeNum;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getClassNum()
	{
		return classNum;
	}

	public void setClassNum(int classNum)
	{
		this.classNum = classNum;
	}

	public int getGradeNum()
	{
		return gradeNum;
	}

	public void setGradeNum(int gradeNum)
	{
		this.gradeNum = gradeNum;
	}

	@Override
	public String toString()
	{
		return "클래스명 : [Student], 필드[name : " + name + ", age : " + age + ", classNum : " + classNum + ", gradeNum : "
				+ gradeNum + "]";
	}

}
