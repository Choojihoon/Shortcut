package com.greedy.shortcut.mywork.model.dto;

import com.greedy.shortcut.board.model.dto.CardTaskDTO;
import com.greedy.shortcut.member.model.dto.MemberDTO;

public class ClientCardTaskAndCardAndMemberDTO {

	private CardTaskDTO cardTaskDTO;
	private ClientCardDTO cardDTO;
	private MemberDTO memberDTO;
	
	public ClientCardTaskAndCardAndMemberDTO() {}

	public ClientCardTaskAndCardAndMemberDTO(CardTaskDTO cardTaskDTO, ClientCardDTO cardDTO, MemberDTO memberDTO) {
		super();
		this.cardTaskDTO = cardTaskDTO;
		this.cardDTO = cardDTO;
		this.memberDTO = memberDTO;
	}

	public CardTaskDTO getCardTaskDTO() {
		return cardTaskDTO;
	}

	public void setCardTaskDTO(CardTaskDTO cardTaskDTO) {
		this.cardTaskDTO = cardTaskDTO;
	}

	public ClientCardDTO getCardDTO() {
		return cardDTO;
	}

	public void setCardDTO(ClientCardDTO cardDTO) {
		this.cardDTO = cardDTO;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	@Override
	public String toString() {
		return "ClientCardTaskAndCardAndMemberDTO [cardTaskDTO=" + cardTaskDTO + ", cardDTO=" + cardDTO + ", memberDTO="
				+ memberDTO + "]";
	}

	
	
}
