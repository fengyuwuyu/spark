package com.ll.spark.entity;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6368715936578284146L;
	private Integer depId;
	private String name;

	public Department() {
	}

	public Department(Integer depId, String name) {
		this.depId = depId;
		this.name = name;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", name=" + name + "]";
	}

}
