
# ETL Transações

Neste projeto, o intuito foi realizar o desenvolvimento de um processo ETL(Tranform, Process and Load). O sistema realiza a leitura de um arquivo CSV armazenado na unidade C: da máquina e realiza a inserção em uma base de dados relacional, neste caso, optei por um banco de dados Postgres.

## Etapas 
### 1. Extract
Nesta primeira etapa, é realizado a leitura de um arquivo CSV. O arquivo de leitura deve ficar armazenado na unidade C: do disco e o arquivo precisa ser nomeado como ```transacoes_input.csv```.

O arquivo CSV possuia seguinte estrutura de dados ``` id,cliente,valor,data_transacao,categoria,status ``` e o delimitador é o caractere ```,```.

### 2. Transform
Nesta etapa o processo realiza a transformação dos dados antes de inserir na base de dados.
As transformações realizadas são:

- Remoção de acentos e substituição de caracteres especiais (substituição do caractere ```ç``` por ```c```). Processo aplicado no nome do cliente, categoria e status.
- Transformação para letras maiúsculas. Aplicado no cliente, categoria e status.

### 3. Load
Inserção dos dados na tabela do banco de dados

## Tecnologias Utilizadas
- Java 23
- Spring Boot 
- Spring Batch
- Spring JPA
- PostgreSQL Driver
- IntelliJ IDE

 ## Rodando o projeto
 Para executar o projeto é necessário clonar o repositório para a maquina local. O projeto foi desenvolvido utilizando o IntelliJ IDE e executado na própria IDE. 

 ### Configurações necessárias
 Para rodar o projeto, crie um banco de dados Postgres chamado ```transacao```. Este banco será acessado pela aplicação no seguinte endereço: ``` http://localhost:5432/transacao ```.

 A criação da tabela será feita pelo próprio Spring por meio do JPA.

 Também é necessário inserir o arquivo ``` transacoes_input.csv ``` no seguinte caminho da máquina local ```C:/transacoes_input.csv```
