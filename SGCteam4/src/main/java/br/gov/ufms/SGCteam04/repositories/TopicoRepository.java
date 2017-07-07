package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.Topico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Repository
public interface TopicoRepository extends CrudRepository<Topico,Integer> {
}
