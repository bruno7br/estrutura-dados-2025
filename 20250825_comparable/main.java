public class Main {
    public static void main(String[] args) {
        Transporte t1 = new Transporte("Marca1", "Modelo1", "Tipo1", "Chassi1", "2020", "2021", "Cor1", "Placa1");
        ArvoreBinaria<Transporte> arvore = new ArvoreBinaria<>();
        arvore.inserir(t1);

        Transporte t2 = new Transporte("Marca2", "Modelo1", "Tipo1", "Chassi2", "2020", "2021", "Cor1", "Placa2");
        Transporte t3 = new Transporte("Marca3", "Modelo1", "Tipo1", "Chassi3", "2020", "2021", "Cor1", "Placa3");
        Transporte t4 = new Transporte("Marca4", "Modelo1", "Tipo1", "Chassi4", "2020", "2021", "Cor1", "Placa4");
        Transporte t5 = new Transporte("Marca5", "Modelo1", "Tipo1", "Chassi5", "2020", "2021", "Cor1", "Placa5");
        Transporte t6 = new Transporte("Marca6", "Modelo1", "Tipo1", "Chassi6", "2020", "2021", "Cor1", "Placa6");

        arvore.inserir(t4);
        arvore.inserir(t6);
        arvore.inserir(t3);
        arvore.inserir(t5);
        arvore.inserir(t2);
        arvore.imprimeEmOrdem();
        arvore.imprimePreFixado();
    }
}

