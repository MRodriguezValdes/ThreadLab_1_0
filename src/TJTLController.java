import java.util.ArrayList;
import java.util.List;

public class TJTLController {
    LabParameters labParameters;
    LabResults labResults;
    TJTLView view;
    TJTLModel model;
    List<Thread> activeProducerThreads; // Lista para almacenar los hilos activos
    List<Thread> activeConsumerThreads;

    public TJTLController() {
        this.labParameters = new LabParameters();
        this.labResults = new LabResults();
        this.model = new TJTLModel(this);
        this.view = new TJTLView(this);
        this.activeProducerThreads = new ArrayList<>();
        this.activeConsumerThreads = new ArrayList<>();
    }

    public static void main(String[] args) {
        TJTLController controller = new TJTLController();
        Thread thread = new Thread(controller.view);
        thread.start();
    }

    public void play() {
        model.play();
    }

    // Agrega un método para obtener las estadísticas actualizadas
    public LabResults getLabResults() {
        return labResults;
    }

    // Método para añadir un hilo a la lista de hilos activos
    public synchronized void addActiveProducerThread(Thread thread) {
        activeProducerThreads.add(thread);
    }

    // Método para eliminar un hilo de la lista de hilos activos
    public synchronized void removeActiveProducerThread(Thread thread) {
        activeProducerThreads.remove(thread);
    }

    // Método para obtener el número de hilos activos (pendientes)
    public synchronized int getActiveProducerThreadCount() {
        return activeProducerThreads.size();
    }

    public synchronized void addActiveConsumerThread(Thread thread) {
        activeProducerThreads.add(thread);
    }

    // Método para eliminar un hilo de la lista de hilos activos
    public synchronized void removeActiveConsumerThread(Thread thread) {
        activeProducerThreads.remove(thread);
    }

    // Método para obtener el número de hilos activos (pendientes)
    public synchronized int getActiveConsumerThreadCount() {
        return activeProducerThreads.size();
    }

    public synchronized void stopActiveThreads(){
        for (Thread activeProducerThread : activeProducerThreads) {
            activeProducerThread.interrupt();
        }
        activeProducerThreads.clear();

        for (Thread activeConsumerThread : activeConsumerThreads) {
            activeConsumerThread.interrupt();
        }
        activeConsumerThreads.clear();
    }
}