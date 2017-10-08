-- Table: public.employee

-- DROP TABLE public.employee;

CREATE TABLE public.employee
(
    type character varying(31) COLLATE pg_catalog."default" NOT NULL,
    employeeid bigint NOT NULL DEFAULT nextval('employee_employeeid_seq'::regclass),
    city character varying(255) COLLATE pg_catalog."default",
    postalcode character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    streetno character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    mobilephone character varying(255) COLLATE pg_catalog."default",
    dateofbirth date,
    enddate date,
    startdate date,
    firstname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    hourlywage integer,
    salary integer,
    CONSTRAINT employee_pkey PRIMARY KEY (employeeid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to jboss;