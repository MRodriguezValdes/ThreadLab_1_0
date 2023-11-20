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

    private void configureResultsPanel(){
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
        // 1 column
        this.add(this.msecToCreateThreadObjects,c);
        c.gridy++;
        this.add(this.msecToStartThreads,c);
        c.gridy++;
        this.add(this.msecForConsumerThreadsProcessing,c);
        c.gridy++;
        this.add(this.msecForProducerThreadsProcessing,c);
        c.gridy++;
        this.add(this.itemsProducedByEachProducer,c);
        c.gridy++;
        this.add(this.itemsConsumedByEachConsumer,c);

        // 2 column

        c.gridx = 1;
        c.gridy = 0;

        this.add(numberOfProcessingProducerThreads,c);
        c.gridy++;
        this.add(numberOfFinishedProducerThreads,c);
        c.gridy++;
        this.add(numberOfPendingProducerThreads,c);
        c.gridy++;
        this.add(numberOfProcessingConsumerThreads,c);
        c.gridy++;
        this.add(numberOfFinishedConsumerThreads,c);
        c.gridy++;
        this.add(numberOfPendingConsumerThreads,c);
    }
}
