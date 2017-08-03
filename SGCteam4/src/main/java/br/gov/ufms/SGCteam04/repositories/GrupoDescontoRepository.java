package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.GrupoDesconto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/10/2017.
 */
@Repository
public interface GrupoDescontoRepository extends CrudRepository<GrupoDesconto,Integer> {
}
