import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class muayenesonucları extends JFrame{
    private JPanel muayenesonucları;
    private JLabel serinoLabel;
    private JTextField serinotextField1;
    private JLabel kaynaknoLabel;
    private JTextField kaynaknotextField1;
    private JLabel kontroluzunluguLabel;
    private JTextField kontroluzunlugutextField1;
    private JLabel kaynakyonLabel;
    private JButton okbutton1;
    private JButton silbutton1;
    private JFormattedTextField kaynakyonTextField1;
    private JButton guncellebutton1;
    private JLabel kalinlikLabel;
    private JTextField kalinliktextField1;
    private JLabel capLabel;
    private JTextField captextField1;
    private JLabel hatatipiLabel;
    private JTextField hatatipitextField1;
    private JLabel hataninyeriLabel;
    private JTextField hataninyeritextField1;
    private JLabel sonucLabel;
    private JComboBox sonuccomboBox1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton ExportforAllExcelbutton1;
    private JButton devambutton1;
    private JTextField sonuctextField1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayenesonucları(String title) {
        super(title);
        connect = database.getConnection();
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayenesonucları);


        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a = kaynakyonTextField1.getText();
                String b = kalinliktextField1.getText();
                String c = captextField1.getText();
                String d = hatatipitextField1.getText();
                String f = hataninyeritextField1.getText();
                String g = sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, g);

                try {

                    statement.executeUpdate("DELETE FROM muayenesonucları where serino='" + x + "'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });



        devambutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a = kaynakyonTextField1.getText();
                String b = kalinliktextField1.getText();
                String c = captextField1.getText();
                String d = hatatipitextField1.getText();
                String f = hataninyeritextField1.getText();
                String g = sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, g);

                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Seri no boş geçilemez");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Kaynak no boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Kontrol uzunluğu boş geçemezsiniz");
                    return;
                } else if ("".equals(a)) {
                    JOptionPane.showMessageDialog(null, "Kaynak yon boş geçemezsin");
                    return;
                } else if ("".equals(b)) {
                    JOptionPane.showMessageDialog(null, "Kalınlık boş geçemezsiniz");
                    return;
                } else if (g.equalsIgnoreCase("RED")) {
                    if ("".equals(d)) {
                        JOptionPane.showMessageDialog(null, "Sonuç RED ise hata tipini boş geçemezsin");

                        return;
                    } else if ("".equals(f)) {
                        JOptionPane.showMessageDialog(null, "Sonuç RED ise hata yerini boş geçemezsin");
                        return;
                    }
                    sec field = new sec();
                    field.setVisible(true);
                    JFrame frame = new sec("PERSONAL SEC");
                    frame.setSize(700, 700);
                    frame.setVisible(true);

                    setVisible(false);
                }

                else {
                        sec field = new sec();
                        field.setVisible(true);
                        JFrame frame = new sec("PERSONAL SEC");
                        frame.setSize(700, 700);
                        frame.setVisible(true);

                        setVisible(false);

                    }

            }});
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a= kaynakyonTextField1.getText();
                String b=kalinliktextField1.getText();
                String c=captextField1.getText();
                String d=hatatipitextField1.getText();
                String f=hataninyeritextField1.getText();
                String g=sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);

                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Seri no boş geçilemez");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Kaynak no boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Kontrol uzunluğu boş geçemezsiniz");
                    return;
                }
                else if("".equals(a)){
                    JOptionPane.showMessageDialog(null, "Kaynak yon boş geçemezsin");
                    return;
                }
                else if("".equals(b)){
                    JOptionPane.showMessageDialog(null, "Kalınlık boş geçemezsiniz");
                    return;
                }
                else if (g.equalsIgnoreCase("RED")){
                     if("".equals(d)  ){
                         JOptionPane.showMessageDialog(null, "Sonuç RED ise hata tipini boş geçemezsin");

                        return;
                     }
                     else if( "".equals(f)){
                         JOptionPane.showMessageDialog(null, "Sonuç RED ise hata yerini boş geçemezsin");
                         return;
                     }

                     else{
                         try {
                             statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"')");
                         }    catch (SQLException e) {
                             e.printStackTrace();
                         }

                     }

                }
                else{
                    try {
                        statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"')");
                    }    catch (SQLException e) {
                        e.printStackTrace();
                    }}
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a= kaynakyonTextField1.getText();
                String b=kalinliktextField1.getText();
                String c=captextField1.getText();
                String d=hatatipitextField1.getText();
                String f=hataninyeritextField1.getText();
                String g=sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                try{
                    statement.executeUpdate("UPDATE muayenesonucları set kaynakno='"+y+"',kontroluzunlugu='"+z+"',kaynakyon='"+a+"',kalinlik='"+b+"',cap='"+c+"',hatatipi='"+d+"',hataninyeri='"+f+"',sonuc='"+g+"'where serino='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public muayenesonucları() {

    }






}
