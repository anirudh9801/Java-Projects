package com.java.junit;
import static org.junit.Assert.*;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveTest {
	@Test
	public void testToString() throws ParseException {
	    LeaveDetails emp = new LeaveDetails(1001, 1, "Satya", createDate1("2023-09-14"), createDate1("2023-09-15"), LeaveStatus.PENDING, LeaveType.PL, "Sick", "Get Well Soon", createDate1("2023-09-13"));

	    String result = "LeaveDetails [" +
	            "leaveId=1001, " +
	            "empId=1, " +
	            "empName=Satya, " +
	            "leaveStartDate=" + createDate1("2023-09-14") + ", " +
	            "leaveEndDate=" + createDate1("2023-09-15") + ", " +
	            "leaveStatus=PENDING, " +
	            "leaveType=PL, " +
	            "leaveReason=Sick, " +
	            "managerComments=Get Well Soon, " +
	            "appliedOn=" + createDate1("2023-09-13") + "]";
	    assertEquals(result, emp.toString());
	}

    private Date createDate1(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateString);
       
    }
	
    @Test
    public void testGettersAndSetters() throws ParseException {
        LeaveDetails emp = new LeaveDetails();
        emp.setLeaveId(1001);
        emp.setEmpId(1);
        emp.setEmpName("Satya");
        emp.setLeaveStartDate(createDate1("2023-09-14"));
        emp.setLeaveEndDate(createDate1("2023-09-15"));
        emp.setLeaveStatus(LeaveStatus.PENDING);
        emp.setLeaveType(LeaveType.PL);
        emp.setLeaveReason("Reason for leave");
        emp.setManagerComments("Manager comments");

        assertEquals(1001, emp.getLeaveId());
        assertEquals(1, emp.getEmpId());
        assertEquals("Satya", emp.getEmpName());
        assertEquals(LeaveStatus.PENDING, emp.getLeaveStatus());
        assertEquals(LeaveType.PL, emp.getLeaveType());
        assertEquals("Reason for leave", emp.getLeaveReason());
        assertEquals("Manager comments", emp.getManagerComments());
    }

    @Test
    public void testConstructor() throws ParseException {
        LeaveDetails leave = new LeaveDetails();
        assertNotNull(leave);

        LeaveDetails emp = new LeaveDetails(1001, 1, "Satya", createDate1("2023-09-14"), createDate1("2023-09-15"), LeaveStatus.PENDING, LeaveType.PL, "Sick", "Get Well Soon", createDate1("2023-09-13"));

    }
}
