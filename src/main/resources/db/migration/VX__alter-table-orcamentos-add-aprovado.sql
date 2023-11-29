use genciv;
alter table orcamentos
add column aprovado boolean;

alter table orcamentos
modify codigo_aprovacao varchar(50);