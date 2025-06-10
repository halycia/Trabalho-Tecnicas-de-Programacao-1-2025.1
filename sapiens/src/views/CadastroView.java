package views;


import javax.swing.*;
import java.awt.*;
import controllers.UsuarioController;
import models.Aluno;

public class CadastroView extends JFrame {

    public CadastroView() {
        setTitle("Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/imagem/bg.jpg");
        imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
        mainPanel.add(imageLabel, BorderLayout.WEST);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 240, 240));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

        JLabel titleLabel = new JLabel("Cadastro de Aluno");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JTextField nomeField = new JTextField(20);
        nomeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        nomeField.setBorder(BorderFactory.createTitledBorder("Nome"));

        JTextField emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));

        JPasswordField senhaField = new JPasswordField(20);
        senhaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        senhaField.setBorder(BorderFactory.createTitledBorder("Senha"));

        JButton cadastrarBtn = new JButton("Cadastrar");
        JButton voltarBtn = new JButton("Voltar");

        cadastrarBtn.setBackground(new Color(144, 238, 144));
        voltarBtn.setBackground(new Color(144, 238, 144));

        cadastrarBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        voltarBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        cadastrarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        cadastrarBtn.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            boolean sucesso = UsuarioController.cadastrarAluno(nome, email, senha);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                new LoginView();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro no cadastro. Verifique os dados.");
            }
        });

        voltarBtn.addActionListener(e -> {
            new LoginView();
            dispose();
        });

        formPanel.add(titleLabel);
        formPanel.add(nomeField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(emailField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(senhaField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(cadastrarBtn);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(voltarBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
}
}