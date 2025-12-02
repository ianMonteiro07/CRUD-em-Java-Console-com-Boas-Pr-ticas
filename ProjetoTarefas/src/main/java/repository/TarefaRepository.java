package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaRepository {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    public void salvar(Tarefa tarefa) {
        tarefa.setId(contadorId++);
        tarefas.add(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas); // Retorna uma cópia para proteger a lista original
    }

    public Optional<Tarefa> buscarPorId(int id) {
        return tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public void atualizar(Tarefa tarefaAtualizada) {
        buscarPorId(tarefaAtualizada.getId()).ifPresent(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setDataConclusao(tarefaAtualizada.getDataConclusao());
        });
    }

    public boolean deletar(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}