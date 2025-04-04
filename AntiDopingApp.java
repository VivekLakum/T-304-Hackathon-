import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class AntiDopingApp extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AntiDopingApp() {
        setTitle("Anti-Doping Education Platform");
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        
        mainPanel.add(createMenuPanel(), "Menu");
        mainPanel.add(createLearnPanel(), "Learn");
        mainPanel.add(createQuizPanel(), "Quiz");
        mainPanel.add(createUpdatesPanel(), "Updates");
        mainPanel.add(createReportPanel(), "Report");
        mainPanel.add(createResourcesPanel(), "Resources");
        mainPanel.add(createAboutPanel(), "About");

        add(mainPanel);
        cardLayout.show(mainPanel, "Menu");
        setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel imageLabel = new JLabel(new ImageIcon("anti_doping.png"));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.NORTH);

        JLabel title = new JLabel("Anti-Doping Education", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        JButton learnBtn = new JButton("\uD83D\uDCDA Learn about Anti-Doping");
        JButton quizBtn = new JButton("\uD83D\uDCDD Take a Quiz");
        JButton updatesBtn = new JButton("\uD83D\uDCF0 View Real-Time Updates");
        JButton reportBtn = new JButton("\uD83D\uDEA8 Report Violation");
        JButton resourcesBtn = new JButton("\uD83D\uDCDA View Resources");
        JButton aboutBtn = new JButton("\u2139 About the App");
        JButton exitBtn = new JButton("\u274C Exit");

        learnBtn.addActionListener(e -> cardLayout.show(mainPanel, "Learn"));
        quizBtn.addActionListener(e -> cardLayout.show(mainPanel, "Quiz"));
        updatesBtn.addActionListener(e -> cardLayout.show(mainPanel, "Updates"));
        reportBtn.addActionListener(e -> cardLayout.show(mainPanel, "Report"));
        resourcesBtn.addActionListener(e -> cardLayout.show(mainPanel, "Resources"));
        aboutBtn.addActionListener(e -> cardLayout.show(mainPanel, "About"));
        exitBtn.addActionListener(e -> System.exit(0));

        buttonPanel.add(learnBtn);
        buttonPanel.add(quizBtn);
        buttonPanel.add(updatesBtn);
        buttonPanel.add(reportBtn);
        buttonPanel.add(resourcesBtn);
        buttonPanel.add(aboutBtn);
        buttonPanel.add(exitBtn);

        panel.add(title, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createLearnPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 255, 200));

        JTextArea textArea = new JTextArea();
        textArea.setText(
            "\uD83E\uDE01 WHAT IS DOPING?\n" +
            "Doping is the use of banned substances or methods to unfairly improve performance.\n\n" +
            "\u26A0\uFE0F DANGERS OF DOPING:\n" +
            "• Heart problems\n" +
            "• Hormonal imbalance\n" +
            "• Psychological disorders\n\n" +
            "\uD83C\uDF1F HOW TO AVOID DOPING:\n" +
            "• Check substances on WADA list\n" +
            "• Use certified supplements\n" +
            "• Consult team medical staff\n" +
            "• Stay educated with official platforms\n\n" +
            "\uD83D\uDCE2 Remember: Clean sport = True sport!"
        );
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createQuizPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBackground(new Color(255, 255, 204));

        JLabel q1Label = new JLabel("Q1: Is taking performance-enhancing drugs allowed?");
        JComboBox<String> answer1 = new JComboBox<>(new String[]{"Yes", "No"});

        JLabel q2Label = new JLabel("Q2: Who sets anti-doping regulations?");
        JComboBox<String> answer2 = new JComboBox<>(new String[]{"NASA", "WADA"});

        JLabel q3Label = new JLabel("Q3: What is the full form of WADA?");
        JComboBox<String> answer3 = new JComboBox<>(new String[]{"World Athletic Drug Authority", "World Anti-Doping Agency"});

        JButton submitBtn = new JButton("Submit Quiz");
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);

        submitBtn.addActionListener(e -> {
            int score = 0;
            if (answer1.getSelectedItem().equals("No")) score++;
            if (answer2.getSelectedItem().equals("WADA")) score++;
            if (answer3.getSelectedItem().equals("World Anti-Doping Agency")) score++;
            resultLabel.setText("You scored " + score + "/3.");
        });

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(q1Label);
        panel.add(answer1);
        panel.add(q2Label);
        panel.add(answer2);
        panel.add(q3Label);
        panel.add(answer3);
        panel.add(submitBtn);
        panel.add(resultLabel);
        panel.add(backBtn);

        return panel;
    }

    private JPanel createUpdatesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(204, 229, 255));

        JTextArea updatesArea = new JTextArea();
        updatesArea.setText(
            "\uD83D\uDCE2 LATEST UPDATES:\n\n" +
            "✔ WADA 2025 guidelines released: new substances banned\n" +
            "✔ AI-based doping detection launched\n" +
            "✔ 4 athletes banned for doping violations\n" +
            "✔ Free Anti-Doping webinar on April 10th\n" +
            "✔ 'Play True Day' campaign is live"
        );
        updatesArea.setEditable(false);
        updatesArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        updatesArea.setMargin(new Insets(10, 10, 10, 10));

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(new JScrollPane(updatesArea), BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createReportPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 228, 225));

        JTextArea reportField = new JTextArea("Describe the doping violation here...");
        reportField.setFont(new Font("Serif", Font.PLAIN, 14));
        reportField.setLineWrap(true);
        reportField.setWrapStyleWord(true);

        JButton submit = new JButton("Submit Report");
        submit.addActionListener(e -> JOptionPane.showMessageDialog(this, "Report submitted anonymously."));

        JButton back = new JButton("Back to Menu");
        back.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        JPanel btnPanel = new JPanel();
        btnPanel.add(submit);
        btnPanel.add(back);

        panel.add(new JScrollPane(reportField), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createResourcesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 255, 240));

        JTextArea resources = new JTextArea();
        resources.setText(
            "\uD83D\uDCDA RESOURCES:\n\n" +
            "• WADA Website: https://www.wada-ama.org\n" +
            "• ADEL Learning: https://adel.wada-ama.org\n" +
            "• Global DRO: https://www.globaldro.com\n" +
            "• Athlete Handbook\n" +
            "• Contact NADO (National Anti-Doping Organization)\n"
        );
        resources.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resources.setEditable(false);
        resources.setMargin(new Insets(10, 10, 10, 10));

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(new JScrollPane(resources), BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 230, 250));

        JTextArea aboutArea = new JTextArea();
        aboutArea.setText(
            "\u2139 ABOUT THIS APP:\n\n" +
            "This static Java Swing application was developed to educate athletes\n" +
            "about anti-doping practices. It includes learning modules, quizzes,\n" +
            "updates, resources, and a reporting feature — all offline.\n\n" +
            "Developed for a college hackathon 2025\n" +
            "Created by: Team Java Warriors"
        );
        aboutArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        aboutArea.setEditable(false);
        aboutArea.setMargin(new Insets(10, 10, 10, 10));

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        panel.add(new JScrollPane(aboutArea), BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AntiDopingApp::new);
    }
}