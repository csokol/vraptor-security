package br.com.caelum.vraptor.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.dao.UserRepository;
import br.com.caelum.vraptor.view.Results;

@Resource
public class HomeController {
	
	@Autowired
	private UserRepository dao;
	@Autowired
	private Result result;
	
//	public HomeController(UserDao dao) {
//		this.dao = dao;
//	}
	
	@Get("/security/")
	public void index() {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		result.include("user", principal);
	}
	
	@Get("/security/queryDoAdmin")
	public void seila() {
		dao.queryDoAdmin();
		result.use(Results.http()).body("welcome vc tem acesso à super query");
	}
	
	@Secured("ROLE_ADMIN")
	@Get("/security/admin")
	public void admin() {
		result.use(Results.http()).body("top secret admin stuff");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_FINANCEIRO')")
	@Get("/security/financeiroOuAdmin")
	public void financeiroOuAdmin() {
		result.use(Results.http()).body("vc só pode ser do financeiro ou admin!");
	}

}
