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

import br.gov.ufms.SGCteam04.models.TipoSubmissao;
import br.gov.ufms.SGCteam04.repositories.TipoSubmissaoRepository;

@Controller
@RequestMapping("/admin/tipo-submissao")
public class TipoSubmissaoController extends CustomController{

    @Autowired
    TipoSubmissaoRepository tipoSubmissaoRepository;
    
    public TipoSubmissaoController() {
    	viewModel = "restrito/admin/tipo-submissao";
    	titleForm = "Cadastro de Tipo de Submissão";
    	titleList = "Listagem de Tipo de Submissão";
    	statusEdicao = "";
    }
    
	@Override
    protected TipoSubmissao getObj() {
		return new TipoSubmissao();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <TipoSubmissao> Iterable<TipoSubmissao> getObjList(){
		return (Iterable<TipoSubmissao>) tipoSubmissaoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		tipoSubmissaoRepository.save((TipoSubmissao)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return tipoSubmissaoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	TipoSubmissao obj = tipoSubmissaoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		tipoSubmissaoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") TipoSubmissao obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
