ALTER TABLE produto ADD COLUMN fornecedor_id INT NOT NULL;

ALTER TABLE produto ADD CONSTRAINT fk_fornecedor
FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
ON DELETE CASCADE ON UPDATE CASCADE;
