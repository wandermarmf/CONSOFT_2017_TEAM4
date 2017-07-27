package br.gov.ufms.SGCteam04.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;
import br.gov.ufms.SGCteam04.repositories.OpcaoPagamentoRepository;
import br.gov.ufms.SGCteam04.repositories.TipoArquivoRepository;

@Controller
@RequestMapping("/admin/conferencia-consulta")
public class ConferenciaConsultaController extends CustomController{

	@Autowired
    ConferenciaRepository conferenciaRepository;
	@Autowired
	TipoArquivoRepository tipoArquivoRepository;
	@Autowired
	OpcaoPagamentoRepository opcaoPagamentoRepository;
	
	// atributos para mainipulação de eventos...
	private Conferencia currentConferencia;
	
	
    public ConferenciaConsultaController() {
    	viewModel = "restrito/admin/conferencia-consulta";
    	titleForm = "Listagem de Conferência";
    	titleList = "Listagem de Conferência";
    	statusEdicao = "";
    	continueInsert = false;
    }
    
	@Override
    protected Conferencia getObj() {
		currentConferencia = new Conferencia();
		return currentConferencia;
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <Conferencia> Iterable<Conferencia> getObjList(){
		return (Iterable<Conferencia>) conferenciaRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		currentConferencia = (Conferencia)obj;
		conferenciaRepository.save(currentConferencia);
	}
	
	@Override
	protected Object findObj(Integer id) {
		currentConferencia = conferenciaRepository.findOne(id);
		return currentConferencia;
	}

	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
		currentConferencia = conferenciaRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (currentConferencia == null) {
    		return false;
    	}
    	else {
    		currentConferencia.getOpcaoPagamentoList().clear();
    		currentConferencia.getTipoArquivoList().clear();
    		conferenciaRepository.delete(currentConferencia);
    		return true;
    	}
	}
	
}
