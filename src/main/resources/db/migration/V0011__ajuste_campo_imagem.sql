ALTER TABLE public.cliente DROP COLUMN imagem;

ALTER TABLE public.usuario
    ADD column imagem varchar(255) null;