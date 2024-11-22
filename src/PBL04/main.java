package PBL04;

import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String codigo;
    private String titulo;
    private int anoPublicacao;
    private String editora;
    private String autor;
    private int paginas;
    private boolean emprestado;

    public Livro(String codigo, String titulo, int anoPublicacao, String editora, String autor, int paginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.paginas = paginas;
        this.emprestado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public String toString() {
        return "Código: " + codigo + ", Título: " + titulo + ", Ano: " + anoPublicacao +
                ", Editora: " + editora + ", Autor: " + autor + ", Páginas: " + paginas +
                ", Emprestado: " + (emprestado ? "Sim" : "Não");
    }
}

class Prateleira {
    private String codigo;
    private ArrayList<Livro> livros;

    public Prateleira(String codigo) {
        this.codigo = codigo;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equalsIgnoreCase(codigo)) {
                return livro;
            }
        }
        return null;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }
}

class Biblioteca {
    private String nome;
    private ArrayList<Prateleira> prateleiras;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.prateleiras = new ArrayList<>();
    }

    public void adicionarPrateleira(Prateleira prateleira) {
        prateleiras.add(prateleira);
    }

    public Livro buscarLivroPorCodigo(String codigo) {
        for (Prateleira prateleira : prateleiras) {
            Livro livro = prateleira.buscarLivroPorCodigo(codigo);
            if (livro != null) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros() {
        for (Prateleira prateleira : prateleiras) {
            for (Livro livro : prateleira.getLivros()) {
                System.out.println(livro);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = new Biblioteca("Biblioteca A");
        Biblioteca biblioteca2 = new Biblioteca("Biblioteca B");

        Prateleira prateleira1 = new Prateleira("P1");
        prateleira1.adicionarLivro(new Livro("L1", "Livro A", 2000, "Editora X", "Autor A", 300));
        prateleira1.adicionarLivro(new Livro("L2", "Livro B", 2001, "Editora Y", "Autor B", 400));
        prateleira1.adicionarLivro(new Livro("L3", "Livro C", 2002, "Editora Z", "Autor C", 500));

        Prateleira prateleira2 = new Prateleira("P2");
        prateleira2.adicionarLivro(new Livro("L4", "Livro D", 2003, "Editora X", "Autor D", 250));
        prateleira2.adicionarLivro(new Livro("L5", "Livro E", 2004, "Editora Y", "Autor E", 350));
        prateleira2.adicionarLivro(new Livro("L6", "Livro F", 2005, "Editora Z", "Autor F", 450));

        biblioteca1.adicionarPrateleira(prateleira1);
        biblioteca1.adicionarPrateleira(prateleira2);

        biblioteca2.adicionarPrateleira(prateleira1);
        biblioteca2.adicionarPrateleira(prateleira2);

        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Emprestar um livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Livros disponíveis:");
                    biblioteca1.listarLivros();
                    biblioteca2.listarLivros();
                    break;
                case 2:
                    System.out.print("Digite o código do livro: ");
                    String codigo = teclado.nextLine();
                    Livro livro = biblioteca1.buscarLivroPorCodigo(codigo);
                    if (livro == null) {
                        livro = biblioteca2.buscarLivroPorCodigo(codigo);
                    }
                    if (livro != null) {
                        System.out.println("Esse é o livro que você deseja emprestar? " + livro);
                        System.out.print("Confirma (s/n)? ");
                        String confirma = teclado.nextLine();
                        if (confirma.equalsIgnoreCase("s")) {
                            livro.emprestar();
                            System.out.println("Livro emprestado com sucesso!");
                        } else {
                            System.out.println("Empréstimo cancelado.");
                        }
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        teclado.close();

    }
}























