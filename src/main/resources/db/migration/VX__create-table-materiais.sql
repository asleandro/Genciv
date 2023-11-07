create table materiais(
id bigint auto_increment primary key,
nome varchar(255),
tipo varchar(50),
valorCusto double,
valorVenda double,
unidade varchar(4),
qtdEmbalagem double,
fornecedorID bigint,
foreign key (fornecedorID) references fornecedores(id)

)