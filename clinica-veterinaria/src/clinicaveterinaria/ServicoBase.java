package clinicaveterinaria;

public class ServicoBase implements IServicoCobranca {
    private String nome;
    private float valor;

    public ServicoBase(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return nome;
    }
}