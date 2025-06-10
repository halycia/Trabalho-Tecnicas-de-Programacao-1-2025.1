package controllers;


import data.BancoDeDadosFake;
import models.Aluno;

public class UsuarioController {
    public static boolean cadastrarAluno(String nome, String email, String senha) {
        for (Aluno a : BancoDeDadosFake.alunos) {
            if (a.getEmail().equals(email)) return false;
        }
        BancoDeDadosFake.alunos.add(new Aluno(nome, email, senha));
        return true;
    }

    public static Aluno logar(String email, String senha) {
        for (Aluno a : BancoDeDadosFake.alunos) {
            if (a.getEmail().equals(email) && a.getSenha().equals(senha)) {
                return a;
            }
        }
        return null;
    }
}