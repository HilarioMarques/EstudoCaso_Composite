# Estudo de Caso 2.4 — Composite: Sistema de Organização de Tarefas

**Universidade Estadual do Piauí — UESPI**
**Campus Drª Josefina Demes**
**Curso:** Bacharelado em Ciência da Computação
**Disciplina:** Padrões de Projeto
**Professora:** Anelli

## Equipe

- Hilário Oliveira Marques Filho
- Luca Áureo Teixeira
- Ryan Charles Lima Sousa

## Resumo

Aplicação em Java que organiza tarefas individuais e projetos (grupos de tarefas)
usando o padrão de projeto **Composite**. Um projeto pode conter tarefas e também
outros projetos, formando uma estrutura em árvore. O sistema calcula a duração
total de uma tarefa ou de um projeto, incluindo tudo o que está dentro dos
projetos internos, sem que o código cliente precise distinguir os dois tipos.

## O que foi feito

| Arquivo | Papel no Composite | Descrição |
|---|---|---|
| `ElementoProjeto.java` | Component | Interface comum, com o método `double calcularDuracao()`. |
| `Tarefa.java` | Leaf | Guarda nome e duração estimada (em horas). `calcularDuracao()` devolve a própria duração. |
| `Projeto.java` | Composite | Guarda nome e uma lista de `ElementoProjeto`. O método `adicionar` aceita tarefas e projetos. `calcularDuracao()` soma a duração de todos os elementos. |
| `main.java` | Cliente | Monta a estrutura do enunciado e imprime o nome do projeto principal e a duração total. |

## Como funciona

Como `Tarefa` e `Projeto` implementam a mesma interface (`ElementoProjeto`), o
`Projeto` consegue guardar os dois tipos na mesma lista. Ao calcular a duração, ele
percorre os elementos e chama `calcularDuracao()` em cada um. Se o elemento for
outro projeto, esse método soma os elementos internos dele (recursão). Assim a
contagem funciona em qualquer nível de aninhamento.

Estrutura montada em `main`:

```
Projeto: Desenvolvimento de Sistema
 ∟ Tarefa: Levantamento de Requisitos — 4 h
 ∟ Tarefa: Modelagem do Banco — 6 h
 ∟ Projeto: Implementação
     ∟ Tarefa: Desenvolvimento Backend — 12 h
     ∟ Tarefa: Desenvolvimento Frontend — 10 h
```

Cálculo: 4 + 6 + (12 + 10) = **32 horas**.

## Como executar

### Pré-requisito

Ter o **JDK** (Java Development Kit) instalado, versão 8 ou superior.
Para conferir, rode no terminal:

```
java -version
javac -version
```

### Linux

1. Instale o JDK, se necessário (exemplo no Ubuntu/Debian):
   ```bash
   sudo apt update && sudo apt install default-jdk
   ```
2. Abra o terminal na pasta onde estão os arquivos `.java`.
3. Compile:
   ```bash
   javac *.java
   ```
4. Execute:
   ```bash
   java main
   ```

### Windows

1. Instale o JDK (por exemplo, o Temurin ou o Oracle JDK) e confirme que `java` e
   `javac` funcionam no Prompt de Comando ou no PowerShell.
2. Abra o Prompt de Comando ou o PowerShell na pasta onde estão os arquivos `.java`
   (dica: na pasta, clique na barra de endereço, digite `cmd` e pressione Enter).
3. Compile:
   ```
   javac *.java
   ```
4. Execute:
   ```
   java main
   ```

> Se o PowerShell não expandir o `*.java`, compile listando os arquivos:
> `javac ElementoProjeto.java Tarefa.java Projeto.java main.java`

> Se os acentos aparecerem errados no terminal do Windows (por exemplo, `Duração`
> aparecendo como `Dura??o`), compile com `javac -encoding UTF-8 *.java` e execute
> `chcp 65001` antes do `java main`. Isso afeta só a exibição, não o cálculo.

## Resultado esperado

```
Projeto: Desenvolvimento de Sistema
Duração total: 32.0 horas
```