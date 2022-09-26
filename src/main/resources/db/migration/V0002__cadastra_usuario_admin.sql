INSERT INTO public.usuario
(email, nome, senha)
VALUES('admin@email.com', 'admin', '$2a$10$ITsmS/V.KvdNgroyhvSGWO/RPvleK7NGY3N4XnuaA2BS9JBo.0FBi');

INSERT INTO public.permissao
(descricao)
VALUES('ROLE_ADMNINISTRADOR');

INSERT INTO public.usuario_permissao
(codigo_usuario, codigo_permissao)
VALUES(1, 1);