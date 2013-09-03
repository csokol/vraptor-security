package br.com.caelum.vraptor.security.dao;

import org.springframework.security.access.annotation.Secured;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.PrototypeScoped;
import br.com.caelum.vraptor.security.model.MeuUser;

@PrototypeScoped
@Component
public class UserDao implements UserRepository {

	@Override
	public MeuUser find(String login) {
		if ("admin".equals(login)) {
			return MeuUser.ADMIN;
		}
		if ("financeiro".equals(login)) {
			return MeuUser.FINANCEIRO;
		}
		if ("user".equals(login)) {
			return MeuUser.USER;
		}
		return null;
	}
	
	
	@Secured("ROLE_ADMIN")
	public MeuUser queryDoAdmin() {
		return null;
	}

}
