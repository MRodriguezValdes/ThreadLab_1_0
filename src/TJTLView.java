import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TJTLView extends JFrame implements Runnable, ActionListener, ChangeListener {
    JPanel mainPanel;
    Settings settings;

    TJTLController controller;
    ResultsViewer results;

    public TJTLView(TJTLController controller) throws HeadlessException {
        this.controller = controller;
        this.mainPanel = new JPanel();
        this.settings = new Settings();
        this.results = new ResultsViewer(new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"),
                new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"), new JTextField("0"));
        // Configuring main panel
        this.configureMainPanel();

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.add(mainPanel);
        this.addListeners();
        this.setDefaultValues();
        this.configureJFrame();
    }

    private void addListeners() {
        // Buttons
        this.settings.controls.playPause.addActionListener(this);
        this.settings.controls.positiveStock.addActionListener(this);
        this.settings.controls.regionProtection.addActionListener(this);
        this.settings.controls.reset.addActionListener(this);

        //Sliders
        this.settings.parameters.adjustConsumeTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                controller.labParameters.consumeTime = settings.parameters.adjustConsumeTime.getValue();
                System.out.println(controller.labParameters.consumeTime);
            }

        });
        this.settings.parameters.adjustMaxConsumeTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                controller.labParameters.maxConsumeTime = settings.parameters.adjustMaxConsumeTime.getValue();
                System.out.println(controller.labParameters.maxConsumeTime);

            }
        });
        this.settings.parameters.adjustProductionTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                controller.labParameters.productionTime = settings.parameters.adjustProductionTime.getValue();
                System.out.println(controller.labParameters.productionTime);

            }
        });

        this.settings.parameters.adjustMaxProductionTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                controller.labParameters.maxProductionTime = settings.parameters.adjustMaxProductionTime.getValue();
                System.out.println(controller.labParameters.maxConsumeTime);
            }
        });

        //CheckBoxes

        this.settings.parameters.consumeTimeRandomFixed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    settings.parameters.adjustConsumeTime.setEnabled(false); // Deshabilitar el JSlider
                    settings.parameters.adjustConsumeTime.setValue(50);
                    controller.labParameters.consumeTime = settings.parameters.adjustConsumeTime.getValue();
                } else {
                    settings.parameters.adjustConsumeTime.setEnabled(true); // Habilitar el JSlider
                }
            }
        });
        this.settings.parameters.productionTimeRandomFixed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    settings.parameters.adjustProductionTime.setEnabled(false); // Deshabilitar el JSlider
                    settings.parameters.adjustProductionTime.setValue(50);
                    controller.labParameters.productionTime = settings.parameters.adjustProductionTime.getValue();
                } else {
                    settings.parameters.adjustProductionTime.setEnabled(true); // Habilitar el JSlider
                }
            }
        });
        this.settings.parameters.maxConsumeTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    settings.parameters.adjustMaxConsumeTime.setEnabled(false); // Deshabilitar el JSlider
                    settings.parameters.adjustMaxConsumeTime.setValue(50);
                    controller.labParameters.maxConsumeTime = settings.parameters.adjustMaxConsumeTime.getValue();
                } else {
                    settings.parameters.adjustMaxConsumeTime.setEnabled(true); // Habilitar el JSlider
                }
            }
        });
        this.settings.parameters.maxProductionTime.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    settings.parameters.adjustMaxProductionTime.setEnabled(false); // Deshabilitar el JSlider
                    settings.parameters.adjustMaxProductionTime.setValue(50);
                    controller.labParameters.maxProductionTime = settings.parameters.adjustMaxProductionTime.getValue();
                } else {
                    settings.parameters.adjustMaxProductionTime.setEnabled(true); // Habilitar el JSlider
                }
            }
        });

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
        this.mainPanel.add(resultsLabel, c);
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

    private void setDefaultValues() {
        this.settings.parameters.consumeTimeRandomFixed.setSelected(this.controller.model.defaultConfig.consumeTimeRandomFixed);
        this.settings.parameters.maxConsumeTime.setSelected(this.controller.model.defaultConfig.maxConsumeTimeRandomFixed);
        this.settings.parameters.productionTimeRandomFixed.setSelected(this.controller.model.defaultConfig.productionTimeRandomFixed);
        this.settings.parameters.maxProductionTime.setSelected(this.controller.model.defaultConfig.maxProductionTimeRandomFixed);
        this.settings.parameters.producers.setText(String.valueOf(this.controller.model.defaultConfig.producers));
        this.settings.parameters.itemByProducers.setText(String.valueOf(this.controller.model.defaultConfig.itemByProducers));
        this.settings.parameters.consumers.setText(String.valueOf(this.controller.model.defaultConfig.consumers));
        this.settings.parameters.itemConsumedByConsumers.setText(String.valueOf(this.controller.model.defaultConfig.itemConsumedByConsumers));
    }

    @Override
    public void run() {
        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        updateStatistics(controller.labResults);
                    }
                });
            }
        });
        timer.start();
    }

    public void updateStatistics(LabResults labResults) {
        // Actualiza la interfaz de usuario con los datos de labResults
        results.msecToCreateThreadObjects.setText(String.valueOf(labResults.msecToCreateThreadObjects));
        results.msecToStartThreads.setText(String.valueOf(labResults.msecToStartThreads));
        results.msecForConsumerThreadsProcessing.setText(String.valueOf(labResults.msecForConsumerThreadsProcessing));
        results.msecForProducerThreadsProcessing.setText(String.valueOf(labResults.msecForProducerThreadsProcessing));
        results.itemsProducedByEachProducer.setText(String.valueOf(labResults.itemsProducedByEachProducer));
        results.itemsConsumedByEachConsumer.setText(String.valueOf(labResults.itemsConsumedByEachConsumer));
        results.numberOfProcessingProducerThreads.setText(String.valueOf(labResults.numberOfProcessingProducerThreads));
        results.numberOfProcessingConsumerThreads.setText(String.valueOf(labResults.numberOfProcessingConsumerThreads));
        results.numberOfPendingConsumerThreads.setText(String.valueOf(labResults.numberOfPendingConsumerThreads));
        results.numberOfPendingProducerThreads.setText(String.valueOf(labResults.numberOfPendingProducerThreads));
        results.numberOfFinishedConsumerThreads.setText(String.valueOf(labResults.numberOfFinishedConsumerThreads));
        results.numberOfFinishedProducerThreads.setText(String.valueOf(labResults.numberOfFinishedProducerThreads));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.resetStatistics();
                this.controller.play();
                break;
            case "Reset":
                this.controller.stopActiveThreads();
                this.controller.model.resetLabResults();
                this.setDefaultValues();
                this.resetStatistics();
                break;
            case "Region Protection":
                if (this.controller.labParameters.regionProtection) {
                    this.controller.labParameters.regionProtection = false;
                } else {
                    this.controller.labParameters.regionProtection = true;
                }
                break;
            case "Positive Stock":
                if (this.controller.labParameters.positiveStock) {
                    this.controller.labParameters.positiveStock = false;
                } else {
                    this.controller.labParameters.positiveStock = true;
                }
                break;
            default:
                System.err.println("don´t exist : " + e);
        }

    }

    private void resetStatistics() {
        this.results.msecToCreateThreadObjects.setText(String.valueOf(0));
        this.results.msecToStartThreads.setText(String.valueOf(0));
        this.results.msecForConsumerThreadsProcessing.setText(String.valueOf(0));
        this.results.msecForProducerThreadsProcessing.setText(String.valueOf(0));
        this.results.itemsProducedByEachProducer.setText(String.valueOf(0));
        this.results.itemsConsumedByEachConsumer.setText(String.valueOf(0));
        this.results.numberOfProcessingProducerThreads.setText(String.valueOf(0));
        this.results.numberOfProcessingConsumerThreads.setText(String.valueOf(0));
        this.results.numberOfPendingConsumerThreads.setText(String.valueOf(0));
        this.results.numberOfPendingProducerThreads.setText(String.valueOf(0));
        this.results.numberOfFinishedConsumerThreads.setText(String.valueOf(0));
        this.results.numberOfFinishedProducerThreads.setText(String.valueOf(0));
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
