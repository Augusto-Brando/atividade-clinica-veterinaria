package clinicaveterinaria;

public class EstadoCancelado extends AtendimentoEstado {
    private static EstadoCancelado instance = new EstadoCancelado();
    private EstadoCancelado() {}

    public static EstadoCancelado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Cancelado";
    }
}