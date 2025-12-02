package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Tarefa {
    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDate dataConclusao;

    public Tarefa() {}

    public Tarefa(String titulo, String descricao, LocalDate dataConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + id +
               " | Título: " + titulo +
               " | Descrição: " + descricao +
               " | Conclusão: " + (dataConclusao != null ? dataConclusao.format(formatter) : "Sem data");
    }
}
