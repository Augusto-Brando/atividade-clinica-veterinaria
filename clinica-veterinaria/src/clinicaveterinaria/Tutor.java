package clinicaveterinaria;

import java.util.Observable;
import java.util.Observer;

public class Tutor implements Observer {
    private String nome;
    private String telefone;
    private String ultimaNotificacao;

    public Tutor(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void update(Observable o, Object arg) {
        Atendimento at = (Atendimento) o;
        if (at.getNomeEstado().equals("EmAtendimento")) {
            this.ultimaNotificacao = "Ola " + this.nome + ", o atendimento do seu pet ja foi iniciado.";
        }
    }
}