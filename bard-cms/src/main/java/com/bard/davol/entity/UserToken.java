package com.bard.davol.entity;

import com.bard.davol.util.ReflectUtil;
import java.io.Serializable;

public class UserToken implements Serializable {
	
	private static final long serialVersionUID = 4379059008179165248L;
	private int tid;
	private String uname;
	private String udid;
	private String utoken;
	private String status;
	private String userType = "";
	private String timestamp;
	private String modifytime;
	private String region;// 所属地区
	private String rank;// 职级

	public UserToken() {

	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUtoken() {
		return this.utoken;
	}

	public void setUtoken(String utoken) {
		this.utoken = utoken;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUdid() {
		return this.udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public String getModifytime() {
		return this.modifytime;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return ReflectUtil.fieldsToString(this);
	}
}