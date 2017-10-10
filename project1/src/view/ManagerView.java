package view;

import controller.CreatNewIdController;
import controller.GenerateCodeForGoodsController;
import controller.ImportGoodsToStoreController;
import controller.ShowEmployeeInfo;
import controller.StatisticOptionController;
import controller.UpdateEmployeeList;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import model.Employee;
import model.Manager;



public class ManagerView {

  private JFrame frame;
  private Manager manager;
  private JButton btnShowAmountZero;
  private JList<String> list;
  private ArrayList<Employee> employeeList;

  /**
   * Constructor.
   * @param manager is manager
   */
  
  public ManagerView(Manager manager) {
    this.manager = manager;
   
    this.employeeList = new ArrayList<>();
    initialize();
  }
  
  public JList<String> getList() {
    return list;
  }

  public void setList(JList<String> list) {
    this.list = list;
  }

  public ArrayList<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(ArrayList<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(220, 50, 1200, 820);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.getContentPane().setLayout(null);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(10, 11, 1164, 759);
    frame.getContentPane().add(tabbedPane);
    
    //below is tab ban hang
    
    JPanel goodsTab = new JPanel();
    tabbedPane.addTab("Quản Lý Hàng Hóa", null, goodsTab, null);
    goodsTab.setLayout(null);
    JLabel lblName = new JLabel("Tên Sản Phẩm");
    lblName.setVerticalAlignment(SwingConstants.BOTTOM);
    lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblName.setBounds(43, 164, 200, 25);
    goodsTab.add(lblName);
    
    JLabel lblPrice = new JLabel("Giá Sản Phẩm");
    lblPrice.setVerticalAlignment(SwingConstants.BOTTOM);
    lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblPrice.setBounds(43, 204, 200, 25);
    goodsTab.add(lblPrice);
    
    JLabel lblDateProducel = new JLabel("Nhà Sản Xuất");
    lblDateProducel.setVerticalAlignment(SwingConstants.BOTTOM);
    lblDateProducel.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDateProducel.setBounds(43, 244, 200, 25);
    goodsTab.add(lblDateProducel);
    
    JLabel lblDateExpire = new JLabel("Ngày Sản Xuất");
    lblDateExpire.setVerticalAlignment(SwingConstants.BOTTOM);
    lblDateExpire.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblDateExpire.setBounds(43, 284, 200, 25);
    goodsTab.add(lblDateExpire);
    
    JLabel lblProducer = new JLabel("Ngày Hết Hạn");
    lblProducer.setVerticalAlignment(SwingConstants.BOTTOM);
    lblProducer.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblProducer.setBounds(43, 324, 200, 25);
    goodsTab.add(lblProducer);
    
    JLabel lblInputNumberImport = new JLabel("Lượng Hàng Nhập");
    lblInputNumberImport.setVerticalAlignment(SwingConstants.BOTTOM);
    lblInputNumberImport.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblInputNumberImport.setBounds(43, 364, 200, 25);
    goodsTab.add(lblInputNumberImport);
    
    JButton btnSave = new JButton("Lưu Thông Tin");
    btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnSave.setBounds(43, 530, 218, 43);
    goodsTab.add(btnSave);
    
    JButton btnGenerateCode = new JButton("Tạo Mã Sản Phẩm");
    btnGenerateCode.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnGenerateCode.setBounds(43, 416, 200, 36);
    goodsTab.add(btnGenerateCode);
    
    JLabel lblCodeForNew = new JLabel("");
    lblCodeForNew.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblCodeForNew.setBounds(43, 463, 258, 36);
    goodsTab.add(lblCodeForNew);
    
    JLabel lblImportGoodsTo = new JLabel("Nhập Hàng Vào Kho");
    lblImportGoodsTo.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblImportGoodsTo.setBounds(43, 54, 394, 50);
    goodsTab.add(lblImportGoodsTo);
    
    JPanel notiPanel = new JPanel();
    notiPanel.setBackground(Color.WHITE);
    notiPanel.setBounds(612, 11, 522, 694);
    goodsTab.add(notiPanel);
    notiPanel.setLayout(null);
    
    btnShowAmountZero = new JButton("New button");
    btnShowAmountZero.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnShowAmountZero.setBounds(21, 37, 491, 65);
    notiPanel.add(btnShowAmountZero);
    
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 217, 502, 466);
    notiPanel.add(scrollPane);
    
    JTextPane txtTopGoods = new JTextPane();
    scrollPane.setViewportView(txtTopGoods);
    
    JComboBox<String> com1 = new JComboBox<String>();
    com1.setFont(new Font("Tahoma", Font.BOLD, 15));
    com1.setEditable(true);
    com1.setModel(new DefaultComboBoxModel<String>(new String[] {"10", "20", "50", "100"}));
    com1.setBounds(113, 125, 398, 26);
    notiPanel.add(com1);
    
    JComboBox<String> com2 = new JComboBox<String>();
    com2.setModel(new DefaultComboBoxModel<String>(new String[] {
        "Tùy chọn . . .", "Bán ra nhiều nhất", "Bán ra ít nhất",
        "Sản phẩm hết hàng", "Sản phẩm hết hạn "}));
    com2.setBounds(113, 162, 398, 26);
    notiPanel.add(com2);
    
    JLabel lblAmount = new JLabel("Amount");
    lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblAmount.setBounds(20, 125, 83, 26);
    notiPanel.add(lblAmount);
    
    JLabel lblOptions = new JLabel("Options");
    lblOptions.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblOptions.setBounds(20, 162, 83, 26);
    notiPanel.add(lblOptions);
    
    JTextField [] arrayJTextField = new JTextField[6];
    for (int i = 0; i < 3; i++) {
      arrayJTextField[i] = new JTextField();
      arrayJTextField[i].setBounds(267, 164 + 40 * i, 250, 25);
      arrayJTextField[i].setFont(new Font("Tahoma", Font.BOLD, 15));
      goodsTab.add(arrayJTextField[i]);
      arrayJTextField[i].setColumns(10);
    }
    
    JComboBox<String> day1 = new JComboBox<>();
    day1.setMaximumRowCount(3);
    day1.setFont(new Font("Tahoma", Font.BOLD, 15));
    day1.setEditable(false);
    day1.setModel(new DefaultComboBoxModel<String>(new String[] {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", 
        "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
    day1.setBounds(267, 284, 50, 25);
    goodsTab.add(day1);
    
    JComboBox<String> day2 = new JComboBox<>();
    day2.setMaximumRowCount(3);
    day2.setFont(new Font("Tahoma", Font.BOLD, 15));
    day2.setEditable(false);
    day2.setModel(new DefaultComboBoxModel<String>(new String[] {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", 
        "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
    day2.setBounds(267, 324, 50, 25);
    goodsTab.add(day2);
    
    JComboBox<String> month1 = new JComboBox<>();
    month1.setMaximumRowCount(3);
    month1.setFont(new Font("Tahoma", Font.BOLD, 15));
    month1.setEditable(false);
    month1.setModel(new DefaultComboBoxModel<String>(new String[] {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
    month1.setBounds(355, 284, 50, 25);
    goodsTab.add(month1);
    
    JComboBox<String> month2 = new JComboBox<>();
    month2.setMaximumRowCount(3);
    month2.setFont(new Font("Tahoma", Font.BOLD, 15));
    month2.setEditable(false);
    month2.setModel(new DefaultComboBoxModel<String>(new String[] {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
    month2.setBounds(355, 324, 50, 25);
    goodsTab.add(month2);
    
    JComboBox<String> year1 = new JComboBox<>();
    year1.setMaximumRowCount(3);
    year1.setFont(new Font("Tahoma", Font.BOLD, 15));
    year1.setEditable(false);
    year1.setModel(new DefaultComboBoxModel<String>(new String[] {
        "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", 
        "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", 
        "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
        "2024", "2025", "2026", "2027", "2028", "2029"}));
    year1.setBounds(441, 284, 76, 25);
    goodsTab.add(year1);
    
    JComboBox<String> year2 = new JComboBox<>();
    year2.setMaximumRowCount(3);
    year2.setFont(new Font("Tahoma", Font.BOLD, 15));
    year2.setEditable(false);
    year2.setModel(new DefaultComboBoxModel<String>(new String[] {
        "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
        "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
        "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
        "2024", "2025", "2026", "2027", "2028", "2029"}));
    year2.setBounds(441, 324, 76, 25);
    goodsTab.add(year2);
    
    ArrayList<JComboBox<String>> comboBoxList = new ArrayList<>();
    comboBoxList.add(day1);
    comboBoxList.add(month1);
    comboBoxList.add(year1);
    comboBoxList.add(day2);
    comboBoxList.add(month2);
    comboBoxList.add(year2);
    
    
    JTextField txtAmount = new JTextField();
    txtAmount.setBounds(267, 364, 250, 25);
    txtAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
    goodsTab.add(txtAmount);
    txtAmount.setColumns(10);
    
    btnSave.addActionListener(new ImportGoodsToStoreController(arrayJTextField, lblCodeForNew, 
        txtAmount, comboBoxList));
    
    //above is tab hang hoa
    
    //below is tab quan ly nhan vien
    
    JPanel employeeTab = new JPanel();
    tabbedPane.addTab("Quản Lý Nhân Viên", null, employeeTab, null);
    employeeTab.setLayout(null);
    
    JButton btnCreatId = new JButton("Tao 1 ID moi");
    btnCreatId.setBounds(560, 63, 144, 23);
    employeeTab.add(btnCreatId);
    
    JLabel lblNewId = new JLabel("ID cho nhan vien moi\r\n");
    lblNewId.setBackground(Color.WHITE);
    lblNewId.setBounds(548, 148, 144, 23);
    employeeTab.add(lblNewId);
    
    btnCreatId.addActionListener(new CreatNewIdController(manager, lblNewId));
    
    
    
    JLabel lblEmployeeList = new JLabel("Danh Sách Nhân Viên");
    lblEmployeeList.setBounds(41, 63, 403, 77);
    employeeTab.add(lblEmployeeList);
    lblEmployeeList.setHorizontalAlignment(SwingConstants.LEFT);
    lblEmployeeList.setFont(new Font("Tahoma", Font.BOLD, 26));
    
    JPanel employeeInfoPanel = new JPanel();
    employeeInfoPanel.setBounds(548, 201, 574, 439);
    employeeTab.add(employeeInfoPanel);
    employeeInfoPanel.setLayout(null);
    
    
    
    JLabel lblTen = new JLabel("Họ và Tên");
    lblTen.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblTen.setBounds(10, 22, 179, 36);
    employeeInfoPanel.add(lblTen);
    
    JLabel lblTuoi = new JLabel("Tuổi");
    lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblTuoi.setBounds(10, 69, 179, 36);
    employeeInfoPanel.add(lblTuoi);
    
    JLabel lblGioiTinh = new JLabel("Giới Tính");
    lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblGioiTinh.setBounds(10, 116, 179, 36);
    employeeInfoPanel.add(lblGioiTinh);
    
    JLabel lblNgaySinh = new JLabel("Ngày Sinh");
    lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNgaySinh.setBounds(10, 163, 179, 36);
    employeeInfoPanel.add(lblNgaySinh);
    
    JLabel lblNgayBatDauLam = new JLabel("Ngày Bắt Đầu Làm");
    lblNgayBatDauLam.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNgayBatDauLam.setBounds(10, 210, 179, 36);
    employeeInfoPanel.add(lblNgayBatDauLam);
    
    JLabel lblMaNhanVien = new JLabel("Mã Số Nhân Viên");
    lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblMaNhanVien.setBounds(10, 257, 179, 36);
    employeeInfoPanel.add(lblMaNhanVien);
    
    JLabel lblLuong = new JLabel("Lương Theo Ca");
    lblLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblLuong.setBounds(10, 304, 179, 41);
    employeeInfoPanel.add(lblLuong);
    
    JLabel lblSoCaLamViec = new JLabel("Số Ca Làm Việc");
    lblSoCaLamViec.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblSoCaLamViec.setBounds(10, 356, 179, 41);
    employeeInfoPanel.add(lblSoCaLamViec);
    
    JScrollPane srollPane1 = new JScrollPane();
    srollPane1.setBounds(41, 201, 483, 345);
    employeeTab.add(srollPane1);
    
    JLabel[] lblGroup = new JLabel[8];
    for (int i = 0; i < 8; i ++) {
      lblGroup[i] = new JLabel();
      lblGroup[i].setBounds(218, 22 + 47 * i, 346, 36);
      lblGroup[i].setFont(new Font("Tahoma", Font.BOLD, 16));
      employeeInfoPanel.add(lblGroup[i]);
    }
    
    list = new JList<String>();
    list.setSelectedIndex(0);
    
    srollPane1.setViewportView(list);
    list.addListSelectionListener(new ShowEmployeeInfo(this,lblGroup));
    
    JButton btnUpdate = new JButton("Update");
    btnUpdate.setBounds(41, 636, 89, 23);
    employeeTab.add(btnUpdate);
    
    btnUpdate.addActionListener(new UpdateEmployeeList(this, manager));
    
    btnGenerateCode.addActionListener(new GenerateCodeForGoodsController(
        arrayJTextField,lblCodeForNew));
    com1.addItemListener(new StatisticOptionController(com1, com2, txtTopGoods));
    com2.addItemListener(new StatisticOptionController(com1, com2, txtTopGoods));
    
    //above is tab quan ly nhan vien
    
    //below is new tab
    JPanel panel2 = new JPanel();
    tabbedPane.addTab("New tab", null, panel2, null);
    
    JPanel helpTab = new JPanel();
    tabbedPane.addTab("Hỗ Trợ", null, helpTab, null);
    helpTab.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("SuperMarket Management System");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblNewLabel.setBounds(240, 174, 478, 40);
    helpTab.add(lblNewLabel);
    
    JLabel lblVersion = new JLabel("Version 1.0");
    lblVersion.setFont(new Font("Tahoma", Font.ITALIC, 15));
    lblVersion.setBounds(240, 250, 478, 40);
    helpTab.add(lblVersion);
    
    JLabel lblAuthorNguyenDinh = new JLabel("Author :  Nguyen Dinh Minh");
    lblAuthorNguyenDinh.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblAuthorNguyenDinh.setBounds(240, 320, 478, 40);
    helpTab.add(lblAuthorNguyenDinh);
    
    JLabel lblMailContact = new JLabel("Mail contact : minh1996bk@gmail.com");
    lblMailContact.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblMailContact.setBounds(240, 390, 478, 40);
    helpTab.add(lblMailContact);
    
    JLabel lblNoPhoneContact = new JLabel("No. Phone contact : +84974066924");
    lblNoPhoneContact.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblNoPhoneContact.setBounds(240, 460, 478, 40);
    helpTab.add(lblNoPhoneContact);
    
    JLabel lblAddressContact = new JLabel("Address contact : Hanoi University of Science and Technology");
    lblAddressContact.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblAddressContact.setBounds(240, 530, 478, 40);
    helpTab.add(lblAddressContact);

   
  
  }
  
  public JButton getBtnShowAmountZero() {
    return btnShowAmountZero;
  }
}
