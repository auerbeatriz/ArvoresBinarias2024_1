package app.service;

import app.dao.DisciplinaDAO;
import app.exception.DisciplinaNaoEncontradaException;
import app.model.Disciplina;

public class DisciplinaService {
    private DisciplinaDAO disciplinaDAO;

    public DisciplinaService() {
        this.disciplinaDAO = new DisciplinaDAO();
    }

    public void cadastrarDisciplina(int codigo, int cargaHoraria, String nome) {
        Disciplina disciplina = new Disciplina(codigo, cargaHoraria, nome);
        disciplinaDAO.cadastrarDisciplinas(disciplina);
    }

    public Disciplina consultarDisciplina(int codigoDisciplina) throws DisciplinaNaoEncontradaException {
        return this.disciplinaDAO.consultarDisciplina(codigoDisciplina);
    }

    public void excluirDisciplina(int codigoDisciplina) throws DisciplinaNaoEncontradaException {
        disciplinaDAO.excluirDisciplina(codigoDisciplina);
    }

    public void informarPreRequisito(int codigo1, int codigo2) throws DisciplinaNaoEncontradaException {
        Disciplina disciplina1 = this.disciplinaDAO.consultarDisciplina(codigo1);
        Disciplina disciplina2 = this.disciplinaDAO.consultarDisciplina(codigo2);
        disciplina1.addPreRequisito(disciplina2);
    }
}
