package views;

import javax.swing.*;
import java.awt.*;

public class ComentarView extends JFrame {

    public ComentarView() {
        setTitle("Comentar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(0, 184, 159)); // fundo verde

        JLabel lblComentario = new JLabel("Comentário:");
        lblComentario.setBounds(30, 30, 100, 25);
        lblComentario.setFont(new Font("Arial", Font.BOLD,16));
        lblComentario.setForeground(Color.WHITE);
        getContentPane().add(lblComentario);

        JTextArea txtComentario = new JTextArea();
        txtComentario.setLineWrap(true);
        txtComentario.setBackground(new Color(127, 255, 212)); // verde claro
        JScrollPane scrollComentario = new JScrollPane(txtComentario);
        scrollComentario.setBounds(30, 60, 320, 200);
        getContentPane().add(scrollComentario);

        JButton btnSalvar = new JButton("Comentar");
        btnSalvar.setBounds(80, 280, 100, 30);
        btnSalvar.setBackground(new Color(127, 255, 212));
        btnSalvar.setForeground(Color.WHITE);
        getContentPane().add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 280, 100, 30);
        btnCancelar.setBackground(Color.GRAY);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.addActionListener(e -> dispose());
        getContentPane().add(btnCancelar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ComentarView().setVisible(true);
        });
    }
}
