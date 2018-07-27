package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.regexp.internal.recompile;

import poly.dto.NoticeDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
 * 자바 서블릿 역할 수행
 * */
@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());

	/*
	 * 비즈니스 로직(중요 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재(싱글톤패턴 적용됨)
	 */
	@Resource(name = "NoticeService")
	private INoticeService noticeService;

	/*
	 * 함수명 위의 value="notice/NoticeList" => /notice/NoticeList.do로 호출되는 url은 무조건
	 * 이 함수가 실행된다. method=RequestMethod.GET => 폼 전송방법을 지정하는 것으로 get방식은 GET,
	 * post방식은 POST이다. method => 기입안하면 GET, POST 모두 가능하나, 가급적 적어주는 것이 좋다.
	 */

	@RequestMapping(value = "a")
	public String a(HttpServletRequest request) throws Exception {
		String top = request.getParameter("top");
		String bottom = request.getParameter("bottom");

		System.out.println("상의 사이즈 : " + top);
		System.out.println("하의 사이즈 : " + bottom);

		return "/a";
	}

	// jsp로부터 데이터를 받기 위해서는 메소드에 매개변수자리에 HttpServlteRequest를 선언 해줘야 한다!!!!!!!
	@RequestMapping(value = "b")
	public String b(HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		String age = request.getParameter("age");
		System.out.println("age : " + age);

		return "/b";
	}

	@RequestMapping(value = "c")
	public String c(HttpServletRequest request) throws Exception {
		String test = request.getParameter("test");
		System.out.println("test : " + test);
		String cm = request.getParameter("cm");
		System.out.println("cm : " + cm);
		String kg = request.getParameter("kg");
		System.out.println("kg : " + kg);
		return "/c";
	}

	@RequestMapping(value = "d")
	public String d(HttpServletRequest request) throws Exception {
		String size = request.getParameter("size");
		System.out.println("size : " + size);
		return "/d";
	}

	@RequestMapping(value = "e")
	public String e(HttpServletRequest request) throws Exception {
		String phone = request.getParameter("phone");
		System.out.println("phone : " + phone);
		return "/e";
	}

	@RequestMapping(value = "bmi")
	public String bmi(HttpServletRequest request, Model model) throws Exception {
		String cm = request.getParameter("cm");
		String kg = request.getParameter("kg");
		// kg/(m*m)
		double m = Integer.parseInt(cm) * 0.01;
		double bmi = Integer.parseInt(kg) / (m * m);

		model.addAttribute("bmi", bmi); // ==request.setAttribute("bmi",bmi);

		return "/bmi";
	}

	@RequestMapping(value = "redirect")
	public String redirect(HttpServletRequest request, Model model) throws Exception {

		model.addAttribute("tmp", "no");

		return "redirect:/redirect";

	}

	@RequestMapping(value = "/notice/noticeReg")
	public String noticeReg(HttpServletRequest request, Model model) throws Exception {
		
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		NoticeDTO nDTO=new NoticeDTO();
		
		nDTO.setTitle(title);
		nDTO.setContent(contents);
		nDTO.setCnt(0);
		
		System.out.println("title : "+title);
		System.out.println("contents : "+contents);
		
		int result=noticeService.insertNotice(nDTO);
		
		if(result==1){
			//등록성공' 게시판 등록 성공 'alert창 띄우고 main화면으로 이동
			model.addAttribute("msg", "게시판 등록 성공");
			model.addAttribute("url", "/main.do");
		}else{
			//등록실패  게시판 등록 실패  'alert창 띄우고 게시판 등록 화면
			model.addAttribute("msg", "게시판 등록 실패");
			model.addAttribute("url", "/notice/noticeReg.do");
		}
		
		return "/alert";
	}

	@RequestMapping(value="/notice/noticeRegView")
	public String noticeRegView(HttpSession session,Model model)throws Exception{
		
		String id=CmmUtil.nvl((String)session.getAttribute("id"));
		//CmmUtil이란 값이 들어온 게 null일때 공백으로 바꿔준다. (공백은 데이터임)
		
		if("".equals(id)){
			//로그인 안한 상태 '로그인을 해주세요 띄우고 로그인 페이지로 이동
			
			model.addAttribute("msg", "로그인을 해주세요");
			model.addAttribute("url", "/main.do");
			return "/alert";
			
		}
		
		
		return "/notice/noticeReg";
		
	}
	
	@RequestMapping(value = "notice/noticeList")
	public String noticeList(Model model) throws Exception {
		
		List<NoticeDTO> nList=noticeService.getNoticeList();
		
		model.addAttribute("nList", nList);
		
		
		
		return "/notice/noticeList";
	}
	
	@RequestMapping(value="/notice/noticeDetail")
	public String noticeDetail(HttpServletRequest request,Model model)throws Exception{
		//게시판 상세보기
		String noticeNo=request.getParameter("noticeNo");
		//jsp에서 게시판 번호를 noticeNo 파라미터 변수값으로 받고 noticeNo 변수에 저장
		NoticeDTO nDTO=noticeService.getNoticeCnt(noticeNo);
		//
		model.addAttribute("nDetail", nDTO);
		
	/*	NoticeDTO nDetail=new NoticeDTO();
		nDetail.setNotice_no(noticeNo);
		
		nDetail=noticeService.getNoticeDetail(nDetail);
		
		*/
		
		
		return "/notice/noticeDetail";
		
	}
	
	@RequestMapping(value="/notice/noticeDelete")
	public String noticeDelete(HttpServletRequest request,Model model)throws Exception{
		
		String noticeNo=request.getParameter("noticeNo");
		NoticeDTO nDTO=new NoticeDTO();
		
		nDTO.setNotice_no(noticeNo);
		
		int result=noticeService.noticeDelete(nDTO);
		
		if(result==1){
			
			model.addAttribute("msg", "삭제 완료");
			model.addAttribute("url", "/notice/noticeList.do");
			
		}else{
			
			model.addAttribute("msg", "삭제를 실패하였습니다.");
			model.addAttribute("url", "/notice/noticeList.do");
			
		}
		
		return "/alert";
	}
	
	
	
	
	/**
	 * 게시판 리스트 보여주기
	 */
	/*
	 * @RequestMapping(value="notice/NoticeList", method=RequestMethod.GET)
	 * public String NoticeList(HttpServletRequest request, HttpServletResponse
	 * response, ModelMap model) throws Exception {
	 * 
	 * //로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
	 * log.info(this.getClass().getName() + ".NoticeList start!");
	 * 
	 * //공지사항 리스트 가져오기 List<NoticeDTO> rList = noticeService.getNoticeList();
	 * 
	 * if (rList==null){ rList = new ArrayList<NoticeDTO>();
	 * 
	 * }
	 * 
	 * //조회된 리스트 결과값 넣어주기 model.addAttribute("rList", rList);
	 * 
	 * //변수 초기화(메모리 효율화 시키기 위해 사용함) rList = null;
	 * 
	 * //로그 찍기(추후 찍은 로그를 통해 이 함수 호출이 끝났는지 파악하기 용이하다.)
	 * log.info(this.getClass().getName() + ".NoticeList end!");
	 * 
	 * //함수 처리가 끝나고 보여줄 JSP 파일명(/WEB-INF/view/notice/NoticeList.jsp) return
	 * "/notice/NoticeList"; }
	 */

}
