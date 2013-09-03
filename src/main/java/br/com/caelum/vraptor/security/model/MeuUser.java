package br.com.caelum.vraptor.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import sun.util.logging.resources.logging;

public class MeuUser implements UserDetails {

	public static final MeuUser USER = new MeuUser("user", "2aa16f2cc99ee441d187d016fe70ff0bf9048f24", 
			"ROLE_USER"); //senha: user
	public static final MeuUser ADMIN = new MeuUser("admin", "ba90d876f6f1de0245a80bc42fc12b14cc27dc2b", 
			"ROLE_USER", "ROLE_ADMIN"); //senha: admin
	public static final MeuUser FINANCEIRO = new MeuUser("financeiro", "ba90d876f6f1de0245a80bc42fc12b14cc27dc2b", 
			"ROLE_USER", "ROLE_FINANCEIRO"); //senha: admin

	private String nome;
	private String password;
    private final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


	public MeuUser(String nome, String password, String...authorities) {
		this.nome = nome;
		this.password = password;
		for (String auth : authorities) {
			this.authorities.add(new SimpleGrantedAuthority(auth));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}