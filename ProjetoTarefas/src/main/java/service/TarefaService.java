package service;

import model.Tarefa;
import repository.TarefaRepository;

import java.util.List;


public class TarefaService {
    private TarefaRepository repository;

    public TarefaService() {
        this.repository = new TarefaRepository();
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        // Poderia ter validações aqui (ex: título não pode ser vazio)
        repository.salvar(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listarTodas();
    }

    public Tarefa buscarTarefa(int id) {
        return repository.buscarPorId(id).orElse(null);
    }

    public void editarTarefa(Tarefa tarefa) {
        repository.atualizar(tarefa);
    }

    public boolean removerTarefa(int id) {
        return repository.deletar(id);
    }
}