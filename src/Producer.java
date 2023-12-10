import java.util.Random;

public class Producer implements Runnable {
    private long startTime;
    private long endTime;
    private boolean sync;
    private int producedQuantity;

    private int timeToSleep;

    private Boolean positiveStock;
    Product product;

    public Producer(Product product, LabParameters labParameters) {
        this.producedQuantity = labParameters.itemByProducers;
        this.product = product;
        this.sync = labParameters.regionProtection;
        this.timeToSleep = labParameters.maxProductionTime;
        this.positiveStock = labParameters.positiveStock;
    }

    public void setThread() {
        //todo
    }

    @Override
    public void run() {

        this.startTime = System.currentTimeMillis();
        for (int i = 0; i < this.producedQuantity; i++) {
            this.product.produce(this.sync,positiveStock);

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
