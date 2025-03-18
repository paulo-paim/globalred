# Projeto Transações GlobalRed

Desafio técnico para a vaga de desenvolvedor na GlobalRed.
O objetivo era o desenvolovimento de um processo ETL para a criação e inserção de dados em uma base de dados. Além disso, de forma opcional, poderia ser criado uma Rest API para exposição e criação de novos recursos da base de dados.

Neste projeto optei por organizar os arquivos em packages baseado na função do arquivo (Model, Controller, Repository, Service), seguindo o padrão MVC.

Caso o projeto inicie com um escopo maior, poderia ser adotada a organização VSA (*vertical Slice Architecture*), na qual cada feature representaria um recorte (ou fatia) do projeto.

Em cada subprojeto deste diretório encontra-se a implementação do código para o cumprimento do desafio.

## Desafios Encontrados
### ETL
- Criação da etapa intemediária do ETL (Transform) devido a manipulação de dados do tipo data.


### API Transações
- Devido a tabela ter sido criada de forma automática pelo JPA, tive dificuldades para o método POST (criação de uma nova transação).
- Devido ao tempo, não foram criadas as rotas para atualização (PUT) e exclusão (DELETE).

## Melhorias que Podem ser feitas
- Alteração do controle do campo identificador da tabela para o banco de dados (criação de uma ```sequence``` ).
- Criação de um ```ENUM``` para armazenar as informações de Status e Categoria das transações, economizando espaço em disco.
