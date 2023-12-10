public class ProtectedCounter {
    private int value;


    public ProtectedCounter() {
        this.value = 0;
    }

    public synchronized void incSync( Boolean positiveStock) {
        if (positiveStock && this.value <= 0) {
            value++;
            notifyAll();
        } else if (!positiveStock) {
            value++;
        }
    }

    public synchronized void decSync(Boolean positiveStock) {
        if (positiveStock && this.value > 0) {
            value--;
        } else if (!positiveStock) {
            value--;
        }else {
            while (this.value<=0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void inc( Boolean positiveStock) {
        if (positiveStock && this.value <= 0) {
            value++;
            notifyAll();
        } else if (!positiveStock) {
            value++;
        }
    }

    public void dec(Boolean positiveStock) {
        if (positiveStock && this.value > 0) {
            value--;
        } else if (!positiveStock) {
            value--;
        }else {
            while (this.value<=0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public int getValue() {
        return value;
    }


}
