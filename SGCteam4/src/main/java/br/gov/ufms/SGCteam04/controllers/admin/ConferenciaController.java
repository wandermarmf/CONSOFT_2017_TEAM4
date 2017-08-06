package br.gov.ufms.SGCteam04.controllers.admin;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import br.gov.ufms.SGCteam04.models.*;
import br.gov.ufms.SGCteam04.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/admin/conferencia")
public class ConferenciaController extends CustomController{

	@Autowired
    ConferenciaRepository conferenciaRepository;
	@Autowired
	TipoArquivoRepository tipoArquivoRepository;
	@Autowired
	OpcaoPagamentoRepository opcaoPagamentoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TipoFaseRepository tipoFaseRepository;
	
	// atributos para mainipulação de eventos...
	private Conferencia currentConferencia;
	
	
    public ConferenciaController() {
    	viewModel = "restrito/admin/conferencia";
    	titleForm = "Cadastro de Conferência";
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
    		conferenciaRepository.delete(currentConferencia);
    		return true;
    	}
	}

	@Override
	protected void doGetViewChilds(ModelAndView mv, Model model) {
		// Busca as listas que serão apresentadas na página
		Iterable<TipoArquivo> listArqObjs = tipoArquivoRepository.findAll();
		Iterable<OpcaoPagamento> listPgObjs = opcaoPagamentoRepository.findAll();
		Iterable<Usuario> usuarios  = usuarioRepository.findAll();
		
		// Pega as lista já configuradas da conferencia
		List<TipoArquivo> listArqConferencia = currentConferencia.getTipoArquivoList();
		List<OpcaoPagamento> listOpPgConferencia = currentConferencia.getOpcaoPagamentoList();
		
		// Sinaliza quais estão selecionadas para esta conferencia...
		for (TipoArquivo tipoArq : listArqObjs) 
			tipoArq.setSelected(listArqConferencia.indexOf(tipoArq) != -1);
		
		for (OpcaoPagamento opPg : listPgObjs) 
			opPg.setSelected(listOpPgConferencia.indexOf(opPg) != -1);
		
		mv.addObject("listArqObjs", listArqObjs);
    	mv.addObject("listPgObjs", listPgObjs);
    	mv.addObject("usuarios",usuarios);
	}
	
	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") Conferencia obj, @RequestParam(value = "uslt") Long idUsuario,
			      @RequestParam(value = "editar",required = false)String editar,
									BindingResult result, Model model, HttpServletRequest request) {
		
		// guarda o objeto da conferencia que está sendo manipulado
		currentConferencia = obj;

		Usuario administrador = usuarioRepository.findOne(idUsuario);
		if(administrador != null)
			obj.setAdministrador(administrador);


		// Pega as listas do banco de dados...
		Iterable<TipoArquivo> listArqObjs = tipoArquivoRepository.findAll();
		Iterable<OpcaoPagamento> listPgObjs = opcaoPagamentoRepository.findAll();
		
		String paramName, paramValue;
		
		/* Zera a lista de arquivos e opção de pagamento anteriores...*/
		currentConferencia.getTipoArquivoList().clear();
		currentConferencia.getOpcaoPagamentoList().clear();
		
		/* guarda o botão auxiliar, caso seja clicado */
		Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
        	paramName = (String) enumeration.nextElement();
        	paramValue = request.getParameter(paramName);
        	
            if ((paramName == null) || (paramName.length() < 11))
            	continue;
            
            if (paramName.substring(0, 12).toLowerCase().equals("checklistarq") == true) {
            	currentConferencia.addTipoArquivo(listArqObjs, paramValue);
            } else if (paramName.substring(0, 11).toLowerCase().equals("checklistpg") == true) {
            	currentConferencia.addOpcaoPagamento(listPgObjs, paramValue);
            }            	
        }

        ModelAndView modelAndView = doPostMappingSave(obj, result, model);
        String response = (String) modelAndView.getModel().get("response");
        if(editar == null && response.equals("success"))
		{
			ArrayList<TipoFase> arrayList =(ArrayList<TipoFase>) tipoFaseRepository.findAll();
			String diretorioFasesConferencia = "restrito/admin/fases-conferencia";
			modelAndView.getModel().put("obj",obj);
			modelAndView.getModel().put("tipos",arrayList);
			modelAndView.getModel().put("adc","conferencia");
			return new ModelAndView(diretorioFasesConferencia,modelAndView.getModel());
		}
		else
		{
			return modelAndView;
		}
	}
}
