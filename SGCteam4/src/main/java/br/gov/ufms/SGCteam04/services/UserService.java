package br.gov.ufms.SGCteam04.services;

import br.gov.ufms.SGCteam04.models.Usuario;
import org.springframework.stereotype.Service;

/**
 * Created by Marco Cardoso on 7/29/2017.
 */
@Service
public interface UserService {

    public Usuario findByEmail(String email);
}
