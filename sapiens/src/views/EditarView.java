package views;

import javax.swing.*;
import java.awt.*;

public class EditarView extends JFrame {

    public EditarView() {
        setTitle("Editar");
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
        txtComentario.setWrapStyleWord(true);
        txtComentario.setBackground(new Color(127, 255, 212)); // verde claro
        JScrollPane scrollComentario = new JScrollPane(txtComentario);
        scrollComentario.setBounds(30, 60, 320, 200);
        getContentPane().add(scrollComentario);

        // Botão SALVAR
        JButton btnSalvar = new JButton("Editar");
        btnSalvar.setBounds(80, 280, 100, 30);
        btnSalvar.setBackground(new Color(127, 255, 212));
        btnSalvar.setForeground(Color.WHITE);
        getContentPane().add(btnSalvar);

        // Botão CANCELAR
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 280, 100, 30);
        btnCancelar.setBackground(Color.GRAY);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.addActionListener(e -> dispose());
        getContentPane().add(btnCancelar);

        // ÍCONE DA LIXEIRA + ação
        ImageIcon iconLixeira = new ImageIcon("src/imagem/lixeira.png");
        Image img = iconLixeira.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JButton btnLixeira = new JButton(scaledIcon);
        btnLixeira.setBounds(20, 330, 30, 30);
        btnLixeira.setBackground(new Color(0, 153, 0));
        btnLixeira.setBorderPainted(false);
        btnLixeira.setFocusPainted(false);
        btnLixeira.setContentAreaFilled(false);

        // Ação ao clicar no botão da lixeira
        btnLixeira.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Deseja apagar o comentário?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                txtComentario.setText(""); // limpa o texto
            }
        });

        getContentPane().add(btnLixeira);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditarView().setVisible(true);
        });
    }
}
