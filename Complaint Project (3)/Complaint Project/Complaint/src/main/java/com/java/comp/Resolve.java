package com.java.comp;

import java.sql.Date;
import java.sql.Timestamp;

public class Resolve {
	private String resolveID;
	private String  complaintID;
	private Timestamp complaintDate;
	private Timestamp   resolveDate;
	private String  resolvedBy;
	private String  comments;
	private long tat;
	
	public Resolve(String resolveID, String complaintID, Timestamp complaintDate, Timestamp resolveDate,
			String resolvedBy, String comments, long tat) {
		super();
		this.resolveID = resolveID;
		this.complaintID = complaintID;
		this.complaintDate = complaintDate;
		this.resolveDate = resolveDate;
		this.resolvedBy = resolvedBy;
		this.comments = comments;
		this.tat = tat;
	}

	public Resolve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResolveID() {
		return resolveID;
	}

	public void setResolveID(String resolveID) {
		this.resolveID = resolveID;
	}

	public String getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(String complaintID) {
		this.complaintID = complaintID;
	}

	public Timestamp getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Timestamp complaintDate) {
		this.complaintDate = complaintDate;
	}

	public Timestamp getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getTat() {
		return tat;
	}

	public void setTat(long tat) {
		this.tat = tat;
	}

	@Override
	public String toString() {
		return "Resolve [resolveID=" + resolveID + ", complaintID=" + complaintID + ", complaintDate=" + complaintDate
				+ ", resolveDate=" + resolveDate + ", resolvedBy=" + resolvedBy + ", comments=" + comments + ", tat="
				+ tat + "]";
	}
   
    
}
