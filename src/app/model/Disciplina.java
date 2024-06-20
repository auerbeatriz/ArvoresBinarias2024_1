package app.model;

import java.util.List;

public class Disciplina {
    private int codigo, cargaHoraria;
    private String nome;
    private List<Disciplina> preRequisitos;

    public Disciplina(int codigo, int cargaHoraria, String nome, List<Disciplina> preRequisitos) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
        this.preRequisitos = preRequisitos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public void addPreRequisito(Disciplina preRequisito) {
        this.preRequisitos.add(preRequisito);
    }
}
