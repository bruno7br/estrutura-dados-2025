public class Transporte implements Comparable<Transporte> {
    String tipo;
    String marca;
    String modelo;
    String cor;
    String anoFabricacao;
    String anoModelo;
    String numeroChassi;
    String placa;

    @Override
    public int compareTo(Transporte outro) {
        String valorAtual = this.marca + '-' + this.modelo + '-' + this.anoFabricacao + '-' + this.numeroChassi;
        String valorOutro = outro.marca + '-' + outro.modelo + '-' + outro.anoFabricacao + '-' + outro.numeroChassi;
        return valorAtual.compareTo(valorOutro);
    }

    public Transporte(String marca, String modelo, String tipo, String chassi, String anoFabricacao, String anoModelo, String cor, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.numeroChassi = chassi;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.cor = cor;
        this.placa = placa;
    }

    @Override
    public String toString() {  
        return "Transporte: " + this.marca + '-' + this.modelo + '-' + this.anoFabricacao + '-' + this.numeroChassi + "\n";
    }
}