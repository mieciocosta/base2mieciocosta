# base2mieciocosta

Projeto de amostra de testes do Selenium Webdriver em execução no Chrome e no Firefox com Docker containers, selenium Grid. Para execução dos testes foi utilizado o TestNg com os relatórios através do maven com Allure report

## Pre-requisitos

- O Docker precisa estar instalado e funcionando.
- As imagens Selenium, Selenium Chrome e Selenium Firefox precisam ser extraídas do Docker Hub

> Use o seguinte comando para extrair as imagens do Docker Hub: `docker pull selenium / hub && docker pull selenium / node-chrome && docker pull selenium / node-chrome-debug && docker pull selenium / node-firefox && docker pull selenium / node-firefox-debug`

> Utilize o link para as diretrizes de instalação do Docker
(https://docs.docker.com/engine/install/ubuntu/)

> Necessário configuração do selenium grid nesta etapa. Sugiro esse tutorial (https://www.linode.com/docs/development/nodejs/install-configure-selenium-grid-ubuntu-16-04/)

## Após instalação e configuração

Use `docker ps -a` para verificar se as imagens do chrome, firefox e selenium hub estão funcionando.

USe o comando `docker-compose up -d` para iniciar.

> Para restart `docker-compose restart`.

> Parar `docker-compose down`.

### Selenium Grid

Tudo ok, agora é acessar o selenium grid : http://localhost:4444/grid/console.

> Verificar o arquivo (base2mieciocosta/docker-compose.yml) para as configurações.

## Allure Report

Para instalação do allure report sugiro (https://www.npmjs.com/package/allure-commandline


