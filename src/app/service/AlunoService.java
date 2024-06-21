package app.service;

import app.dao.AlunoDAO;
import app.model.Aluno;
import app.model.Disciplina;

public class AlunoService {
    private AlunoDAO alunoDAO;

    public AlunoService() {
        this.alunoDAO = new AlunoDAO();
    }

    public void cadastrarAluno(String nome, int matricula) {
        Aluno aluno = new Aluno(matricula, nome);
        alunoDAO.cadastrarAluno(aluno);

    }

    public void informarDisciplinaCursada(int matricula, Disciplina disciplina) {
        Aluno aluno = alunoDAO.getAlunoPorMatricula(matricula);

        if(aluno != null && aluno.cursouPreRequisitos(disciplina.getPreRequisitos())) {
             aluno.addDisciplinaCursada(disciplina);
        } else {
            // TODO: EXCEPTION
            System.out.println("Aluno não encontrado no sistema.");
        }
    }

    public Aluno consultarAlunoNome(String nome) {
        return alunoDAO.consultarAlunoNome(nome);
    }

    public Aluno consultarAlunoMatricula(int matricula) {
        return alunoDAO.consultarAlunoMatricula(matricula);
    }

    public void excluirAluno(int matricula) {
        alunoDAO.excluirAluno(matricula);
    }
}
