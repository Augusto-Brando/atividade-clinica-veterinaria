package clinicaveterinaria;

import java.util.Observable;
import java.util.Observer;

public class Recepcao implements Observer {
    private String ultimaNotificacao;

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        Atendimento at = (Atendimento) o;
        if (at.getNomeEstado().equals("Finalizado")) {
            this.ultimaNotificacao = "Recepcao: atendimento finalizado, liberar pagamento.";
        }
    }
}