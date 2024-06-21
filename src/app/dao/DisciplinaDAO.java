package app.dao;

import app.exception.DisciplinaNaoEncontradaException;
import app.model.Disciplina;
import app.util.ComparadorDisciplina;
import lib.ArvoreBinaria;

public class DisciplinaDAO {
    private ComparadorDisciplina comparadorDisciplina = new ComparadorDisciplina();
    private ArvoreBinaria<Disciplina> disciplinas;

    public DisciplinaDAO(){
        this.disciplinas = new ArvoreBinaria<Disciplina>(comparadorDisciplina);
    }

    public void cadastrarDisciplinas(Disciplina disciplina){
        this.disciplinas.adicionar(disciplina);
    }



    public Disciplina consultarDisciplina(int codigo) throws DisciplinaNaoEncontradaException{
        Disciplina DisciTemp = new Disciplina(codigo);
        Disciplina disciplina = this.disciplinas.pesquisar(DisciTemp, new ComparadorDisciplina());

        if(disciplina == null){
            throw new DisciplinaNaoEncontradaException("Disciplina não encontrada no sitema");
        }
        return disciplina;
    }

    public Disciplina excluirDisciplina(int codigo) throws DisciplinaNaoEncontradaException{
        Disciplina disciplina = this.consultarDisciplina(codigo);
        if(disciplina == null){
            throw new DisciplinaNaoEncontradaException("Disciplina não encontrada no sitema");
        }
        return this.disciplinas.remover(disciplina);
    }
}
