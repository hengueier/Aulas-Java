# Projeto Capstone — Sistema Bancário em Java

## Descrição Geral

Desenvolver um **sistema bancário de console** (terminal) que simule as operações básicas de um banco real, aplicando **todos os conceitos estudados no módulo básico de Java**: desde declaração de variáveis e estruturas de controle até orientação a objetos completa (classes, herança, polimorfismo, encapsulamento, interfaces, classes abstratas, coleções e tratamento de exceções).

O projeto deve ser construído de forma **incremental**, permitindo que o aluno veja o código evoluir a cada etapa.

---

## Escopo Funcional

### 1. Cadastro de Clientes
- Criar cliente com nome, CPF e data de nascimento
- Validar CPF único no sistema
- Listar todos os clientes cadastrados

### 2. Abertura de Contas
- Cada cliente pode ter **uma ou mais contas**
- Tipos de conta:
  - **Conta Corrente** → possui taxa de manutenção e limite de cheque especial
  - **Conta Poupança** → rende juros mensais
- Cada conta tem: número, agência, saldo e titular

### 3. Operações Bancárias
- **Depósito** (valores positivos apenas)
- **Saque** (respeitando saldo + limite, quando houver)
- **Transferência** entre contas
- **Consulta de saldo**
- **Extrato** (histórico de transações)

### 4. Relatórios
- Listar todas as contas de um cliente
- Calcular total depositado no banco
- Aplicar **rendimento** em todas as poupanças
- Aplicar **taxa** em todas as correntes

### 5. Armazenamento
No momento todo o armazenamento será realizado em memória, sem uso de arquivos e banco de dados.

## Entregáveis
Criar um repositório para hospedar esse código, adicionar meu usuário "hengueier" como colaborador e requisitar revisão.

