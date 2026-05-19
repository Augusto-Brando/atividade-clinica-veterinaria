package clinicaveterinaria;

public class EstadoAgendado extends AtendimentoEstado {
    private static EstadoAgendado instance = new EstadoAgendado();
    private EstadoAgendado() {}

    public static EstadoAgendado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Agendado";
    }

    public boolean iniciar(Atendimento atendimento) {
        atendimento.setEstado(EstadoEmAtendimento.getInstance());
        return true;
    }

    public boolean cancelar(Atendimento atendimento) {
        atendimento.setEstado(EstadoCancelado.getInstance());
        return true;
    }
}