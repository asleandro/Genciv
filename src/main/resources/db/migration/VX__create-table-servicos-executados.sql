CREATE TABLE servicos_executados (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    servico_orcado_id BIGINT,
    obra_id BIGINT,
    quantidade DOUBLE,
    FOREIGN KEY (servico_orcado_id) REFERENCES servicos_orcados(id),
    FOREIGN KEY (obra_id) REFERENCES obras(id)
);
