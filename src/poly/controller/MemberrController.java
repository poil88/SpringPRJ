package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MemberDTO;
import poly.service.IMemberService;
import poly.service.impl.MemberService;

@Controller
public class MemberrController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "MemberService")
	private IMemberService memberService;
	
	
	//@Resource(name="MemberService")는 리소스 객체이름을 지정해준거임 MemberService
	//private 접근제한자로 IMemberService 클래스의 memberService객체를 사용하겠다는 뜻.!
	//이제 new한것 처럼 memberService를 객체로 사용할 수 있다.
	
	@RequestMapping(value = "main")
	public String main(HttpServletRequest request, Model model) throws Exception {
		return "/main";
	}
	// Requesting(value="member/memberReg")
	// 리퀘스트 맵핑을 통해 Reg화면을 만들고 따로 데이터를 받지 않고 화면만 띄워주기 때문에 return만 지정해준다

	@RequestMapping(value = "member/memberReg")
	public String memberReg() throws Exception {
		return "/member/memberReg";
	}

	// Reg 화면에서 회원가입클릭 후 실제 데이터가 넘어가는 화면 Proc에서 데이터값을 받아준다 .
	// 이떄 Reg에서 요청한 액션의 주소값 Proc로 데이터를 보내고 memberController에서 value값을 Proc를
	// 찾은후 받아야할 데이터 값을 request를 사용해 받아준다.
	// request의 매개변수 이름은 form태그에서의 name으로 매개변수를 받고
	// 데이터를 효율적으로 주고 받을수 있도록 MemberDTO라는 클래스를 작성 후 get set을 해준다
	// get set을 해주는 이유는 효율적으로 코드를 줄여서 데이터를 주고 받을 수 있게 해준다
	// 먼저 DTO클래스에서 작성 후 MemberDTO 클래스의 MemberDTO mDTO=new MemberDTO(); 생성자 생성 후
	// DTO를 만들때는 변수명은 DB에서 작성한 컬럼명으로 똑같이 작성해준다
	// mDTO 객체에 . set으로 id값pw값 name값 addr값 addrD값을 세팅해주고 데이터를 private 으로 설정
	// 했기때문에 get을 사용해야 값 을 가져올 수 있다.
	// sysout을 통해 값을 확인 해보면 Reg에서 넘어온 값들을 확인할 수 있다.
	// 이떄 아직 jsp화면으로 뿌려주기 위함이 아니라 데이터 값만 받고 콘솔에 확인하기위해 request를 사용해
	// 데이터값을 받아준걸 확인할 수 있다.

	@RequestMapping(value = "/member/memberProc")
	public String memberProc(HttpServletRequest request, Model model) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId(id);
		mDTO.setPwassword(pw);
		mDTO.setMember_name(name);
		mDTO.setMember_addr(addr);
		mDTO.setMember_addrDetail(addrDetail);
		
		// DTO를 데이터베이스에 insert해야 하는데
		// insert 과정은 contrller -> service -> mapper ->SQL-> mapper -> service -> controller
		// Controller
		
		int result=memberService.insertMember(mDTO);
		
		//int 타입의 result변수에 멤버서비스객체의 인서트 메서드의 값을 받는다 매개변수는 mDTO
		
		if(result!= 0){
			//회원가입성공
			model.addAttribute("msg","회원가입 성공하셨습니다.");
			model.addAttribute("url","/main.do");
		}else{
			//회원가입실패
		}

		
		return "/alert";
		
		
	}
	
	@RequestMapping(value="/member/memberList")
	public String memberList(Model model)throws Exception{
		log.info(this.getClass()+"memberList start");
		//회원 목록을 불러올 로직을 작성
		//멤버 리스트를 불러와줄 메소드작성 memberList() 작성 
		//List의 memberDTO타입의 mList 변수에 memberService객체의 getMemberList함수를 가져와
		//변수(mList)에 값저장
		
		List<MemberDTO> mList=memberService.getMemberList();
		
		/*	for(int i=0;i<mList.size();i++){
			MemberDTO mDTO=mList.get(i);
			System.out.println(mDTO.getMember_name());
			//위 두줄과 아래 한줄은 같은 의미
			System.out.println(mList.get(i).getMember_name());
			
		}
		*/
		model.addAttribute("mList",mList);
		
		log.info(this.getClass()+"memberList End");
		return "/member/memberList";
	}
	
	
	@RequestMapping(value="/member/memberDetail")
	public String MemberDetail(HttpServletRequest request,Model model)throws Exception{
		String MemberNo= request.getParameter("memberNo");
		// MemberNo를 키값으로 받아왔기떄문에 값을 받아줘야함 이떄 request.getParameter 
		// 매개변수는 mbmerNo List 키값과 똑같이 받아줌
		
		log.info("MemberNo:" + MemberNo);
		
		MemberDTO mDetail =new MemberDTO();
		mDetail.setMember_no(MemberNo);
		//MemberDTO 타입의 mDetail변수를 생성자로 생성
		//mDetail객체에 .setMember_no 매개변수는 위에서받은 MemberNo값 
		
		mDetail=memberService.getMemberDetail(mDetail);
		
		
		model.addAttribute("mDetail", mDetail);
		
		return "/member/memberDetail";
	}
	
	@RequestMapping(value="/member/memberDelete")
	public String MemberDelte(HttpServletRequest request,Model model)throws Exception{
		
		String memberNo=(String)request.getParameter("MemberNo");
		log.info("memberNo : "  + memberNo);
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMember_no(memberNo);
		
		memberService.deleteMember(mDTO);

		return "redirect:/member/memberList.do";
	}
	
	@RequestMapping(value="/member/memberUpdateView")
	public String MemberUpdateView(HttpServletRequest request,Model model)throws Exception{
		String memberNo=request.getParameter("MemberNo");
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMember_no(memberNo);
		
		mDTO=memberService.getMemberDetail(mDTO);
		model.addAttribute("mDTO",mDTO);
		
		return "/member/memberUpdateView";
		
	}
	@RequestMapping(value="/member/memberUpdateProc")
	public String memberUpdateProc(HttpServletRequest request,Model model)throws Exception{
		
		String id=request.getParameter("id");
		String pw=request.getParameter("password");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String addrDetail=request.getParameter("addrDetail");
		String memberNo=request.getParameter("memberNo");
		
		MemberDTO mDTO=new MemberDTO();
		mDTO.setId(id);
		mDTO.setPwassword(pw);
		mDTO.setMember_name(name);
		mDTO.setMember_addr(addr);
		mDTO.setMember_addrDetail(addrDetail);
		mDTO.setMember_no(memberNo);
		
		int result=memberService.updateMemberList(mDTO);
		//수정에 성공햇을경우 수정 성공 alert띄우고 메인페이지로 이동 
		
		if(result!=0){
			model.addAttribute("msg", "수정이 완료되었습니다.");
			model.addAttribute("url", "/member/memberList.do");
		}else{
			model.addAttribute("msg", "수정이 실패되었습니다.");
			model.addAttribute("url", "/main.do");
		}
		
		return "/alert";
	}
	@RequestMapping(value="/member/loginProc")
	public String loginProc(HttpServletRequest request,Model model,HttpSession session)throws Exception{
		
		String id=request.getParameter("id");
		String pw=request.getParameter("password");
		
		MemberDTO mDTO=new MemberDTO();
		
		mDTO.setId(id);
		mDTO.setPassword(pw);
		
		mDTO=memberService.getLogin(mDTO);
		
		if(mDTO==null){
			
		}else{
			//로그인 성공
			session.setAttribute("id", mDTO.getId());
		}
		return "/main";

	
	
	}
	
}
