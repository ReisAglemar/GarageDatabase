# GarageDatabase

**GarageDatabase** é um projeto para gerenciar **fabricantes** e **veículos**, com funcionalidades de **CRUD** para interação com o banco de dados **PostgreSQL**. Além disso, o projeto integra a **API Google Gemini** para fornecer informações adicionais sobre fabricantes e carros.

---

## 🛠️ Tecnologias Utilizadas
- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para facilitar o desenvolvimento.
- **Lombok**: Para reduzir a escrita de código boilerplate.
- **JPA**: Persistência de dados.
- **Hibernate**: Mapeamento ORM.
- **PostgreSQL**: Banco de dados relacional.
- **Google Gemini API**: Para enriquecer os dados com informações externas.

---

## 🎯 Funcionalidades
1. **CRUD de Fabricantes**:
   - Inserir, atualizar, consultar e excluir dados de fabricantes.
2. **CRUD de Veículos**:
   - Gerenciar informações de veículos no banco de dados.
3. **Integração com a API Google Gemini**:
   - Obter informações adicionais sobre veículos e fabricantes de forma automatizada.

---

## 🚀 Como Executar o Projeto
### Pré-requisitos:
- Java 17+
- Maven instalado
- Banco de dados PostgreSQL configurado
- Credenciais da API Google Gemini

### Passos:
1 - Clone o repositório:
   
    git clone https://github.com/ReisAglemar/garage-database.git
    cd garageDatabase


2- Configure o arquivo application.properties com as credenciais do PostgreSQL e da API Google Gemini:

    spring.datasource.url=jdbc:postgresql://localhost:5432/garage_db
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    google.gemini.api.key=sua-chave-da-api

Execute o projeto:

    mvn spring-boot:run

🛠️ Estrutura do Projeto

GarageDatabase é um sistema orientado a objetos, projetado para modularidade e fácil manutenção.

Pacotes principais:

    model: Classes de entidade para fabricantes e veículos.
    repository: Repositórios JPA para persistência de dados.
    service: Regras de negócio e integração com a API Google Gemini.
    controller: Endpoints REST para as operações de CRUD.
    config: Configurações do Spring Boot.

🔗 API Endpoints

Fabricantes

    POST /api/manufacturers: Cadastrar fabricante.
    GET /api/manufacturers/{id}: Consultar fabricante pelo ID.
    PUT /api/manufacturers/{id}: Atualizar fabricante.
    DELETE /api/manufacturers/{id}: Remover fabricante.

Veículos

    POST /api/vehicles: Cadastrar veículo.
    GET /api/vehicles/{id}: Consultar veículo pelo ID.
    PUT /api/vehicles/{id}: Atualizar veículo.
    DELETE /api/vehicles/{id}: Remover veículo.

📜 Licença

Este projeto é livre para uso, modificação e distribuição.

🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

📞 Contato

Caso tenha dúvidas ou sugestões, entre em contato:

    E-mail: aglemar.reis@gmail.com
    
