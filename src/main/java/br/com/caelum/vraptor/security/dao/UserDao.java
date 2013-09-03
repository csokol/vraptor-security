package br.com.caelum.vraptor.security.dao;

import br.com.caelum.vraptor.security.model.MeuUser;

public class UserDao implements UserRepository {

	@Override
	public MeuUser find(String login) {
		if ("admin".equals(login)) {
			return MeuUser.ADMIN;
		}
		if ("user".equals(login)) {
			return MeuUser.USER;
		}
		return null;
	}

}
