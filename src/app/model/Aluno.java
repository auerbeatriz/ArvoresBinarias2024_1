package app.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é a classe Aluno que será utilizada como tipo do conteúdo das árvores nos 
 * programas de teste para redigir os relatórios.
 */

public class Aluno  {
    private int matricula;
    private String nome;
    private List<Disciplina> disciplinasCursadas;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
        this.disciplinasCursadas = new ArrayList<Disciplina>();
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void addDisciplinaCursada(Disciplina disciplina) {
        this.disciplinasCursadas.add(disciplina);
    }

    public boolean cursouPreRequisitos(List<Disciplina> disciplinas) {
        for(Disciplina disciplina : disciplinas) {
            if (!this.getDisciplinasCursadas().contains(disciplina)) {
                return false;
            }
        }

        return true;
    }

    public String toString(){
        String disciplinas = "";
        for(Disciplina disciplina : this.disciplinasCursadas) {
            disciplinas += disciplina.getCodigo() + " - " + disciplina.getNome() + "\n";
        }

        String s = "Matrícula: " + this.getMatricula() + "\n" +
                    "Nome do aluno: " + this.getNome() + "\n\n" +
                    "*** Disciplinas cursadas ***\n" +
                    disciplinas;
        return s;
    }
}
