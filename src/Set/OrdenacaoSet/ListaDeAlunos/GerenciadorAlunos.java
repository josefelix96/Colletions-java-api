package Set.OrdenacaoSet.ListaDeAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAlunoPorMatricula(long matricula){
        Aluno alunoParaRemover = null;
        if (!alunoSet.isEmpty()){
            for (Aluno a : alunoSet){
                if (a.getMatricula() == matricula){
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        }else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }
    public void exibirAlunos(){
        if (!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(alunoSet);
        return alunosPorNota;
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        //Adicionando alunos
        gerenciadorAlunos.adicionarAluno("jose", 1L, 7.90);
        gerenciadorAlunos.adicionarAluno("joao", 2L, 6.5);
        gerenciadorAlunos.adicionarAluno("ana", 3L, 7);
        gerenciadorAlunos.adicionarAluno("maria", 4L, 6.4);
        gerenciadorAlunos.adicionarAluno("carlos", 5L, 4.90);
        gerenciadorAlunos.adicionarAluno("junior", 6L, 2.5);

        //Exibindo alunos
        gerenciadorAlunos.exibirAlunos();

        //Removendo alunos
        gerenciadorAlunos.removerAlunoPorMatricula(1L);
        gerenciadorAlunos.exibirAlunos();

        //Exibindo alunos por nome
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        //Exibindo alunos por nota
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

    }

}
