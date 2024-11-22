package PBL03b;

class Funcionario {
    String nome;
    double salario;
    int idade;
    String cargo;
    String periodo;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String nome,String cargo, double salario, String periodo) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.periodo = periodo;
    }

    public Funcionario(String nome, String cargo, double salario, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.idade = idade;
    }


    public void imprimirDados() {
        System.out.println("Funcionário: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Salario: " + this.salario);
        System.out.println("Período: " + this.periodo);
    }
}

class Main37 {
    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario("Ana","Analista",3500.00);
        Funcionario funcionario2 = new Funcionario("Carlos","Analista",3500.00);
        Funcionario funcionario3 = new Funcionario("João","Engenheiro",5200.00,"noturno");
        Funcionario funcionario4 = new Funcionario("Roberto","Engenheiro",5200.00,"diurno");
        Funcionario funcionario5 = new Funcionario("Maria","Gerente",7800.00,38);

        funcionario1.imprimirDados();
        funcionario2.imprimirDados();
        funcionario3.imprimirDados();
        funcionario4.imprimirDados();
        funcionario5.imprimirDados();

        double Total = funcionario1.salario + funcionario2.salario + funcionario3.salario + funcionario4.salario + funcionario5.salario;
        System.out.println("O valor total que a empresa tem que pagar é:" + Total);
    }
}

