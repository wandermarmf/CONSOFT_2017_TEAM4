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

import br.gov.ufms.SGCteam04.models.CategoriaPreco;
import br.gov.ufms.SGCteam04.repositories.CategoriaPrecoRepository;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/categoria-preco")
public class CategoriaPrecoController extends CustomController {


    @Autowired
    CategoriaPrecoRepository categoriaPrecoRepository;

    public CategoriaPrecoController() {
    	viewModel = "restrito/admin/categoria-preco";
    	titleForm = "Cadastro de Categoria de preço";
    	titleList = "Listagem de Categoria de preço";
    	statusEdicao = "";
    }
    
	@Override
    protected CategoriaPreco getObj() {
		return new CategoriaPreco();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <CategoriaPreco> Iterable<CategoriaPreco> getObjList(){
		return (Iterable<CategoriaPreco>) categoriaPrecoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		categoriaPrecoRepository.save((CategoriaPreco)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return categoriaPrecoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	CategoriaPreco obj = categoriaPrecoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		categoriaPrecoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") CategoriaPreco obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
}
