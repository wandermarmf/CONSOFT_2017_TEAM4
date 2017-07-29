package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Marco Cardoso on 7/28/2017.
 */
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

    Usuario findByEmail(String email);
}
