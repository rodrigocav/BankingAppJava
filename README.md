# Sistema Bancário em Java

Este é um sistema bancário simples desenvolvido em Java, com foco em programação orientada a objetos. O sistema permite gerenciar clientes e suas contas, realizar operações financeiras básicas, e exibir informações importantes via um menu interativo no console.

---

## Funcionalidades

- **Cadastro de clientes**: Permite registrar clientes informando CPF, nome e data de nascimento.
- **Criação de contas**: O sistema suporta dois tipos de conta: Conta Corrente e Conta Poupança.
- **Depósitos**: Permite depositar valores positivos nas contas.
- **Saques**: Permite sacar valores, considerando saldo disponível. Caso o saldo seja zero, há um limite especial de até R$450,00 que pode ser utilizado mediante confirmação.
- **Consulta de saldo**: Consulta o saldo disponível na conta.
- **Listagem de clientes**: Exibe todos os clientes cadastrados no sistema.

---

## Estrutura do projeto

- **Main.java**: Classe principal, contém o menu interativo para o usuário realizar operações.
- **Banco.java**: Gerencia a coleção de contas e operações relacionadas a busca e listagem.
- **Conta.java** (abstrata): Classe base para as contas bancárias, com métodos comuns como depositar, sacar e consultar saldo.
- **ContaCorrente.java** e **ContaPoupanca.java**: Extendem a classe Conta e representam os tipos específicos de conta.
- **Cliente.java**: Representa os dados pessoais do cliente (CPF, nome, data de nascimento).

---
