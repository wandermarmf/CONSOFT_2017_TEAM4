package br.gov.ufms.SGCteam04.repositories;

import br.gov.ufms.SGCteam04.models.OpcaoPagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marco Cardoso on 7/10/2017.
 */
@Repository
public interface OpcaoPagamentoRepository extends CrudRepository<OpcaoPagamento,Integer>{
}
