package com.ll.spark.entity;

public class People {

	private Integer userId;
	private String name;
	private Integer depId;
	private Integer age;
	private String passwd;

	public People() {
	}

	public People(Integer userId, String name, Integer depId, Integer age, String passwd) {
		this.userId = userId;
		this.name = name;
		this.depId = depId;
		this.age = age;
		this.passwd = passwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "People [userId=" + userId + ", name=" + name + ", depId=" + depId + ", age=" + age + ", passwd="
				+ passwd + "]";
	}

}
