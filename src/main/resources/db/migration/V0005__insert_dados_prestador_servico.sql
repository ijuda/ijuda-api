ALTER TABLE prestador_servico DROP COLUMN email;

INSERT INTO prestador_servico(ativo, cpf, bairro, cep, cidade, complemento, numero, pais, rua, telefone, usuario)
VALUES(true, '201.232.142-05', 'aldeota', '23152-223', 'Fortaleza', 'casa', 10, 'Brasil', 'Rua presidente 01', '85 779587524', 7),
      (true, '800.905.543-37', 'meireles','60764-605', 'Fortaleza', 'casa', 10, 'Brasil', 'Rua Doutor Procópio', '88 37785318', 8),
      (true, '391.656.403-06', 'pirambu', '76829-049', 'Fortaleza', 'casa', 885, 'Brasil', 'Rua Alexandre Guimarães', '69 991480018', 9),
      (true, '573.690.048-30', 'beira-mar', '72622-302', 'Fortaleza', 'casa', 538, 'Brasil', 'Rua Recanto das Emas', '61 986019881', 10),
      (true, '154.223.882-08', 'panamericano', '69919-790', 'Fortaleza', 'casa', 403, 'Brasil', 'Avenida W67', '68 99371-5087', 11);