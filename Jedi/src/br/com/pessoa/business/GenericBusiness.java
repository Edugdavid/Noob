package br.com.pessoa.business;

import java.util.HashMap;
import java.util.Map;

public class GenericBusiness {
	private Map<String, String> redirect = new HashMap<String, String>();

	public Map<String, String> put(String... valor) {
		this.redirect.put("url", valor[0]);
		this.redirect.put("msg", valor[1]);
		return this.redirect;
	}
}
