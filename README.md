# Sistema de Consulta Nutricional - TACO

Este projeto é uma aplicação web desenvolvida para consultar informações nutricionais de alimentos com base na **Tabela Brasileira de Composição de Alimentos (TACO)**. A aplicação oferece uma interface amigável para os usuários e uma API robusta para acessar os dados.

## Objetivo do Projeto

Este sistema foi desenvolvido como parte do **Projeto Integrador II** da UNIFAGOC. O objetivo foi criar uma aplicação completa com backend e frontend utilizando boas práticas de desenvolvimento e arquitetura hexagonal.

## Tecnologias Utilizadas

### Backend
- **Kotlin**
- **Spring Boot**
  - Spring Security
  - Spring Web Services
- **PostgreSQL**

### Frontend
- **React.js**
- **JavaScript**
- **HTML**
- **CSS**

## Arquitetura do Projeto

O sistema foi desenvolvido seguindo a **Arquitetura Hexagonal**, também conhecida como Ports and Adapters. Essa abordagem permite maior flexibilidade e desacoplamento entre as camadas do sistema, facilitando testes e manutenção.

### Estrutura do Backend
- **Domain**: Contém as entidades e as regras de negócio principais.
- **Application**: Responsável por coordenar os casos de uso do sistema.
- **Adapters**:
  - **Entrada**: Camada REST com endpoints expostos, desenvolvida com Spring Boot.
  - **Saída**: Comunicação com o banco de dados PostgreSQL e outros serviços externos.

### Benefícios da Arquitetura Hexagonal
- Separação clara entre lógica de negócios, infraestrutura e interfaces.
- Facilidade para substituir tecnologias ou implementar novas integrações.
- Foco na lógica central do sistema.

## Funcionalidades do Sistema

- **Consulta de alimentos**: Pesquise informações nutricionais de alimentos presentes na Tabela Brasileira de Composição de Alimentos (TACO).
- **Exibição detalhada**: Visualize os dados nutricionais completos de um alimento, como calorias, proteínas, carboidratos, gorduras, entre outros.
- **Autenticação segura**: Acesso protegido por autenticação e autorização utilizando Spring Security.
- **Responsividade**: Interface otimizada para diversos dispositivos.
- **API RESTful**: Backend fornece uma API estruturada e documentada para acesso aos dados.


## Passo a Passo: Configuração do Backend

### 1. Clonar o Repositório
Primeiramente, clone o repositório do projeto para sua máquina local

### 2. Configurar o Banco de Dados PostgreSQL
O banco de dados PostgreSQL já está incluído no repositório. Siga os passos abaixo para restaurá-lo:

#### 2.1 Restaurar o Banco de Dados
Abra o PostgreSQL e crie um novo banco de dados chamado taco e faça o restore do banco de dados no Postgres.
#### 2.2 Atualizar as Credenciais do Banco de Dados
No repositório clonado, localize o arquivo src/main/resources/application.yml.
Abra o arquivo e atualize as configurações de conexão com o banco de dados para corresponder ao seu PostgreSQL:
```yml
  spring:
  datasource:
    name: taco
    url: jdbc:postgresql://localhost:5432/taco
    username: <seu-usuario>
    password: <sua-senha>
    driver-class-name: org.postgresql.Driver
```
#### 3. Ajustar Dependências com Gradle
* Abra o projeto no seu IDE (como IntelliJ IDEA ou VS Code).
* Se estiver utilizando IntelliJ IDEA, após abrir o projeto, execute o seguinte:
* Vá até View > Tool Windows > Gradle.
* Clique com o botão direito sobre o nome do projeto no painel Gradle e selecione Reload All Gradle Projects.

Após o reload, a IDE irá baixar e configurar todas as dependências necessárias.

#### 4. Testando a API com Postman

A aplicação fornece uma **API RESTful** para consulta das informações nutricionais de alimentos. Para facilitar o teste das rotas, você pode usar o **Postman**, uma ferramenta popular para testar APIs. 

##### Acessando as Rotas da API

1. **Link para o Postman**: 
   Para visualizar e testar as rotas da API, você pode acessar a documentação no Postman através do link abaixo:  
[Documentação da API no Postman](https://solar-moon-739512.postman.co/workspace/McLovers~afc03bfc-20b6-45eb-81e5-6ab4563e366e/overview)

2. **Endpoints principais**:
   A seguir estão os principais endpoints que você pode testar no Postman:

   - **GET /api/alimentos**: Retorna a lista de alimentos disponíveis na TACO.
     - **Parâmetros**: Nenhum
     - **Resposta**: Lista de alimentos com informações nutricionais.

   - **GET /api/alimentos/{id}**: Retorna as informações nutricionais de um alimento específico pelo ID.
     - **Parâmetros**:
       - `id`: ID do alimento (exemplo: 1)
     - **Resposta**: Dados nutricionais detalhados do alimento.

   - **POST /api/alimentos**: Adiciona um novo alimento à base de dados.
     - **Corpo da requisição**:
       ```json
       {  "categoria": "Cereais e derivados",  "numeroalimento": "1",        "descricaoalimento": "Arroz, integral, cozido",        "carboidrato": "25,80",        "energiakcal": "123,534",        "energiakj": "516,86",        "proteina": "2,58",        "lipideos": "1,00",        "colesterol": "NA",        "fibraalimentar": "2,74",        "calcio": "5,20",        "magnesio": "58,70",        "fosforo": "105,85",        "ferro": "0,26",        "sodio": "1,24",        "potassio": "75,15",        "cobre": "0,02",        "zinco": "0,68",        "vitaminac": ""    }
       ```
     - **Resposta**: Confirmação de que o alimento foi adicionado.

   - **PUT /api/alimentos/{id}**: Atualiza as informações de um alimento específico.
     - **Parâmetros**:
       - `id`: ID do alimento a ser atualizado.
     - **Corpo da requisição**:
       ```json
       
         {  "categoria": "Cereais e derivados",  "numeroalimento": "1",        "descricaoalimento": "Arroz, integral, cozido",        "carboidrato": "25,80",        "energiakcal": "123,534",        "energiakj": "516,86",        "proteina": "2,58",        "lipideos": "1,00",        "colesterol": "NA",        "fibraalimentar": "2,74",        "calcio": "5,20",        "magnesio": "58,70",        "fosforo": "105,85",        "ferro": "0,26",        "sodio": "1,24",        "potassio": "75,15",        "cobre": "0,02",        "zinco": "0,68",        "vitaminac": ""    }
       
       ```
     - **Resposta**: Confirmação da atualização do alimento.

   - **DELETE /api/alimentos/{id}**: Deleta um alimento específico.
     - **Parâmetros**:
       - `id`: ID do alimento a ser deletado.
     - **Resposta**: Confirmação da remoção do alimento.

3. Autenticação

  - A API utiliza **Spring Security** para autenticação. Para testar os endpoints protegidos, você precisará incluir um token JWT (ou outro método de autenticação) nas requisições.

  - **Exemplo de Header de Autenticação**:
  ```bash
  Authorization: Bearer <seu-token-jwt-aqui>
  ```

## Considerações Finais

Este projeto foi uma excelente oportunidade para aplicar os conhecimentos adquiridos durante o curso de **Ciência da Computação** na **UNIFAGOC**. A escolha da **Arquitetura Hexagonal** e das tecnologias utilizadas foi crucial para garantir a escalabilidade e a facilidade de manutenção do sistema.

A aplicação fornece um serviço útil para consulta de informações nutricionais, utilizando dados da **Tabela Brasileira de Composição de Alimentos (TACO)**, e foi construída com foco em boas práticas de desenvolvimento e segurança.

Agradecemos a todos os membros do grupo pela dedicação e trabalho em equipe!

---

**Integrantes do Projeto:**
- Caio (Banner)
- Kaio (Desenvolvedor Backend)
- Savio (Desenvolvedor Frontend)
- Luís, Joao Pedro e Juan (Relatório)


