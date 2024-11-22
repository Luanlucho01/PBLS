package PBL03;

class Cliente {
    private String nome;
    private double saldo;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Erro: o valor do depósito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.printf("Retirada de R$%.2f realizada com sucesso.%n", valor);
        } else if (valor > 0) {
            System.out.println("Erro: saldo insuficiente para realizar a retirada.");
        } else {
            System.out.println("Erro: o valor da retirada deve ser positivo.");
        }
    }

    public void imprimirDados() {
        System.out.printf("Cliente: %s | Saldo: R$%.2f%n", nome, saldo);
    }
}

class Banco {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Jandira Silva", 2500.00);
        Cliente cliente2 = new Cliente("Sandra Rodrigues", 1800.00);
        Cliente cliente3 = new Cliente("Luciana Teixeira", 5000.00);

        System.out.println("Dados iniciais dos clientes:");
        cliente1.imprimirDados();
        cliente2.imprimirDados();
        cliente3.imprimirDados();

        System.out.println("\nOperações para Jandira Silva:");
        cliente1.retirar(1000.00);
        cliente1.imprimirDados();

        System.out.println("\nOperações para Sandra Rodrigues:");
        cliente2.retirar(2000.00);
        cliente2.depositar(500.00);
        cliente2.imprimirDados();
        cliente2.retirar(2000.00);
        cliente2.imprimirDados();

        System.out.println("\nOperações para Luciana Teixeira:");
        cliente3.depositar(1000.00);
        cliente3.imprimirDados();
    }
}

