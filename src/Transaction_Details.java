
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fajar
 */
public class Transaction_Details extends javax.swing.JInternalFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
String[][] data = null;
int lock = 0;
String[] coloumNames = new String [4];
static JScrollPane scroll;
int stock_brg;
String[][] temp;
 // header is Vector contains table Column
 static Vector headers = new Vector();
 Vector datas = new Vector();
 // Model is used to construct JTable
// static DefaultTableModel model = null;
 // data is Vector contains Data from Excel File
 static Vector dataa = new  Vector();
  static int tableWidth = 0; // set the tableWidth
  static int tableHeight = 0; // set the tableHeight
  int stk;
  int y;
  int gaji;
  int harga,max_harga;
  int jml1,qty1;
    /**
     * Creates new form Transaction_Details
     */
    public Transaction_Details() {
        initComponents();
         try {
        conn = KoneksiDB.ConnectDB();
    } catch (SQLException ex) {
      //  Logger.getLogger(Produk.class.getName()).log(Level.SEVERE, null, ex);
    }
        //update_table();
         
       getMax_Nota();
        combobox();
        kombo();
        kombos();
        timeisup();
        jLabel8.setVisible(false);
        jTextField1.setVisible(false);
    }
    
    private void getMax_Nota()
 {
             try{
    String sql = "select max(id_penjualan) from transaksi";
     pst = conn.prepareStatement(sql);
     rs=pst.executeQuery();
    
    while(rs.next()){
    String price = rs.getString("max(id_penjualan)");
    if (price == null){
   //id_pen.setText(""+(x+1));
    //JOptionPane.showMessageDialog(null, x);
    //int b = Integer.parseInt(id_pen.getText());
    id_pen.setText(""+1);
    }
    else 
    {
     int x = Integer.parseInt(price);
    //tm.setText(price);
    id_pen.setText(""+(x+1));
    //JOptionPane.showMessageDialog(null, x);
    int b = Integer.parseInt(id_pen.getText());
    id_pen.setText(""+b);
    
    }
    }
    }
    catch(SQLException Ex){
    JOptionPane.showMessageDialog(null, Ex);
    }
 }

    private void combobox(){
    try{
    String sql = "select id_customer from customer";
     pst = conn.prepareStatement(sql);
     rs=pst.executeQuery();
    
    while(rs.next()){
    String name = rs.getString("id_customer");
    id_cus.addItem(name);
    //JOptionPane.showMessageDialog(null, price);
    
    }
    }
    catch(SQLException Ex){
    JOptionPane.showMessageDialog(null, "Error");
    }
    }
 
 private void kombo(){
  try{
    String sql = "select id_pegawai from pegawai";
     pst = conn.prepareStatement(sql);
     rs=pst.executeQuery();
    
    while(rs.next()){
    String name = rs.getString("id_pegawai");
    id_peg.addItem(name);
    //String price = rs.getString("harga");
    //tm.setText(price);
    //JOptionPane.showMessageDialog(null, price);
    
    }
    }
    catch(SQLException Ex){
    JOptionPane.showMessageDialog(null, Ex);
    }
 }
 
 public void timeisup(){
Calendar cal = new GregorianCalendar();
int date  = cal.get(Calendar.DATE);
int month  = cal.get(Calendar.MONTH);
int year  = cal.get(Calendar.YEAR);
thn.setText(year+"-"+(month+1)+"-"+date);
 }


 
 private void kombos(){
  try{
    String sql = "select id_barang from barang";
     pst = conn.prepareStatement(sql);
     rs=pst.executeQuery();
    
    while(rs.next()){
    String name = rs.getString("id_barang");
    ComboBox.addItem(name);
    //String price = rs.getString("harga");
    //tm.setText(price);
    //JOptionPane.showMessageDialog(null, price);
    
    }
    }
    catch(SQLException Ex){
    JOptionPane.showMessageDialog(null, Ex);
    }
 }
//    private void update_table(){
//    try {
//            String sql = "select * from transaksi";
//            pst = conn.prepareStatement(sql);
//            rs=pst.executeQuery();
//            trans.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_pen = new javax.swing.JTextField();
        thn = new javax.swing.JTextField();
        th = new javax.swing.JTextField();
        id_cus = new javax.swing.JComboBox();
        id_peg = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        kurs = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jml = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalJ = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Transaksi");

        jLabel6.setText("Kurs");

        jLabel4.setText("Total Harga");

        jLabel5.setText("Tanggal");

        jLabel2.setText("ID Pegawai");

        jLabel3.setText("ID Customer");

        jLabel1.setText("ID Penjualan");

        th.setText("0");

        jButton1.setText("Bayar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        kurs.setText("0");

        ComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel7.setText("ID Barang");

        jLabel8.setText("ID Penjualan");
        jLabel8.setEnabled(false);

        jLabel9.setText("Harga");

        jTextField1.setText("0");
        jTextField1.setEnabled(false);

        Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Employee);

        jTextField2.setText("0");

        jButton4.setText("Tambah");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Jumlah");

        jml.setText("0");
        jml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmlKeyReleased(evt);
            }
        });

        jLabel11.setText("Total");

        totalJ.setText("0");

        jLabel12.setText("Cari Barang");

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Nota");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(thn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(th, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_peg, javax.swing.GroupLayout.Alignment.LEADING, 0, 147, Short.MAX_VALUE)
                            .addComponent(id_pen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kurs)
                            .addComponent(search))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(id_cus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField2)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jml, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(2, 2, 2)
                                                    .addComponent(totalJ, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))))))
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(10, 10, 10)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(th, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(totalJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel12)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           masuk_transaksi();
           masuk_detail();
           cetak();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            try {
                if (lock < 1) {
                    coloumNames = new String[]{"ID Barang", "Harga", "Jumlah", "Total Harga"};
                    data = new String[1][4];
                    data[0][0] = (String)ComboBox.getSelectedItem();
                    data[0][1] = jTextField2.getText();
                    data[0][2] = jml.getText();
                    data[0][3] = totalJ.getText();
                    
//                    data[0][3] = tk.getText();
                      int x1 = Integer.parseInt(totalJ.getText());
                    int x2 = Integer.parseInt(jml.getText());
                    jml1 = jml1+x1;
                    qty1 = qty1+x2;
                    th.setText(""+jml1);      
                    Employee.setModel(new DefaultTableModel(data, coloumNames));
                    lock = lock + 1;

                } else {
                    temp = data;
                     System.out.println("ComboBox.getSelectedItem() "+ComboBox.getSelectedItem());
                        if (temp[temp.length-1][0] == ComboBox.getSelectedItem())
                        {
                            String x = (String) ComboBox.getSelectedItem();
                            int b1,b2,b3;
                            int y1,y2,y3;
                            b1 = Integer.parseInt(temp[temp.length-1][2]);
                            b2 = Integer.parseInt(jml.getText());
                            b3 = b1+b2;
                            y1 = Integer.parseInt(temp[temp.length-1][3]);
                            y2 = Integer.parseInt(totalJ.getText());
                            y3 = y1+y2;
                            temp[temp.length-1][2] = ""+b3;
                            temp[temp.length-1][3] = ""+y3;
                            data = temp;
                            Employee.setModel(new DefaultTableModel(data, coloumNames));
                            
                        //c = data.length;
                        int x1 = Integer.parseInt(totalJ.getText());
                    int x2 = Integer.parseInt(jml.getText());
                    jml1 = jml1+x1;
                    qty1 = qty1+x2;
                    th.setText(""+jml1);
                    //quan.setText(""+qty1);
                      //  System.out.println("c = "+c);
                        System.out.println("data "+data.length);
                        }
                        else {
                          temp = null;  
                            temp = new String[data.length + 1][data.length + 4];
                    for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < 4; j++) {
                            temp[i][j] = data[i][j];
                        }
                    }

                    temp[data.length][0] = (String)ComboBox.getSelectedItem();
                    temp[data.length][1] = jTextField2.getText();
                    temp[data.length][2] = jml.getText();
                    temp[data.length][3] = totalJ.getText();
                    
                    data = (String[][]) temp;
                    Employee.setModel(new DefaultTableModel(data, coloumNames));
                    int x1 = Integer.parseInt(totalJ.getText());
                    int x2 = Integer.parseInt(jml.getText());
                    jml1 = jml1+x1;
                    qty1 = qty1+x2;
                    th.setText(""+jml1);
                        }
                        temp = null;
                       }
//                int j = Integer.parseInt(numb.getText());
//                stk = stk-j;

            } catch (Exception Ex) {
                JOptionPane.showMessageDialog(null, "Maaf Data Yang anda entry terdapat keasalahan Mohon dicek ulang");
            }
        } catch (HeadlessException Ex) {
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             try {
            int position = Employee.getSelectedRow();
            String[][] temp = new String[data.length - 1][4];
            int totalx = Integer.parseInt(th.getText());
            int i = 0;
            int total2 = Integer.parseInt(data[i][3]);
            int tota3 = totalx-total2;
            th.setText(""+tota3);
            for (i = 0; i < position; i++) {
                temp[i][0] = data[i][0];
                temp[i][1] = data[i][1];
                temp[i][2] = data[i][2];
                temp[i][3] = data[i][3]; }
            for (i = position + 1; i < data.length; i++) {
                temp[i - 1][0] = data[i][0];
                temp[i - 1][1] = data[i][1];
                temp[i - 1][2] = data[i][2];
                temp[i - 1][3] = data[i][3];}
            data = temp;
            Employee.setModel(new DefaultTableModel(data, coloumNames));
            if (data.length < 1) {
                data = null;
                jml1= 0;
                lock = 0;
            }
           // int j = Integer.parseInt(numb.getText());

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, "Array atau jumlah data telah kosong");

            data = null;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBoxPopupMenuWillBecomeInvisible
        try{
            String sql = "select harga from memiliki where id_barang='"+ComboBox.getSelectedItem()+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();

            while(rs.next()){
                String price = rs.getString("harga");
                //String id_number = rs.getString("no_seri");
                jTextField2.setText(price);
               

            }
        }
        catch(SQLException Ex){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_ComboBoxPopupMenuWillBecomeInvisible

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                   try 
           
       {
       Connection conns;
       conns = KoneksiDB.ConnectDB();
       JFileChooser jChooser = new JFileChooser();
       jChooser.showOpenDialog(null);
       jChooser.setMultiSelectionEnabled(false);
       File file = jChooser.getSelectedFile();
       String report = jChooser.getSelectedFile().toString();
       JasperDesign jasperDesign = JRXmlLoader.load(report);
       String sql = "select a.ID_PENJUALAN,c.ID_BARANG,c.NAMA_BARANG,a.TANGGAL_TRANSAKSI,b.HARGA from transaksi a join dimiliki b on (a.ID_PENJUALAN = b.ID_PENJUALAN) join barang c on (c.ID_BARANG = b.ID_BARANG) where a.ID_PENJUALAN = '"+id_pen.getText()+"'";
       JRDesignQuery newQuery = new JRDesignQuery();
       newQuery.setText(sql);
       jasperDesign.setQuery(newQuery);
       JasperReport jasperReport = null;
                       try {
                           jasperReport = JasperCompileManager.compileReport(jasperDesign);
                       } catch (JRException ex) {
                           Logger.getLogger(Transaction_Details.class.getName()).log(Level.SEVERE, null, ex);
                       }
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conns);
       JRViewer test = new JRViewer(jasperPrint);
       JFrame frame = new JFrame("Report");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.getContentPane().add(test); //new JRViewer(jasperPrint)
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
       frame.pack();
       frame.setVisible(true);    
       frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons.png")));
        
        
       }
       catch (Exception ex) 
       {
           System.out.println(ex);
           System.out.println(System.getProperty("java.endorsed.dirs"));
           JOptionPane.showMessageDialog(null, ex);
       }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmlKeyReleased
        try{
        int x = Integer.parseInt(jTextField2.getText());
        int x2 = Integer.parseInt(jml.getText());
        int b = x*x2;
        totalJ.setText(""+b);}
        catch (Exception ex)
        {
        
        }
    }//GEN-LAST:event_jmlKeyReleased

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       try {
            String sql = "select d.ID_order,b.NAMA_BARANG,d.HARGA,b.id_barang from memiliki d join barang b on (b.ID_BARANG = d.ID_BARANG)where b.NAMA_BARANG=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, search.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("id_barang");
                ComboBox.setSelectedItem(add1);
                String add2 = rs.getString("harga");
                jTextField2.setText(add2);
//                String add3 = rs.getString("tgl_masuk");
//                txt3.setText(add3);
//                String add4 = rs.getString("tgl_keluar");
//                txt4.setText(add4);
//                String add5 = rs.getString("jumlah");
//                txt5.setText(add5);
            }
        } catch (SQLException e) {
        } 
    }//GEN-LAST:event_searchKeyReleased


    void masuk_transaksi() 
    {
                try {
            //String x = thn.getText()+"-"+bln.getText()+"-"+hari.getText();
            String sql = "INSERT INTO transaksi (id_penjualan,id_pegawai,id_customer,harga,tanggal_transaksi,kurs) VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_pen.getText());
            pst.setString(2, (String)id_peg.getSelectedItem());
            pst.setString(3, (String)id_cus.getSelectedItem());
            pst.setString(4, th.getText());
            pst.setString(5, thn.getText());
            pst.setString(6, kurs.getText());
            //              JOptionPane.showMessageDialog(null, id_barang.getText());
            //              JOptionPane.showMessageDialog(null, nama_barang.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        //update_table();
    }
    
    void masuk_detail()
    {
        if (data.length > 0){
         for(int i = 0; i < data.length; i++)
            { 
        try {
            String sql = "INSERT INTO dimiliki VALUES ('" + data[i][0]+"','"+id_pen.getText()+"','" + data[i][1] + "','"+ data[i][2] +"','"+ data[i][3] +"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
        } catch (SQLException ex) {
          //  Logger.getLogger(nota.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
            }

    }
        else {
            }
    }
    
    private void cetak(){
    try {
        //String x = "E:\\tes.jrxml";
    String report = "E:\\report\\notas.jrxml";
    JasperDesign jasperDesign = JRXmlLoader.load(report);
    String sql = "select * from dimiliki where id_penjualan="+id_pen.getText()+"";
    System.out.println(id_pen.getText());
    //System.out.println(s);
    JRDesignQuery newQuery = new JRDesignQuery();
    newQuery.setText(sql);
    jasperDesign.setQuery(newQuery);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
     JasperPrintManager.printReport(jasperPrint,false);
//    JRViewer test = new JRViewer(jasperPrint);
//    JFrame frame = new JFrame("Report");
//    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    frame.getContentPane().add(test);
//    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//    frame.pack();
//    frame.setVisible(true);
    }
    catch (JRException | HeadlessException ex)
    {
        System.out.println(ex);
}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JTable Employee;
    private javax.swing.JComboBox id_cus;
    private javax.swing.JComboBox id_peg;
    private javax.swing.JTextField id_pen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jml;
    private javax.swing.JTextField kurs;
    private javax.swing.JTextField search;
    private javax.swing.JTextField th;
    private javax.swing.JTextField thn;
    private javax.swing.JTextField totalJ;
    // End of variables declaration//GEN-END:variables
}
