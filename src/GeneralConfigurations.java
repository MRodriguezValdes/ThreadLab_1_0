import javax.swing.*;
import java.awt.*;

public class GeneralConfigurations extends JPanel {
    JTextField producers;
    JTextField itemByProducers;
    JCheckBox productionTimeRandomFixed;
    JSlider adjustProductionTime;
    JCheckBox maxProductionTime;
    JSlider  adjustMaxProductionTime;


    JTextField customers;
    JTextField itemConsumedByCustomer;
    JCheckBox consumeTimeRandomFixed;
    JSlider adjustConsumeTime;
    JCheckBox maxConsumeTime;
    JSlider adjustMaxConsumeTime;


    public GeneralConfigurations(JTextField producers, JTextField itemByProducers, JCheckBox productionTimeRandomFixed, JCheckBox maxTimeProduction,
                                 JTextField customers, JTextField itemConsumedByCustomer, JCheckBox consumeTimeRandomFixed, JCheckBox maxConsumeTime,
                                 JSlider adjustProductionTime, JSlider adjustMaxProductionTime , JSlider adjustConsumeTime, JSlider adjustMaxConsumeTime) {
        this.producers = producers;
        this.itemByProducers = itemByProducers;
        this.productionTimeRandomFixed = productionTimeRandomFixed;
        this.adjustProductionTime=adjustProductionTime;
        this.maxProductionTime = maxTimeProduction;
        this.adjustMaxProductionTime=adjustMaxProductionTime;
        this.customers = customers;
        this.itemConsumedByCustomer = itemConsumedByCustomer;
        this.consumeTimeRandomFixed = consumeTimeRandomFixed;
        this.adjustConsumeTime = adjustConsumeTime;
        this.maxConsumeTime = maxConsumeTime;
        this.adjustMaxConsumeTime = adjustMaxConsumeTime;

        this.configureParametersPanel();
    }


    private void configureParametersPanel() {
        // Configuring panel layout
        this.setLayout(new GridBagLayout());

        //
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;

        // 1 column
        this.add(this.producers, c);
        c.gridy++;
        this.add(this.itemByProducers, c);
        c.gridy++;
        this.add(this.productionTimeRandomFixed, c);
        c.gridy++;
        this.add(this.adjustProductionTime,c);
        c.gridy++;
        this.add(this.maxProductionTime, c);
        c.gridy++;
        this.add(this.adjustMaxProductionTime,c);

        //2 column
        c.gridy = 0;
        c.gridx = 1;
        this.add(this.customers,c);
        c.gridy++;
        this.add(this.itemConsumedByCustomer,c);
        c.gridy++;
        this.add(consumeTimeRandomFixed,c);
        c.gridy++;
        this.add(this.adjustConsumeTime,c);
        c.gridy++;
        this.add(maxConsumeTime,c);
        c.gridy++;
        this.add(this.adjustMaxConsumeTime,c);

    }
}
