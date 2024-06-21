package app.dao;

import app.model.Aluno;
import app.util.ComparadorAlunoPorMatricula;
import app.util.ComparadorAlunoPorNome;
import lib.ArvoreBinaria;

public class AlunoDAO {
    private ComparadorAlunoPorMatricula comparadorAlunoPorMatricula = new ComparadorAlunoPorMatricula();
    private ComparadorAlunoPorNome ComparadorAlunoPorNome = new ComparadorAlunoPorNome();
    private ArvoreBinaria<Aluno> alunos;

    public AlunoDAO() {
        this.alunos = new ArvoreBinaria<Aluno>(comparadorAlunoPorMatricula);
    }

    public void cadastrarAluno(Aluno aluno) {
        this.alunos.adicionar(aluno);
    }

    public Aluno getAlunoPorMatricula(int matricula) {
        //TODO
        return null;
    }

    public Aluno consultarAlunoNome(String nome) {
        Aluno aluno = new Aluno(nome);
        return this.alunos.pesquisar(aluno, ComparadorAlunoPorNome);
    }

    public Aluno consultarAlunoMatricula(int matricula) {
        Aluno aluno = new Aluno(matricula);
        return this.alunos.pesquisar(aluno);
    }

    public void excluirAluno(int matricula) {
        Aluno aluno = new Aluno(matricula);
        this.alunos.remover(aluno);
    }
}
