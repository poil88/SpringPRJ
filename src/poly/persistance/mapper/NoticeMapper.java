package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("NoticeMapper")
public interface NoticeMapper {
	
	public int insertNotice(NoticeDTO nDto)throws Exception;
	public List<NoticeDTO> getNoticeList()throws Exception; 
	public NoticeDTO getNoticeDetail(NoticeDTO nDetail)throws Exception;
	public int noticeDelete(NoticeDTO nDTO)throws Exception;
	public int UpdatenoticeCnt(String noticeNo)throws Exception;
	public NoticeDTO getnotice(String noticeNo)throws Exception;
//게시판 select 는 매개변수값 없음 인터페이스 만들었으니 재정의 해줘야하는데 getNoticeList id값 맞춰줘야함
	
}
