package com.choong.spr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.mapper.BoardMapper;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	public List<BoardDto> listBoard(String type, String keyword) {
		// TODO Auto-generated method stub
		return mapper.selectBoardAll(type, "%" + keyword + "%");
	}

	@Transactional
	public boolean insertBoard(BoardDto board, MultipartFile file) {
//		board.setInserted(LocalDateTime.now());
		
		// 게시글 등록
		int cnt = mapper.insertBoard(board);
		
		// 파일 등록 
		if (file.getSize() > 0) {
			mapper.insertFile(board.getId(), file.getOriginalFilename());
//			saveFile(board.getId(), file); // 파일 시스템에 저장
			saveFileAwsS3(board.getId(), file); // s3에 업로드
		}
		
		return cnt == 1; 
	}
	public BoardDto getBoardById(int id) {
		// TODO Auto-generated method stub
		return mapper.selectBoardById(id);
	}

	public boolean updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(dto) == 1;
	}

	@Transactional
	public boolean deleteBoard(int id) {

		replyMapper.deleteByBoardId(id);
		
		return mapper.deleteBoard(id) == 1;
	}


}





