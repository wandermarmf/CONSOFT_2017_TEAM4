package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.Sessao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/30/2017.
 */
@Repository
public interface SessaoRepository extends CrudRepository<Sessao,Long> {
}
