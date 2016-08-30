import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Label extends JLabel{

    public String name;

    public Label(String str){
        super(str);
        this.name = str;
        this.setHorizontalAlignment(JLabel.RIGHT);
        this.setPreferredSize(new Dimension(380,50));
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(10,10,10,10));
    }

}
