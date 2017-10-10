package view;

import controller.InsertGoodsToBillListController;
import controller.LogOutController;
import controller.PrintBillListToFileController;
import controller.SaveUpdateEmployeeInfoController;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import model.Bill;
import model.Employee;


public class EmployeeView {

  private JFrame frame;
  private JTextField txtCode;
  private JTextField txtAmount;
  private Employee employee;
  private ArrayList<Bill> listBill;
  private JTextField txtBegin;
  private JTextField txtDateOfBirth;
  private JTextField txtSex;
  private JTextField txtAges;
  private JTextField txtName;
  private JLabel lblEmployeeId;
  private JLabel lblSessionCount;
  private JLabel lblSalaryPerSession;

  /**
   * Constructor.
   * @param employee = employee
   */
  
  public EmployeeView(Employee employee) {
    this.listBill = new ArrayList<Bill>();
    this.employee =  employee;
    initialize();
  }

  public JTextField getTxtBegin() {
    return txtBegin;
  }
  
  public void setTxtBegin(JTextField txtBegin) {
    this.txtBegin = txtBegin;
  }
  
  public JTextField getTxtDateOfBirth() {
    return txtDateOfBirth;
  }
  
  public void setTxtDateOfBirth(JTextField txtDateOfBirth) {
    this.txtDateOfBirth = txtDateOfBirth;
  }
  
  public JTextField getTxtSex() {
    return txtSex;
  }
  
  public void setTxtSex(JTextField txtSex) {
    this.txtSex = txtSex;
  }
  
  public JTextField getTxtAges() {
    return txtAges;
  }
  
  public void setTxtAges(JTextField txtAges) {
    this.txtAges = txtAges;
  }
  
  public JTextField getTxtName() {
    return txtName;
  }
  
  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }
  
  public JLabel getLblEmployeeId() {
    return lblEmployeeId;
  }
  
  public void setLblEmployeeId(JLabel lblEmployeeId) {
    this.lblEmployeeId = lblEmployeeId;
  }
  
  public JLabel getLblSessionCount() {
    return lblSessionCount;
  }
  
  public void setLblSessionCount(JLabel lblSessionCount) {
    this.lblSessionCount = lblSessionCount;
  }
  
  public JLabel getLblSalaryPerSession() {
    return lblSalaryPerSession;
  }
  
  public void setLblSalaryPerSession(JLabel lblSalaryPerSession) {
    this.lblSalaryPerSession = lblSalaryPerSession;
  }

  /**
   * Initialize the contents of the frame.
   */
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(220, 50, 1250, 820);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(10, 11, 1214, 759);
    frame.getContentPane().add(tabbedPane);
    
    //below is sale_tab
    JPanel saleTab = new JPanel();
    tabbedPane.addTab("Bán Hàng", null, saleTab, null);
    saleTab.setLayout(null);
    
    JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm");
    lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 17));
    lblMaSanPham.setBounds(39, 53, 170, 30);
    saleTab.add(lblMaSanPham);
    
    JLabel lblSoLuong = new JLabel("Sô Lượng");
    lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 17));
    lblSoLuong.setBounds(39, 103, 170, 30);
    saleTab.add(lblSoLuong);
    
    txtCode = new JTextField();
    txtCode.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtCode.setBounds(219, 53, 301, 33);
    saleTab.add(txtCode);
    txtCode.setColumns(10);
    
    txtAmount = new JTextField();
    txtAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtAmount.setBounds(219, 103, 86, 33);
    saleTab.add(txtAmount);
    txtAmount.setColumns(10);
    
    JButton btnInsert = new JButton("Thêm Vào Hóa Đơn");
    btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnInsert.setBounds(554, 53, 200, 35);
    saleTab.add(btnInsert);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(770, 53, 395, 552);
    saleTab.add(scrollPane);
    
    JTextPane txtBill = new JTextPane();
    txtBill.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtBill.setText(" ");
    scrollPane.setViewportView(txtBill);
    
    JButton btnPrint = new JButton("In Hóa Đơn");
    btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnPrint.setBounds(770, 629, 178, 42);
    saleTab.add(btnPrint);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(39, 229, 443, 410);
    saleTab.add(textArea);
    
    JLabel lblNoti = new JLabel("");
    lblNoti.setBounds(39, 169, 481, 14);
    saleTab.add(lblNoti);
    
    InsertGoodsToBillListController insertConn = new InsertGoodsToBillListController(
        employee, listBill, txtCode, txtAmount, txtBill, lblNoti);
    btnInsert.addActionListener(insertConn);
    
    
    PrintBillListToFileController printBillCon = new PrintBillListToFileController(
        employee, listBill, txtBill);
    btnPrint.addActionListener(printBillCon);
    
    //above is sale_tab
    
    //below is information_tab
    
    JPanel informationTab = new JPanel();
    tabbedPane.addTab("Trang Cá Nhân", null, informationTab, null);
    informationTab.setLayout(null);
    
    JLabel lblAvatar = new JLabel("");
    lblAvatar.setIcon(new ImageIcon(EmployeeView.class.getResource(
        "/img/20882035_140778833191803_6566284977844443911_n.jpg")));
    lblAvatar.setBounds(829, 76, 335, 338);
    informationTab.add(lblAvatar);
    
    JButton btnSave = new JButton("Lưu");
    btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnSave.setBounds(70, 605, 159, 39);
    informationTab.add(btnSave);
    
    JLabel lblThongTinCa = new JLabel("Thông Tin Cá Nhân");
    lblThongTinCa.setFont(new Font("Tahoma", Font.BOLD, 22));
    lblThongTinCa.setBounds(90, 22, 477, 39);
    informationTab.add(lblThongTinCa);
    
    JLabel lblTen = new JLabel("Tên");
    lblTen.setVerticalAlignment(SwingConstants.BOTTOM);
    lblTen.setBackground(new Color(221, 160, 221));
    lblTen.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblTen.setBounds(89, 100, 106, 30);
    
    informationTab.add(lblTen);
    
    JLabel lblTuoi = new JLabel("Tuổi");
    lblTuoi.setVerticalAlignment(SwingConstants.BOTTOM);
    lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblTuoi.setBounds(89, 160, 216, 30);
    informationTab.add(lblTuoi);
    
    JLabel lblGioiTinh = new JLabel("Giới Tính");
    lblGioiTinh.setVerticalAlignment(SwingConstants.BOTTOM);
    lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblGioiTinh.setBounds(90, 220, 216, 30);
    informationTab.add(lblGioiTinh);
    
    JLabel lblNgaySinh = new JLabel("Ngày Sinh");
    lblNgaySinh.setVerticalAlignment(SwingConstants.BOTTOM);
    lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNgaySinh.setBounds(89, 280, 216, 30);
    informationTab.add(lblNgaySinh);
    
    JLabel lblNgayLam = new JLabel("Ngày Băt Đầu Làm");
    lblNgayLam.setVerticalAlignment(SwingConstants.BOTTOM);
    lblNgayLam.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNgayLam.setBounds(89, 340, 216, 30);
    informationTab.add(lblNgayLam);
    
    
    
    JLabel lblMaSoNhan = new JLabel("Mã Số Nhân Viên");
    lblMaSoNhan.setVerticalAlignment(SwingConstants.BOTTOM);
    lblMaSoNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblMaSoNhan.setBounds(88, 400, 217, 30);
    informationTab.add(lblMaSoNhan);
    
    JLabel lblLuongTheoCa = new JLabel("Lương Theo Ca");
    lblLuongTheoCa.setVerticalAlignment(SwingConstants.BOTTOM);
    lblLuongTheoCa.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblLuongTheoCa.setBounds(89, 460, 216, 30);
    informationTab.add(lblLuongTheoCa);
    
    JLabel lblSoCaLam = new JLabel("Số Ca Làm Việc");
    lblSoCaLam.setVerticalAlignment(SwingConstants.BOTTOM);
    lblSoCaLam.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblSoCaLam.setBounds(90, 525, 215, 30);
    informationTab.add(lblSoCaLam);
    
    lblEmployeeId = new JLabel("");
    lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblEmployeeId.setBounds(315, 400, 399, 30);
    informationTab.add(lblEmployeeId);
      
    lblSessionCount = new JLabel("");
    lblSessionCount.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblSessionCount.setBounds(315, 525, 399, 30);
    informationTab.add(lblSessionCount);
    
    lblSalaryPerSession = new JLabel("");
    lblSalaryPerSession.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblSalaryPerSession.setBounds(315, 460, 399, 30);
    informationTab.add(lblSalaryPerSession);
    
    txtBegin = new JTextField();
    txtBegin.setFont(new Font("Tahoma", Font.BOLD, 16));
    txtBegin.setBounds(315, 340, 399, 30);
    informationTab.add(txtBegin);
    txtBegin.setColumns(10);
    
    txtDateOfBirth = new JTextField();
    txtDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
    txtDateOfBirth.setColumns(10);
    txtDateOfBirth.setBounds(315, 280, 399, 30);
    informationTab.add(txtDateOfBirth);
    
    txtSex = new JTextField();
    txtSex.setFont(new Font("Tahoma", Font.BOLD, 16));
    txtSex.setColumns(10);
    txtSex.setBounds(315, 220, 399, 30);
    informationTab.add(txtSex);
    
    txtAges = new JTextField();
    txtAges.setFont(new Font("Tahoma", Font.BOLD, 16));
    txtAges.setColumns(10);
    txtAges.setBounds(315, 160, 399, 30);
    informationTab.add(txtAges);
    
    txtName = new JTextField();
    txtName.setFont(new Font("Tahoma", Font.BOLD, 16));
    txtName.setColumns(10);
    txtName.setBounds(315, 100, 399, 30);
    informationTab.add(txtName);
    
    JButton btnLogout = new JButton("Dang Xuat");
    btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnLogout.setBounds(255, 605, 159, 39);
    informationTab.add(btnLogout);
    
    btnSave.addActionListener(new SaveUpdateEmployeeInfoController(this, employee));
    btnLogout.addActionListener(new LogOutController(employee,frame));
  }
}
