Este é um trabalho sobre o tema Circuit-Breaker ou "Disjuntor" da Unidade Curricular Padrões de Projetos de Software no IFSC Gaspar


---

```markdown
# ⚡ Circuit Breaker com Spring Boot

Este projeto demonstra uma implementação do padrão **Circuit Breaker** usando **Java**, **Spring Boot**, **Resilience4j**, e é executado dentro de um contêiner **Docker**. Ideal para simular comportamento resiliente em microsserviços, com suporte a testes via **Postman**.

---

## 📌 Sobre o Projeto

O padrão **Circuit Breaker** é usado para prevenir que falhas em serviços externos afetem o sistema principal, proporcionando maior **resiliência** e **tolerância a falhas**.

Este projeto inclui:

- API REST simples com endpoints protegidos por circuit breaker
- Integração com Resilience4j
- Containerização com Docker
- Testes de chamadas com Postman

---

## 🚀 Tecnologias Usadas

- Java 17+
- Spring Boot 3.x
- Spring Web
- Resilience4j
- Maven
- Docker
- Postman

---

## 🗂️ Estrutura do Projeto

```

circuit-breaker-springboot/
├── src/
│   └── main/
│       └── java/com/example/circuitbreaker/
│           ├── controller/MedicoController.java
│           ├── model/Medico.java
│           ├── repository/MedicoRepository.java
│           ├── service/MedicoService.java
│           ├── CircuitBreakerApplication.java
├── docker/
│   └── Dockerfile
├── postman/
│   └── CircuitBreaker.postman\_collection.json
├── pom.xml
└── README.md

````

---

## ⚙️ Como Rodar o Projeto

### 🔧 Pré-requisitos

- Java 17+
- Spring Boot
- Maven
- Docker

### ✅ Executando localmente

```bash
# Clone o repositório
git clone https://github.com/abdieldeathayde/Circuit-Breaker
cd Circuit-Breaker

# Build do projeto
./mvnw clean package

# Rodar aplicação
java -jar target/circuit-breaker-0.0.1-SNAPSHOT.jar
````

### 🐳 Rodando com Docker

```bash
# Build da imagem
docker build -t circuit-breaker-app .

# Executar container
docker run -p 8080:8080 circuit-breaker-app
```

---

## 🧪 Testando com Postman

A pasta `/postman` contém uma coleção pronta para testar os endpoints do projeto.

### Como usar:

1. Abra o **Postman**
2. Teste o endpoint:
   `GET http://localhost:8080/crm`


```


## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

Feito por [@abdieldeathayde](https://github.com/abdieldeathayde)


