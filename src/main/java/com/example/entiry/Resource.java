package com.example.entiry;

public class Resource {
	private Integer resourceId; 
	private Integer courseId; 
	private String link; 
	private String createTime; 
	private String updateTime;
	private Integer type;
	
	
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", courseId=" + courseId + ", link=" + link + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", type=" + type + "]";
	}
	
	
}
