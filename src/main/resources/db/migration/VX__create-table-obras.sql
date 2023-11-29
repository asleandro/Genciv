CREATE TABLE obras (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    orcamento_id BIGINT,
    FOREIGN KEY (orcamento_id) REFERENCES orcamentos(id)
);

create table servicos_executados (
	id bigint primary key auto_increment,
	servico_orcado_id bigint,
	obra_id bigint,
	quantidade double,
	foreign key (servico_orcado_id) references servicos_orcado(id),
	foreign key (obra_id) references obras(id)
);

CREATE TABLE materiais_utilizados (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    servico_orcado_id BIGINT,
    obra_id BIGINT,
    quantidade DOUBLE,
    -- Outros campos necessários,
    FOREIGN KEY (servico_orcado_id) REFERENCES servicos_orcados(id),
    FOREIGN KEY (obra_id) REFERENCES obras(id)
);