package com.greedy.shortcut.meeting.model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.shortcut.meeting.model.dto.MeetingDTO;

@RunWith(SpringJUnit4ClassRunner.class)


@ContextConfiguration(locations = {"file:src/main/resources/spring/servlet-context.xml", 
"file:src/main/resources/spring/root-context.xml", 
"file:src/main/resources/spring/security-context.xml"})     




public class MeetingMapperTest {
	 java.sql.Date projectStartDate=java.sql.Date.valueOf("2021-04-20");
	
	@Autowired
	MeetingMapper meetingMapper;
	
	MeetingDTO meeting;
	@Before
	public void setUp() {
		meeting = new MeetingDTO();
		
		meeting.setMeetingNo(1);
		meeting.setMeetingName("회의제목");
		meeting.setMeetingText("회의 내요오오");
		meeting.setEnrollDate(projectStartDate);
		meeting.setSprintNo(1);
		meeting.setPjtNo(1);
		meeting.setStatus("N");
		
		System.out.println("여기" + meeting);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertMeeting() {
		meetingMapper.insertMeeting(meeting);
		System.out.println(meeting);
	}

	/*
	 * @Test public void testProjectMemberCheck() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectProjectMember() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testInsertProjectMember() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectMeeting() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectMeetingList() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectMeetingDetail() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectMeetingDetailMember() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testDeletedMeeting() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testModifyComplete() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectSprintNumber() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectSprintName() { fail("Not yet implemented"); }
	 */

}
