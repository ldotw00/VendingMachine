import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI extends JFrame{
    public GUI(){
        setTitle("음식주문하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setBackground(Color.gray);
        cp.setLayout(null);

        setSize(1500,1000);

        Font font = new Font("굴림",Font.PLAIN,18);

        a.setBounds(60,100,420,420);
        b.setBounds(540, 100, 420, 420);
        c.setBounds(1020, 100, 420, 420);

        aNumber.setBounds(80,540,350,30);
        bNumber.setBounds(560,540,350,30);
        cNumber.setBounds(1040,540,350,30);

        currentCost.setFont(font);
        currentCost.setBounds(110,620,300,50);

        Total.setFont(font);
        Total.setBounds(110,720,300,50);

        textField1.setBounds(440,620,600,50);
        textField2.setBounds(440,720,600,50);

        button2.setBounds(1080,720,100,50);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(button2,"구매완료되었습니다.","구매완료",JOptionPane.PLAIN_MESSAGE);
            }
        });

        button1.setBounds(1080,620,100,50);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(button1,"금액이 확정되었습니다.","금액확정",JOptionPane.INFORMATION_MESSAGE);
            }
        });



        cp.add(a);
        cp.add(b);
        cp.add(c);
        cp.add(aNumber);
        cp.add(bNumber);
        cp.add(cNumber);
        cp.add(currentCost);
        cp.add(Total);
        cp.add(textField1);
        cp.add(textField2);
        cp.add(button1);
        cp.add(button2);
    }

    private JSpinner aNumber;
    private JSpinner bNumber;
    private JSpinner cNumber;
    private JLabel currentCost;
    private JLabel Total;
    private JPanel a;
    private JPanel b;
    private JPanel c;
    private JPanel Top;
    private JPanel Bottom;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;


    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}
