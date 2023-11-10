CREATE TABLE `enderecos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf_cnpj` varchar(14) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `celular` varchar(14) DEFAULT NULL,
  `endereco_id` bigint DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_cnpj` (`cpf_cnpj`),
  KEY `FK_enderecoCliente` (`endereco_id`),
  CONSTRAINT `FK_enderecoCliente` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id`)
)