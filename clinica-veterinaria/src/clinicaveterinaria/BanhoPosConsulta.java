package clinicaveterinaria;

public class BanhoPosConsulta extends ServicoDecorator {

    public BanhoPosConsulta(IServicoCobranca servico) {
        super(servico);
    }

    public float getValor() {
        return this.servico.getValor() + 30.0f;
    }

    public String getDescricao() {
        return this.servico.getDescricao() + " + banho";
    }
}