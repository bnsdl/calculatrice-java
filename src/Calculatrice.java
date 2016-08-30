import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculatrice {

    private JPanel container = new JPanel();
    private Label screen = new Label("0");
    private String symbolArr[] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".",
            "=", "+", "-", "/", "*", "C"},
            operator = "";
    private Dimension dim = new Dimension(60, 40);
    private double number;
    private boolean opClick = false,
            update = false;


    public Calculatrice() {

        Window window = new Window();

        initCalculatrice();
        window.setContentPane(container);
        window.setVisible(true);
    }

    private void initCalculatrice() {

        Button button;

        container.add(screen);

        for (int i = 0; i < symbolArr.length; i++) {
            button = new Button(symbolArr[i]);
            button.setPreferredSize(dim);
            switch (i) {
                case 11:
                    button.addActionListener(new EqualListener());
                    break;
                case 12:
                    button.addActionListener(new PlusListener());
                    break;
                case 13:
                    button.addActionListener(new SubstractListener());
                    break;
                case 14:
                    button.addActionListener(new DivListener());
                    break;
                case 15:
                    button.addActionListener(new MultiListener());
                    break;
                case 16:
                    button.addActionListener(new ResetListener());
                    break;
                default:
                    button.addActionListener(new NumberListener());
                    break;

            }
            container.add(button);
        }

    }

    private void calcul(){

        switch (operator){
            case "+" :
                number += Double.valueOf(screen.getText());
                break;
            case "-" :
                number -= Double.valueOf(screen.getText());
                break;
            case "*" :
                number *= Double.valueOf(screen.getText());
                break;
            case "/" :
                try{
                    number /= Double.valueOf(screen.getText());
                    screen.setText(String.valueOf(number));
                } catch(ArithmeticException e) {
                    screen.setText("0");
                }
                break;
            default :
                break;
        }

    }

    class NumberListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String str = ((Button)e.getSource()).getText();
            if (update) {
                update = false;
            } else {
                if (!screen.getText().equals("0"))
                    str = screen.getText() + str;
            }
            screen.setText(str);
        }
    }

    class PlusListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            if(opClick){
                calcul();
                screen.setText(String.valueOf(number));
            }
            else{
                number = Double.valueOf(screen.getText());
                opClick = true;
            }
            operator = "+";
            update = true;
        }
    }

    class SubstractListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            if(opClick){
                calcul();
                screen.setText(String.valueOf(number));
            }
            else{
                number = Double.valueOf(screen.getText());
                opClick = true;
            }
            operator = "-";
            update = true;
        }
    }

    class MultiListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            if(opClick){
                calcul();
                screen.setText(String.valueOf(number));
            }
            else{
                number = Double.valueOf(screen.getText());
                opClick = true;
            }
            operator = "*";
            update = true;
        }
    }

    class DivListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            if(opClick){
                calcul();
                screen.setText(String.valueOf(number));
            }
            else{
                number = Double.valueOf(screen.getText());
                opClick = true;
            }
            operator = "/";
            update = true;
        }
    }

    class EqualListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            calcul();
            screen.setText(String.valueOf(number));
            update = true;
            opClick = false;
        }
    }

    class ResetListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            screen.setText("0");
            update = true;
            opClick = false;
            number = 0;
            operator = "";
        }
    }
}
