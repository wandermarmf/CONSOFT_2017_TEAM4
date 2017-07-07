package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.TipoSubmissao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Repository
public interface TipoSubmissaoRepository extends CrudRepository<TipoSubmissao,Integer> {
}
