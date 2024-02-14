public class Producer implements Runnable {
    Product product;
    LabResults labResults;
    TJTLController controller;
    private long startTime;
    private long endTime;
    private boolean sync;
    private int producedQuantity;
    private int timeToSleep;
    private Boolean positiveStock;

    public Producer(Product product, LabParameters labParameters, TJTLController controller) {
        this.producedQuantity = labParameters.itemByProducers;
        this.product = product;
        this.sync = labParameters.regionProtection;
        this.timeToSleep = labParameters.productionTime;
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
        this.labResults.numberOfProcessingProducerThreads++;
        for (int i = 0; i < this.producedQuantity; i++) {
            this.product.produce(this.sync, positiveStock);
            labResults.itemsProducedByEachProducer++;
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        this.labResults.numberOfFinishedProducerThreads++;
        this.labResults.numberOfProcessingProducerThreads--;
        this.labResults.numberOfPendingProducerThreads --;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
