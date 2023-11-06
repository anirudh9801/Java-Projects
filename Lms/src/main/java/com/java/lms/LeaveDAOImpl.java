package com.java.lms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class LeaveDAOImpl implements LeaveDetailsDAO {

    Connection connection;
    PreparedStatement pst;

    public LeaveDAOImpl() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
    }

    public int dateDiff(Date startDate, Date endDate) {
        long ms = endDate.getTime() - startDate.getTime();
        int diff = (int) (ms / (1000 * 60 * 60 * 24));
        diff++;
        return diff;
    }

    // overlapping leaves
    private boolean isLeaveOverlapping(int empId, Date startDate, Date endDate) throws SQLException {
        String query = "SELECT COUNT(*) FROM LeaveDetails " +
                "WHERE EmpId = ? " +
                "AND ((LeaveStartDate BETWEEN ? AND ?) OR (LeaveEndDate BETWEEN ? AND ?))";
        pst = connection.prepareStatement(query);
        pst.setInt(1, empId);
        pst.setDate(2, startDate);
        pst.setDate(3, endDate);
        pst.setDate(4, startDate);
        pst.setDate(5, endDate);
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            int overlapCount = resultSet.getInt(1);
            return overlapCount > 0;
        }
        return false;
    }

    @Override
    public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
        //  LeaveStartDate is yesterday's date
        Date today = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = new Date(calendar.getTimeInMillis());

        if (leaveDetails.getLeaveStartDate().before(yesterday)) {
            return "Leave Start Date cannot be yesterday's date.";
        }

        //  LeaveEndDate is yesterday's date
        else if (leaveDetails.getLeaveEndDate().before(yesterday)) {
            return "Leave End Date cannot be yesterday's date.";
        }

        //  LeaveStartDate is greater than LeaveEndDate
        else if (leaveDetails.getLeaveStartDate().after(leaveDetails.getLeaveEndDate())) {
            return "Leave Start Date cannot be greater than Leave End Date.";
        }

        // Calculate the number of days for the leave
        int diff = dateDiff(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
        leaveDetails.setNoOfDays(diff);

        Employee employee = new EmployeeDAOImpl().searchEmployeeDao(leaveDetails.getEmpId());

        // Check if NoOfDays exceeds Leave Available
        int leaveAvailable = employee.getLeaveAvail();
        if (diff > leaveAvailable) {
            return "No. of days of leave exceeds available leave balance.";
        }

        // Check for overlapping leaves
        if (isLeaveOverlapping(leaveDetails.getEmpId(), leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate())) {
            return "You are still in leaving period,you cant not take leave in btwn";
        }

        // Insert the leave record
        String cmd = "Insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate," +
                "noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, leaveDetails.getEmpId());
        pst.setDate(2, leaveDetails.getLeaveStartDate());
        pst.setDate(3, leaveDetails.getLeaveEndDate());
        pst.setInt(4, leaveDetails.getNoOfDays());
        pst.setString(5, leaveDetails.getLeaveType().toString());
        pst.setString(6, leaveDetails.getLeaveReason());
        pst.executeUpdate();

        // Update LeaveAvail for the employee
        cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, diff);
        pst.setInt(2, leaveDetails.getEmpId());
        pst.executeUpdate();

        return "Leave Applied...";
    }
}
