CREATE TABLE produtos (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	nome VARCHAR NOT NULL,
	descricao VARCHAR NOT NULL,
	preco NUMERIC(10,2) NOT NULL CHECK(preco > 0),
	PRIMARY KEY(id)
)


SELECT * FROM produtos;

INSERT INTO produtos (nome, descricao, preco) 
VALUES ('Livro Java', 'Livro didático Java', 100);

ALTER TABLE produtos ALTER COLUMN nome TYPE VARCHAR(50);

ALTER TABLE produtos 
ADD COLUMN qtd_estoque INT NOT NULL DEFAULT 0 CHECK (qtd_estoque >= 0);

INSERT INTO produtos (nome, descricao, preco)
VALUES ('Livro SQL', 'Livro didático SQL', 120);

UPDATE produtos SET qtd_estoque = 5 WHERE id = 2;

SELECT id as GENERATED_KEY FROM produtos;

DELETE FROM produtos WHERE id > 2 AND nome = 'Livro SQL';
