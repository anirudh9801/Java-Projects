package com.java.hms;

public class Doctor {
	
	private String docid;
	private String docName;
	private String docDept;
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocDept() {
		return docDept;
	}
	public void setDocDept(String docDept) {
		this.docDept = docDept;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String docid, String docName, String docDept) {
		super();
		this.docid = docid;
		this.docName = docName;
		this.docDept = docDept;
	}
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", docName=" + docName + ", docDept=" + docDept + "]";
	}
	
	
	

}
