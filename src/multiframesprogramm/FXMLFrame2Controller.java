package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import static multiframesprogramm.MultiFramesProgramm.choiceBoxAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame2Controller implements Initializable {

    private final ObservableList<String> headphoneTypes = FXCollections.observableArrayList(
            "Внутриканальные",
            "Накладные",
            "Полноразмерные",
            "С костной проводимостью"
    );

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label choiceBoxLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Тип наушников");
        choiceBox.setItems(headphoneTypes);
        choiceBox.setValue(choiceBoxAnswer.isEmpty() ? headphoneTypes.get(0) : choiceBoxAnswer);
        updateLabel();

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel();
        });
    }

    private void updateLabel() {
        String selected = choiceBox.getValue();
        choiceBoxAnswer = selected;
        choiceBoxLabel.setText("Выбрано: " + selected);
    }

    @FXML
    private void frame2backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("1"));
    }

    @FXML
    private void frame2nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("3"));
    }
}