package br.ufscar.dc.pibd.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufscar.dc.pibd.classes.Pessoa;

@SuppressWarnings("serial")
public class UserAccount implements UserDetails {
 
    private Pessoa pessoa;
     
    public UserAccount(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(pessoa.getRole());
        return Arrays.asList(authority);
    }
    
    public Long getId() {
    	return pessoa.getId();
    }
    
    @Override
    public String getPassword() {
        return pessoa.getPassword();
    }
 
    @Override
    public String getUsername() {
        return pessoa.getEmail();
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

	public Pessoa getUser() {
		return pessoa;
	}
    
}