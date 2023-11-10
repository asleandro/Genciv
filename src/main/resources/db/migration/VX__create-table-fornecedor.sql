CREATE TABLE `fornecedores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `telefone` varchar(16) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco_id` bigint DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj` (`cnpj`),
  KEY `FK_enderecoFornecedor` (`endereco_id`),
  CONSTRAINT `FK_enderecoFornecedor` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id`)
) 