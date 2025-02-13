create table fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    numero VARCHAR(20),
    categoria VARCHAR(100) NOT NULL,
    ativo tinyint NOT NULL
)