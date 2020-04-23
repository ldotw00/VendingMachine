import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

    int sum_change;
    public void calculatechange(int change) {
        int fiveman = 0;
        int oneman = 0;
        int fivechun = 0;
        int onechun = 0;
        int fiveback = 0;
        int oneback = 0;
        int fivesip = 0;
        int onesip = 0;
        sum_change = change;
        while (change >= 50000) {
            change = change - 50000;
            fiveman += 1;
        }
        while (change >= 10000) {
            change = change - 10000;
            oneman += 1;
        }
        while (change >= 5000) {
            change = change - 5000;
            fivechun += 1;
        }
        while (change >= 1000) {
            change = change - 1000;
            onechun += 1;
        }
        while (change >= 500) {
            change = change - 500;
            fiveback += 1;
        }
        while (change >= 100) {
            change = change - 100;
            oneback += 1;
        }
        while (change >= 50) {
            change = change - 50;
            fivesip += 1;
        }
        while (change >= 10) {
            change = change - 10;
            onesip += 1;
        }

        if (sum_change == 0) {
            JOptionPane.showMessageDialog(btnchange, "잔돈은 총 " + sum_change + "원 입니다.\n"
                            + "주문해주셔서 감사합니다!\n"
                    , "잔돈 확인", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (sum_change > 0) {
            JOptionPane.showMessageDialog(btnchange, "잔돈은 총 " + sum_change + "원 입니다.\n"
                            + "===============\n"
                            + print_change(fiveman, 50000)
                            + print_change(oneman, 10000)
                            + print_change(fivechun, 5000)
                            + print_change(onechun, 1000)
                            + print_change(fiveback, 500)
                            + print_change(oneback, 100)
                            + print_change(fivesip, 50)
                            + print_change(onesip, 10)
                            + "===============\n"
                    , "잔돈 확인", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(btnpurchase, "돈이 부족합니다.", "구매 오류", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public String print_change(int unit, int num){
        if(unit != 0)
            return (num + "원 X " + unit + "장\n");
        else
            return "";
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
        txttotal.setFont(new Font("굴림", Font.BOLD, 30));

        txtinput = new JTextField("",10);
        IntegerDocument integeronly2 = new IntegerDocument ();
        txtinput.setDocument(integeronly2);
        txtinput.setFont(new Font("굴림", Font.BOLD, 30));

        btnpurchase = new JButton("구매하기");
        btnchange = new JButton("잔돈확인");

        btnpurchase.setFont(new Font("굴림", Font.BOLD, 30));
        btnchange.setFont(new Font("굴림", Font.BOLD, 30));

        ImageIcon menu = new ImageIcon(getClass().getResource("image/set.png"));
        JLabel img = new JLabel(menu);
        pn0.add(img);

        SpinnerNumberModel value1 = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerNumberModel value2 = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerNumberModel value3 = new SpinnerNumberModel(0, 0, 10, 1);

        JSpinner spin1 = new JSpinner(value1);
        JSpinner spin2 = new JSpinner(value2);
        JSpinner spin3 = new JSpinner(value3);

        JComponent field1 = ((JSpinner.DefaultEditor) spin1.getEditor());
        Dimension prefSize1 = field1.getPreferredSize();
        prefSize1 = new Dimension(200, prefSize1.height);
        field1.setPreferredSize(prefSize1);

        JComponent field2 = ((JSpinner.DefaultEditor) spin2.getEditor());
        Dimension prefSize2 = field1.getPreferredSize();
        prefSize2 = new Dimension(200, prefSize2.height);
        field2.setPreferredSize(prefSize2);

        JComponent field3 = ((JSpinner.DefaultEditor) spin3.getEditor());
        Dimension prefSize3 = field1.getPreferredSize();
        prefSize3 = new Dimension(200, prefSize3.height);
        field3.setPreferredSize(prefSize3);

        pn1.add(spin1);
        spin1.setFont(new Font("굴림", Font.BOLD, 20));

        pn1.add(spin2);
        spin2.setFont(new Font("굴림", Font.BOLD, 20));

        pn1.add(spin3);
        spin3.setFont(new Font("굴림", Font.BOLD, 20));

        JLabel space = new JLabel("                        " +
                                    "                           " +
                                    "                           " +
                                    "                           " +
                                    "                           ");
        space.setFont(new Font("굴림", Font.BOLD, 15));
        pn1.add(space);

        spin1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner spin1 = (JSpinner) e.getSource();
                int amount1 = 5500 * (Integer)spin1.getValue();
            }
        });

        spin2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner spin2 = (JSpinner) e.getSource();
                int amount2 = 6000 * (Integer)spin2.getValue();
            }
        });

        spin3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner spin3 = (JSpinner) e.getSource();
                int amount3 = 2000 * (Integer)spin3.getValue();
            }
        });

        JLabel text1 = new JLabel("구매 금액 :");
        text1.setFont(new Font("굴림", Font.BOLD, 30));

        pn1.add(text1);
        pn1.add(txttotal);
        pn1.add(btnpurchase);

        JLabel text2 = new JLabel("투입 금액 :");
        text2.setFont(new Font("굴림", Font.BOLD, 30));

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
        frame.setBounds(350,150,700,460);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
