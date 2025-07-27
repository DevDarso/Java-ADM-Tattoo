DROP DATABASE adm_tattoo;
CREATE DATABASE IF NOT EXISTS adm_tattoo;
USE adm_tattoo;

CREATE TABLE cadastro (
id INT NOT NULL AUTO_INCREMENT,
status VARCHAR(11) NOT NULL,
nome VARCHAR(50) NOT NULL,
cpf VARCHAR(14) NOT NULL,
cnpj VARCHAR(18) NOT NULL,
data VARCHAR(10) NOT NULL,
tel VARCHAR(14),
cep VARCHAR(9),
rua VARCHAR(30),
numero VARCHAR(10),
bairro VARCHAR(30),
local VARCHAR(16),
cidade VARCHAR(30),
email VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE agenda (
    idAgenda INT NOT NULL AUTO_INCREMENT,
    idCliente INT NOT NULL,
    data DATE NOT NULL,
    hora VARCHAR(5) NOT NULL,
    sinal DOUBLE,
    status VARCHAR(10),
    permiteColaborador BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idAgenda),
    FOREIGN KEY (idCliente) REFERENCES cadastro(id) ON DELETE CASCADE
);

CREATE TABLE agenda_participantes (
    id INT NOT NULL AUTO_INCREMENT,
    idAgenda INT NOT NULL,
    idProfissional INT NOT NULL,
    papel ENUM('Principal', 'Colaborador') NOT NULL DEFAULT 'Colaborador',
    tipoServico VARCHAR(40),
    PRIMARY KEY (id),
    FOREIGN KEY (idAgenda) REFERENCES agenda(idAgenda) ON DELETE CASCADE,
    FOREIGN KEY (idProfissional) REFERENCES cadastro(id) ON DELETE CASCADE
);

 CREATE TABLE adicional (
 id INT NOT NULL AUTO_INCREMENT,
 idAgenda INT,
 sessao INT,
 duracao VARCHAR(5),
 nota VARCHAR(255),
 observacao VARCHAR(255),
 PRIMARY KEY (id),
 FOREIGN KEY (idAgenda) REFERENCES agenda(idAgenda) ON DELETE CASCADE
 );
 
CREATE TABLE comissao (
    id INT NOT NULL AUTO_INCREMENT,
    idAgenda INT NOT NULL,
    idProfissional INT NOT NULL,
    valor DOUBLE,
    porcentagem INT,
    total DOUBLE,
    PRIMARY KEY (id),
    FOREIGN KEY (idAgenda) REFERENCES agenda(idAgenda) ON DELETE CASCADE,
    FOREIGN KEY (idProfissional) REFERENCES cadastro(id) ON DELETE CASCADE
);

 CREATE TABLE servico (
 idServico INT NOT NULL AUTO_INCREMENT,
 nomeServico VARCHAR(50) NOT NULL,
 valor DOUBLE,
 PRIMARY KEY (idServico)
 );
 
INSERT INTO servico (nomeServico) VALUES 
('Retoque tattoo'),
('Tattoo'),
('Tattoo + Piercing(jóia)'),
('Tattoo + Piercing(jóia) + Perfuração'),
('Piercing(jóia)'),
('Perfuração'),
('Perfuração+Piercing(jóia)'),
('Manutenção piercing'),
('Outros...');

CREATE TABLE formulario (
id INT NOT NULL AUTO_INCREMENT,
idCliente INT NOT NULL,
titulo VARCHAR(50),
cabecalho TEXT,
questionario TEXT,
empresa VARCHAR(50),
cidade VARCHAR(50),
rodape VARCHAR(255),
FOREIGN KEY (idCliente) REFERENCES cadastro(id) ON DELETE CASCADE,
PRIMARY KEY (id)
);

CREATE TABLE funcionario (
id INT NOT NULL AUTO_INCREMENT,
idFuncionario INT NOT NULL,
cargo VARCHAR(20),
data_entrada DATE,
status BOOLEAN,
data_saida DATE,
senha VARCHAR(70),
FOREIGN KEY (idFuncionario) REFERENCES cadastro (id) ON DELETE CASCADE,
PRIMARY KEY (id)
);

INSERT INTO cadastro (status,nome,cpf,cnpj,data,tel,cep,rua,numero,bairro,local,cidade,email) VALUES
('Funcionário','Algum nome','111.222.333-44','','1990-01-01','(51)55555-5555','55555-555','Alguma rua','00','Algum bairro','Casa','Alguma cidade','Algum e-mail'),
('Funcionário','Outro nome','111.222.333-44','','1990-01-01','(51)55555-5555','55555-555','Alguma rua','00','Algum bairro','Casa','Alguma cidade','Algum e-mail'),
('Cliente','Algum cliente','111.222.333-44','','1990-01-01','(51)55555-5555','55555-555','Alguma rua','00','Algum bairro','Casa','Alguma cidade','Algum e-mail'),
('Cliente','Outro cliente','111.222.333-44','','1990-01-01','(51)55555-5555','55555-555','Alguma rua','00','Algum bairro','Casa','Alguma cidade','Outro e-mail');

INSERT INTO funcionario (idFuncionario,cargo,data_entrada,status,data_saida,senha) VALUES
(1,'Gerente','2025-01-01',1,null,'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM='), /* Senha 123 libera todas as funções de gerente */
(2,'Algum cargo','2025-01-01',1,null,'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM='); /*Senha 123 bloqueia funções de funcionario */

INSERT INTO agenda (idCliente,data,hora,sinal,status,permiteColaborador) VALUES
(3,'2024-06-12','00:15',0,'Atendido',0),
(3,'2024-06-11','00:15',0,'Atendido',1),
(3,'2024-06-10','00:30',0,'Atendido',0),
(4,'2025-12-09','00:15',0,'Agendado',0),
(3,'2024-06-08','00:15',0,'Atendido',1),
(4,'2025-11-07','00:30',0,'Agendado',0),
(3,'2024-06-06','00:15',0,'Atendido',0),
(4,'2024-06-05','00:15',0,'Atendido',1),
(3,'2025-10-04','00:30',0,'Agendado',0),
(3,'2024-06-03','00:15',0,'Atendido',0),
(4,'2024-06-02','00:15',0,'Atendido',1),
(3,'2025-09-01','00:30',0,'Agendado',0),
(3,'2024-01-12','00:15',0,'Atendido',0),
(4,'2024-01-11','00:15',0,'Atendido',1),
(3,'2024-01-10','00:30',0,'Atendido',0),
(4,'2024-01-09','00:15',0,'Atendido',0),
(3,'2025-09-08','00:15',0,'Agendado',1),
(3,'2024-01-07','00:30',0,'Atendido',0),
(4,'2024-01-06','00:15',0,'Atendido',0),
(3,'2025-09-05','00:15',0,'Agendado',1),
(4,'2024-01-04','00:30',0,'Atendido',0),
(3,'2025-08-03','00:15',0,'Agendado',0),
(4,'2024-01-02','00:15',0,'Atendido',1),
(3,'2025-08-01','00:30',0,'Agendado',0);

INSERT INTO comissao (idAgenda,idProfissional,valor,porcentagem,total) VALUES
(1,2,250,100,250),
(2,2,300,100,300),
(3,1,400,100,400),
(4,1,500,100,500),
(5,2,1000,50,500),
(6,2,1800,50,900),
(7,2,500,50,250),
(8,1,200,100,200),
(9,2,400,100,400),
(10,2,300,100,300),
(11,1,1800,50,900),
(12,1,400,100,400),
(13,1,300,100,300),
(14,1,200,100,200),
(15,1,300,100,300),
(16,1,200,100,200),
(17,2,200,100,200),
(18,2,300,100,300),
(19,2,250,100,250),
(20,2,200,100,200),
(21,2,300,100,300),
(22,2,250,100,250),
(23,2,250,100,250),
(24,2,300,100,300);

INSERT INTO agenda_participantes (idAgenda,idProfissional,papel,tipoServico) VALUES
(1,2,'Principal','Tattoo'),
(2,2,'Principal','Piercing'),
(3,1,'Principal','Outros'),
(4,1,'Principal','Tattoo'),
(5,2,'Principal','Tattoo'),
(6,2,'Principal','Piercing'),
(7,2,'Principal','Tattoo'),
(8,1,'Principal','Tattoo'),
(9,2,'Principal','Piercing'),
(10,2,'Principal','Tattoo'),
(11,1,'Principal','Piercing'),
(12,1,'Principal','Piercing'),
(13,1,'Principal','Tattoo'),
(14,1,'Principal','Piercing'),
(15,1,'Principal','Piercing'),
(16,1,'Principal','Tattoo'),
(17,2,'Principal','Piercing'),
(18,2,'Principal','Piercing'),
(19,2,'Principal','Tattoo'),
(20,2,'Principal','Piercing'),
(21,2,'Principal','Piercing'),
(22,2,'Principal','Tattoo'),
(23,2,'Principal','Piercing'),
(24,2,'Principal','Tattoo');
