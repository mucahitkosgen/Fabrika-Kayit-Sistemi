import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sec extends JFrame{
    private JPanel sec;
    private JLabel personalLabel;
    private JComboBox personalcomboBox1;
    private JButton devambutton1;
    private JButton okbutton1;

    public sec(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(sec);
       // okbutton1.addActionListener(new ActionListener() {
         //   @Override
           // public void actionPerformed(ActionEvent actionEvent) {

           // }
        //});
        devambutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String a=personalcomboBox1.getSelectedItem().toString();
                if("".equals(a)){
                    JOptionPane.showMessageDialog(null, "Personal seçmeden devam edemezsiniz");
                    return;
                }
                else if("OPERATOR".equals(a)) {
                    operator field = new operator();
                    field.setVisible(true);
                    JFrame frame = new operator("OPERATOR");
                    frame.setSize(700, 700);
                    frame.setVisible(true);
                    setVisible(false);
            }
                else if("DEGERLENDIREN".equals(a)){
                    degerlendiren field = new degerlendiren();
                    field.setVisible(true);
                    JFrame frame = new degerlendiren("DEGERLENDIREN");
                    frame.setSize(700, 700);
                    frame.setVisible(true);
                    setVisible(false);
                }
                else if("ONAY".equals(a)){
                    onay field = new onay();
                    field.setVisible(true);
                    JFrame frame = new onay("Gözetim Muayene Raporu");
                    frame.setSize(700, 700);
                    frame.setVisible(true);
                    setVisible(false);
                }
                else if("MUSTERI".equals(a)){
                    musteri field = new musteri();
                    field.setVisible(true);
                    JFrame frame = new musteri("Gözetim Muayene Raporu");
                    frame.setSize(700, 700);
                    frame.setVisible(true);
                    setVisible(false);
                }
            }
        }
        );}

    public sec() {

    }


    public static void main (String[]args){
            JFrame frame = new sec("Alan Seçim Yeri");
            // frame.setPreferredSize(new Dimension(700, 700));
            //frame.pack();
            frame.setSize(700, 700);
            // frame.setLocationRelativeTo(null);
            //frame.getContentPane().setSize(500,500);
            //frame.pack();
            //frame.setLocationRelativeTo(null);

            frame.setVisible(true);


        }

    }