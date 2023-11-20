import javax.swing.*;
import java.awt.*;

public class Results extends JPanel {

    JTextField msecToCreateThreadObjects;
    JTextField msecToStartThreads;
    JTextField msecForConsumerThreadsProcessing;
    JTextField msecForProducerThreadsProcessing;
    JTextField itemsProducedByEachProducer;
    JTextField itemsConsumedByEachConsumer;
    JTextField numberOfProcessingProducerThreads;
    JTextField numberOfFinishedProducerThreads;
    JTextField numberOfPendingProducerThreads;
    JTextField numberOfProcessingConsumerThreads;
    JTextField numberOfFinishedConsumerThreads;
    JTextField numberOfPendingConsumerThreads;

    public Results(JTextField msecToCreateThreadObjects, JTextField msecToStartThreads, JTextField msecForConsumerThreadsProcessing, JTextField msecForProducerThreadsProcessing, JTextField itemsProducedByEachProducer, JTextField itemsConsumedByEachConsumer, JTextField numberOfProcessingProducerThreads, JTextField numberOfFinishedProducerThreads, JTextField numberOfPendingProducerThreads, JTextField numberOfProcessingConsumerThreads, JTextField numberOfFinishedConsumerThreads, JTextField numberOfPendingConsumerThreads) {
        this.msecToCreateThreadObjects = msecToCreateThreadObjects;
        this.msecToStartThreads = msecToStartThreads;
        this.msecForConsumerThreadsProcessing = msecForConsumerThreadsProcessing;
        this.msecForProducerThreadsProcessing = msecForProducerThreadsProcessing;
        this.itemsProducedByEachProducer = itemsProducedByEachProducer;
        this.itemsConsumedByEachConsumer = itemsConsumedByEachConsumer;
        this.numberOfProcessingProducerThreads = numberOfProcessingProducerThreads;
        this.numberOfFinishedProducerThreads = numberOfFinishedProducerThreads;
        this.numberOfPendingProducerThreads = numberOfPendingProducerThreads;
        this.numberOfProcessingConsumerThreads = numberOfProcessingConsumerThreads;
        this.numberOfFinishedConsumerThreads = numberOfFinishedConsumerThreads;
        this.numberOfPendingConsumerThreads = numberOfPendingConsumerThreads;

        this.configureResultsPanel();
    }

    private void configureResultsPanel() {
        // Configuring panel layout
        this.setLayout(new GridBagLayout());

        //
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;

        // 1 column Labels
        JLabel lMsecToCreateThreadObjects = new JLabel("msecToCreateThreadObjects");
        JLabel lMsecToStartThreads = new JLabel("msecToStartThreads");
        JLabel lMsecForConsumerThreadsProcessing = new JLabel("msecForConsumerThreadsProcessing");
        JLabel lMsecForProducerThreadsProcessing = new JLabel("msecForProducerThreadsProcessing");
        JLabel lItemsProducedByEachProducer = new JLabel("itemsProducedByEachProducer");
        JLabel lItemsConsumedByEachConsumer = new JLabel("itemsConsumedByEachConsumer");

        // 1 column

        this.add(lMsecToCreateThreadObjects,c);
        c.gridx=1;
        this.add(this.msecToCreateThreadObjects, c);
        c.gridy++;
        c.gridx=0;
        this.add(lMsecToStartThreads,c);
        c.gridx=1;
        this.add(this.msecToStartThreads, c);
        c.gridx=0;
        c.gridy++;
        this.add(lMsecForConsumerThreadsProcessing,c);
        c.gridx=1;
        this.add(this.msecForConsumerThreadsProcessing, c);
        c.gridy++;
        c.gridx=0;
        this.add(lMsecForProducerThreadsProcessing,c);
        c.gridx=1;
        this.add(this.msecForProducerThreadsProcessing, c);
        c.gridy++;
        c.gridx=0;
        this.add(lItemsProducedByEachProducer,c);
        c.gridx=1;
        this.add(this.itemsProducedByEachProducer, c);
        c.gridy++;
        c.gridx=0;
        this.add(lItemsConsumedByEachConsumer,c);
        c.gridx=1;
        this.add(this.itemsConsumedByEachConsumer, c);

        // 2 column Labels
        JLabel lNumberOfProcessingProducerThreads =new JLabel("numberOfProcessingProducerThreads");
        JLabel lNumberOfFinishedProducerThreads =new JLabel("numberOfFinishedProducerThreads");
        JLabel lNumberOfPendingProducerThreads = new JLabel("numberOfPendingProducerThreads");
        JLabel lNumberOfProcessingConsumerThreads = new JLabel("numberOfProcessingConsumerThreads");
        JLabel lNumberOfFinishedConsumerThreads = new JLabel("numberOfFinishedConsumerThreads");
        JLabel lNumberOfPendingConsumerThreads = new JLabel("numberOfPendingConsumerThreads");



        // 2 column

        c.gridx = 2;
        c.gridy = 0;
        this.add(lNumberOfProcessingProducerThreads,c);
        c.gridx = 3;
        this.add(numberOfProcessingProducerThreads, c);
        c.gridy++;
        c.gridx = 2;
        this.add(lNumberOfFinishedProducerThreads,c);
        c.gridx = 3;
        this.add(numberOfFinishedProducerThreads, c);
        c.gridy++;
        c.gridx = 2;
        this.add(lNumberOfPendingProducerThreads,c);
        c.gridx = 3;
        this.add(numberOfPendingProducerThreads, c);
        c.gridy++;
        c.gridx = 2;
        this.add(numberOfProcessingConsumerThreads,c);
        c.gridx = 3;
        this.add(numberOfProcessingConsumerThreads, c);
        c.gridy++;
        c.gridx = 2;
        this.add(lNumberOfFinishedConsumerThreads,c);
        c.gridx = 3;
        this.add(numberOfFinishedConsumerThreads, c);
        c.gridy++;
        c.gridx = 2;
        this.add(lNumberOfPendingConsumerThreads,c);
        c.gridx = 3;
        this.add(numberOfPendingConsumerThreads, c);
    }
}
