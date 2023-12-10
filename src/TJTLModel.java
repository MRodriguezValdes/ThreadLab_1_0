public class TJTLModel {
    LabParameters actualConfig;
    LabParameters defaultConfig;

    LabResults labResults;
    Product product;
    Thread[] consumers;
    Thread[] producers;

    public TJTLModel(LabParameters actualConfig) {
        this.product = new Product("Hamburger");
        this.actualConfig = actualConfig;
        this.defaultConfig = new LabParameters();
        this.labResults = new LabResults();
    }

    public void play() {
        consumers = new Thread[actualConfig.consumers];
        producers = new Thread[actualConfig.producers];
        for (int i = 0; i < consumers.length; i++) {
            Thread thread = new Thread(new Consumer(product, actualConfig));
            this.consumers[i] = thread;
            thread.start();
        }
        for (int i = 0; i < producers.length; i++) {
            Thread thread = new Thread(new Producer(product, actualConfig));
            this.producers[i] = thread;
            thread.start();
        }
    }

    public void resetConfig() {
        this.product = new Product("Hamburger");
        this.actualConfig = defaultConfig;
    }

    public LabResults getResults() {
        return new LabResults();
    }

    public void applyConfig(LabParameters labParameters) {
        this.actualConfig = labParameters;
    }


}
