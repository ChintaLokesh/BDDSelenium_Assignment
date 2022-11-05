package com.cucumber.pojo;

import java.sql.Date;

public class Status {
	private String timestamp;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public Object getError_message() {
		return error_message;
	}

	public void setError_message(Object error_message) {
		this.error_message = error_message;
	}

	public int getElapsed() {
		return elapsed;
	}

	public void setElapsed(int elapsed) {
		this.elapsed = elapsed;
	}

	public int getCredit_count() {
		return credit_count;
	}

	public void setCredit_count(int credit_count) {
		this.credit_count = credit_count;
	}

	public Object getNotice() {
		return notice;
	}

	public void setNotice(Object notice) {
		this.notice = notice;
	}

	private int error_code;
	private Object error_message;
	private int elapsed;
	private int credit_count;
	private Object notice;
}
