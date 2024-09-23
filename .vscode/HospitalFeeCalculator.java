import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalFeeCalculator extends JFrame {
    private JRadioButton maleRadioButton, femaleRadioButton, childRadioButton;
    private JTextField ageTextField, feeTextField;
    private JButton calculateButton;

    public HospitalFeeCalculator() {
        setTitle("HÓA ĐƠN BÊNH VIỆN  - HOA HỒNG");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Tạo các thành phần giao diện
        JLabel ageLabel = new JLabel("Nhập tuổi : ");
        ageTextField = new JTextField();

        JLabel genderLabel = new JLabel("Chọn giới tính :");
        maleRadioButton = new JRadioButton("Nam");
        femaleRadioButton = new JRadioButton("Nữ");
        childRadioButton = new JRadioButton("Trẻ em (dưới 18)");

        // ButtonGroup để chỉ có thể chọn một lựa chọn giới tính
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(childRadioButton);

        // Mặc định chọn "Male"
        maleRadioButton.setSelected(true);

        calculateButton = new JButton("Viện Phí");
        feeTextField = new JTextField();
        feeTextField.setEditable(false); // Không cho phép nhập vào ô này

        // Thêm các thành phần vào giao diện
        add(ageLabel);
        add(ageTextField);

        add(genderLabel);
        add(new JPanel()); // Ô trống để căn chỉnh
        add(maleRadioButton);
        add(femaleRadioButton);
        add(childRadioButton);
        add(new JPanel()); // Ô trống để căn chỉnh

        add(calculateButton);
        add(feeTextField);

        // Xử lý sự kiện khi bấm nút "Calculate Fee"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFee();
            }
        });
    }

    // Hàm xử lý tính phí
    private void calculateFee() {
        try {
            int age = Integer.parseInt(ageTextField.getText());

            if (maleRadioButton.isSelected()) {
                // Xử lý cho Nam
                if (age >= 18 && age <= 35) {
                    feeTextField.setText("200000 VND");
                } 
                else if(age>=1 && age <18){
                    
                    feeTextField.setText("vui lòng chọn mục trẻ em ");
                }
                else if (age >= 36 && age <= 50) {
                    feeTextField.setText("300000 VND");
                } else if (age >= 51 && age <= 145) {
                    feeTextField.setText("500000 VND");
                } else {
                    showError();
                }
            } else if (femaleRadioButton.isSelected()) {
                // Xử lý cho Nữ
                if (age >= 18 && age <= 35) {
                    feeTextField.setText("180000 VND");
                }
                else if(age>=1 && age <18){
                    
                    feeTextField.setText("vui lòng chọn mục trẻ em ");
                }
                else if (age >= 36 && age <= 50) {
                    feeTextField.setText("250000 VND");
                } else if (age >= 51 && age <= 145) {
                    feeTextField.setText("450000 VND");
                } else {
                    showError();
                }
            } else if (childRadioButton.isSelected()) {
                // Xử lý cho Trẻ em
                if (age >= 0 && age <= 17) {
                    feeTextField.setText("100000 VND");
                } 
                else if(age>=18){
                    feeTextField.setText("quá tuổi trẻ em ");
                }
                else {
                    showError();
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Hiển thị lỗi khi nhập sai độ tuổi
    private void showError() {
        JOptionPane.showMessageDialog(this, "Xin vui lòng nhập độ tuổi chính xác", "Error", JOptionPane.ERROR_MESSAGE);
        feeTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HospitalFeeCalculator().setVisible(true);
            }
        });
    }
}
