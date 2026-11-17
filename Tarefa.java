public class Tarefa implements ElementoProjeto {

    // Nome da tarefa (ex.: "Levantamento de Requisitos")
    private final String nome;

    // Duração estimada da tarefa, em horas
    private final double duracaoEstimada;

    /**
     * Construtor: cria uma tarefa com nome e duração estimada.
     *
     * @param nome            nome da tarefa
     * @param duracaoEstimada duração estimada em horas
     */
    
    public Tarefa(String nome, double duracaoEstimada) {
        this.nome = nome;
        this.duracaoEstimada = duracaoEstimada;
    }

    /**
     * Como a tarefa é uma folha (não tem filhos), a duração dela é
     * simplesmente a duração estimada que foi informada no construtor.
     */
    @Override
    public double calcularDuracao() {
        return duracaoEstimada;
    }

    // Getter do nome, útil para exibição
    public String getNome() {
        return nome;
    }
}