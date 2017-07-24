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

import br.gov.ufms.SGCteam04.models.TipoFase;
import br.gov.ufms.SGCteam04.repositories.TipoFaseRepository;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/tipo-fase")
public class TipoFaseController extends CustomController {

    @Autowired
    TipoFaseRepository tipoFaseRepository;

    public TipoFaseController() {
    	viewModel = "restrito/admin/tipo-fase";
    	titleForm = "Cadastro de Tipo de Fase";
    	titleList = "Listagem de Tipo de Fase";
    	statusEdicao = ""; 
    }
    
	@Override
    protected TipoFase getObj() {
		return new TipoFase();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <TipoFase> Iterable<TipoFase> getObjList(){
		return (Iterable<TipoFase>) tipoFaseRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		tipoFaseRepository.save((TipoFase)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return tipoFaseRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	TipoFase obj = tipoFaseRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		tipoFaseRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") TipoFase obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
