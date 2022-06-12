package Controlls;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.Optional;

public class controlls {
    @FXML
    protected Button one;
    @FXML
    protected Button two;
    @FXML
    protected Button three;
    @FXML
    protected Button four;
    @FXML
    protected Button five;
    @FXML
    protected Button six;
    @FXML
    protected Button seven;
    @FXML
    protected Button eight;
    @FXML
    protected Button nine;
    @FXML
    protected Button zero;
    @FXML
    protected Button point;
    @FXML
    protected Button delete;
    @FXML
    protected Text life;
    @FXML
    protected Text score;
    @FXML
    protected ImageView cele;
    @FXML
    protected TextArea disPlay;

    private StringBuilder save = new StringBuilder();
    final String pi = "3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949";
    private int index = 0;
    private int scor = 0;

    @FXML
    private void num0() {
        check('0');
    }

    @FXML
    private void num1() {
        check('1');
    }

    @FXML
    private void num2() {
        check('2');
    }

    @FXML
    private void num3() {
        check('3');
    }

    @FXML
    private void num4() {
        check('4');
    }

    @FXML
    private void num5() {
        check('5');
    }

    @FXML
    private void num6() {
        check('6');
    }

    @FXML
    private void num7() {
        check('7');
    }

    @FXML
    private void num8() {
        check('8');
    }

    @FXML
    private void num9() {
        check('9');
    }

    @FXML
    private void numPoint() {
        if (index == 1) {
            index++;
            save.append('.');
            disPlay.setText(save.toString());
            point.setDisable(true);
        }
    }

    //Delete method
    @FXML
    private void delete() {
        if (save.charAt(save.length() - 1) != '.') {
            try {
                if (index > 0) {
                    index--;
                }
                scor = scor - 5;
                score.setText(String.valueOf(scor));
                save.deleteCharAt(save.length() - 1);
                disPlay.setText(save.toString());
            } catch (StringIndexOutOfBoundsException exception) {
            }
        }
    }

    //Check if the input is right, otherwise do some game rules
    private void check(char x) {
        cele.setVisible(false);
        if (pi.charAt(index) == x) {
            index++;
            scor = scor + 5;
            save.append(x);
            disPlay.setText(save.toString());
            score.setText(String.valueOf(scor));
            originalColor();
            if (scor % 50 == 0 && scor > 0) {
                int lifes = Integer.parseInt(life.getText());
                life.setText(String.valueOf(lifes + 1));
                cele.setVisible(true);
            }
        } else {
            wrongBut(x);
            int lifes = Integer.parseInt(life.getText());
            life.setText(String.valueOf(lifes - 1));
            if (lifes == 1) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText("GAME OVER, Your score is " + scor);
                alert.setContentText("Do you want to play again?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    life.setText(String.valueOf(3));
                    scor = 0;
                    index = 0;
                    point.setDisable(false);
                    originalColor();
                    score.setText(String.valueOf(scor));
                    save = new StringBuilder();
                    disPlay.setText(save.toString());
                } else if (result.get() == ButtonType.CANCEL) {
                    System.exit(0);
                }
            }
        }
    }

    //Set the original background to the button
    private void originalColor() {
        one.setStyle("-fx-background-color: #54524b; ");
        two.setStyle("-fx-background-color: #54524b; ");
        three.setStyle("-fx-background-color: #54524b; ");
        four.setStyle("-fx-background-color: #54524b; ");
        five.setStyle("-fx-background-color: #54524b; ");
        six.setStyle("-fx-background-color: #54524b; ");
        seven.setStyle("-fx-background-color: #54524b; ");
        eight.setStyle("-fx-background-color: #54524b; ");
        nine.setStyle("-fx-background-color: #54524b; ");
        zero.setStyle("-fx-background-color: #54524b; ");
    }

    //Set background to the wrong button and to the right button
    private void wrongBut(char x) {
        if (x == '0') zero.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '1') one.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '2') two.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '3') three.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '4') four.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '5') five.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '6') six.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '7') seven.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '8') eight.setStyle("-fx-background-color: #f75d3e; ");
        if (x == '9') nine.setStyle("-fx-background-color: #f75d3e; ");
        if (pi.charAt(index) == '0') zero.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '1') one.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '2') two.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '3') three.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '4') four.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '5') five.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '6') six.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '7') seven.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '8') eight.setStyle("-fx-background-color: #3bed6b; ");
        if (pi.charAt(index) == '9') nine.setStyle("-fx-background-color: #3bed6b; ");
    }
}
