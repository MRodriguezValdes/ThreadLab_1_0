import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements Runnable {
    JPanel mainPanel;
    Settings settings;

    Results results;

    public View() throws HeadlessException {

        this.mainPanel = new JPanel();
        this.settings = new Settings();
        this.results = new Results(new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"),
                       new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"));
        // Configuring main panel
        this.configureMainPanel();

        this.add(mainPanel);
        this.configureJFrame();
    }

    private void configureMainPanel() {
        this.mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        this.mainPanel.add(this.settings, c);

        c.gridy++;
        c.weightx = 1;
        c.weighty = 1;
        this.mainPanel.add(this.results, c);


    }

    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void run() {
        //todo:Logic for update data into the JTextFields
    }
}
