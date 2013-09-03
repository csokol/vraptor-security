package br.com.caelum.vraptor.security.dao;

import br.com.caelum.vraptor.security.model.MeuUser;

public interface UserRepository {

	MeuUser find(String login);

	MeuUser queryDoAdmin();

}
