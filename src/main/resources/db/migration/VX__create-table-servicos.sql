CREATE TABLE `servicos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `valor_instalacao_por_und` decimal(10,2) NOT NULL,
  `valor_material_por_und` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) 