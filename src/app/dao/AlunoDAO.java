package app.dao;

import app.exception.AlunoNaoEncontradoException;
import app.model.Aluno;
import app.util.ComparadorAlunoPorMatricula;
import app.util.ComparadorAlunoPorNome;
import lib.ArvoreBinaria;

public class AlunoDAO {
    private ComparadorAlunoPorMatricula comparadorAlunoPorMatricula = new ComparadorAlunoPorMatricula();
    private ComparadorAlunoPorNome comparadorAlunoPorNome = new ComparadorAlunoPorNome();
    private ArvoreBinaria<Aluno> alunos;

    public AlunoDAO() {
        this.alunos = new ArvoreBinaria<Aluno>(comparadorAlunoPorMatricula);
    }

    public void cadastrarAluno(Aluno aluno) {
        this.alunos.adicionar(aluno);
    }

    public Aluno consultarAlunoNome(String nome) throws AlunoNaoEncontradoException {
        Aluno alunoDummy = new Aluno(nome);
        Aluno aluno = this.alunos.pesquisar(alunoDummy, new ComparadorAlunoPorNome());

        if(aluno == null) {
            throw new AlunoNaoEncontradoException("Aluno não encontrado no sistema.");
        }

        return aluno;
    }

    public Aluno consultarAlunoMatricula(int matricula) throws AlunoNaoEncontradoException {
        Aluno alunoDummy = new Aluno(matricula);
        Aluno aluno = this.alunos.pesquisar(alunoDummy);

        if(aluno == null) {
            throw new AlunoNaoEncontradoException("Aluno não encontrado no sistema.");
        }

        return aluno;
    }

    public Aluno excluirAluno(int matricula) throws AlunoNaoEncontradoException {
        Aluno aluno = this.consultarAlunoMatricula(matricula);
        return this.alunos.remover(aluno);
    }
}
