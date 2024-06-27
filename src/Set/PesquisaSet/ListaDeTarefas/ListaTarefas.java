package Set.PesquisaSet.ListaDeTarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;
    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }
    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        }else {
            System.out.println("Nenhuma tarefa para remover!");
        }
        if (tarefaParaRemover == null){
            System.out.println("Tarefa não encontrada!");
        }
    }
    public void exibirTarefas(){
        if (!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        }else {
            System.out.println("Não há tarefas!");
        }
    }
    public int contarTarefas(){
        return tarefaSet.size();
    }
    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }
    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (!t.isConcluida()){
                tarefasNaoConcluidas.add(t);
            }
        }
        return tarefasNaoConcluidas;
    }
    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
            }
        }
    }
    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaParaMarcarComoPendente = null;
        for (Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }
        if (tarefaParaMarcarComoPendente != null){
            if (tarefaParaMarcarComoPendente.isConcluida()){
                tarefaParaMarcarComoPendente.setConcluida(false);
            }
        }else {
            System.out.println("Tarefa não encontrada na lista!");
        }
    }
    public void limparListaTarefas(){
        if (tarefaSet.isEmpty()){
            System.out.println("A lista ja esta vazia!");
        }else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        //Adicionando tarefas a lista
        listaTarefas.adicionarTarefa("Estudar java");
        listaTarefas.adicionarTarefa("Fazer Exercicios fisicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler um livro de programação");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        //exibindo tarefas da lista
        listaTarefas.exibirTarefas();

        //removendo tarefas
        listaTarefas.removerTarefa("Preparar apresentação");
        listaTarefas.exibirTarefas();

        //Exibindo o numero de tarefas
        System.out.println("Totatl de tarefas: " + listaTarefas.contarTarefas());

        //Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        //Marcando tarefas como concluidas
        listaTarefas.marcarTarefaConcluida("Fazer exercicios fisicos");
        listaTarefas.marcarTarefaConcluida("Estudar java");

        //exibindo tarefas da lista
        listaTarefas.exibirTarefas();

        //Obtendo tarefas concluidas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        //marcar tarefas como pendente
        listaTarefas.marcarTarefaPendente("Estudar java");
        listaTarefas.exibirTarefas();

        //limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();


    }


}
