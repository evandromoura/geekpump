ALTER TABLE public.usuario ADD genero character varying NULL;



-- DROP TABLE public.historico_repeticao;

CREATE TABLE public.historico_repeticao (
	id serial NOT NULL,
	qtd_repeticao numeric NOT NULL,
	data_repeticao timestamp NOT NULL,
	id_usuario int4 NOT NULL,
	id_exercicio int4 NOT NULL,
	CONSTRAINT historico_repeticao_pk PRIMARY KEY (id)
);

ALTER TABLE public.historico_repeticao ADD CONSTRAINT historico_repeticao_exercicio_fk FOREIGN KEY (id_exercicio) REFERENCES public.exercicio(id);
ALTER TABLE public.historico_repeticao ADD CONSTRAINT historico_repeticao_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);



---------------------------REFACTOR


ALTER TABLE public.execucao_treino RENAME TO execucao_treino_exercicio;
ALTER SEQUENCE public.execucao_treino_id_seq RENAME TO execucao_treino_exercicio_id_seq;
ALTER TABLE public.treino_usuario_divisao_exercicio ADD data_add timestamp without time zone NULL;

