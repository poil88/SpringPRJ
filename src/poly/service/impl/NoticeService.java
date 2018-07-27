package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.NoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService {

	@Resource(name = "NoticeMapper")
	private NoticeMapper noticeMapper;

	@Override
	public int insertNotice(NoticeDTO nDto) throws Exception {

		return noticeMapper.insertNotice(nDto);

	}

	@Override
	public List<NoticeDTO> getNoticeList() throws Exception {

		return noticeMapper.getNoticeList();
	}

	@Override
	public NoticeDTO getNoticeDetail(NoticeDTO nDetail) throws Exception {

		return noticeMapper.getNoticeDetail(nDetail);
	}

	@Override
	public int noticeDelete(NoticeDTO nDTO) throws Exception {
		
		return noticeMapper.noticeDelete(nDTO);
	}

	@Override
	public NoticeDTO getNoticeCnt(String noticeNo) throws Exception {
		noticeMapper.UpdatenoticeCnt(noticeNo);
		//noticeMapper에 UpdatenoticeCnt 메소드에 noticeNo값을 넘겨줌
		return noticeMapper.getnotice(noticeNo);
		
	}

}
