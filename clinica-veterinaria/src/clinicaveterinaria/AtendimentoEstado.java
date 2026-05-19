package clinicaveterinaria;

public abstract class AtendimentoEstado {

    public abstract String getNome();

    public boolean iniciar(Atendimento atendimento) {
        return false;
    }

    public boolean finalizar(Atendimento atendimento) {
        return false;
    }

    public boolean cancelar(Atendimento atendimento) {
        return false;
    }
}