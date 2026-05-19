package clinicaveterinaria;

public class TaxaAtendimentoDomiciliar extends ServicoDecorator {

    public TaxaAtendimentoDomiciliar(IServicoCobranca servico) {
        super(servico);
    }

    public float getValor() {
        // taxa fixa de 50 reais
        return this.servico.getValor() + 50.0f;
    }

    public String getDescricao() {
        return this.servico.getDescricao() + " + atendimento domiciliar";
    }
}