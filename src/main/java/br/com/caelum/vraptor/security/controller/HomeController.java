package br.com.caelum.vraptor.security.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.security.dao.UserDao;

@Resource
public class HomeController {
	
	private UserDao dao;

	public HomeController(UserDao dao) {
		this.dao = dao;
	}
	
	@Get("/security/")
	public void index() {
		System.out.println("hello world " + dao);
	}

}
