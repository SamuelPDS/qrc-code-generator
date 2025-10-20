Seu novo `README.md` para o projeto Shortenet URL, seguindo o modelo do OrderHub, ficaria assim:

---

# QRCode Generator

QRCode Generator é um sistema criado para gerar códigos QR a partir de URLs, desenvolvido com Spring Boot, persistência em PostgreSQL, mapeamento com MapStruct e arquitetura REST.

## 🚀 Funcionalidades
### Core Features

✅ Gerador de QR Codes: API REST para criar códigos QR a partir de URLs;
✅ Armazenamento: URLs são armazenadas em serviços da AWS S3, garantindo alta disponibilidade;

### Recursos Técnicos

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

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- MapStruct
- Lombok
- PostgreSQL
- Maven
