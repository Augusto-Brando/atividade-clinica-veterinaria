package clinicaveterinaria;

public class Animal {
    private String nome;
    private String especie;
    private boolean adotado;

    public Animal(String nome, String especie, boolean adotado) {
        this.nome = nome;
        this.especie = especie;
        this.adotado = adotado;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public boolean isAdotado() {
        return adotado;
    }
}