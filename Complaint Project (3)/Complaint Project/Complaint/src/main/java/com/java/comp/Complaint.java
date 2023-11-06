package com.java.comp;

import java.sql.Date;

public class Complaint {
private String complaintID;
private String complaintType;
private String CDescription;
private Date complaintDate;
private String severity;
private String status;

public Complaint(String complaintID, String complaintType, String cDescription, Date complaintDate, String severity,
		String status) {
	super();
	this.complaintID = complaintID;
	this.complaintType = complaintType;
	CDescription = cDescription;
	this.complaintDate = complaintDate;
	this.severity = severity;
	this.status = status;
}

public Complaint() {
	super();
	// TODO Auto-generated constructor stub
}

public String getComplaintID() {
	return complaintID;
}

public void setComplaintID(String complaintID) {
	this.complaintID = complaintID;
}

public String getComplaintType() {
	return complaintType;
}

public void setComplaintType(String complaintType) {
	this.complaintType = complaintType;
}

public String getCDescription() {
	return CDescription;
}

public void setCDescription(String cDescription) {
	CDescription = cDescription;
}

public Date getComplaintDate() {
	return complaintDate;
}

public void setComplaintDate(Date complaintDate) {
	this.complaintDate = complaintDate;
}

public String getSeverity() {
	return severity;
}

public void setSeverity(String severity) {
	this.severity = severity;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "Complaint [complaintID=" + complaintID + ", complaintType=" + complaintType + ", CDescription="
			+ CDescription + ", complaintDate=" + complaintDate + ", severity=" + severity + ", status=" + status + "]";
}


}




