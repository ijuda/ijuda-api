INSERT INTO pagamento
(data_pagamento, valor, cliente_id)
VALUES('2022-08-01 08:50:33', 50, 1),
      ('2022-08-01 09:30:33', 100, 2),
      ('2022-08-01 10:50:33', 200, 3),
      ('2022-08-01 11:50:33', 300, 4),
      ('2022-08-01 12:50:33', 400, 5);

INSERT INTO categoria(nome)
VALUES('Assistência técnica'),
      ('Aulas'),
      ('Autos'),
      ('Consultoria'),
      ('Design e Tecnologia'),
      ('Eventos'),
      ('Moda e beleza'),
      ('Reforma e reparos'),
      ('Saúde'),
      ('Serviços Domésticos');

INSERT INTO servico
(nome, valor, categoria_id)
VALUES('Computador Desktop', 50, 1),
      ('Notebooks e Laptops', 50, 1),
      ('Televisão', 50, 1),
      ('Micro-ondas', 50, 1),
      ('Ar condicionado', 50, 1),

      ('Concurso', 50, 2),
      ('Idiomas', 50, 2),
      ('Informática', 50, 2),
      ('Gastronomia', 50, 2),
      ('Música', 50, 2),

      ('Alarme', 50, 3),
      ('Auto Elétrico', 50, 3),
      ('Borracharia', 50, 3),
      ('Guincho', 50, 3),
      ('Pintura', 50, 3),

      ('Advogado', 50, 4),
      ('Contador', 50, 4),
      ('Palestrante', 50, 4),
      ('Tradução', 50, 4),
      ('Segurança do Trabalho', 50, 4),

      ('Animação', 50, 5),
      ('AutoCad e modelagem 3D', 50, 5),
      ('Desenvolvimento de Games', 50, 5),
      ('Edição de Fotos', 50, 5),
      ('Web Design', 50, 5),

      ('Animação de Festas', 50, 6),
      ('Assessor de Eventos', 50, 6),
      ('Bandas e Cantores', 50, 6),
      ('Bartenders', 50, 6),
      ('Djs', 50, 6),

      ('Alfaiate', 50, 7),
      ('Artesanato', 50, 7),
      ('Barbeiro', 50, 7),
      ('Cabelereiros', 50, 7),
      ('Depilação', 50, 7),

      ('Arquiteto', 50, 8),
      ('Chaveiro', 50, 8),
      ('Concretagem', 50, 8),
      ('Desentupidor', 50, 8),
      ('Eletricista', 50, 8),

      ('Coach', 50, 9),
      ('Enfermeira', 50, 9),
      ('Fisioterapeuta', 50, 9),
      ('Fonaudiólogo', 50, 9),
      ('Médico', 50, 9),

      ('Babá', 50, 10),
      ('Cozinheira', 50, 10),
      ('Entregador', 50, 10),
      ('Motorista', 50, 10),
      ('Passeador de Cães', 50, 10);