package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import static multiframesprogramm.MultiFramesProgramm.listViewAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame3Controller implements Initializable {

    private final ObservableList<String> brands = FXCollections.observableArrayList(
            "Sony", "Sennheiser", "JBL", "Apple", "Samsung", "Marshall", "Audio-Technica"
    );

    @FXML
    private Label listViewLabel;
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Производитель");
        listView.setItems(brands);

        if (listViewAnswer.isEmpty()) {
            listView.getSelectionModel().selectFirst();
        } else {
            listView.getSelectionModel().select(listViewAnswer);
        }
        updateLabel();

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel();
        });
    }

    private void updateLabel() {
        String selected = listView.getSelectionModel().getSelectedItem();
        listViewAnswer = selected;
        listViewLabel.setText("Выбрано: " + selected);
    }

    @FXML
    private void frame3backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("2"));
    }

    @FXML
    private void frame3nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("4"));
    }
}