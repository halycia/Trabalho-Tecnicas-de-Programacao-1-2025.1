package views;

import javax.swing.*;
import java.awt.*;
import controllers.UsuarioController;
import models.Aluno;

public class LoginView extends JFrame {

    public LoginView() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal com divisão
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Painel esquerdo com imagem
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/imagem/bg.jpg");
        imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
        mainPanel.add(imageLabel, BorderLayout.WEST);

        // Painel direito com formulário
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 240, 240));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(60, 40, 60, 40));

        JLabel titleLabel = new JLabel("Avaliação de Professores");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JTextField emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));

        JPasswordField senhaField = new JPasswordField(20);
        senhaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        senhaField.setBorder(BorderFactory.createTitledBorder("Senha"));

        JButton loginBtn = new JButton("Entrar");
        JButton cadastroBtn = new JButton("Criar Conta");

        loginBtn.setBackground(new Color(144, 238, 144));
        cadastroBtn.setBackground(new Color(144, 238, 144));

        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cadastroBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        cadastroBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        loginBtn.addActionListener(e -> {
            Aluno a = UsuarioController.logar(emailField.getText(), new String(senhaField.getPassword()));
            if (a != null) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                new TelaPrincipalView(a);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login inválido!");
            }
        });

        cadastroBtn.addActionListener(e -> {
            new CadastroView();
            dispose();
        });

        formPanel.add(titleLabel);
        formPanel.add(emailField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(senhaField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(loginBtn);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(cadastroBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
}
}