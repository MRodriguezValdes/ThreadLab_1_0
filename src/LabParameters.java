import javax.swing.*;
import java.util.Random;

public class LabParameters{
    int producers= 200;
    int itemByProducers=100;
    Boolean productionTimeRandomFixed = true;
    int maxProductionTime = new Random().nextInt(100);
    int consumers = 400;
    int itemConsumedByCustomer = 50;
    Boolean consumeTimeRandomFixed = true;
    int maxConsumeTime=new Random().nextInt(100);

    Boolean regionProtection = false;
    Boolean positiveStock = false;
}
