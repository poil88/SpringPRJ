package poly.service;

import java.util.List;

import poly.dto.MemberDTO;

public interface IMemberService {
	//insertMember메서드를 사용하기위해 만들어줌 하지만 interface때문에 메소드만 만들어줌
	//interface때문에 implements 를 만들어줘야함
	//컨트롤러에서 데이터값을 서비스를통해 전달 한다 이때 서비스의 메소드를 이용 
	//interface만들고 impl해서 사용한다
	
	public int insertMember(MemberDTO mDto)throws Exception;
	public List<MemberDTO> getMemberList() throws Exception;
	//멤버리스트를 가져오기 위해 getMemberList()메소드 작성 인터페이스 때문에 
	//재정의 시켜줘야함
	public MemberDTO getMemberDetail(MemberDTO mDetail) throws Exception;
	//MemberDTO 반환타입의 getMemberDetail함수 작성 매개변수로 MemberDTO타입의 mDetail
	public int deleteMember(MemberDTO mDelete) throws Exception;
	public int updateMemberList(MemberDTO mDTO)throws Exception;
	public MemberDTO getLogin(MemberDTO mDTO)throws Exception;
	
}
