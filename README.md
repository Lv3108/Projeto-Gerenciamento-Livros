# Projeto gerenciador de livros

### Descrição
API REST desenvolvida com Spring boot com o intuito de gerenciar livros, permitindo cadastrar, consultar, deletar e atualizar.

### Tecnoligias Utilizadas
- Java 21 (ou a versão que você utilizou)
- Spring Boot
- Spring Data JPA
- Hibernate
- Postgres
- Maven
- Swagger

### Funcionalidades
- Cadastrar 
- Atualizar 
- Deletar
- Deletar por ID
- Buscar todos
- Buscar por ID
- Buscar por Disponível
- Buscar por Indisponível
- Atualizar para Disponível

### Estrutura do Projeto
#### Model
Livro -> entidade que representa um livro

#### Repository
LivroRepository -> interface que faz conexão com o banco de dados

#### Service
LivroService -> classe que delimita as regras da API

#### Controller
LivroController -> classe que envia e recebe mensagens HTTP

#### DTO
LivroDTO -> transferi dados entre a aplicação, sem passar pela entidade

#### Swagger
LivroSwagger -> utilizada para documentar, visualizar e testar API REST

### Exceptions
ErrorResponse -> estrutura do erro
BusinessException -> quando regra de negócio é violada
ResourceNotFoundException -> quando o recurso procurado não existe(ID).


### Endpoints
| Método | Endpoint | Descrição |
| :---- | :---- | :---- |
| POST | /livro | Cadastrar livro |
| DELETE | /livro | Deletar todos os livros |
| DELETE | /livro/{id} | Deletar por ID |
| GET | /livro | Buscar todos do livros |
| GET | /livro/{id} | Buscar livro por ID |
| GET | /livro/buscarPorDisponivel | Buscar por todos os livros disponíveis |
| PUT | /livro/{id} | Atualizar livro por ID |
| PATCH | /livro/{id}/disponivel | Marcar livro como disponivel |
| PATCH | /livro/{id}/indisponivel | Marcar livro como indisponivel |






