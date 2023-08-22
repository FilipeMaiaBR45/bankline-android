# bankline-android

Aplicativo nativo android utlizando kotlin

App desenvolvido na SantanderDevWeek pela dio.me

App utilizando as mas recentes tecnologias do ecossistema android (Retrofit, LiveData, MVVM, etc.)

## Tabela de Conteúdo

- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Exemplos](#exemplos)

## Instalação

* Para instalar o App faça um clone desse repositorio, abra o projeto no Android Studio, e execute em um emulador ou em um dispositivo android fisico
* Para rodar a API que o aplicativo consuma clone este repostiorio (https://github.com/digitalinnovationone/santander-dev-week-bankline-api) e abra o projeto em alguma IDE para o ecossistema java
  * É necessario que se tenha o PostgreSQL instalado na sua maquina
    * dentro do pgAdmin crie o databse com o nome "banklineapi_db" e certifique-se que o servidor esteja rodando na porta 5432 (se estiver rodadando em outra porta, troque no arquivo application.propretios do projeto SpringBoot)  
  * configure o postgres no arquivo

## Como Usar
* http://localhost:8080/swagger-ui/index.html#/
  *   para visualizar algum dado no aplicativo entre na URL acima e crie um correntista, verique qual é o id do mesmo dentro do banco de dados e com isso crie movimentações passando o id do correntista para o idConta no metodo POST de movimentações

feito isso basta que se insira o id do correntista na tela inicial do app e pressione o botão continue, na tela seguinte será listada todas as movimentações do correntista com o ID passado na tela anterior



## Exemplos


<img src="https://github.com/FilipeMaiaBR45/bankline-android/assets/58606133/c17b589d-4962-4d1a-85f2-4c08a617d9ad" width="250" height="500">

<img src="https://github.com/FilipeMaiaBR45/bankline-android/assets/58606133/cad8b3c9-d0b9-4aef-bd85-c5df04d59070" width="250" height="500">

<img src="https://github.com/FilipeMaiaBR45/bankline-android/assets/58606133/757b42eb-8d7a-4a0e-b071-aa6b593dd86e" width="250" height="500">

