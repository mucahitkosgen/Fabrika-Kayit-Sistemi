import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class yonetici extends JFrame {
    private JPanel yonetici;
    private JLabel yoneticiisimLabel;
    private JTextField yoneticiisimtextField1;
    private JLabel sıfreLabel;
    private JLabel sıfreLable;
    private JButton girisbutton1;
    private JPasswordField sıfrepasswordField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton devambutton1;


    public static Connection connect = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public static String user = "root", pass = "Kule1845";
    public yonetici(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(yonetici);

        JLabel label=new JLabel("yoneticiisim");

        girisbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=yoneticiisimtextField1.getText();
                String y=sıfrepasswordField1.getText();
                if (x.equalsIgnoreCase("Mücahit") && y.equalsIgnoreCase("KURUM")) {
                    sec field=new sec();
                    field.setVisible(true);
                    JFrame frame = new sec("Gözetim Muayene Raporu");
                    frame.setSize(700,700);
                    frame.setVisible(true);

                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız");
                }


            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new yonetici("Yönetici giriş");
        frame.setSize(700,700);
        frame.setVisible(true);
    }}


