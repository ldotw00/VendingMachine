import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendingMachine extends JTable {

    JTextField txttotal, txtinput;
    JButton btnpurchase, btnchange;

    public VendingMachine() {
        layouts();
    }

    public void calculatechange(int change) {
        int fiveman = 0; int oneman = 0;
        int fivechun = 0; int onechun = 0;
        int fiveback = 0; int oneback = 0;
        int fivesip = 0; int onesip = 0;
        int sum_change = change;
        while (change >= 50000) {
            change = change - 50000;
            fiveman += 1; }
        while (change >= 10000) {
            change = change - 10000;
            oneman += 1; }
        while (change >= 5000) {
            change = change - 5000;
            fivechun += 1; }
        while (change >= 1000) {
            change = change - 1000;
            onechun += 1; }
        while (change >= 500) {
            change = change - 500;
            fiveback += 1; }
        while (change >= 100) {
            change = change - 100;
            oneback += 1; }
        while (change >= 50) {
            change = change - 50;
            fivesip += 1; }
        while (change >= 10) {
            change = change - 10;
            onesip += 1; }
        JOptionPane.showMessageDialog(btnchange,"잔돈은 총 " +sum_change+ "원 입니다.\n"
                        + "===============\n"
                        + "        50000원 X " + fiveman + "장\n"
                        + "        10000원 X " + oneman + "장\n"
                        + "        5000원   X " + fivechun + "장\n"
                        + "        1000원   X " + onechun + "장\n"
                        + "        500원     X " + fiveback + "개\n"
                        + "        100원     X " + oneback + "개\n"
                        + "        50원       X " + fivesip + "개\n"
                        + "        10원       X " + onesip + "개\n"
                        + "===============\n"
                , "잔돈 확인",JOptionPane.INFORMATION_MESSAGE);

    }

    public class IntegerDocument extends PlainDocument {
        int currentValue = 0;
        public IntegerDocument() {
        }
        public int getValue() {
            return currentValue;
        }
        public void insertString(int offset, String string,
                                 AttributeSet attributes) throws BadLocationException {
            if (string == null) {
                return;
            } else {
                String newValue;
                int length = getLength();
                if (length == 0) {
                    newValue = string;
                } else {
                    String currentContent = getText(0, length);
                    StringBuffer currentBuffer =
                            new StringBuffer(currentContent);
                    currentBuffer.insert(offset, string);
                    newValue = currentBuffer.toString();
                }
                currentValue = checkInput(newValue, offset);
                super.insertString(offset, string, attributes);
            }
        }
        public void remove(int offset, int length)
                throws BadLocationException {
            int currentLength = getLength();
            String currentContent = getText(0, currentLength);
            String before = currentContent.substring(0, offset);
            String after = currentContent.substring(length+offset,
                    currentLength);
            String newValue = before + after;
            currentValue = checkInput(newValue, offset);
            super.remove(offset, length);
        }
        public int checkInput(String proposedValue, int offset)
                throws BadLocationException {
            if (proposedValue.length() > 0) {
                try {
                    int newValue = Integer.parseInt(proposedValue);
                    return newValue;
                } catch (NumberFormatException e) {
                    throw new BadLocationException(proposedValue, offset);
                }
            } else {
                return 0;
            }
        }
    }

    public void layouts() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel order = new JPanel(new GridLayout(3, 1));

        JPanel pn0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        txttotal = new JTextField("",10);
        IntegerDocument integeronly = new IntegerDocument ();
        txttotal.setDocument(integeronly);

        txtinput = new JTextField("",10);
        IntegerDocument integeronly2 = new IntegerDocument ();
        txtinput.setDocument(integeronly2);

        txttotal.setFont(new Font("Arial", Font.BOLD, 30));
        txtinput.setFont(new Font("Arial", Font.BOLD, 30));

        btnpurchase = new JButton("구매하기");
        btnchange = new JButton("잔돈확인");

        btnpurchase.setFont(new Font("Arial", Font.BOLD, 30));
        btnchange.setFont(new Font("Arial", Font.BOLD, 30));

        ImageIcon menu = new ImageIcon(getClass().getResource("image/set.png"));
        JLabel img = new JLabel(menu);
        pn0.add(img);

        JLabel text1 = new JLabel("구매 금액 :");
        text1.setFont(new Font("Arial", Font.BOLD, 30));

        pn1.add(text1);
        pn1.add(txttotal);
        pn1.add(btnpurchase);

        JLabel text2 = new JLabel("투입 금액 :");
        text2.setFont(new Font("Arial", Font.BOLD, 30));

        pn1.add(text2);
        pn1.add(txtinput);
        pn1.add(btnchange);

        order.add(pn0);
        order.add(pn1);
        this.add(order);

        /*
        JPanel bottomPn1 = new JPanel();
        bottomPn1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        bottomPn1.add(btnpurchase);
        bottomPn1.add(btnchange);

        this.add(bottomPn1);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         */
        btnchange.setEnabled(false);
        btnpurchase.addMouseListener(new MouseAdapter() {
            int savedchange;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int savedtotal = Integer.parseInt(txttotal.getText());
                int savedinput = Integer.parseInt(txtinput.getText());
                savedchange = savedinput - savedtotal;
                if (savedchange >= 0) {
                    JOptionPane.showMessageDialog(btnpurchase, "구매 완료되었습니다.\n잔돈을 확인해주세요.", "구매 완료", JOptionPane.PLAIN_MESSAGE);
                    btnchange.setEnabled(true);
                    btnchange.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            calculatechange(savedchange);
                        }
                    });


                } else {
                    JOptionPane.showMessageDialog(btnpurchase, "돈이 부족합니다.", "구매 오류", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        VendingMachine vendingmachine=new VendingMachine();
        JFrame frame=new JFrame("음식 주문 자판기");
        frame.getContentPane().add(vendingmachine);
        frame.setBounds(200,150,700,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}