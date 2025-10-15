package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import static multiframesprogramm.MultiFramesProgramm.spinnerAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame5Controller implements Initializable {

    @FXML
    private Label spinnerLabel;
    @FXML
    private Spinner<Integer> spinner;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Количество");

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, spinnerAnswer);
        spinner.setValueFactory(valueFactory);

        updateLabel();

        spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel();
        });
    }

    private void updateLabel() {
        spinnerAnswer = spinner.getValue();
        spinnerLabel.setText("Выбрано: " + spinnerAnswer);
    }

    @FXML
    private void frame5backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("4"));
    }

    @FXML
    private void frame5nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("6"));
    }
}