INSERT INTO usuario(email, nome, senha)
VALUES('benicioelias@email.com','Benicio Elias Araujo','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('osvaldo_raimundo@email.com','Osvaldo Raimundo Oliveira','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('miguel_luiz@email.com','Miguel Luiz Rezende','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('filipe_fernando@email.com','Filipe Fernando Pires','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('bento_leonardo@email.com','Bento Leonardo Cavalcanti','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),

      ('pietra_lavinia@email.com','Pietra Lavinia Ribeiro','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('silvana_kamilly@email.com','Silvana Kamilly Allana Gomes','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('severino_pedro@email.com','Severino Pedro Henrique','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('lucas_geraldo@email.com','Lucas Geraldo Guilherme','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy'),
      ('isabelle_francisca@email.com','Isabelle Francisca Fernandes','$2a$10$j7JFA0ITP3kocgmXdVmip.bnL4D1KOnHuxgZsRxey.mrJ4Us2wjUy');


INSERT INTO cliente(ativo, cpf, bairro, cep, cidade, complemento, numero, pais, rua, telefone, usuario)
values (true,'123.586.633-52','Bonsucesso','60545-505','Fortaleza','casa', 903, 'Brasil', 'Rua Padre Antônio Nunes Gurgel','85 985936910', 12),
       (true,'804.109.913-09','Dionisio Torres','60135-238','Fortaleza','casa', 978, 'Brasil', 'Avenida Pontes Vieira','85 988100923', 13),
       (true,'466.517.383-48','Serrinha','60741-670','Fortaleza','casa', 636, 'Brasil', 'Vila Araújo Castro','85 994487172', 14),
       (true,'010.920.993-10','Bonsucesso','60520-590','Fortaleza','casa', 443, 'Brasil', 'Rua Doze de Julho','85 982966371', 15),
       (true,'151.887.463-01','Conjunto Esperança','60763-490','Fortaleza','casa', 856, 'Brasil', 'Avenida G','85 982804165', 16);

INSERT INTO prestador_servico(ativo, cpf, bairro, cep, cidade, complemento, numero, pais, rua, telefone, usuario)
VALUES(true, '882.702.323-27', 'Henrique Jorge', '60525-470', 'Fortaleza', 'casa', 284, 'Brasil', 'Vila São Paulino', '85 983977764', 17),
      (true, '061.221.373-08', 'Vila Velha', '60349-432', 'Fortaleza', 'casa', 999, 'Brasil', 'Rua Eduardo Araújo', '85 997482022', 18),
      (true, '750.917.253-50', 'Alto da Balança', '60851-195', 'Fortaleza', 'casa', 586, 'Brasil', 'Avenida Borges de Melo', '85 996773331', 19),
      (true, '597.414.493-72', 'Conjunto Ceará', '60531-100', 'Fortaleza', 'casa', 328, 'Brasil', 'Conjunto Ceará', '85 993169597', 20),
      (true, '390.973.413-88', 'Meireles', '60170-240', 'Fortaleza', 'casa', 906, 'Brasil', 'Rua Coronel Linhares', '85 991115028', 21);


INSERT INTO usuario_permissao
(codigo_usuario, codigo_permissao)
VALUES(12, 2),
      (13, 2),
      (14,2),
      (15,2),
      (16,2),

      (17,3),
      (18,3),
      (19,3),
      (20,3),
      (21,3);