package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.TipoFase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/9/2017.
 */
@Repository
public interface TipoFaseRepository extends CrudRepository<TipoFase,Integer>{
}
