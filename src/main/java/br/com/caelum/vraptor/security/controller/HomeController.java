package br.com.caelum.vraptor.security.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class HomeController {
	
	@Get("/")
	public void index() {
		System.out.println("hello world");
	}

}
