package br.gov.ufms.SGCteam04.controllers;

import br.gov.ufms.SGCteam04.models.*;
import br.gov.ufms.SGCteam04.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Marco Cardoso on 7/9/2017.
 */
@Controller()
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    TipoFaseRepository tipoFaseRepository;

    @Autowired
    TipoArquivoRepository tipoArquivoRepository;

    @Autowired
    TipoSubmissaoRepository tipoSubmissaoRepository;

    @Autowired
    CategoriaPrecoRepository categoriaPrecoRepository;

    @Autowired
    GrupoParticipanteRepository grupoParticipanteRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    TipoEventoProdutoRepository tipoEventoProdutoRepository;

    @Autowired
    GrupoDescontoRepository grupoDescontoRepository;

    @Autowired
    OpcaoPagamentoRepository opcaoPagamentoRepository;


    /*
        ADICIONAR OPCAO DE PAGAMENTO
     */
    @GetMapping("/opcao-pagamento")
    private String opcaoPagamento()
    {
        return "restrito/admin/opcao-pagamento";
    }

    @PostMapping("/opcao-pagamento")
    private String opcaoPagamentoPost(
            Model model,
            @RequestParam(value = "descricao",required = true)String descricao
    )
    {
        try {
            OpcaoPagamento opcaoPagamento = new OpcaoPagamento();
            opcaoPagamento.setDescricao(descricao);
            opcaoPagamentoRepository.save(opcaoPagamento);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe uma opcao de pagamento com esta descricao !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro ocorreu !");
        }
        return "restrito/admin/opcao-pagamento";
    }


    /*
        ADICIONAR GRUPO DE DESCONTO
     */
    @GetMapping("/grupo-desconto")
    private String grupoDesconto()
    {
        return "restrito/admin/grupo-desconto";
    }

    @PostMapping("/grupo-desconto")
    private String grupoDescontoPost(
            Model model,
            @RequestParam(value = "descricao",required = true)String descricao,
            @RequestParam(value = "valor",required = true) Double valor
    )
    {
        try {
            GrupoDesconto grupoDesconto = new GrupoDesconto();
            grupoDesconto.setNome(descricao);
            grupoDesconto.setValor(valor);
            grupoDescontoRepository.save(grupoDesconto);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe um grupo de desconto com esta descrição !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Ocorreu um erro !");
        }
        return "restrito/admin/grupo-desconto";
    }


    /*
        ADICIONAR TIPO EVENTO PRODUTO
     */
    @GetMapping("/tipo-evento-produto")
    private String tipoEventoProduto()
    {
        return "restrito/admin/tipo-evento-produto";
    }

    @PostMapping("/tipo-evento-produto")
    private String tipoEventoProdutoPost(
            Model model,
            @RequestParam(value = "nome",required = true) String nome,
            @RequestParam(value = "informacao", required = true)String informacao,
            @RequestParam(value = "modoSelecao", required = true) Character modoSelecao,
            @RequestParam(value = "ordemSelecao", required = true) Integer ordemSelecao
    )
    {
        try {

            TipoEventoProduto tipoEventoProduto = new TipoEventoProduto();
            tipoEventoProduto.setNome(nome);
            tipoEventoProduto.setInformacao(informacao);
            tipoEventoProduto.setModoSelecao(modoSelecao);
            tipoEventoProduto.setOrdemSelecao(ordemSelecao);
            tipoEventoProdutoRepository.save(tipoEventoProduto);
            model.addAttribute("response","success");

        }
        catch(DataIntegrityViolationException d)
        {
            model.addAttribute("response","Já existe um tipo evento produto com este nome !");
        }
        catch(Exception e)
        {
            model.addAttribute("response","Um erro ocorreu !");
        }

        return "restrito/admin/tipo-evento-produto";
    }

    /*
        ADICIONAR TIPO DO TOPICO
     */
    @GetMapping("/topico")
    private String topico()
    {
        return "restrito/admin/topico";
    }

    @PostMapping("/topico")
    private String topicoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            Topico topico = new Topico();
            topico.setTopico(descricao);
            topicoRepository.save(topico);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            model.addAttribute("response","Já existe um topico com este nome !");
        }
        catch(Exception e)
        {
            model.addAttribute("response","Ocorreu um erro !");
        }
        return "restrito/admin/topico";
    }


    /*
        ADICIONAR GRUPO PARTICIPANTE
     */
    @GetMapping("/grupo-participante")
    private String grupoParticipante()
    {
        return "restrito/admin/grupo-participante";
    }

    @PostMapping("/grupo-participante")
    private String grupoParticipantePost(
            Model model,
            @RequestParam(value = "nome",required = true) String nome
    )
    {
        try {
            GrupoParticipante grupoParticipante = new GrupoParticipante();
            grupoParticipante.setGrupo(nome);
            grupoParticipanteRepository.save(grupoParticipante);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            model.addAttribute("response","Já existe um grupo com este nome !");
        }
        catch(Exception e)
        {
            model.addAttribute("response","Ocorreu um erro !");
        }
        return "restrito/admin/grupo-participante";
    }


    /*
        ADICIONAR CATEGORIA PREÇO
     */
    @GetMapping("/categoria-preco")
    private String categoriaPreco()
    {
        return "restrito/admin/categoria-preco";
    }

    @PostMapping("/categoria-preco")
    private String categoriaPrecoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao,
            @RequestParam(value = "valor", required = true) Double valor
    )
    {
        try {
            CategoriaPreco categoriaPreco = new CategoriaPreco();
            categoriaPreco.setCategoriaPreco(descricao);
            categoriaPreco.setPreco(valor);
            categoriaPrecoRepository.save(categoriaPreco);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe uma categoria com a descrição fornecida !");
        }
        catch(Exception e )
        {
            model.addAttribute("response","Um erro ocorreu !");
        }
        return "restrito/admin/categoria-preco";
    }



    /*
        TIPO SUBMISSÃO
     */
    @GetMapping("/tipo-submissao")
    private String tipoSubmissao()
    {
        return "restrito/admin/tipo-submissao";
    }

    @PostMapping("/tipo-submissao")
    private String tipoSubmissaoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoSubmissao tipoSubmissao = new TipoSubmissao();
            tipoSubmissao.setTipoSubmissao(descricao);
            tipoSubmissaoRepository.save(tipoSubmissao);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe um tipo de submissão com esta descrição !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }
        return "restrito/admin/tipo-submissao";
    }

    /*
        TIPO ARQUIVO
     */
    @GetMapping("/tipo-arquivo")
    private String tipoArquivo()
    {
        return "restrito/admin/tipo-arquivo";
    }

    @PostMapping("/tipo-arquivo")
    private String tipoArquivoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoArquivo tipoArquivo = new TipoArquivo();
            tipoArquivo.setTipoArquivo(descricao);
            tipoArquivoRepository.save(tipoArquivo);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe um tipo de arquivo com esta descrição !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }



        return "restrito/admin/tipo-arquivo";
    }

    /*
        TIPO FASE
     */

    @GetMapping("/tipo-fase")
    private String tipoFase()
    {
        return "restrito/admin/tipo-fase";
    }

    @PostMapping("/tipo-fase")
    private String tipoFasePost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoFase fase = new TipoFase();
            fase.setDescricao(descricao);
            tipoFaseRepository.save(fase);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Fase com descrição já existente !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }



        return "restrito/admin/tipo-fase";
    }

}
