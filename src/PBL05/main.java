package PBL05;

import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    protected String nome;
    protected int idade;
    protected String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void apresentar() {
        System.out.printf("Nome: %s | Idade: %d | Email: %s%n", nome, idade, email);
    }

    public String getNome() {
        return nome;
    }
}

class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    public Aluno(String nome, int idade, String email, String matricula, String curso) {
        super(nome, idade, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Matrícula: %s | Curso: %s%n", matricula, curso);
    }
}

class Professor extends Pessoa {
    private String disciplina;
    private double salario;

    public Professor(String nome, int idade, String email, String disciplina, double salario) {
        super(nome, idade, email);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Disciplina: %s | Salário: R$%.2f%n", disciplina, salario);
    }

    public double calcularBonus() {
        return salario * 0.1;
    }
}

class Funcionario extends Pessoa {
    private String departamento;
    private int horasTrabalhadas;
    private double salarioHora;

    public Funcionario(String nome, int idade, String email, String departamento, int horasTrabalhadas, double salarioHora) {
        super(nome, idade, email);
        this.departamento = departamento;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Departamento: %s | Horas Trabalhadas: %d | Salário/Hora: R$%.2f%n",
                departamento, horasTrabalhadas, salarioHora);
    }

    public double calcularPagamento() {
        return horasTrabalhadas * salarioHora;
    }
}

class Monitor extends Aluno {
    private int horasMonitoria;
    private static final double VALOR_HORA = 30.00;

    public Monitor(String nome, int idade, String email, String matricula, String curso, int horasMonitoria) {
        super(nome, idade, email, matricula, curso);
        this.horasMonitoria = horasMonitoria;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Horas de Monitoria: %d%n", horasMonitoria);
    }

    public double calcularPagamentoMonitoria() {
        return horasMonitoria * VALOR_HORA;
    }
}

class EscolaDeDanca {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Aluno("Alice", 20, "alice@gmail.com", "A001", "Ballet Clássico"));
        pessoas.add(new Professor("Carlos", 35, "carlos@gmail.com", "Dança Contemporânea", 5000.00));
        pessoas.add(new Funcionario("Beatriz", 40, "beatriz@gmail.com", "Administração", 160, 20.00));
        pessoas.add(new Monitor("Diego", 22, "diego@gmail.com", "A002", "Street Dance", 10));
        pessoas.add(new Aluno("Fernanda", 25, "fernanda@gmail.com", "A003", "Jazz"));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Listar todas as pessoas");
            System.out.println("2. Visualizar detalhes de uma pessoa");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                System.out.println("\nPessoas na escola:");
                for (Pessoa pessoa : pessoas) {
                    System.out.println("- " + pessoa.getNome());
                }
            } else if (opcao == 2) {
                System.out.print("\nDigite o nome da pessoa que deseja visualizar: ");
                String nome = teclado.nextLine();
                Pessoa pessoaEncontrada = null;

                for (Pessoa pessoa : pessoas) {
                    if (pessoa.getNome().equalsIgnoreCase(nome)) {
                        pessoaEncontrada = pessoa;
                        break;
                    }
                }

                if (pessoaEncontrada != null) {
                    System.out.printf("Essa é a pessoa que você deseja visualizar? (Sim/Não)%n");
                    String resposta = teclado.nextLine();

                    if (resposta.equalsIgnoreCase("Sim")) {
                        System.out.println("\nDetalhes da pessoa:");
                        pessoaEncontrada.apresentar();
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                } else {
                    System.out.println("Pessoa não encontrada.");
                }
            } else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        teclado.close();
    }
}
