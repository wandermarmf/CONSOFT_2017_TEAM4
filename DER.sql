
CREATE TABLE Topico (
       ID_TOPICO            INTEGER NOT NULL,
       TOPICO               VARCHAR(20),
       PRIMARY KEY (ID_TOPICO)
);


CREATE TABLE Trabalho (
       ID_Trabalho          INTEGER NOT NULL,
       ID_TOPICO            INTEGER,
       titulo               VARCHAR(20),
       palavraChave         VARCHAR(200),
       resumo               BLOB,
       status               CHAR(1),
       PRIMARY KEY (ID_Trabalho)
);


CREATE TABLE PESSOA (
       ID_PESSOA            INTEGER NOT NULL,
       NOME                 VARCHAR(20),
       DataNascimento       DATE,
       Email                VARCHAR(200),
       Senha                VARCHAR(30),
       WebSite              VARCHAR(200),
       Nacionalidade        VARCHAR(20),
       UsuarioAtivo         CHAR(1),
       PRIMARY KEY (ID_PESSOA)
);


CREATE TABLE CONFERENCIA (
       ID_CONFERENCIA       INTEGER NOT NULL,
       nomeAbreviado        VARCHAR(20),
       NomeConferencia      VARCHAR(200),
       SubTitulo            VARCHAR(20),
       SubTituloSecundario  VARCHAR(20),
       PaginaWeb            VARCHAR(200),
       CidadeConferencia    VARCHAR(30),
       CidadeEmissaoFatura  VARCHAR(30),
       ID_PESSOA_ADM        INTEGER,
       ID_PESSOA_FATURA     INTEGER,
       ValorTaxaEmissaoFatura NUMERIC(12,2),
       MoedaConferencia     VARCHAR(20),
       PRIMARY KEY (ID_CONFERENCIA)
);


CREATE TABLE ConferenciaComite (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_PESSOA_Coordenador INTEGER,
       ComitePrograma       VARCHAR(20),
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma)
);


CREATE TABLE ConferenciaComiteVotacao (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_Votacao           INTEGER NOT NULL,
       ID_Trabalho          INTEGER,
       Nota                 INTEGER,
       Data                 DATE,
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Votacao)
);


CREATE TABLE ConferenciaComiteForum (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_Forum             INTEGER NOT NULL,
       nomeForum            VARCHAR(20),
       InstrucoesForum      BLOB,
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Forum)
);


CREATE TABLE ConferenciaForumMensagem (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_Forum             INTEGER NOT NULL,
       ID_Mensagem          INTEGER NOT NULL,
       data                 DATE,
       conteudo             BLOB,
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Forum, 
              ID_Mensagem)
);


CREATE TABLE AUTOR (
       ID_Autor             INTEGER NOT NULL,
       PRIMARY KEY (ID_Autor)
);


CREATE TABLE Trabalho_Autor (
       ID_Trabalho          INTEGER NOT NULL,
       Papel                CHAR(1) NOT NULL,
       ID_Autor_Apresentador INTEGER,
       PRIMARY KEY (ID_Trabalho, Papel)
);


CREATE TABLE REVISOR (
       ID_Revisor           INTEGER NOT NULL,
       PRIMARY KEY (ID_Revisor)
);


CREATE TABLE Revisao (
       ID_Revisao           INTEGER NOT NULL,
       ID_Revisor           INTEGER,
       ID_Trabalho          INTEGER,
       Status               CHAR(1),
       data                 DATE,
       nota                 INTEGER,
       comentario           BLOB,
       PRIMARY KEY (ID_Revisao)
);


CREATE TABLE TipoArquivo (
       ID_TipoArquivo       INTEGER NOT NULL,
       TipoArquivo          VARCHAR(30),
       PRIMARY KEY (ID_TipoArquivo)
);


CREATE TABLE TrabalhoArquivo (
       ID_Trabalho          INTEGER NOT NULL,
       ID_Arquivo           INTEGER NOT NULL,
       ID_TipoArquivo       INTEGER,
       Nome                 VARCHAR(20),
       Conteudo             BLOB,
       PRIMARY KEY (ID_Trabalho, ID_Arquivo)
);


CREATE TABLE ConferenciaComiteSubmissao (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_Trabalho          INTEGER NOT NULL,
       Data                 DATE,
       versao               INTEGER,
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Trabalho)
);


CREATE TABLE REVISOR_TOPICO (
       ID_Revisor           INTEGER NOT NULL,
       ID_TOPICO            INTEGER NOT NULL,
       PRIMARY KEY (ID_Revisor, ID_TOPICO)
);


CREATE TABLE GrupoParcitipante (
       ID_GrupoParticipante INTEGER NOT NULL,
       GrupoParticipante    VARCHAR(30),
       PRIMARY KEY (ID_GrupoParticipante)
);


CREATE TABLE ConferenciaParticipante (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_Participante      INTEGER NOT NULL,
       DataInscricao        DATE,
       ID_GrupoParticipante INTEGER,
       PerfilOculto         CHAR(1),
       Faturado             CHAR(1),
       PRIMARY KEY (ID_CONFERENCIA, ID_Participante)
);


CREATE TABLE Fatura (
       id_fatura            INTEGER NOT NULL,
       ID_CONFERENCIA       INTEGER,
       ID_Participante      INTEGER,
       dataFatura           DATE,
       valorInscricao       NUMERIC(12,2),
       valorProdutos        NUMERIC(12,2),
       valorDesconto        NUMERIC(12,2),
       valorFatura          NUMERIC(12,2),
       situacaoFatura       CHAR(1),
       dataPagamento        DATE,
       PRIMARY KEY (id_fatura)
);


CREATE TABLE CategoriaPreco (
       ID_CategoriaPreco    INTEGER NOT NULL,
       categoriaPreco       VARCHAR(30),
       preco                NUMERIC(12,2),
       PRIMARY KEY (ID_CategoriaPreco)
);


CREATE TABLE TipoProdutoEvento (
       ID_TipoProduto       INTEGER NOT NULL,
       nome                 VARCHAR(30),
       Informacao           BLOB,
       modoSelecao          CHAR(1),
       OrdemSelecao         CHAR(1),
       PRIMARY KEY (ID_TipoProduto)
);


CREATE TABLE ConferenciaProduto (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_Produto           INTEGER NOT NULL,
       Titulo               VARCHAR(20),
       Abreviacao           VARCHAR(30),
       dataEvento           DATE,
       localEvento          VARCHAR(30),
       Informacao           BLOB,
       ID_TipoProduto       INTEGER,
       ID_CategoriaPreco    INTEGER,
       eventoAtivo          CHAR(1),
       PRIMARY KEY (ID_CONFERENCIA, ID_Produto)
);


CREATE TABLE ConferenciaParticipanteProduto (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_Participante      INTEGER NOT NULL,
       ID_Produto           INTEGER NOT NULL,
       PRIMARY KEY (ID_CONFERENCIA, ID_Participante, ID_Produto)
);


CREATE TABLE ConferenciaComiteMembro (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_ComitePrograma    INTEGER NOT NULL,
       ID_Membro            INTEGER NOT NULL,
       PRIMARY KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Membro)
);


CREATE TABLE OpcaoPagamento (
       ID_OpacaoPagamento   INTEGER NOT NULL,
       opcaoPagamento       VARCHAR(30),
       PRIMARY KEY (ID_OpacaoPagamento)
);


CREATE TABLE ConferenciaSessao (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_SESSAO            INTEGER NOT NULL,
       NOME                 VARCHAR(20),
       NOMEABREVIADO        VARCHAR(30),
       PEIRODOINICIAL       DATE,
       PEIRODOFINAL         DATE,
       PRIMARY KEY (ID_CONFERENCIA, ID_SESSAO)
);


CREATE TABLE ConferenciaSessaoConteudo (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_SESSAO            INTEGER NOT NULL,
       ID_Trabalho          INTEGER NOT NULL,
       PRIMARY KEY (ID_CONFERENCIA, ID_SESSAO, ID_Trabalho)
);


CREATE TABLE ConferenciaOpcaoPagto (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_OpacaoPagamento   INTEGER NOT NULL,
       PRIMARY KEY (ID_CONFERENCIA, ID_OpacaoPagamento)
);


CREATE TABLE ENDERECO (
       ID_Endereco          INTEGER NOT NULL,
       ID_PESSOA            INTEGER NOT NULL,
       TipoEndereco         CHAR(1),
       Endereco             VARCHAR(20),
       Complemento          VARCHAR(30),
       Bairro               VARCHAR(30),
       ciadde               VARCHAR(30),
       estado               CHAR(2),
       cep                  VARCHAR(8),
       pais                 VARCHAR(30),
       PRIMARY KEY (ID_Endereco, ID_PESSOA)
);


CREATE TABLE TELEFONE (
       ID_TELEFONE          INTEGER NOT NULL,
       ID_PESSOA            INTEGER NOT NULL,
       codigo_pais          INTEGER,
       ddd                  INTEGER,
       numero               INTEGER,
       PRIMARY KEY (ID_TELEFONE, ID_PESSOA)
);


CREATE TABLE ConferenciaIntervaloDesconto (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_INTERVALO_DESCONTO INTEGER NOT NULL,
       PERIODOINICIAL       DATE,
       PEIRODOFINAL         DATE,
       ID_GrupoParticipante INTEGER,
       DESCONTO             NUMERIC(12,2),
       PRIMARY KEY (ID_CONFERENCIA, ID_INTERVALO_DESCONTO)
);


CREATE TABLE ConferenciaSessaoTopico (
       ID_CONFERENCIA       INTEGER NOT NULL,
       ID_SESSAO            INTEGER NOT NULL,
       ID_TOPICO            INTEGER NOT NULL,
       PRIMARY KEY (ID_CONFERENCIA, ID_SESSAO, ID_TOPICO)
);


CREATE TABLE TIPOFASE (
       ID_TIPO_FASE         INTEGER NOT NULL,
       TIPOFASE             VARCHAR(30),
       PRIMARY KEY (ID_TIPO_FASE)
);


CREATE TABLE ConferenciaFase (
       ID_TIPO_FASE         INTEGER NOT NULL,
       ID_CONFERENCIA       INTEGER NOT NULL,
       PeriodoInicial       DATE,
       PeriodoFinal         DATE,
       FaseDesativada       CHAR(1),
       PRIMARY KEY (ID_TIPO_FASE, ID_CONFERENCIA)
);

CREATE VIEW VCONFERENCIA (ID_CONFERENCIA, nomeAbreviado, NomeConferencia, SubTitulo, SubTituloSecundario, PaginaWeb, CidadeConferencia, CidadeEmissaoFatura, ID_PESSOA_ADM, ID_PESSOA_FATURA, ValorTaxaEmissaoFatura, Nome_Organizador, Nome_Contato, Email_Contato, Endereco_Contato, Bairro_Contato, ciadde_Contato, estado_Contato, cep_Contato, Complemento_Contato)  AS
       SELECT C.ID_CONFERENCIA, C.nomeAbreviado, C.NomeConferencia, C.SubTitulo, C.SubTituloSecundario, C.PaginaWeb, C.CidadeConferencia, C.CidadeEmissaoFatura, C.ID_PESSOA_ADM, C.ID_PESSOA_FATURA, C.ValorTaxaEmissaoFatura, PES_ADM.NOME, PES_FATURA.NOME, PES_FATURA.Email, END_FAT.Endereco, END_FAT.Bairro, END_FAT.ciadde, END_FAT.estado, END_FAT.cep, END_FAT.Complemento
       FROM CONFERENCIA C, PESSOA PES_ADM, PESSOA PES_FATURA, ENDERECO END_FAT;


ALTER TABLE Trabalho
       ADD FOREIGN KEY (ID_TOPICO)
                             REFERENCES Topico;


ALTER TABLE CONFERENCIA
       ADD FOREIGN KEY (ID_PESSOA_FATURA)
                             REFERENCES PESSOA;


ALTER TABLE CONFERENCIA
       ADD FOREIGN KEY (ID_PESSOA_ADM)
                             REFERENCES PESSOA;


ALTER TABLE ConferenciaComite
       ADD FOREIGN KEY (ID_PESSOA_Coordenador)
                             REFERENCES PESSOA;


ALTER TABLE ConferenciaComite
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ConferenciaComiteVotacao
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE ConferenciaComiteVotacao
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_ComitePrograma)
                             REFERENCES ConferenciaComite;


ALTER TABLE ConferenciaComiteForum
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_ComitePrograma)
                             REFERENCES ConferenciaComite;


ALTER TABLE ConferenciaForumMensagem
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_ComitePrograma, ID_Forum)
                             REFERENCES ConferenciaComiteForum;


ALTER TABLE AUTOR
       ADD FOREIGN KEY (ID_Autor)
                             REFERENCES PESSOA;


ALTER TABLE Trabalho_Autor
       ADD FOREIGN KEY (ID_Autor_Apresentador)
                             REFERENCES AUTOR;


ALTER TABLE Trabalho_Autor
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE REVISOR
       ADD FOREIGN KEY (ID_Revisor)
                             REFERENCES PESSOA;


ALTER TABLE Revisao
       ADD FOREIGN KEY (ID_Revisor)
                             REFERENCES REVISOR;


ALTER TABLE Revisao
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE TrabalhoArquivo
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE TrabalhoArquivo
       ADD FOREIGN KEY (ID_TipoArquivo)
                             REFERENCES TipoArquivo;


ALTER TABLE ConferenciaComiteSubmissao
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE ConferenciaComiteSubmissao
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_ComitePrograma)
                             REFERENCES ConferenciaComite;


ALTER TABLE REVISOR_TOPICO
       ADD FOREIGN KEY (ID_TOPICO)
                             REFERENCES Topico;


ALTER TABLE REVISOR_TOPICO
       ADD FOREIGN KEY (ID_Revisor)
                             REFERENCES REVISOR;


ALTER TABLE ConferenciaParticipante
       ADD FOREIGN KEY (ID_GrupoParticipante)
                             REFERENCES GrupoParcitipante;


ALTER TABLE ConferenciaParticipante
       ADD FOREIGN KEY (ID_Participante)
                             REFERENCES PESSOA;


ALTER TABLE ConferenciaParticipante
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE Fatura
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_Participante)
                             REFERENCES ConferenciaParticipante;


ALTER TABLE ConferenciaProduto
       ADD FOREIGN KEY (ID_CategoriaPreco)
                             REFERENCES CategoriaPreco;


ALTER TABLE ConferenciaProduto
       ADD FOREIGN KEY (ID_TipoProduto)
                             REFERENCES TipoProdutoEvento;


ALTER TABLE ConferenciaProduto
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ConferenciaParticipanteProduto
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_Produto)
                             REFERENCES ConferenciaProduto;


ALTER TABLE ConferenciaParticipanteProduto
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_Participante)
                             REFERENCES ConferenciaParticipante;


ALTER TABLE ConferenciaComiteMembro
       ADD FOREIGN KEY (ID_Membro)
                             REFERENCES PESSOA;


ALTER TABLE ConferenciaComiteMembro
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_ComitePrograma)
                             REFERENCES ConferenciaComite;


ALTER TABLE ConferenciaSessao
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ConferenciaSessaoConteudo
       ADD FOREIGN KEY (ID_Trabalho)
                             REFERENCES Trabalho;


ALTER TABLE ConferenciaSessaoConteudo
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_SESSAO)
                             REFERENCES ConferenciaSessao;


ALTER TABLE ConferenciaOpcaoPagto
       ADD FOREIGN KEY (ID_OpacaoPagamento)
                             REFERENCES OpcaoPagamento;


ALTER TABLE ConferenciaOpcaoPagto
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ENDERECO
       ADD FOREIGN KEY (ID_PESSOA)
                             REFERENCES PESSOA;


ALTER TABLE TELEFONE
       ADD FOREIGN KEY (ID_PESSOA)
                             REFERENCES PESSOA;


ALTER TABLE ConferenciaIntervaloDesconto
       ADD FOREIGN KEY (ID_GrupoParticipante)
                             REFERENCES GrupoParcitipante;


ALTER TABLE ConferenciaIntervaloDesconto
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ConferenciaSessaoTopico
       ADD FOREIGN KEY (ID_TOPICO)
                             REFERENCES Topico;


ALTER TABLE ConferenciaSessaoTopico
       ADD FOREIGN KEY (ID_CONFERENCIA, ID_SESSAO)
                             REFERENCES ConferenciaSessao;


ALTER TABLE ConferenciaFase
       ADD FOREIGN KEY (ID_CONFERENCIA)
                             REFERENCES CONFERENCIA;


ALTER TABLE ConferenciaFase
       ADD FOREIGN KEY (ID_TIPO_FASE)
                             REFERENCES TIPOFASE;



