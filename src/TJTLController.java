import java.util.ArrayList;
import java.util.List;

public class TJTLController {
    LabParameters labParameters;
    LabResults labResults;
    TJTLView view;
    TJTLModel model;

    public TJTLController() {
        this.labParameters = new LabParameters();
        this.labResults = new LabResults();
        this.model = new TJTLModel(this);
        this.view = new TJTLView(this);
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

}