package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface INoticeService {
	public int insertNotice(NoticeDTO nDto)throws Exception;
	public List<NoticeDTO> getNoticeList()throws Exception;
	public NoticeDTO getNoticeDetail(NoticeDTO nDetail)throws Exception;
	public int noticeDelete(NoticeDTO nDTO)throws Exception;
	public NoticeDTO getNoticeCnt(String noticeNo)throws Exception;
	//getNoticeCnt String 타입의 noticeNo변수명으로 함수작성
	
	
}
