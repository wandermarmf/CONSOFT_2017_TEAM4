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

import br.gov.ufms.SGCteam04.models.Topico;
import br.gov.ufms.SGCteam04.repositories.TopicoRepository;

@Controller
@RequestMapping("/admin/topico")
public class TopicoController extends CustomController{

    @Autowired
    TopicoRepository topicoRepository;
    
    public TopicoController() {
    	viewModel = "restrito/admin/topico";
    	titleForm = "Cadastro de Tópicos";
    	titleList = "Listagem de Tópicos";
    	statusEdicao = "";
    }
    
	@Override
    protected Topico getObj() {
		return new Topico();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <Topico> Iterable<Topico> getObjList(){
		return (Iterable<Topico>) topicoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		topicoRepository.save((Topico)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return topicoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	Topico obj = topicoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		topicoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") Topico obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
}
