package br.gov.ufms.SGCteam04.services;

import br.gov.ufms.SGCteam04.models.Usuario;

/**
 * Created by Marco Cardoso on 7/29/2017.
 */
public interface UserService {

    public Usuario findByEmail(String email);
}
