package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.MemberDTO;

@Mapper("MemberMapper")
public interface MemberMapper {

	public int insertMember(MemberDTO dto) throws Exception;
	
	// @Mapper("MemberMapper") 메퍼이름 지정
	// 서비스에서 Mapper를 사용하기위해 Resource에 메퍼 객체화 해줬고 
	//MemberMapperMapper인터페이스 생성 후 메소드 생성
	
	public List<MemberDTO> getMemberList()throws Exception;
	//멤버리스트 함수 작성 인터페이스떄문에 재정의 시켜줘야함
	
	
	public MemberDTO getMemberDetail(MemberDTO dto)throws Exception;
	
	public int deleteMember(MemberDTO dto)throws Exception;
	
	public int updateMember(MemberDTO mDTO)throws Exception;
	
	public MemberDTO getLoin(MemberDTO mDTO)throws Exception;
	
	// 서비스에서 getMemberDetail 사용하기위해 함수 작성 매개변수로 MemberDTO dto  
	// 메소드 사용하기위해 재정의 
	
}
