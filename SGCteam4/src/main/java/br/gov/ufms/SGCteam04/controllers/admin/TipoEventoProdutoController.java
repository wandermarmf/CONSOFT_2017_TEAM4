package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.TipoEventoProduto;
import br.gov.ufms.SGCteam04.models.TipoEventoProduto;
import br.gov.ufms.SGCteam04.repositories.TipoEventoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/tipo-evento-produto")
public class TipoEventoProdutoController extends CustomController {

    @Autowired
    TipoEventoProdutoRepository tipoEventoProdutoRepository;

    public TipoEventoProdutoController() {
    	viewModel = "restrito/admin/tipo-evento-produto";
    	titleForm = "Cadastro de Tipo de Evento / Produtos";
    	titleList = "Listagem de Tipo de Evento / Produtos";
    	statusEdicao = "";
    }
    
	@Override
    protected TipoEventoProduto getObj() {
		return new TipoEventoProduto();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <TipoEventoProduto> Iterable<TipoEventoProduto> getObjList(){
		return (Iterable<TipoEventoProduto>) tipoEventoProdutoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		tipoEventoProdutoRepository.save((TipoEventoProduto)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return tipoEventoProdutoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	TipoEventoProduto obj = tipoEventoProdutoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		tipoEventoProdutoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") TipoEventoProduto obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
