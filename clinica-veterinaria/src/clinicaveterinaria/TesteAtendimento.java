package clinicaveterinaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteAtendimento {

    @Test
    public void testEstadoInicialAgendado() {
        Tutor tutor = new Tutor("Joao", "999999999");
        Animal animal = new Animal("Rex", "Cachorro", false);
        IServicoCobranca servico = new ServicoBase("Consulta", 100.0f);
        Atendimento at = new Atendimento(tutor, animal, servico);
        assertEquals("Agendado", at.getNomeEstado());
    }

    @Test
    public void testMudancaValidaAgendadoParaEmAtendimento() {
        Tutor tutor = new Tutor("Maria", "888888888");
        Animal animal = new Animal("Mia", "Gato", true);
        Atendimento at = new Atendimento(tutor, animal, new ServicoBase("Consulta", 100.0f));
        assertTrue(at.iniciar());
        assertEquals("EmAtendimento", at.getNomeEstado());
    }

    @Test
    public void testMudancaValidaEmAtendimentoParaFinalizado() {
        Atendimento at = new Atendimento(
                new Tutor("Carlos", "777777777"),
                new Animal("Bob", "Cachorro", false),
                new ServicoBase("Consulta", 100.0f));
        at.iniciar();
        assertTrue(at.finalizar());
        assertEquals("Finalizado", at.getNomeEstado());
    }

    @Test
    public void testCancelarAgendado() {
        Atendimento at = new Atendimento(
                new Tutor("Ana", "666666666"),
                new Animal("Luna", "Gato", true),
                new ServicoBase("Consulta", 100.0f));
        assertTrue(at.cancelar());
        assertEquals("Cancelado", at.getNomeEstado());
    }

    @Test
    public void testMudancaInvalidaFinalizadoParaCancelado() {
        Atendimento at = new Atendimento(
                new Tutor("Pedro", "555555555"),
                new Animal("Thor", "Cachorro", false),
                new ServicoBase("Consulta", 100.0f));
        at.iniciar();
        at.finalizar();
        assertFalse(at.cancelar());
        assertEquals("Finalizado", at.getNomeEstado());
    }

    @Test
    public void testMudancaInvalidaAgendadoParaFinalizado() {
        Atendimento at = new Atendimento(
                new Tutor("Lucas", "444444444"),
                new Animal("Nina", "Gato", false),
                new ServicoBase("Consulta", 100.0f));
        // nao pode pular pra finalizado direto
        assertFalse(at.finalizar());
        assertEquals("Agendado", at.getNomeEstado());
    }

    @Test
    public void testAvisoTutorAoIniciar() {
        Tutor tutor = new Tutor("Joana", "333333333");
        Atendimento at = new Atendimento(
                tutor,
                new Animal("Pipoca", "Cachorro", false),
                new ServicoBase("Consulta", 100.0f));
        at.addObserver(tutor);
        at.iniciar();
        assertNotNull(tutor.getUltimaNotificacao());
        assertTrue(tutor.getUltimaNotificacao().contains("Joana"));
    }

    @Test
    public void testAvisoVeterinarioAoCancelar() {
        ServicoVeterinario vet = new ServicoVeterinario("Roberto");
        Atendimento at = new Atendimento(
                new Tutor("Carla", "222222222"),
                new Animal("Toby", "Cachorro", false),
                new ServicoBase("Consulta", 100.0f));
        at.addObserver(vet);
        at.cancelar();
        assertNotNull(vet.getUltimaNotificacao());
        assertTrue(vet.getUltimaNotificacao().contains("Roberto"));
    }

    @Test
    public void testAvisoRecepcaoAoFinalizar() {
        Recepcao recepcao = new Recepcao();
        Atendimento at = new Atendimento(
                new Tutor("Bruno", "111111111"),
                new Animal("Mel", "Gato", true),
                new ServicoBase("Consulta", 100.0f));
        at.addObserver(recepcao);
        at.iniciar();
        at.finalizar();
        assertNotNull(recepcao.getUltimaNotificacao());
    }

    @Test
    public void testValorBaseSemRegras() {
        IServicoCobranca servico = new ServicoBase("Consulta", 100.0f);
        Atendimento at = new Atendimento(
                new Tutor("Teste", "000000000"),
                new Animal("Teste", "Cachorro", false),
                servico);
        assertEquals(100.0f, at.getValorFinal());
    }

    @Test
    public void testValorComDescontoAnimalAdotado() {
        IServicoCobranca servico = new DescontoAnimalAdotado(new ServicoBase("Consulta", 100.0f));
        Atendimento at = new Atendimento(
                new Tutor("Teste", "000000000"),
                new Animal("Adotadinho", "Cachorro", true),
                servico);
        assertEquals(90.0f, at.getValorFinal());
    }

    @Test
    public void testValorComTaxaDomiciliar() {
        IServicoCobranca servico = new TaxaAtendimentoDomiciliar(new ServicoBase("Consulta", 100.0f));
        Atendimento at = new Atendimento(
                new Tutor("Teste", "000000000"),
                new Animal("Teste", "Cachorro", false),
                servico);
        assertEquals(150.0f, at.getValorFinal());
    }

    @Test
    public void testValorComMultiplasRegras() {
        // consulta 100 + domiciliar 50 + banho 30 = 180, com desconto adotado -> 162
        IServicoCobranca servico = new DescontoAnimalAdotado(
                new BanhoPosConsulta(
                        new TaxaAtendimentoDomiciliar(
                                new ServicoBase("Consulta", 100.0f))));
        Atendimento at = new Atendimento(
                new Tutor("Teste", "000000000"),
                new Animal("Adotadinho", "Gato", true),
                servico);
        assertEquals(162.0f, at.getValorFinal());
    }

    @Test
    public void testDescricaoComMultiplasRegras() {
        IServicoCobranca servico = new BanhoPosConsulta(
                new TaxaAtendimentoDomiciliar(
                        new ServicoBase("Consulta", 100.0f)));
        assertTrue(servico.getDescricao().contains("Consulta"));
        assertTrue(servico.getDescricao().contains("domiciliar"));
        assertTrue(servico.getDescricao().contains("banho"));
    }
}