Seu novo `README.md` para o projeto Shortenet URL, seguindo o modelo do OrderHub, ficaria assim:

---

# QRCode Generator

QRCode Generator é um sistema criado para gerar códigos QR a partir de URLs, desenvolvido com Spring Boot, persistência em PostgreSQL, mapeamento com MapStruct e arquitetura REST.

## 🚀 Funcionalidades
### Core Features

✅ Gerador de QR Codes: API REST para criar códigos QR a partir de URLs;
✅ Armazenamento: URLs são armazenadas em serviços da AWS S3, garantindo alta disponibilidade;

### Recursos Técnicos

📊 Monitoramento: Spring Boot Actuator para métricas e health checks  
🗄️ Persistência: Armazenamento em AWS S3
 Geração de QR Codes: Biblioteca ZXing para criação de códigos QR
🛠️ Redução de boilerplate: Lombok  
⚡ APIs REST: Controllers para operações CRUD

## 🏗️ Arquitetura

### Estrutura do Projeto

`src/main/java/com/samuel/qrcode.generator.api/`  
├── infra/          \# configurações AWS S3 por meio de adapters
├── controller/      \# Controllers REST    
├── DTO/ \# DTOs 
├── ports/      \# interface principal para upload e download de arquivos
├── service/         \# Lógica de negócio  
└── ShortenetUrlApplication.java

### Fluxo de Encurtamento

1. Criação: Usuário envia URL original via API REST
2. Geração: Sistema gera URL encurtada e salva no banco
3. Redirecionamento: Acesso à URL curta redireciona para a original
4. Expiração: URLs podem expirar conforme configuração
5. Consulta: Endpoints para listar e consultar URLs

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- MapStruct
- Lombok
- PostgreSQL
- Maven

## 🚦 Endpoints

### APIs Públicas

- **Criar URL encurtada**  
  `POST /urls`  
  Content-Type: application/json

- **Redirecionar para URL original**  
  `GET /{shortenedUrl}`

### APIs Administrativas

- **Listar URLs**  
  `GET /admin/urls`

- **Consultar detalhes da URL**  
  `GET /admin/urls/{id}`

- **Remover URL**  
  `DELETE /admin/urls/{id}`

## 📋 Configuração

### Banco de Dados

No arquivo `application.yml`:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/authservice
    username: root
    password: root
```

## 🚀 Execução

### Desenvolvimento

```shell
# Clonar repositório
git clone https://github.com/SamuelPDS/url-shortener.git
cd shortenet-url

# Executar com Maven
./mvnw spring-boot:run
```

## 📊 Monitoramento

- **Health Check**  
  `GET /actuator/health`

- **Métricas**  
  `GET /actuator/metrics`

## 🧪 Testes - a ser implementado

```shell
# Executar todos os testes 
./mvnw test
```

## 📝 Exemplo de Uso

**Criar URL encurtada**

```shell
curl -X POST http://localhost:8080/urls \
-H "Content-Type: application/json" \
-d '{"originalUrl": "https://www.exemplo.com"}'
```

**Redirecionar**

```shell
curl -L http://localhost:8080/abc123
```
