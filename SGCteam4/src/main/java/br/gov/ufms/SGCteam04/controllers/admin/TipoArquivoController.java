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

import br.gov.ufms.SGCteam04.models.TipoArquivo;
import br.gov.ufms.SGCteam04.repositories.TipoArquivoRepository;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/tipo-arquivo")
public class TipoArquivoController extends CustomController {

    @Autowired
	TipoArquivoRepository tipoArquivoRepository;
	
    public TipoArquivoController() {
    	viewModel = "restrito/admin/tipo-arquivo";
    	titleForm = "Cadastro de Tipos de Arquivos";
    	titleList = "Listagem de Tipos de Arquivos";
    	statusEdicao = "";
    }
    
	@Override
    protected TipoArquivo getObj() {
		return new TipoArquivo();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <TipoArquivo> Iterable<TipoArquivo> getObjList(){
		return (Iterable<TipoArquivo>) tipoArquivoRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		tipoArquivoRepository.save((TipoArquivo)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return tipoArquivoRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	TipoArquivo obj = tipoArquivoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		tipoArquivoRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") TipoArquivo obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	

}
