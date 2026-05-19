package clinicaveterinaria;

import java.util.Observable;
import java.util.Observer;

public class ServicoVeterinario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public ServicoVeterinario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        Atendimento at = (Atendimento) o;
        // veterinario so e avisado em caso de cancelamento
        if (at.getNomeEstado().equals("Cancelado")) {
            this.ultimaNotificacao = "Dr(a). " + this.nome + ", um atendimento foi cancelado.";
        }
    }
}