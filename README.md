# Sistema de Gerenciamento de Estudantes (Backend)

Este é um sistema de gerenciamento de estudantes baseado em console (CLI) desenvolvido em Java. A aplicação gerencia operações completas de CRUD (criação, leitura, atualização e exclusão) utilizando uma integração direta com o banco de dados relacional PostgreSQL via JDBC.

---

## 🚀 Funcionalidades

O sistema provê as seguintes operações principais:

1. **Adicionar estudante**: Cadastro de novos registros contendo nome e curso.
2. **Editar estudante**:
   - Editar apenas o nome.
   - Editar apenas o curso.
   - Editar nome e curso simultaneamente.
3. **Remover estudante**:
   - Remoção por nome.
   - Remoção por ID (chave primária).
   - Remoção em lote de todos os estudantes de um determinado curso.
4. **Listar estudantes**:
   - Exibição de todos os registros no banco.
   - Busca detalhada por nome.
   - Filtro de estudantes por curso.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: [Java (JDK)](https://www.oracle.com/java/)
* **Banco de Dados**: [PostgreSQL](https://www.postgresql.org/)
* **Interface**: CLI (Interface de Linha de Comando)
* **Driver JDBC**: PostgreSQL JDBC Driver

---

## 📂 Estrutura do Projeto

A organização do código-fonte dentro de `src/` segue um padrão modular:

```text
src/
├── data/
│   ├── BancoDeDados.java           # Lógica do CRUD e execução de comandos SQL
│   ├── ConexaoBancoDeDados.java    # Configurações e abertura de conexão com o PostgreSQL
│   └── CriadorDeTabelas.java       # Criação automática de tabelas (DDL) caso não existam
├── main/
│   └── SistemaGerenciamentoEstudantes.java  # Ponto de entrada (Main Class)
├── model/
│   └── Estudante.java              # Classe modelo representando a entidade Estudante
└── view/
    └── Menu.java                   # Interface do menu interativo no console
```

---

## ⚙️ Configuração e Pré-requisitos

### 1. Banco de Dados PostgreSQL

Certifique-se de ter o PostgreSQL instalado e rodando em sua máquina.

1. Crie um banco de dados chamado `Escola` no PostgreSQL:
   ```sql
   CREATE DATABASE "Escola";
   ```
2. Caso precise ajustar as credenciais (porta, usuário, senha), edite o arquivo `src/data/ConexaoBancoDeDados.java`:
   ```java
   String url = "jdbc:postgresql://localhost:5432/Escola";
   String usuario = "seu_usuario";
   String senha = "sua_senha";
   ```
   *(A tabela `estudantes` é criada automaticamente pelo sistema ao iniciar pela primeira vez).*

### 2. Driver JDBC

Para que o Java se conecte ao PostgreSQL, você deve incluir o driver JDBC do PostgreSQL no classpath do seu projeto. 
* Se estiver utilizando o **Eclipse IDE**:
  1. Clique com o botão direito no projeto -> **Properties** -> **Java Build Path** -> **Libraries**.
  2. Adicione o `.jar` do driver do PostgreSQL (ex: `postgresql-42.x.x.jar`).

---

## 🏃 Como Executar

### Via IDE (Eclipse / VS Code / IntelliJ)
1. Importe o projeto para a sua IDE de preferência.
2. Configure o build path para incluir o driver do PostgreSQL.
3. Execute o arquivo `src/main/SistemaGerenciamentoEstudantes.java`.

### Via Linha de Comando (Terminal)
1. Compile os arquivos incluindo o driver no classpath (exemplo para Windows/Linux):
   ```bash
   javac -cp "lib/postgresql-42.x.x.jar" -d bin src/**/*.java
   ```
2. Execute a aplicação informando o classpath correspondente:
   ```bash
   java -cp "bin;lib/postgresql-42.x.x.jar" main.SistemaGerenciamentoEstudantes
   ```
   *(No Linux/macOS, use `:` como separador no lugar de `;` no comando `java -cp`).*
