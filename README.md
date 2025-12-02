Gerenciador de Tarefas (CLI)

Um sistema simples e eficiente para gerenciamento de tarefas via linha de comando (CLI), desenvolvido em **Java**. O projeto utiliza uma arquitetura em camadas para demonstrar boas práticas de organização de código.
 Funcionalidades

O sistema permite realizar as operações básicas de **CRUD**:
- **Cadastrar:** Criação de novas tarefas com Título, Descrição e Data de Conclusão.
- **Listar:** Visualização de todas as tarefas cadastradas.
- **Atualizar:** Edição dos dados de uma tarefa existente (mantendo dados antigos caso o campo seja deixado em branco).
- **Excluir:** Remoção de tarefas pelo ID.
- **Validação:** Tratamento de erros para datas inválidas e IDs inexistentes.

 Estrutura do Projeto

O código está organizado nos seguintes pacotes:

```text
src/main/java/
├── app/
│   └── Main.java           # Ponto de entrada (View/Controller), menu e interação com usuário.
├── model/
│   └── Tarefa.java         # Objeto de Domínio (POJO) representando a Tarefa.
├── repository/
│   └── TarefaRepository.java # Camada de acesso a dados (Simulação de banco em memória).
└── service/
    └── TarefaService.java  # Regras de negócio e ponte entre App e Repository.
🛠️ Tecnologias Utilizadas
Java 8+ (Uso da API java.time com LocalDate).

Scanner para entrada de dados via console.

Estruturas de Dados (List, ArrayList) para persistência em memória.

▶️ Como Executar
Pré-requisitos
Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.

Passo a Passo
Navegue até a pasta raiz do código fonte (onde está a pasta app, model, etc, ou na raiz src/main/java):

Cole
cd src/main/java
Compile os arquivos Java:


Cole
javac app/Main.java model/*.java repository/*.java service/*.java
Execute a aplicação:


Cole 
java app.Main -> Roda o software
🖥️ Exemplo de Uso
Plaintext

=== GERENCIADOR DE TAREFAS ===
1. Cadastrar Tarefa
2. Listar Tarefas
3. Atualizar Tarefa
4. Excluir Tarefa
0. Sair
Escolha uma opção: 1

--- Nova Tarefa ---
Título: Estudar Java
Descrição: Revisar POO e Collections
Data de Conclusão (dd/MM/yyyy): 25/12/2023
Tarefa cadastrada com sucesso!
Desenvolvido para fins de estudo sobre arquitetura em camadas e manipulação de dados em Java.
