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

import br.gov.ufms.SGCteam04.models.GrupoDesconto;
import br.gov.ufms.SGCteam04.repositories.GrupoDescontoRepository;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/grupo-desconto")
public class GrupoDescontoController extends CustomController {

    @Autowired
    GrupoDescontoRepository grupoDescontoRepository;

    public GrupoDescontoController() {
    	viewModel = "restrito/admin/grupo-desconto";
    	titleForm = "Cadastro de Grupo de Descontos";
    	titleList = "Listagem de Grupo de Descontos";
    	statusEdicao = "";
    }
    
	@Override
    protected GrupoDesconto getObj() {
		return new GrupoDesconto();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <GrupoDesconto> Iterable<GrupoDesconto> getObjList(){
		return (Iterable<GrupoDesconto>) grupoDescontoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		grupoDescontoRepository.save((GrupoDesconto)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return grupoDescontoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	GrupoDesconto obj = grupoDescontoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		grupoDescontoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") GrupoDesconto obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
