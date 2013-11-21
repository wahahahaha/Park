package com.thirdparty.data;

public class LoginData {
	private String message = "";
	private String token = "";
	private String status = "";
	private String jglx = "";
	private String phone = "";
	private String sbdm = "";
	private String name = "";
	private String jgdm = "";
	private String sblx = "";

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message == null ? "" : message;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token == null ? "" : token;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status == null ? "" : status;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public String getJglx() {
		return jglx == null ? "" : jglx;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone == null ? "" : phone;
	}

	public void setSbdm(String sbdm) {
		this.sbdm = sbdm;
	}

	public String getSbdm() {
		return sbdm == null ? "" : sbdm;
	}

	public void setRealName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return name == null ? "" : name;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJgdm() {
		return jgdm == null ? "" : jgdm;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public String getSblx() {
		return sblx == null ? "" : sblx;
	}
}
