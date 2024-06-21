package app.view;

import app.exception.AlunoNaoEncontradoException;
import app.model.Aluno;
import app.model.Disciplina;
import app.service.AlunoService;
import app.service.DisciplinaService;

import java.util.Scanner;

/**
 * Esse código foi parcialmente gerado pelo ChatGPT
 * */
public class Menu {
    private AlunoService alunoService;
    private DisciplinaService disciplinaService;
    private Scanner s;

    public Menu() {
        this.alunoService = new AlunoService();
        this.disciplinaService = new DisciplinaService();
        this.s = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Disciplina");
            System.out.println("3. Informar pré-requisito");
            System.out.println("4. Informar Disciplina cursada");
            System.out.println("5. Consultar Aluno por Nome");
            System.out.println("6. Consultar Aluno por Matrícula");
            System.out.println("7. Excluir Aluno por Matrícula");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarDisciplina();
                    break;
                case 4:
                    this.informarDisciplinaCursada();
                    break;
                case 5:
                    this.consultarAlunoNome();
                    break;
                case 6:
                    this.consultarAlunoMatricula();
                    break;
                case 7:
                    this.excluirAlunoMatricula();
                    break;
                // Adicione os demais casos
                case 0:
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.println("------------------ CADASTRO ALUNO ------------------");

        System.out.print("Nome: ");
        String nome = s.nextLine();

        System.out.print("Matrícula: ");
        int matricula = s.nextInt();

        alunoService.cadastrarAluno(nome, matricula);
        System.out.println("Aluno cadastrado com sucesso.");
        System.out.println("-----------------------------------------------------");
    }

    private void cadastrarDisciplina() {
        System.out.println("---------------- CADASTRO DISCIPLINA ----------------");

        System.out.print("Nome: ");
        String nome = s.nextLine();

        System.out.print("Código: ");
        int codigo = s.nextInt();
        s.nextLine();

        System.out.print("Carga Horária: ");
        int cargaHoraria = s.nextInt();
        s.nextLine();

        disciplinaService.cadastrarDisciplina(codigo, nome, cargaHoraria);
        System.out.println("Disciplina cadastrada com sucesso.");
        System.out.println("-----------------------------------------------------");
    }

    private void informarDisciplinaCursada() {
        System.out.println("------------ INFORMAR DISCIPLINA CURSADA ------------");

        System.out.print("Matrícula do aluno: ");
        int matricula = s.nextInt();
        s.nextLine();

        System.out.print("Código da disciplina: ");
        int codigoDisciplina = s.nextInt();
        s.nextLine();

        //TODO: EXCEPTION
        Disciplina disciplina = disciplinaService.consultaDisciplina(codigoDisciplina);

        try {
            alunoService.informarDisciplinaCursada(matricula, disciplina);
            System.out.println("Disciplina cursada registrada com sucesso.");
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------");
    }

    private void consultarAlunoNome() {
        System.out.println("------------------ CONSULTAR ALUNO ------------------");

        System.out.print("Nome do aluno: ");
        String nome = s.nextLine();

        Aluno aluno = null;
        try {
            aluno = alunoService.consultarAlunoNome(nome);
            System.out.println(aluno);
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------------------------");
    }

    private void consultarAlunoMatricula() {
        System.out.println("------------------ CONSULTAR ALUNO ------------------");

        System.out.print("Matrícula do aluno: ");
        int matricula = s.nextInt();
        s.nextLine();

        try {
            Aluno aluno = alunoService.consultarAlunoMatricula(matricula);
            System.out.println(aluno);
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------------------------");
    }

    private void excluirAlunoMatricula() {
        System.out.println("------------------- EXCLUIR ALUNO -------------------");

        System.out.print("Matrícula do aluno: ");
        int matricula = s.nextInt();
        s.nextLine();

        try {
            alunoService.excluirAluno(matricula);
            System.out.println("Aluno excluído com sucesso.");
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------------------------");
    }
}
