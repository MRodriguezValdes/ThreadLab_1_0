public class Consumer implements Runnable {
    Product product;
    LabResults labResults;
    TJTLController controller;
    private long startTime;
    private long endTime;
    private boolean sync;
    private int consumedQuantity;
    private int timeToSleep;
    private Boolean positiveStock;

    public Consumer(Product product, LabParameters labParameters, TJTLController controller) {
        this.product = product;
        this.sync = labParameters.regionProtection;
        this.consumedQuantity = labParameters.itemConsumedByConsumers;
        this.timeToSleep = labParameters.maxConsumeTime;
        this.positiveStock = labParameters.positiveStock;
        this.labResults = controller.getLabResults();
        this.controller = controller;

    }

    public void setThread() {
        //todo
    }

    @Override
    public void run() {
        this.startTime = System.currentTimeMillis();
        this.controller.addActiveConsumerThread(Thread.currentThread());
        this.labResults.numberOfProcessingConsumerThreads++;
        for (int i = 0; i < this.consumedQuantity; i++) {
            this.product.consume(this.sync, positiveStock);
            labResults.itemsConsumedByEachConsumer++;

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        this.labResults.numberOfProcessingConsumerThreads--;
        this.labResults.numberOfFinishedConsumerThreads++;
        this.controller.removeActiveConsumerThread(Thread.currentThread());
        this.labResults.numberOfPendingConsumerThreads= this.controller.getActiveConsumerThreadCount();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
