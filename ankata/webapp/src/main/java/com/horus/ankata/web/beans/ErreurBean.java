package com.horus.ankata.web.beans;

import com.horus.ankata.core.pojo.Erreur;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.context.annotation.Scope;




@ManagedBean
@Scope("session")
public class ErreurBean {

	private List<Erreur> erreurs;

	public ErreurBean() {

	}

	@PostConstruct
	private void init() {

	}

	public List<Erreur> getErreurs() {
		return erreurs;
	}

	public void setErreurs(List<Erreur> erreurs) {
		this.erreurs = erreurs;
	}

}
