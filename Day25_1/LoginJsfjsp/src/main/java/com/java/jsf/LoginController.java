package com.java.jsf;

import java.util.Iterator;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;

public class LoginController {
	
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String validateLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(login.getUserName().length()<=5) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"User Name Contains Min 6 characters",null));
		}else if(login.getPassCode().length()<=5) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Password Conatins Min 6 characters",null));
		}else {
			LoginValidate logV= new LoginValidate();
			return logV.validate(login);
		}
		return null;
	}
	

}
