package com.udemy.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer Status;
	private String mensagem;
	private long timeStamp;
	
	public StandardError(Integer status, String mensagem, long timeStamp) {
		super();
		Status = status;
		this.mensagem = mensagem;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
