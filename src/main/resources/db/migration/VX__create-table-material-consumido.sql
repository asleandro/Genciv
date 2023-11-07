CREATE TABLE servicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    valor_instalacao_por_und DOUBLE NOT NULL,
    valor_material_por_und DOUBLE NOT NULL
);

CREATE TABLE material_consumido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantidade_consumida DOUBLE NOT NULL,
    material_id BIGINT NOT NULL,
    servico_id BIGINT NOT NULL,
    FOREIGN KEY (material_id) REFERENCES materiais(id),
    FOREIGN KEY (servico_id) REFERENCES servicos(id)
);


