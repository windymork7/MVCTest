package kr.co.ex.MvcController;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.javalec.ex.VO.Member;
import kr.co.javalec.ex.VO.Student;
import kr.co.javalec.ex.vali.MemberValidator;

@Controller
public class ViewController
{
	@RequestMapping("/view")
	public String view()
	{
		return "/list/view";
	}
	
	// Model은 데이터를 담아준다.
	@RequestMapping("/content")
	public String content(Model model)
	{
		model.addAttribute("id", 30);
		return "/list/content";
	}
	
	// ModelAndView는 view까지 담아준다
	@RequestMapping("/reply")
	public ModelAndView reply()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", 30);
		mv.setViewName("/list/reply");
		
		return mv;
	}
	
	@RequestMapping("/send")
	public String send(Model model, HttpServletRequest request)
	{
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "/list/send";
	}
	
	
	@RequestMapping("/send2")
	public String send2(@RequestParam("id") String id
						,@RequestParam("pw") String pw, Model model)
	{
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		
		return "/list/send2";
	}
	
//	@RequestMapping("/join")
//	public String join(@RequestParam("name") String name
//						,@RequestParam("id") String id
//						,@RequestParam("pw") String pw
//						,@RequestParam("email") String email
//						, Model model)
//	{
//		Member member = new Member();
//		
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//		System.out.println(member.toString());
//		
//		model.addAttribute("member", member);
//		
//		return "/member/join";
//	}
	
	
	@RequestMapping("/join")
	public String joinData(Member member)
	{
		return "/member/join";
	}
	
	
	@RequestMapping("student/{studentId}")
	public String getStudent(@PathVariable String studentId, Model model)
	{
		model.addAttribute("studentId", studentId);
		
		return "student/studentView";
	}
	
	@RequestMapping("studentTest")
	public String studentTest()
	{
		return "student/studentTest";
	}
	
//	@RequestMapping("studentTestProcess.met")
//	public String getStudentTest(@RequestParam("studentId") String studentId, Model model)
//	{
//		model.addAttribute("studentId", studentId);
//		return "student/studentTestResult";
//	}
	
	
	@RequestMapping(value="studentTestProcess.met", method = RequestMethod.GET)
	public String getStudentTest(HttpServletRequest request, Model model)
	{
		System.out.println("RequestMethod.GET");
		
		String studentId = request.getParameter("studentId");
		System.out.println("id : " + studentId);
		model.addAttribute("studentId", studentId);
		
		
		return "student/studentTestResult";
	}
	
	
	@RequestMapping(value="studentTestProcess.met", method = RequestMethod.POST)
	public ModelAndView getStudentTest(HttpServletRequest request)
	{
		System.out.println("RequestMethod.POST");
		
		String studentId = request.getParameter("studentId");
		System.out.println("studentId : " + studentId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/studentTestResult");
		mv.addObject("studentId", studentId);
		
		return mv;
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "student/index";
	}
	
	
	@RequestMapping("/studentClassProcess")
	public String studentView(@ModelAttribute("stu") Student student)
	{
		return "student/studentView";
	}
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model)
	{
		String id = request.getParameter("id");
		
		if (id.equals("abc"))
			return "redirect:studentNg?id="+id;
		else
			return "redirect:studentOk?id="+id;
		
	}
	
	
	@RequestMapping("/studentNg")
	public String studentNg(@RequestParam("id") String id, Model model)
	{
		model.addAttribute("id", id);
		return "student/studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(@RequestParam("id") String id, Model model)
	{
		model.addAttribute("id", id);
		return "student/studentOk";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1()
	{
		return "student/studentURL1";
	}
	
	
	@RequestMapping("/input1")
	public String input1()
	{
		return "member2/input1";
	}
	
//	@RequestMapping("/member/creaete")
//	public String memberCreate(@ModelAttribute("member") Member member
//								, BindingResult result)	
//	{
//		String page = "member2/output1";
//		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);
//		
//		if (result.hasErrors())
//		{
//			page = "member2/output2";
//		}
//		
//		return page;
//	}
	
	@RequestMapping("/member/creaete")
	public String memberCreate(@ModelAttribute("member") @Valid Member member
								, BindingResult result)	
	{
		String page = "member2/output1";
		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);
		
		if (result.hasErrors())
		{
			page = "member2/output2";
		}
		
		return page;
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.setValidator(new MemberValidator());
	}
	
}
