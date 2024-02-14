public class TJTLModel {
    LabParameters actualConfig;
    LabParameters defaultConfig;
    Product product;
    Thread[] consumers;
    Thread[] producers;
    LabResults labResults;
    TJTLController controller;
    public TJTLModel(TJTLController controller) {
        this.product = new Product("Hamburger");
        this.actualConfig = controller.labParameters;
        this.defaultConfig = new LabParameters();
        this.labResults= controller.getLabResults();
        this.controller=controller;
    }

    public void play() {
        this.controller.stopActiveThreads();
        this.resetLabResults();
        long startCreatingObjectsTime = System.currentTimeMillis();
        consumers = new Thread[actualConfig.consumers];
        producers = new Thread[actualConfig.producers];
        for (int i = 0; i < consumers.length; i++) {
            Thread thread = new Thread(new Consumer(product, actualConfig,controller));
            this.consumers[i] = thread;
            thread.start();
        }
        for (int i = 0; i < producers.length; i++) {
            Thread thread = new Thread(new Producer(product, actualConfig,controller));
            this.producers[i] = thread;
            thread.start();
        }

        long endCreatingObjectsTime = System.currentTimeMillis();
        labResults.msecToCreateThreadObjects = endCreatingObjectsTime - startCreatingObjectsTime;
//        try {
//            for (Thread consumer : consumers) {
//                consumer.join();
//            }
//            for (Thread producer : producers) {
//                producer.join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        labResults.msecToStartThreads = System.currentTimeMillis() - endCreatingObjectsTime;
    }

    public void resetConfig() {
        this.product = new Product("Hamburger");
        this.actualConfig = defaultConfig;
    }
    public void resetLabResults(){
        this.labResults.msecToCreateThreadObjects = 0.0;
        this.labResults.msecToStartThreads = 0.0;
        this.labResults.msecForConsumerThreadsProcessing = 0.0;
        this.labResults.msecForProducerThreadsProcessing = 0.0;
        this.labResults.itemsProducedByEachProducer = 0;
        this.labResults.itemsConsumedByEachConsumer = 0;
        this.labResults.numberOfProcessingProducerThreads = 0;
        this.labResults.numberOfFinishedProducerThreads = 0;
        this.labResults.numberOfPendingProducerThreads = 0;
        this.labResults.numberOfProcessingConsumerThreads = 0;
        this.labResults.numberOfFinishedConsumerThreads = 0;
        this.labResults.numberOfPendingConsumerThreads = 0;
    }
    public LabResults getResults() {
        return new LabResults();
    }

    public void applyConfig(LabParameters labParameters) {
        this.actualConfig = labParameters;
    }


}
