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

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;

@Controller
@RequestMapping("/admin/Conferencia")
public class ConferenciaController extends CustomController{

    @Autowired
    ConferenciaRepository conferenciaRepository;
    
    public ConferenciaController() {
    	viewModel = "restrito/admin/Conferencia";
    	titleForm = "Cadastro de Conferência";
    	titleList = "Listagem de Conferência";
    	statusEdicao = "";
    }
    
	@Override
    protected Conferencia getObj() {
		return new Conferencia();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <Conferencia> Iterable<Conferencia> getObjList(){
		return (Iterable<Conferencia>) conferenciaRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		conferenciaRepository.save((Conferencia)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return conferenciaRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	Conferencia obj = conferenciaRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		conferenciaRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") Conferencia obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
}
