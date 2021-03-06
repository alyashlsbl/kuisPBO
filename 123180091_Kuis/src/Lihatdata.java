
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Lihatdata extends JFrame {
    
    String[][] data = new String [500][8];
    String[] kolom = {"NIM","Nama","Matkul 1","Nilai 1","Matkul 2","Nilai 2","Rata2","Nilai"}; //nama kolom pada tabel yang akan dilihat
    
    JTable tabel;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    
    public void Lihatdatanilai(){
        
        setTitle("Data Nilai Mahasiswa");
        try {
            KoneksiDB koneksi = new KoneksiDB();
            statement = koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM mahasiswa"; //perintah mengambil data
            resultSet = statement.executeQuery(sql); //data disimpan dalam resultset
            
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("matkul1");
                data[p][3] = resultSet.getString("nilai1");
                data[p][4] = resultSet.getString("matkul2");
                data[p][5] = resultSet.getString("nilai2");
                data[p][6] = resultSet.getString("rata2");
                data[p][7] = resultSet.getString("nilai");
                p++;
            }
            statement.close();
            koneksi.getKoneksi().close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan : " + sqle);
        } catch (ClassNotFoundException classe){
            JOptionPane.showMessageDialog(rootPane, "Class tidak ditemukan : " + classe);
        }
        
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);
        
        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
    }
    
}
