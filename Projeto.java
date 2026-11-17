import java.util.ArrayList;
import java.util.List;

public class Projeto implements ElementoProjeto {

    // Nome do projeto (ex.: "Desenvolvimento de Sistema")
    private final String nome;

    // Coleção dos elementos que fazem parte deste projeto.
    // O tipo da lista é a interface ElementoProjeto, por isso ela aceita
    // Tarefa e Projeto ao mesmo tempo.
    private final List<ElementoProjeto> elementos = new ArrayList<>();

    /**
     * Construtor: cria um projeto vazio, apenas com o nome.
     *
     * @param nome nome do projeto
     */
    public Projeto(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um elemento (tarefa ou outro projeto) dentro deste projeto.
     *
     * @param elemento tarefa ou projeto a ser adicionado
     */
    
    public void adicionar(ElementoProjeto elemento) {
        elementos.add(elemento);
    }

    /**
     * Calcula a duração total do projeto: percorre todos os elementos e soma
     * as durações de cada um.
     *
     * Se o elemento for uma Tarefa, ele devolve a duração dela. Se for outro
     * Projeto, ele chama o próprio calcularDuracao() (recursão), que por sua
     * vez soma os elementos internos. Por isso os projetos internos também
     * entram na conta, em qualquer nível de profundidade.
     */
    @Override
    public double calcularDuracao() {
        double total = 0;
        for (ElementoProjeto elemento : elementos) {
            total += elemento.calcularDuracao();
        }
        return total;
    }

    // Getter do nome, útil para exibição
    public String getNome() {
        return nome;
    }
}