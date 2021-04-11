package sample;

import java.lang.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private CheckBox type1;
    @FXML
    private CheckBox type2;
    @FXML
    private CheckBox type3;
    @FXML
    private Label password;
    @FXML
    private TextField numberOfChars;
    private String pass="";
    private boolean[] typesOfChar = new boolean[3];
    private char[] alphabet = new char[26];
    public void pressButton(ActionEvent e){
        if(type1.isSelected())this.typesOfChar[0]=true;
        else this.typesOfChar[0]=false;
        if(type2.isSelected())this.typesOfChar[1]=true;
        else this.typesOfChar[1]=false;
        if(type3.isSelected())this.typesOfChar[2]=true;
        else this.typesOfChar[2]=false;
        int i=0;
        for( char c = 'a'; c <= 'z'; c++, i++){
            this.alphabet[i]=c;
        }
        this.createPassword();
    }
    public void createPassword(){
        this.pass="";
        for(int i=0;i<Integer.parseInt(this.numberOfChars.getText());i++){
            int nextChar=0;
            for(;;) {
                nextChar = (int) (Math.random() * 3);
                if(this.typesOfChar[nextChar]==true)break;
            }
            if(nextChar==0){
                int whichLetter = (int) (Math.random() * 26);
                this.pass+=this.alphabet[whichLetter];
            }
            else if(nextChar==1){
                int whichLetter = (int) (Math.random() * 26);
                this.pass+=Character.toUpperCase(this.alphabet[whichLetter]);
            }
            else{
                int num = (int) (Math.random() * 10);
                this.pass+=String.valueOf(num);
            }
        }
        this.password.setText(this.pass);
    }
}
