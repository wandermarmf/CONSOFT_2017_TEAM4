package br.gov.ufms.SGCteam04.services;

import br.gov.ufms.SGCteam04.models.Role;
import br.gov.ufms.SGCteam04.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/29/2017.
 */
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 3185970362329652822L;

    private Usuario usuario;

    public UserDetailsImpl(Usuario user){
        this.usuario = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        List<Role> roles = usuario.getRoles();
        for(Role role : roles)
        {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
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
