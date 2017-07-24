package br.gov.ufms.SGCteam04.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.ufms.SGCteam04.models.OpcaoPagamento;
import br.gov.ufms.SGCteam04.repositories.OpcaoPagamentoRepository;

/**
 * Created by Marco Cardoso on 7/16/2017.
 */
@Controller
@RequestMapping("/admin/opcao-pagamento")
public class OpcaoPagamentoController extends CustomController {


    @Autowired
    OpcaoPagamentoRepository opcaoPagamentoRepository;

    public OpcaoPagamentoController() {
    	viewModel = "restrito/admin/opcao-pagamento";
    	titleForm = "Cadastro de Opções de Pagamento";
    	titleList = "Listagem de Opções de Pagamento";
    	statusEdicao = "";
    }
    
	@Override
    protected OpcaoPagamento getObj() {
		return new OpcaoPagamento();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <OpcaoPagamento> Iterable<OpcaoPagamento> getObjList(){
		return (Iterable<OpcaoPagamento>) opcaoPagamentoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		opcaoPagamentoRepository.save((OpcaoPagamento)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return opcaoPagamentoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	OpcaoPagamento obj = opcaoPagamentoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		opcaoPagamentoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") OpcaoPagamento obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
