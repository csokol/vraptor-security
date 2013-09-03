package br.com.caelum.vraptor.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.dao.UserDao;
import br.com.caelum.vraptor.view.Results;

@Resource
public class HomeController {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private Result result;
	
//	public HomeController(UserDao dao) {
//		this.dao = dao;
//	}
	
	@Get("/security/")
	public void index() {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		result.use(Results.http()).body("welcome " + principal.getUsername());
	}
	
	@Secured("ROLE_ADMIN")
	@Get("/security/admin")
	public void admin() {
		result.use(Results.http()).body("top secret admin stuff");
	}

}
