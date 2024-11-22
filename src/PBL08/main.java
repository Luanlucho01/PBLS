package PBL08;

import java.util.ArrayList;

abstract class ExcecaoSeguranca extends Exception {
    public ExcecaoSeguranca(String mensagem) {
        super(mensagem);
    }
}

class ExcecaoSaldoInsuficiente extends Exception {
    public ExcecaoSaldoInsuficiente() {
        super("Saldo insuficiente para realizar a operação.");
    }
}

abstract class ExcecaoAutenticacao extends ExcecaoSeguranca {
    public ExcecaoAutenticacao(String mensagem) {
        super(mensagem);
    }
}

class ExcecaoHorarioInvalido extends ExcecaoSeguranca {
    public ExcecaoHorarioInvalido() {
        super("Operação fora do horário permitido (8h às 22h).");
    }
}

class ExcecaoContaInvalida extends ExcecaoAutenticacao {
    public ExcecaoContaInvalida() {
        super("Número de conta inválido.");
    }
}

class ExcecaoSenhaInvalida extends ExcecaoAutenticacao {
    public ExcecaoSenhaInvalida() {
        super("Senha inválida.");
    }
}

class Banco {
    private String nome;
    private ArrayList<ContaCorrente> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void criar_conta(int numero, String senha, double saldo) {
        ContaCorrente novaConta = new ContaCorrente(numero, senha, saldo);
        contas.add(novaConta);
    }

    public void sacar(int numero, String senha, double valor, int horario) throws ExcecaoSeguranca, ExcecaoSaldoInsuficiente {
        if (horario < 8 || horario > 22) {
            throw new ExcecaoHorarioInvalido();
        }

        ContaCorrente conta = buscarConta(numero);
        if (conta == null) {
            throw new ExcecaoContaInvalida();
        }

        conta.retirar(valor, senha);
    }

    private ContaCorrente buscarConta(int numero) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public ArrayList<ContaCorrente> getContas() {
        return contas;
    }
}

class ContaCorrente {
    private int numero;
    private String senha;
    private double saldo;

    public ContaCorrente(int numero, String senha, double saldo) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void retirar(double valor, String senha) throws ExcecaoSaldoInsuficiente, ExcecaoSenhaInvalida {
        if (!this.senha.equals(senha)) {
            throw new ExcecaoSenhaInvalida();
        }
        if (valor > saldo) {
            throw new ExcecaoSaldoInsuficiente();
        }
        saldo -= valor;
        System.out.println("Saque de " + valor + " realizado com sucesso. Saldo atual: " + saldo);
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}

class Teste {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco PBL");

        // 5 contas
        banco.criar_conta(1, "1234", 500.00);
        banco.criar_conta(2, "abcd", 1000.00);
        banco.criar_conta(3, "xyz", 1500.00);
        banco.criar_conta(4, "9876", 2000.00);
        banco.criar_conta(5, "qwer", 2500.00);


        realizarSaque(banco, 1, "1234", 100, 10); // Sem problemas
        realizarSaque(banco, 2, "errada", 50, 10); // Senha inválida
        realizarSaque(banco, 3, "xyz", 2000, 10); // Saldo Insuficiente
        realizarSaque(banco, 10, "1234", 100, 10); // Conta Inva
        realizarSaque(banco, 4, "9876", 300, 23); // Horario Invalido
    }

    private static void realizarSaque(Banco banco, int numero, String senha, double valor, int horario) {
        try {
            banco.sacar(numero, senha, valor, horario);
        } catch (ExcecaoSeguranca | ExcecaoSaldoInsuficiente e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
