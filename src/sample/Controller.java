package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    double data;
    Operation op;
    ArrayList<Button> list = new ArrayList<>();

    @FXML
    private TextField display;

    @FXML
    private Button zero,one,two,three,four,five,six,seven,eight,nine,equal,clear,plus,minus,divide,multiply;

    @FXML
    private void onCloseAction(ActionEvent event) {
        Platform.exit();
    }


    @FXML
    private void onNumberAction(ActionEvent event) {
        if(event.getSource()==zero){
            display.setText(display.getText()+"0");
        }
        else if(event.getSource()==one){
            display.setText(display.getText()+"1");
        }
        else if(event.getSource()==two){
            display.setText(display.getText()+"2");
        }
        else if(event.getSource()==three){
            display.setText(display.getText()+"3");
        }
        else if(event.getSource()==four){
            display.setText(display.getText()+"4");
        }
        else if(event.getSource()==five){
            display.setText(display.getText()+"5");
        }
        else if(event.getSource()==six){
            display.setText(display.getText()+"6");
        }
        else if(event.getSource()==seven){
            display.setText(display.getText()+"7");
        }
        else if(event.getSource()==eight){
            display.setText(display.getText()+"8");
        }
        else if(event.getSource()==nine) {
            display.setText(display.getText() + "9");
        }
    }

    @FXML
    private void onButtonAction(ActionEvent event){
        if(event.getSource()==clear){
            display.setText("");
            op=null;
        }
        else if(event.getSource()==plus){
            data = Double.parseDouble(display.getText());
            display.setText("");
             op = Operation.ADDITION;
        }
        else if(event.getSource()==minus){
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.SUBTRACTION;
        }
        else if(event.getSource()==multiply){
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.MULTIPLICATION;
        }
        else if(event.getSource()==divide){
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.DIVISION;
        }
        else if(event.getSource()==equal){
            double secondNumber  = Double.parseDouble(display.getText());
            if(op==Operation.ADDITION){
                double result = data+secondNumber;
                display.setText(String.valueOf(result));
            }
            else if(op==Operation.SUBTRACTION){
                double result = data-secondNumber;
                display.setText(String.valueOf(result));
            }
            else if(op==Operation.MULTIPLICATION){
                double result = data*secondNumber;
                display.setText(String.valueOf(result));
            }
            else if(op==Operation.DIVISION){
                try{
                    double result = data/secondNumber;
                    display.setText(String.valueOf(result));
                }
                catch (Exception e){
                    display.setText("Error !");
                }
            }
            else{
                display.setText(display.getText());
            }
        }
    }

    @FXML
    private void onEnableAction(ActionEvent event){
        clear.setDisable(false);
    }

    @FXML
    private void onDisableAction(ActionEvent event){
        clear.setDisable(true);
    }

    @FXML
    private void onDarkStyle(ActionEvent event){
        for(Button btn:list){
            btn.setStyle("-fx-background-color: black;"+"-fx-text-fill: white;"+"-fx-border-width:2px;"+"-fx-border-color: white;");
        }
    }

    @FXML
    private void onLightStyle(ActionEvent event){
        for(Button btn:list){
            btn.setStyle("-fx-background-color: whitesmoke;"+"-fx-text-fill: black;"+"-fx-border-width:1px;"+"-fx-border-color: black;");
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        display.setEditable(false);

        list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
        list.add(equal);
        list.add(clear);
        list.add(plus);
        list.add(minus);
        list.add(multiply);
        list.add(divide);





    }
    enum Operation{
        ADDITION,MULTIPLICATION,SUBTRACTION,DIVISION;
    }

}
