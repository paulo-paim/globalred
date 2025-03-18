CREATE SEQUENCE transacao_sequence
    START WITH 1
    INCREMENT BY 1;

-- Criação da tabela 'transacoes'
CREATE TABLE transacoes (
    id INT PRIMARY KEY DEFAULT nextval('transacao_sequence'),
    cliente VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);