package clinicaveterinaria;

public class EstadoFinalizado extends AtendimentoEstado {
    private static EstadoFinalizado instance = new EstadoFinalizado();
    private EstadoFinalizado() {}

    public static EstadoFinalizado getInstance() {
        return instance;
    }

    public String getNome() {
        return "Finalizado";
    }
    // finalizado nao pode mais mudar de estado
}