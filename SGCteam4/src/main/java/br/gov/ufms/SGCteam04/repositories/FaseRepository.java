package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.Fase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/30/2017.
 */
@Repository
public interface FaseRepository extends CrudRepository<Fase,Long> {
}
