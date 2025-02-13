create table produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) NOT NULL,
    preco int NOT NULL,
    numero VARCHAR(20),
    categoria VARCHAR(100) NOT NULL,
    ativo tinyint NOT NULL
)