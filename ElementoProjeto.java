public interface ElementoProjeto {

    /**
     * Calcula a duração total do elemento, em horas.
     *
     * - Em uma Tarefa, é a própria duração estimada.
     * - Em um Projeto, é a soma das durações de tudo o que ele contém.
     *
     * @return duração total em horas
     */
    double calcularDuracao();
}