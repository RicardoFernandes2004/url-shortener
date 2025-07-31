# 🔗 URL Shortener

Projeto full-stack de encurtador de URLs, com back-end em Java + Spring Boot, banco MongoDB e front-end simples em HTML/JS hospedado no Netlify. Idealizado e desenvolvido para prática de desenvolvimento, deploy em nuvem e integração de APIs REST.

## 🚀 Tecnologias Utilizadas

### Back-End
- Java 21 (Amazon Corretto)
- Spring Boot
- MongoDB Atlas
- Bucket4j (Rate Limiting)
- Docker (para deploy)
- Render (Hospedagem)

### Front-End
- HTML / CSS / JS
- Netlify (Deploy)

## 🌐 Como funciona

- O usuário envia uma URL longa para o endpoint `/api/urls/posturl`
- A API gera um código curto único e armazena no banco
- Ao acessar `/[id]`, o usuário é redirecionado para a URL original
- Há limitação de requisições por IP usando Bucket4j

## 📦 Endpoints principais

```http
POST /api/urls/posturl
Body: {
  "url": "https://exemplo.com"
}
```

```http
GET /{id}
```
Redireciona para a URL original encurtada.

---

## ⚙️ Rodando localmente

### Pré-requisitos:
- Java 21 (Amazon Corretto)
- Maven 3.9+
- Conta no [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)

### Passos:

1. **Clone o repositório**  
```bash
git clone https://github.com/seuusuario/seurepo.git
cd seurepo
```

2. **Configure o `application.properties`**  
Crie o arquivo `src/main/resources/application.properties` com:

```properties
spring.data.mongodb.uri=mongodb+srv://<USUARIO>:<SENHA>@<CLUSTER>.mongodb.net/?retryWrites=true&w=majority
spring.data.mongodb.database=nome-do-banco
```

Ou, se preferir variáveis de ambiente:

```properties
spring.data.mongodb.uri=${DB_URI}
spring.data.mongodb.database=${DB_NAME}
```

3. **Execute o projeto localmente**  
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 🖥️ Front-End

O front-end foi feito em HTML, CSS e JavaScript puro e está hospedado no Netlify. Ele permite que o usuário:
- Digite uma URL e gere uma versão encurtada
- Copie a URL encurtada com um clique
- Veja o link encurtado em formato amigável
- Interface simples e funcional

Caso queira usar um front diferente, mude a configuração do CORS.

---

## 🧠 Aprendizados

- Integração do Spring Boot com MongoDB Atlas
- Criação e consumo de APIs REST com redirecionamento HTTP
- Deploy com Docker e Render
- Implementação de filtros no Spring (Rate Limiting com Bucket4j)
- Deploy front-end via Netlify
- Boas práticas de estrutura de projeto full-stack

---

## 📎 Extras

- Limite de 20 requisições por minuto por IP para evitar abuso
- Link gerado possui formato compacto (ex: `https://url-shortener-ysr1.onrender.com/abc123`)
- Layout limpo com botão para copiar link e autoria visível via GitHub

---

## 🙋‍♂️ Autor

Desenvolvido por [Ricardo Fernandes](https://github.com/RicardoFernandes2004)
