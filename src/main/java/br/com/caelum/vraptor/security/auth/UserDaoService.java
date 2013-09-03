package br.com.caelum.vraptor.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.caelum.vraptor.security.dao.UserDao;
import br.com.caelum.vraptor.security.dao.UserRepository;
import br.com.caelum.vraptor.security.model.MeuUser;

public class UserDaoService implements UserDetailsService {
	
    private UserRepository users;
	private PasswordEncoder encoder;
    
    @Autowired
    public UserDaoService(UserRepository users, PasswordEncoder encoder) {
		this.users = users;
		this.encoder = encoder;
    }

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		MeuUser user = users.find(login);
		return user;
	}

}
