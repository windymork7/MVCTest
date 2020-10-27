package kr.co.javalec.ex.vali;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.javalec.ex.VO.Member;

public class MemberValidator implements Validator
{
	@Override
	public boolean supports(Class<?> arg0)
	{
		return Member.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object obj, Errors errors)
	{
		System.out.println("validate()");
		Member member = (Member)obj;
		
		
//		String memberName = member.getName();
//		if (memberName == null || memberName.trim().isEmpty())
//		{
//			System.out.println("memberName is null or empty");
//			errors.rejectValue("name", "trouble");
//		}
		
		ValidationUtils.rejectIfEmpty(errors, "name", "trouble");
		
		
		String memberId = member.getId();
		if (memberId == null || memberId.trim().isEmpty() || memberId.equals("0"))
		{
			System.out.println("memberId is 0");
			errors.rejectValue("id", "trouble");
		}
		
	}
	
	
}
