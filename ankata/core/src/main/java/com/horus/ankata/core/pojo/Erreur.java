package com.horus.ankata.core.pojo;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringEscapeUtils;

public class Erreur {

	/** Creates a new instance of Erreur */
	public Erreur() {
	}

	// champ
	private String classe;
	private String message;
	private String detail;

	// constructeur
	public Erreur(String classe, String message, String detail) {
		this.setClasse(classe);
		this.setMessage(message);
		this.setDetail(detail);
	}

	public Erreur(Throwable th) {
		this.setClasse(th.getClass().getName());
		this.setMessage(th.getMessage());
		this.setDetail(getStackTraceHtml(th));
	}

	// getters et setters

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getStackTrace(Throwable th) {
		

		StringWriter writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		fillStackTrace(th, pw);
		
		return writer.toString();
	}
	public String getStackTraceHtml(Throwable th) {
		String s=getStackTrace(th);
		return StringEscapeUtils.escapeHtml3(s);
	}
	private void fillStackTrace(Throwable ex, PrintWriter pw) {
		if (null == ex) {
			return;
		}

		ex.printStackTrace(pw);

		if (ex instanceof ServletException) {
			Throwable cause = ((ServletException) ex).getRootCause();

			if (null != cause) {
				pw.println("Root Cause:");
				fillStackTrace(cause, pw);
			}
		} else {
			Throwable cause = ex.getCause();

			if (null != cause) {
				pw.println("Cause:");
				fillStackTrace(cause, pw);
			}
		}
	}

}
