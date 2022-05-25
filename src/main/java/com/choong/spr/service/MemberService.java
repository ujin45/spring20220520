package com.choong.spr.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.MemberDto;
import com.choong.spr.mapper.MemberMapper;

@Service
public class MemberService {

	
	@Autowired
	private MemberMapper mapper;
	
	public boolean addMember(MemberDto member) {
		
		return mapper.insertMember(member)==1;
	}

	public boolean hasMemberId(String id) {
		
		return mapper.countMemberId(id) > 0;
	}

	public boolean hasMemberEmail(String email) {
		return mapper.countMemberEmail(email) > 0;
	}

	public boolean hasMemberNickName(String nickName) {
		return mapper.countMemberNickName(nickName);
	}

	public List<MemberDto> listMember() {
		return mapper.selectAllMember();
	}

	public MemberDto getMemberById(String id) {
		return mapper.selectMemberById(id);
	}

	public boolean removeMember(MemberDto dto) {
		MemberDto member = mapper.selectMemberById(dto.getId());
		
		if (member.getPassword().equals(dto.getPassword())) {
			return mapper.deleteMemberById(dto.getId()) == 1;
		}
		
		return false;
	}

}
