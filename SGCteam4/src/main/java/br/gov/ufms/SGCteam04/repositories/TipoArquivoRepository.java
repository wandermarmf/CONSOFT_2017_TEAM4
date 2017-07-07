package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.TipoArquivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Repository
public interface TipoArquivoRepository extends CrudRepository<TipoArquivo,Integer> {
}
