/**
 * Classe principal (cliente do padrão Composite).
 *
 * Monta a estrutura de projetos e tarefas pedida no enunciado e exibe o nome
 * do projeto principal junto com a sua duração total.
 */

public class main {

    public static void main(String[] args) {

        // Projeto principal (raiz da estrutura)
        Projeto sistema = new Projeto("Desenvolvimento de Sistema");

        // Tarefas que ficam direto no projeto principal
        Tarefa requisitos = new Tarefa("Levantamento de Requisitos", 4);
        Tarefa modelagem = new Tarefa("Modelagem do Banco", 6);

        // Projeto interno, que será colocado dentro do projeto principal
        Projeto implementacao = new Projeto("Implementação");

        // Tarefas que ficam dentro do projeto "Implementação"
        Tarefa backend = new Tarefa("Desenvolvimento Backend", 12);
        Tarefa frontend = new Tarefa("Desenvolvimento Frontend", 10);

        // Montando o projeto interno (dois níveis abaixo da raiz)
        implementacao.adicionar(backend);
        implementacao.adicionar(frontend);

        // Montando o projeto principal: o método adicionar aceita tanto
        // tarefas quanto projetos, pois ambos são ElementoProjeto
        sistema.adicionar(requisitos);
        sistema.adicionar(modelagem);
        sistema.adicionar(implementacao);

        // Exibe o resultado. Uma única chamada de calcularDuracao() percorre
        // toda a árvore e soma: 4 + 6 + (12 + 10) = 32 horas.
        System.out.println("Projeto: " + sistema.getNome());
        System.out.println("Duração total: " + sistema.calcularDuracao() + " horas");
    }
}