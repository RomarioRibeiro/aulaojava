package com.romario.aulao.service.exception;

public class DatalIntegrityExcepition extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public DatalIntegrityExcepition (String msg) {
		super(msg);
	}
	
	public DatalIntegrityExcepition (String msg, Throwable cause ) {
		super(msg,cause);
	}
	
}
