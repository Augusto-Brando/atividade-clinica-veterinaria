package clinicaveterinaria;

public abstract class ServicoDecorator implements IServicoCobranca {
    protected IServicoCobranca servico;

    public ServicoDecorator(IServicoCobranca servico) {
        this.servico = servico;
    }

    public float getValor() {
        return this.servico.getValor();
    }

    public String getDescricao() {
        return this.servico.getDescricao();
    }
}