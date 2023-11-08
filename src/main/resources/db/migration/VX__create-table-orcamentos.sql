create table Orcamentos(
id bigint auto_increment primary key,
cliente_id bigint,
obra_orcada VARCHAR(150),
endereco_id bigint,
valor_material_total decimal(10,2),
valor_servico_total decimal(10,2),
prazo_pagamento_material varchar(100),
prazo_pagamento_servico varchar(100),
ativo boolean,
foreign key (cliente_id) references clientes(id),
foreign key (endereco_id) references enderecos(id)

)