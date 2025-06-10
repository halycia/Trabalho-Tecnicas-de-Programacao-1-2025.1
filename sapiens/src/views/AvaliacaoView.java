package views;

import javax.swing.*;
import java.awt.*;
import models.Aluno;

public class AvaliacaoView extends JFrame {

    private Aluno aluno;

    public AvaliacaoView(Aluno aluno) {
        this.aluno = aluno;

        setTitle("Avaliação de Professor");
        setSize(500, 400); // Tamanho aumentado para acomodar novos campos
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        Color verdeFundo = new Color(0, 184, 159);
        Color verdeAreaComentario = new Color(127, 255, 212);
        Color brancoCampos = Color.WHITE;

        // Painel principal com background verde
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(verdeFundo);

        // 1. Cabeçalho
        JLabel headerLabel = new JLabel("Avalie o professor", SwingConstants.LEFT);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(new Color(189, 236, 182)); // Verde escuro
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // 2. Corpo central com os campos
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(verdeFundo);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Campo Professor
        JLabel professorLabel = new JLabel("Professor:");
        professorLabel.setFont(new Font("Arial", Font.BOLD, 18));
        professorLabel.setForeground(Color.WHITE);
        professorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField professorField = new JTextField();
        professorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        professorField.setBackground(brancoCampos);
        professorField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));

        // Campo Disciplina
        JLabel disciplinaLabel = new JLabel("Disciplina:");
        disciplinaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        disciplinaLabel.setForeground(Color.WHITE);
        disciplinaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField disciplinaField = new JTextField();
        disciplinaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        disciplinaField.setBackground(brancoCampos);
        disciplinaField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));

        // Campo Comentário
        JLabel comentarioLabel = new JLabel("Comentário:");
        comentarioLabel.setFont(new Font("Arial", Font.BOLD, 18));
        comentarioLabel.setForeground(Color.WHITE);
        comentarioLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea comentarioArea = new JTextArea(5, 20);
        comentarioArea.setBackground(verdeAreaComentario);
        comentarioArea.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
        JScrollPane scrollComentario = new JScrollPane(comentarioArea);
        scrollComentario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        // Adicionando componentes ao centro
        centerPanel.add(professorLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(professorField);
        centerPanel.add(Box.createVerticalStrut(15));
        
        centerPanel.add(disciplinaLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(disciplinaField);
        centerPanel.add(Box.createVerticalStrut(15));
        
        centerPanel.add(comentarioLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(scrollComentario);

        // 3. Rodapé com botões
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        footerPanel.setBackground(verdeFundo);

        JButton cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        cancelarBtn.setForeground(Color.WHITE);
        cancelarBtn.setBackground(Color.GRAY);
        cancelarBtn.setPreferredSize(new Dimension(100, 30));

        JButton avaliarBtn = new JButton("Avaliar");
        avaliarBtn.setFont(new Font("Arial", Font.BOLD, 14));
        avaliarBtn.setBackground(new Color(127, 255, 212)); // Verde escuro
        avaliarBtn.setForeground(Color.WHITE);
        avaliarBtn.setPreferredSize(new Dimension(100, 30));

        // Ações dos botões
        cancelarBtn.addActionListener(e -> {
            new TelaPrincipalView(this.aluno).setVisible(true);
            this.dispose();
        });
        
        avaliarBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Avaliação enviada com sucesso!");
        });

        footerPanel.add(cancelarBtn);
        footerPanel.add(avaliarBtn);

        // Montagem final
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
}
}