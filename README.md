# Selenium Saucedemo Portfólio

Projeto de automação de testes E2E da aplicação [SauceDemo](https://www.saucedemo.com/), desenvolvido como portfólio de automação com foco em **qualidade, organização e escalabilidade**.

## Sobre o projeto

O framework está sendo construído de forma incremental utilizando **Java, Selenium WebDriver, JUnit 6 e Maven**, aplicando conceitos de **POO, Page Object Model (POM) e separação de responsabilidades**.

O projeto conta com:

- Page Objects para representar páginas e comportamentos da aplicação.
- **BasePage** para centralizar ações comuns e **Explicit Wait**.
- **DriverFactory** com suporte a Chrome, Edge e Firefox.
- Configuração externa de URL, browser, headless e timeout.
- Dados de teste separados por contexto (`LoginData`, `ProductData` e `CheckoutData`).
- Testes parametrizados com JUnit.
- Tags e Maven Profiles para execução de **Smoke** e **Regression**.
- Captura automática de screenshots em falhas.
- Relatórios com **Allure**.
- **GitHub Actions** com execução cross-browser em Chrome, Edge e Firefox.
- Pipeline de **Smoke em Pull Requests** e **Regression na branch main ou manualmente**.
- Geração e publicação do relatório Allure pelo pipeline de CI.

## CI/CD

O pipeline utiliza Maven Profiles e propriedades de execução para controlar a suíte e o navegador:

```text
Pull Request
    ↓
Smoke Tests
    ├── Chrome
    ├── Edge
    └── Firefox

Push na main / execução manual
    ↓
Regression Tests
    ├── Chrome
    ├── Edge
    └── Firefox
    ↓
Allure Report
    ↓
GitHub Pages
```

## 📊 Allure Report

O relatório mais recente da suíte de Regression é publicado automaticamente pelo pipeline no GitHub Pages:

[🔎 Visualizar Allure Report](https://lspenserl.github.io/Selenium_Saucedemo_Portfolio/)

## Como executar os testes

### Pré-requisitos

- Java 26
- Maven
- Chrome, Edge ou Firefox

### Executar todos os testes

Na raiz do projeto:

```bash
mvn clean test
```

### Executar apenas Smoke Tests

```bash
mvn clean test -Psmoke
```

### Executar apenas Regression Tests

```bash
mvn clean test -Pregression
```

### Executar em um navegador específico

O navegador pode ser informado pela propriedade `browser`:

```bash
mvn clean test -Psmoke -Dbrowser=chrome
mvn clean test -Psmoke -Dbrowser=edge
mvn clean test -Psmoke -Dbrowser=firefox
```

### Executar em modo Headless

Para executar sem abrir a janela do navegador:

```bash
mvn clean test -Pregression -Dbrowser=chrome -Dheadless=true
```

### Alterar o timeout

O timeout padrão é definido em `config.properties` e pode ser sobrescrito por linha de comando:

```bash
mvn clean test -Dbrowser=chrome -Dwait.timeout=20
```

### Gerar e visualizar o relatório Allure localmente

Após executar os testes:

```bash
allure generate target/allure-results -o target/allure-report
allure open target/allure-report
```

Os screenshots capturados em caso de falha ficam disponíveis em:

```text
target/screenshots/
```

## Estrutura

```text
src
├── main
│   ├── java
│   │   ├── core
│   │   └── pages
│   └── resources
└── test
    ├── java
    │   ├── base
    │   ├── data
    │   ├── extensions
    │   └── tests
    └── resources
```

## Tecnologias

**Java · Selenium WebDriver · JUnit 6 · Maven · Allure · GitHub Actions**

O projeto continua em evolução com novas automações, melhorias de arquitetura e práticas de CI/CD.