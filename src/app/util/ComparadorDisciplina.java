package app.util;

import app.model.Aluno;
import app.model.Disciplina;

import java.util.Comparator;

public class ComparadorDisciplina implements Comparator<Disciplina> {

    @Override
    public int compare(Disciplina o1, Disciplina o2) {
        return Integer.compare(o1.getCodigo(), o2.getCodigo());
    }

}
