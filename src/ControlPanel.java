import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    JToggleButton playPause;
    JButton reset;
    JButton regionProtection;

    JButton positiveStock;


    public ControlPanel(JToggleButton playPause, JButton reset, JButton regionProtection, JButton positiveStock) {
        this.playPause = playPause;
        this.reset = reset;
        this.regionProtection = regionProtection;
        this.positiveStock = positiveStock;

        this.configureControlsPanel();
    }

    private void configureControlsPanel() {
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

        this.add(this.playPause, c);
        c.gridy++;
        this.add(this.reset, c);
        c.gridy++;
        this.add(this.regionProtection, c);
        c.gridy++;
        this.add(this.positiveStock, c);

    }
}
