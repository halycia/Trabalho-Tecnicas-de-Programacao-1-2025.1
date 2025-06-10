/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author halycia
 */

import java.util.ArrayList;
import java.util.List;
// Importar classes Avaliacao, Professor e Aluno quando forem implementadas

public class Disciplina {
    private String codigo;
    private String nome;
    private List<Avaliacao> avaliacoes;
    private List<Professor> professores;
    private List<Aluno> alunos;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.avaliacoes = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void listarAvaliacoes() {
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println(" | Nota: " + avaliacao.getNota());
        }
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    // Setters
    // Somente o nome da disciplina pode ser alterado
    public void setNome(String nome) {
        this.nome = nome;
    }
}

