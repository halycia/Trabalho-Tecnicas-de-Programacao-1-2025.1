/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author halyc
 */

// Importar as classes Aluno e Avaliacao quando forem implementadas

public class Comentario {
    private String texto;
    private String data;
    private Aluno autor;  
    private Avaliacao avaliacao;

    public Comentario(String texto, String data, Aluno autor, Avaliacao avaliacao) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
        this.avaliacao = avaliacao;

        // Associando o comentario a avaliacao
        this.avaliacao.adicionarComentario(this);
    }

    // Metodos
    public void editarTexto(String novoTexto) {
        this.texto = novoTexto;
    }

    public void excluirTexto() {
        // mantem o historico, excluindo somente o texto do comentario em si
        this.texto = "[Comentário excluído]";
    }

    // Getters
    public String getTexto() {
        return texto;
    }

    public String getData() {
        return data;
    }

    public Aluno getAutor() {
        return autor;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
}
