CREATE TABLE categoria (id BIGSERIAL NOT NULL,
                        nome varchar(255),
                        PRIMARY KEY (id));

CREATE TABLE cliente (id BIGSERIAL NOT NULL,
                      ativo boolean, cpf varchar(255),
                      bairro varchar(255),
                      cep varchar(255),
                      cidade varchar(255),
                      complemento varchar(255),
                      numero int8, pais varchar(255),
                      rua varchar(255),
                      imagem BYTEA,
                      telefone varchar(255),
                      usuario int8, PRIMARY KEY (id));

CREATE TABLE pagamento (id BIGSERIAL NOT NULL,
                        data_pagamento timestamp, valor float8,
                        cliente_id int8, PRIMARY KEY (id));

CREATE TABLE permissao (id BIGSERIAL NOT NULL,
                        descricao varchar(255),
                        PRIMARY KEY (id));

CREATE TABLE prestador_servico (id BIGSERIAL NOT NULL,
                                ativo boolean, cpf varchar(255),
                                email varchar(255),
                                bairro varchar(255),
                                cep varchar(255),
                                cidade varchar(255),
                                complemento varchar(255),
                                numero int8, pais varchar(255),
                                rua varchar(255),
                                nome varchar(255),
                                telefone varchar(255),
                                usuario int8, PRIMARY KEY (id));

CREATE TABLE servico (id BIGSERIAL NOT NULL,
                      nome varchar(255),
                      valor float8,
                      categoria_id int8, PRIMARY KEY (id));

CREATE TABLE servico_prestadores_servicos (servico_id int8 NOT NULL,
                                           prestador_servico_id int8 NOT NULL);

CREATE TABLE solicitacao_servico (id BIGSERIAL NOT NULL,
                                  ativo boolean, descricao varchar(255),
                                  bairro varchar(255),
                                  cep varchar(255),
                                  cidade varchar(255),
                                  complemento varchar(255),
                                  numero int8, pais varchar(255),
                                  rua varchar(255),
                                  status_solicitacao varchar(255),
                                  total float8,
                                  cliente_id int8, pagamento_id int8, prestador_servico_id int8, servico_id int8, PRIMARY KEY (id));

CREATE TABLE usuario (id BIGSERIAL NOT NULL,
                      email varchar(255),
                      nome varchar(255),
                      senha varchar(255),
                      PRIMARY KEY (id));

CREATE TABLE usuario_permissao (codigo_usuario int8 NOT NULL,
                                codigo_permissao int8 NOT NULL);

ALTER TABLE cliente ADD CONSTRAINT FKys2popaa4ruj08ql48977dxp
    FOREIGN KEY (usuario) REFERENCES usuario;

ALTER TABLE pagamento ADD CONSTRAINT FK8fh46wc82qvy6h0sny4g72ymk
    FOREIGN KEY (cliente_id) REFERENCES cliente;

ALTER TABLE prestador_servico ADD CONSTRAINT FKbrhmv1mpi5gqf0a3q6tnb7a3b
    FOREIGN KEY (usuario) REFERENCES usuario;

ALTER TABLE servico ADD CONSTRAINT FK3s3u441gpubcnj5g69hqim1p3
    FOREIGN KEY (categoria_id) REFERENCES categoria;

ALTER TABLE servico_prestadores_servicos ADD CONSTRAINT FK44qm7fyqw1ej80gbyfmjwawuq
    FOREIGN KEY (prestador_servico_id) REFERENCES prestador_servico;

ALTER TABLE servico_prestadores_servicos ADD CONSTRAINT FKgyxb63jgw1cme9e5ermm7rfsp
    FOREIGN KEY (servico_id) REFERENCES servico;

ALTER TABLE solicitacao_servico ADD CONSTRAINT FKi5nyh4ydrsurjj4d3a4bub0gi
    FOREIGN KEY (cliente_id) REFERENCES cliente;

ALTER TABLE solicitacao_servico ADD CONSTRAINT FK1ti7c0imfnyq5hqk1o2lhbev7
    FOREIGN KEY (pagamento_id) REFERENCES pagamento;

ALTER TABLE solicitacao_servico ADD CONSTRAINT FKftsba64pu02rhxmaklphrviyb
    FOREIGN KEY (prestador_servico_id) REFERENCES prestador_servico;

ALTER TABLE solicitacao_servico ADD CONSTRAINT FKh3e1e2jxcm8f0xnd2vgol4360
    FOREIGN KEY (servico_id) REFERENCES servico;

ALTER TABLE usuario_permissao ADD CONSTRAINT FK5tjrvuwlx1yp72mrf8t8vj93e
    FOREIGN KEY (codigo_permissao) REFERENCES permissao;

ALTER TABLE usuario_permissao ADD CONSTRAINT FKeogfr4akeqn19xr3wmyx0n8bo
    FOREIGN KEY (codigo_usuario) REFERENCES usuario;