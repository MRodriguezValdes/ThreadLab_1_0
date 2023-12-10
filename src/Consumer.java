import java.util.Random;

public class Consumer implements Runnable {
    private long startTime;
    private long endTime;
    private boolean sync;
    private int consumedQuantity;
    private int timeToSleep;

    private Boolean positiveStock;
    Product product;

    public Consumer(Product product, LabParameters labParameters) {
        this.product = product;
        this.sync = labParameters.regionProtection;
        this.consumedQuantity = labParameters.itemConsumedByCustomer;
        this.timeToSleep = labParameters.maxConsumeTime;
        this.positiveStock = labParameters.positiveStock;    }

    public void setThread() {
        //todo
    }

    @Override
    public void run() {
        this.startTime = System.currentTimeMillis();
        for (int i = 0; i < this.consumedQuantity; i++) {
            this.product.consume(this.sync,positiveStock);

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
