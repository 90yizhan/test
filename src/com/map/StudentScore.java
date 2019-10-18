package com.map;

public class StudentScore {

	private String stuName;
	private String subject;
	private Integer score;
	
	public StudentScore(String stuName, String subject, Integer score) {
		super();
		this.stuName = stuName;
		this.subject = subject;
		this.score = score;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentScore [stuName=" + stuName + ", subject=" + subject
				+ ", score=" + score + "]";
	}
	
}
