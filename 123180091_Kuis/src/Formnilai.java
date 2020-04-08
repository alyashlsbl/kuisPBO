
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Formnilai extends JFrame {
    
    JLabel lnim,lnama,lmatkul1,lnilai1,lmatkul2,lnilai2;
    JTextField txnim,txnama,txmatkul1,txnilai1,txmatkul2,txnilai2;
    JButton convert;
    Statement statement;
    
     public void form (){
         
        setTitle("Hitung Nilai");
        
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lmatkul1 = new JLabel("Mata Kuliah 1");
        lnilai1 = new JLabel("Nilai 1");
        lmatkul2 = new JLabel("Mata Kuliah 2");
        lnilai2 = new JLabel("Nilai 2");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txmatkul1 = new JTextField("");
        txnilai1 = new JTextField("");
        txmatkul2 = new JTextField("");
        txnilai2 = new JTextField("");
        
        convert = new JButton("Convert");
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmatkul1);
        add(lnilai1);
        add(lmatkul2);
        add(lnilai2);
        add(txnim);
        add(txnama);
        add(txmatkul1);
        add(txnilai1);
        add(txmatkul2);
        add(txnilai2);
        add(convert);
        
        lnim.setBounds(50, 70, 50, 30);
        lnama.setBounds(50, 120, 50, 30);
        lmatkul1.setBounds(50, 170, 80, 30);
        lnilai1.setBounds(50, 220, 50, 30);
        lmatkul2.setBounds(50, 270, 80, 30);
        lnilai2.setBounds(50, 320, 50, 30);
        txnim.setBounds(180, 70, 150, 30);
        txnama.setBounds(180, 120, 150, 30);
        txmatkul1.setBounds(180, 170, 150, 30);
        txnilai1.setBounds(180, 220, 150, 30);
        txmatkul2.setBounds(180, 270, 150, 30);
        txnilai2.setBounds(180, 320, 150, 30);
        convert.setBounds(170, 380, 150, 30);
        
        setSize(500,500); //untuk menentukan luas jendela
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String a1 = txnim.getText();
                String a2 = txnama.getText();
                String a3 = txmatkul1.getText();
                int a4 = Integer.parseInt(txnilai1.getText());
                String a5 = txmatkul2.getText();
                int a6 = Integer.parseInt(txnilai2.getText());
                float rerata = (float) ((a4+a6)/2.0);
                
                String x = null;
                if(rerata>=80 && rerata<=100)
                {x = "A";}
                else if(rerata>=75 && rerata<80)
                {x = "B+";}
                else if(rerata>=65 && rerata<75)
                {x = "B";}
                else if(rerata>=60 && rerata<65)
                {x = "C+";}
                else if(rerata>=50 && rerata<60)
                {x = "C";}
                else if(rerata>=20 && rerata<50)
                {x = "D";}
                else if(rerata>=0 && rerata<20)
                {x = "E";}
                else{x = "Error";}
                
                
                KoneksiDB koneksi = new KoneksiDB();
                try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO mahasiswa VALUES ('" + a1 + "','" +
                                                a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "','" + rerata + "','" + x + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Formnilai.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Formnilai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                System.out.println("NIM = "+a1);
                System.out.println("Nama = "+a2);
                System.out.println("Mata Kuliah 1 = "+a3);
                System.out.println("Nilai 1 = "+a4);
                System.out.println("Mata Kuliah 2 = "+a5);
                System.out.println("Nilai 2 = "+a6);
                System.out.println("Rata-rata = "+rerata);
                System.out.println("Nilai = "+x);
                
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                }
                
            }
        });
                
     } 
}
