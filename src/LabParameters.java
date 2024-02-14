import java.util.Random;

public class LabParameters {
    int producers = 200;
    int itemByProducers = 100;
    Boolean productionTimeRandomFixed = true;

    Boolean maxProductionTimeRandomFixed = true;
    int productionTime = new Random().nextInt(100);
    int maxProductionTime = new Random().nextInt(100);
    int consumers = 400;
    int itemConsumedByConsumers = 50;
    Boolean consumeTimeRandomFixed = true;
    Boolean maxConsumeTimeRandomFixed = true;
    int consumeTime = new Random().nextInt(100);
    int maxConsumeTime = new Random().nextInt(100);

    Boolean regionProtection = false;
    Boolean positiveStock = false;
}
