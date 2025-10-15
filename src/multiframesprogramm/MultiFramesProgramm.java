package multiframesprogramm;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MultiFramesProgramm extends Application {

    static Stage stageMain;

    // Новые переменные для хранения ответов
    static String choiceBoxAnswer = ""; // Для типа наушников
    static String listViewAnswer = "";  // Для бренда
    static double sliderAnswer = 1000; // Для цены
    static int spinnerAnswer = 1;     // Для количества

    @Override
    public void start(Stage stage) throws Exception {
        stageMain = stage;
        stage.getIcons().add(new Image("/images/icon.jpg"));
        stage.setScene(new SceneBuilder().getScene("1"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}