package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MemberDTO;
import poly.persistance.mapper.MemberMapper;
import poly.service.IMemberService;
@Service("MemberService")
//서비스를 사용하기위해 서비스 어노테이션 사용 서비스이름은 "MemberService"로 지정
public class MemberService implements IMemberService{
	//class MemberService IMemberService를 상속받는다
	//@Resource는 new 와 같은데 싱글톤 패턴을 적용시킨다 . 
	//아래의 문장은 private MemberMapper memberMapper = new MemberMapper();
	//와 같은 문장이다.
	
	@Resource(name="MemberMapper")
	private MemberMapper memberMapper;
	
	//서비스에서 interface로 만들어줬기때문에 재정의 Override 어노테이션 이용 해서
	//메소드 재정의 return값은 memberMapper객체에 insertMember메소드를 반환
	
	@Override
	public int insertMember(MemberDTO mDto) throws Exception {
		//반환값이 int인 이유는
		//insert,update,delete문은 int 
		//select 는 dto 또는 java의 HaspMap을 반환한다.
		
		return memberMapper.insertMember(mDto);
		
	}

	@Override
	public List<MemberDTO> getMemberList() throws Exception {
		
		return memberMapper.getMemberList();
	}
	//멤버리스트 재정의시켜주고 return은 memberMapper객체의 getMemberDetail함수 사용

	@Override
	public MemberDTO getMemberDetail(MemberDTO mDetail) throws Exception {
		//메소드 사용하기위해 재정의 해줌  매개변수로 MemberDTO 타입의 mDetail 변수 
		return memberMapper.getMemberDetail(mDetail);
		//memberMapper 
	}

	@Override
	public int deleteMember(MemberDTO mDelete) throws Exception {
		
		return memberMapper.deleteMember(mDelete);
	}

	@Override
	public int updateMemberList(MemberDTO mDTO) throws Exception {
		
		return memberMapper.updateMember(mDTO);
	}

	@Override
	public MemberDTO getLogin(MemberDTO mDTO) throws Exception {
		
		return memberMapper.getLoin(mDTO);
	}

	
	
	
	
	
}
