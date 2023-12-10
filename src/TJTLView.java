import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TJTLView extends JFrame implements Runnable, ActionListener, ChangeListener  {
    JPanel mainPanel;
    Settings settings;

    ResultsViewer results;

    public TJTLView() throws HeadlessException {

        this.mainPanel = new JPanel();
        this.settings = new Settings();
        this.results = new ResultsViewer(new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"),
                new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"));
        // Configuring main panel
        this.configureMainPanel();

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.add(mainPanel);
        this.configureJFrame();
    }

    private void configureMainPanel() {
        this.mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Thread Lab Pro");
        Font font = new Font(title.getFont().getFontName(), Font.BOLD, 25);
        title.setFont(font);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setFont(font);
        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;

        this.mainPanel.add(title, c);
        c.gridy++;
        c.weightx = 0;
        c.weighty = 0;

        settings.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.mainPanel.add(this.settings, c);

        c.gridy++;
        c.weightx = 1;
        c.weighty = 0;
        this.mainPanel.add(resultsLabel,c);
        c.gridy++;

        results.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.mainPanel.add(this.results, c);


    }

    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void run() {
        //todo:Logic for update data into the JTextFields
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
