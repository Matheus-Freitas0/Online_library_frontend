CREATE TABLE livro (
    id                              SERIAL              PRIMARY KEY                                         ,
    titulo                          VARCHAR(255)        NOT NULL                                            ,
    autor                           VARCHAR(255)                                                            ,
    editora                         VARCHAR(255)                                                            ,
    isbn                            VARCHAR(255)                                                            ,
    ano_publicacao                  INT                             CHECK (ano_publicacao >= 1500)          ,
    quantidade_total                INT                 NOT NULL    CHECK (quantidade_total >= 0)           ,
    quantidade_disponivel           INT                 NOT NULL    CHECK (quantidade_disponivel >= 0)      ,
    created                         TIMESTAMP           DEFAULT     CURRENT_TIMESTAMP
);

CREATE TYPE tipo_usuario AS ENUM('LEITOR', 'ADMIN');

CREATE TABLE usuario (
    id                              SERIAL              PRIMARY KEY                                                     ,
    nome                            VARCHAR(255)        NOT NULL                                                        ,
    email                           VARCHAR(255)        NOT NULL                    UNIQUE                              ,
    senha                           VARCHAR(255)        NOT NULL                    CHECK (char_length(senha) >= 6)     ,
    tipo                            tipo_usuario        NOT NULL                    DEFAULT 'LEITOR'                    ,
    created                         TIMESTAMP           DEFAULT CURRENT_TIMESTAMP
);

CREATE TYPE status_emprestimo AS ENUM('EM_ANDAMENTO', 'DEVOLVIDO', 'ATRASADO');

CREATE TABLE emprestimo (
    id                       SERIAL                     PRIMARY KEY                                           ,
    usuario_id               BIGINT                     NOT NULL                                              ,
    data_devolucao           DATE                       NOT NULL CHECK(data_devolucao >= CURRENT_DATE)        ,
    data_devolvido           DATE                                                                             ,
    status                   status_emprestimo          NOT NULL DEFAULT 'EM_ANDAMENTO'                       ,
    created                  TIMESTAMP                  DEFAULT CURRENT_TIMESTAMP                             ,
    CONSTRAINT fk_usuario    FOREIGN KEY (usuario_id)   REFERENCES usuario(id)
);

CREATE TABLE emprestimo_livro (
    emprestimo_id   BIGINT                              NOT NULL                                                  ,
    livro_id        BIGINT                              NOT NULL                                                  ,
    PRIMARY KEY     (emprestimo_id, livro_id)                                                                     ,
    CONSTRAINT      fk_emprestimo                       FOREIGN KEY (emprestimo_id)   REFERENCES emprestimo(id)   ,
    CONSTRAINT      fk_livro                            FOREIGN KEY (livro_id)        REFERENCES livro(id)
);
