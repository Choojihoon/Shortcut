package com.greedy.shortcut.meeting.model.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.greedy.shortcut.meeting.model.dto.MeetingDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
"file:src/main/resources/spring/root-context.xml", 
"file:src/main/resources/spring/security-context.xml"}) 

public class MeetingServiceImplTest {

	 java.sql.Date projectStartDate=java.sql.Date.valueOf("2021-04-20");
	
	@Autowired
	MeetingService meetingService;
	
	MeetingDTO meetingDTO;
	
	@Before
	public void setUp() {
		meetingDTO = new MeetingDTO();
		
		meetingDTO.setMeetingNo(1);
		meetingDTO.setMeetingName("회의제목");
		meetingDTO.setMeetingText("회의 내요오오");
		meetingDTO.setEnrollDate(projectStartDate);
		meetingDTO.setSprintNo(1);
		meetingDTO.setPjtNo(1);
		meetingDTO.setStatus("N");
	}
	
	@Test
	public void testInsertMeeting() {

		assertTrue(meetingService.insertMeeting(meetingDTO));
		
	}
	
	@Test
	public void testSelectMeeting() {

		
		assertEquals(meetingDTO.getMeetingName(), "회의제목");
		assertEquals(meetingDTO.getMeetingText(), "");
		
	}

}
