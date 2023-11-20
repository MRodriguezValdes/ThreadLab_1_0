import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    Controls controls;
    Parameters parameters;


    public Settings() {

        this.controls = new Controls(new JToggleButton("Play"), new JButton("Reset"), new JButton("Region Protection"), new JButton("Positive Stock"));
        this.parameters = new Parameters(new JTextField("Producers"), new JTextField("Item By Producers"), new JCheckBox("Production time random fixed"), new JCheckBox("Max time production"),
                new JTextField("Customer"), new JTextField("Item consumed by customer"), new JCheckBox("Consume time random fixed"), new JCheckBox("max consume time"),new JSlider(),new JSlider(),new JSlider(),new JSlider());

        this.configureSettingPanel();
    }

    private void configureSettingPanel() {
        // Configuring panel layout
        this.setLayout(new GridBagLayout());
        //

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        this.add(controls, c);
        c.gridx++;
        c.weightx = 1;
        this.add(parameters, c);
    }
}
