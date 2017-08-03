package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/28/2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}
