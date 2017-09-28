-- Table: public.mouton

-- DROP TABLE public.mouton;

CREATE TABLE public.mouton
(
    id_mouton integer NOT NULL,
    nom text COLLATE pg_catalog."default",
    naissance date,
    sexe character(1) COLLATE pg_catalog."default",
    couleur character(1) COLLATE pg_catalog."default",
    sousespece text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    id_troupeau integer,
    CONSTRAINT mouton_pkey PRIMARY KEY (id_mouton)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.mouton
    OWNER to postgres;
	
-- Table: public.troupeau

-- DROP TABLE public.troupeau;

CREATE TABLE public.troupeau
(
    id_troupeau integer NOT NULL,
    nom text COLLATE pg_catalog."default",
    ecurie text COLLATE pg_catalog."default",
    CONSTRAINT troupeau_pkey PRIMARY KEY (id_troupeau)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.troupeau
    OWNER to postgres;