package clinicaveterinaria;

import java.util.Observable;

/**
 * Sistema de Atendimento de Clinica Veterinaria
 *
 * Autores:
 * - Augusto Brando Almeida
 * - Eduardo de Oliveira Ferreira Filho
 */

public class Atendimento extends Observable {
    private Tutor tutor;
    private Animal animal;
    private IServicoCobranca servico;
    private AtendimentoEstado estado;

    public Atendimento(Tutor tutor, Animal animal, IServicoCobranca servico) {
        this.tutor = tutor;
        this.animal = animal;
        this.servico = servico;
        this.estado = EstadoAgendado.getInstance();
    }

    public void setEstado(AtendimentoEstado estado) {
        this.estado = estado;
        // sempre que muda o estado, avisa os interessados
        setChanged();
        notifyObservers();
    }

    public AtendimentoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getNome();
    }

    public float getValorFinal() {
        return servico.getValor();
    }

    public boolean iniciar() {
        return estado.iniciar(this);
    }

    public boolean finalizar() {
        return estado.finalizar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Animal getAnimal() {
        return animal;
    }
}