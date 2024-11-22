package PBL07;

abstract class Personagem {
    private boolean vivo = true;
    protected float posicao_x;
    protected float posicao_y;
    protected float posicao_z;
    protected int cor;

    public Personagem(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        this.vivo = vivo;
        this.posicao_x = posicao_x;
        this.posicao_y = posicao_y;
        this.posicao_z = posicao_z;
        this.cor = cor;
    }

    public abstract void correr(float x, float y);

    public abstract void saltar(float z);

    public abstract void atirar();

    public void morrer() {
        this.vivo = false;
        System.out.println("Morto");
    }
}

abstract class Heroi extends Personagem {
    public Heroi(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void correr(float x, float y) {
        this.posicao_x += x;
        this.posicao_y += y;
        System.out.println("Heroi correndo ...");
    }

    @Override
    public void saltar(float z) {
        this.posicao_z += z;
        System.out.println("Heroi saltando ...");
    }
}

abstract class Vilao extends Personagem {
    public Vilao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void correr(float x, float y) {
        this.posicao_x += x;
        this.posicao_y += y;
        System.out.println("Vilao correndo ...");
    }
}

abstract class Ladrao extends Vilao {
    public Ladrao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void saltar(float z) {
        this.posicao_z += z;
        System.out.println("Ladrao saltando ...");
    }
}

abstract class Terrorista extends Vilao {
    public Terrorista(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void atirar() {
        System.out.println("Terrorista atirando ...");
    }
}

class Coringa extends Ladrao {
    public Coringa(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void atirar() {
        System.out.println("Coringa atirando ...");
    }
}

class Pinguim extends Ladrao {
    public Pinguim(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void atirar() {
        System.out.println("Pinguim atirando ...");
    }

    @Override
    public void correr(float x, float y) {
        this.posicao_x += x;
        this.posicao_y += y;
        System.out.println("Pinguim correndo ...");
    }
}

class Goldfinger extends Terrorista implements Personificacao {
    private Heroi heroi;

    public Goldfinger(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void saltar(float z) {
        this.posicao_z += z;
        System.out.println("Goldfinger saltando ...");
    }

    @Override
    public void camuflar(int cor) {
        this.cor = cor;
        System.out.println("Goldfinger camuflando ...");
    }

    @Override
    public void personificar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Personificando ...");
    }
}

class DrNo extends Terrorista {
    public DrNo(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void saltar(float z) {
        this.posicao_z += z;
        System.out.println("DrNo saltando ...");
    }

    @Override
    public void correr(float x, float y) {
        this.posicao_x += x;
        this.posicao_y += y;
        System.out.println("DrNo correndo ...");
    }
}

class Batman extends Heroi implements Camuflagem {
    public Batman(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void atirar() {
        System.out.println("Batman atirando ...");
    }

    @Override
    public void camuflar(int cor) {
        this.cor = cor;
        System.out.println("Batman camuflando ...");
    }
}

class JamesBond extends Heroi {
    public JamesBond(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    @Override
    public void atirar() {
        System.out.println("JamesBond atirando ...");
    }

    @Override
    public void saltar(float z) {
        this.posicao_z += z;
        System.out.println("JamesBond saltando ...");
    }
}

interface Camuflagem {
    void camuflar(int cor);
}

interface Personificacao extends Camuflagem {
    void personificar(Heroi heroi);
}

class Teste {
    public static void main(String[] args) {
        Personagem batman = new Batman(true, 0, 0, 0, 1);
        Personagem jamesBond = new JamesBond(true, 0, 0, 0, 2);
        Personagem coringa = new Coringa(true, 0, 0, 0, 3);
        Personagem goldfinger = new Goldfinger(true, 0, 0, 0, 4);
        Personagem drNo = new DrNo(true, 0, 0, 0, 5);

        batman.correr(2, 3);
        batman.saltar(5);
        batman.atirar();
        ((Batman) batman).camuflar(7);
        batman.morrer();

        jamesBond.correr(1, 1);
        jamesBond.saltar(2);
        jamesBond.atirar();

        coringa.correr(3, 3);
        coringa.saltar(1);
        coringa.atirar();

        goldfinger.correr(2, 2);
        goldfinger.saltar(4);
        goldfinger.atirar();
        ((Goldfinger) goldfinger).camuflar(6);
        ((Goldfinger) goldfinger).personificar((Heroi) batman);

        drNo.correr(4, 5);
        drNo.saltar(3);
        drNo.atirar();
    }
}
