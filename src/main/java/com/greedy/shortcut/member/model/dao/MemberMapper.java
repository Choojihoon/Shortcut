package com.greedy.shortcut.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import com.greedy.shortcut.member.model.dto.MemberDTO;
import com.greedy.shortcut.member.model.service.UserDetailsVO;

public interface MemberMapper {

	int registMember(MemberDTO member);

	MemberDTO selectUserInfoOne(String inputUserId);

	Object selectUserInfoCount(String email);

	void ModifyMember(MemberDTO memberDTO);

	void updateMember(MemberDTO dto);

}
