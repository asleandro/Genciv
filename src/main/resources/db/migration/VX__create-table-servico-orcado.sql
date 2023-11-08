create table servico_orcado (
id bigint auto_increment primary key,
servico_id bigint,
valor_material_orcado decimal(10,2),
valor_servico_orcado decimal(10,2),
unidade varchar(5),
quantidade double,
orcamento_id bigint,
foreign key (servico_id) references servicos(id),
foreign key (orcamento_id) references orcamentos(id)

)
