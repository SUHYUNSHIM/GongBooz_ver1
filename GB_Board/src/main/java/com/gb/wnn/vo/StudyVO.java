package com.gb.wnn.vo;

public class StudyVO {
	private String study_name; //스터디 모임 이름
	private String study_tag; //스터디 종류 태그
	private String region; //오프라인 장소
	private int max_member; //인원 제한수 
	
	public StudyVO() {};
	
	
	public StudyVO(String study_name, String study_tag, String region, int max_member) {
		super();
		this.study_name = study_name;
		this.study_tag = study_tag;
		this.region = region;
		this.max_member = max_member;
	}

	//추가로 생성자 만들수도

	//getter, setter
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	public String getStudy_tag() {
		return study_tag;
	}
	public void setStudy_tag(String study_tag) {
		this.study_tag = study_tag;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getMax_member() {
		return max_member;
	}
	public void setMax_member(int max_member) {
		this.max_member = max_member;
	}
	
	
	
}
