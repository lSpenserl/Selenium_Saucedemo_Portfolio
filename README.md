# Selenium Saucedemo Portfólio 

Projeto de automação de testes E2E da aplicação [SauceDemo](https://www.saucedemo.com/), desenvolvido com foco em boas práticas de automação e organização de código.

## Sobre o projeto

A ideia deste repositório é construir, de forma gradual, um framework de automação utilizando **Java + Selenium WebDriver + JUnit 5 + Maven**, aplicando conceitos de **POO, Page Object Model e separação de responsabilidades**.

Os testes são estruturados para manter o código de automação reutilizável, organizado e fácil de evoluir.

Atualmente, o projeto contempla cenários de **login com sucesso e login com credenciais inválidas**, utilizando Page Objects, métodos reutilizáveis, configuração externa e **Explicit Wait**.

## Estrutura

- **BasePage**: centraliza ações comuns do Selenium.
- **DriverFactory**: responsável pela criação do WebDriver.
- **ConfigReader**: leitura das configurações do projeto.
- **Page Objects**: representam as páginas e seus comportamentos.
- **BaseTest**: estrutura comum para execução dos testes.
- **Testes**: cenários funcionais automatizados com JUnit 5.

## Técnicas e conceitos

**Page Object Model · Encapsulamento · Herança · Abstração · Factory Pattern · Explicit Wait · Separação de responsabilidades · Testes positivos e negativos**

## Tecnologias

**Java · Selenium WebDriver · JUnit 5 · Maven · IntelliJ IDEA**

O projeto está em evolução e será incrementado com novas funcionalidades e melhorias de arquitetura ao longo do desenvolvimento.
