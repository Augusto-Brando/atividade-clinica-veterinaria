package clinicaveterinaria;

public class EstadoEmAtendimento extends AtendimentoEstado {
    private static EstadoEmAtendimento instance = new EstadoEmAtendimento();
    private EstadoEmAtendimento() {}

    public static EstadoEmAtendimento getInstance() {
        return instance;
    }

    public String getNome() {
        return "EmAtendimento";
    }

    public boolean finalizar(Atendimento atendimento) {
        atendimento.setEstado(EstadoFinalizado.getInstance());
        return true;
    }
}