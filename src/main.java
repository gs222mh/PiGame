import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {
    static Stage classStage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        classStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/pi.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.getIcons().add(new Image("images/pi.png"));
        stage.setTitle("500 Digits of Pi");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}