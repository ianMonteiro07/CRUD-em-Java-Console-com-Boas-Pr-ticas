package app;

import model.Tarefa;
import service.TarefaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static TarefaService service = new TarefaService();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    atualizar();
                    break;
                case 4:
                    excluir();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("--------------------------------------------");
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
        System.out.println("1. Cadastrar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Atualizar Tarefa");
        System.out.println("4. Excluir Tarefa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int op = Integer.parseInt(scanner.nextLine());
            return op;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrar() {
        System.out.println("\n--- Nova Tarefa ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        LocalDate data = lerData();

        Tarefa novaTarefa = new Tarefa(titulo, descricao, data);
        service.cadastrarTarefa(novaTarefa);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    private static void listar() {
        System.out.println("\n--- Lista de Tarefas ---");
        List<Tarefa> tarefas = service.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : tarefas) {
                System.out.println(t);
            }
        }
    }

    private static void atualizar() {
        System.out.println("\n--- Atualizar Tarefa ---");
        System.out.print("Digite o ID da tarefa: ");
        int id = lerOpcao();
        
        Tarefa tarefaExistente = service.buscarTarefa(id);
        
        if (tarefaExistente != null) {
            System.out.println("Deixe em branco para manter o valor atual.");
            
            System.out.print("Novo Título (" + tarefaExistente.getTitulo() + "): ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isEmpty()) tarefaExistente.setTitulo(novoTitulo);
            
            System.out.print("Nova Descrição (" + tarefaExistente.getDescricao() + "): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) tarefaExistente.setDescricao(novaDescricao);
            
            System.out.println("Nova Data (Atual: " + tarefaExistente.getDataConclusao().format(dateFormatter) + ")");
            LocalDate novaData = lerDataOpcional();
            if (novaData != null) tarefaExistente.setDataConclusao(novaData);
            
            service.editarTarefa(tarefaExistente);
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void excluir() {
        System.out.println("\n--- Excluir Tarefa ---");
        System.out.print("Digite o ID da tarefa: ");
        int id = lerOpcao();
        
        if (service.removerTarefa(id)) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static LocalDate lerData() {
        while (true) {
            try {
                System.out.print("Data de Conclusão (dd/MM/yyyy): ");
                String dataStr = scanner.nextLine();
                return LocalDate.parse(dataStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy");
            }
        }
    }
    
    private static LocalDate lerDataOpcional() {
        while (true) {
            try {
                System.out.print("Nova Data (ou Enter para pular): ");
                String dataStr = scanner.nextLine();
                if (dataStr.isEmpty()) return null;
                return LocalDate.parse(dataStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy");
            }
        }
    }
}