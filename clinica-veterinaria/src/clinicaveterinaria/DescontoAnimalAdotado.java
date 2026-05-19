package clinicaveterinaria;

public class DescontoAnimalAdotado extends ServicoDecorator {

    public DescontoAnimalAdotado(IServicoCobranca servico) {
        super(servico);
    }

    public float getValor() {
        // 10% de desconto pra animal adotado
        return this.servico.getValor() * 0.9f;
    }

    public String getDescricao() {
        return this.servico.getDescricao() + " + desconto adotado";
    }
}