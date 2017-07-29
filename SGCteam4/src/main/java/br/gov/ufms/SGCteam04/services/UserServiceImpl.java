package br.gov.ufms.SGCteam04.services;

import br.gov.ufms.SGCteam04.models.Usuario;
import br.gov.ufms.SGCteam04.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Marco Cardoso on 7/29/2017.
 */
@Service
public class UserServiceImpl implements  UserService,UserDetailsService{


    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = findByEmail(s);
        if(usuario == null)
        {
            throw new UsernameNotFoundException(s);
        }
        return new UserDetailsImpl(usuario);
    }
}
