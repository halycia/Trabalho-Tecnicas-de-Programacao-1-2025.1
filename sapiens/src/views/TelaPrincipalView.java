package views;


import javax.swing.*;
import models.Aluno;

public class TelaPrincipalView extends JFrame {
    private Aluno aluno; // Armazena o aluno como atributo

    public TelaPrincipalView(Aluno aluno) {
        this.aluno = aluno; // Guarda o aluno recebido
        
        setTitle("Bem-vindo, " + aluno.getNome());
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton avaliarBtn = new JButton("Avaliar Professor");
        // Passando o aluno para a AvaliacaoView
        avaliarBtn.addActionListener(e -> {
            new AvaliacaoView(this.aluno).setVisible(true);
            this.dispose(); // Fecha a tela principal se necessário
        });
        
        JButton btnComentar = new JButton("Comentar");
        btnComentar.setBounds(50, 200, 120, 30);
        btnComentar.addActionListener(e -> new ComentarView().setVisible(true));
        getContentPane().add(btnComentar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(200, 200, 120, 30);
        btnEditar.addActionListener(e -> new EditarView().setVisible(true));
        getContentPane().add(btnEditar);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Você está logado como: " + aluno.getEmail()));
        panel.add(Box.createVerticalStrut(20));
        panel.add(avaliarBtn);

        add(panel);
        setVisible(true);
}
}