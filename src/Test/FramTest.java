package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.AnalysisService;
import service.serviceImpl.AnalysisServiceImpl;

public class FramTest extends JFrame implements ActionListener {
	String[] operate = {"%","√","x²","¼",
						"CE","C","×","÷",
						"7","8","9","*",
						"4","5","6","-",
						"1","2","3","+",
						"±","0",".","="};
	JTextField result = new JTextField(35);
	JButton[] jb = null;
	double num1;
	double num2;
	public FramTest() {
		this.setTitle("calculator");
		this.setSize(400, 450);
		
		JPanel all = new JPanel(new BorderLayout());	
		JPanel jp1 = new JPanel();		//放置输入框面板
		
		result.setPreferredSize(new Dimension(10, 35)); // 设置 输入框大小
		result.setHorizontalAlignment(JTextField.RIGHT); // 设置输入框从右往左显示
		Font font = new Font("黑体", Font.PLAIN, 20); // 设置字体样式
		result.setFont(font); // 将样式设置
		result.setEditable(false); // 设置为不可编辑
		jp1.add(result);
		JPanel jp2 = new JPanel(new GridLayout(6, 4, 10, 10));////放置操作按钮面板
		jb = new JButton[operate.length];
		for (int i = 0; i < operate.length; i++) {
			jb[i] = new JButton(operate[i] + "");
			jp2.add(jb[i]);
			jb[i].addActionListener(this);
		}
		all.add(jp1, BorderLayout.NORTH);
		all.add(jp2, BorderLayout.CENTER);
		this.add(all);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ".":
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "+":
		case "-":
		case "*":
		case "÷":{
			result.setText(result.getText() + e.getActionCommand());
			break;
		}
		case "%":{
		}
		case "√":{
			result.setText(Math.sqrt(Double.parseDouble(result.getText()))+"");
			break;
		}
		case "x²":{
			result.setText(Math.pow((Double.parseDouble(result.getText())),2)+"");
			break;
		}
		case "¼":{
			result.setText(Math.sqrt(Double.parseDouble(result.getText())/1)+"");
			break;
		}
		case "CE":{
			result.setText("");
			break;
		}
		case "C":{
			result.setText("");
			break;
		}
		case "×":{
			if(!result.getText().isEmpty()) {
				result.setText(result.getText().substring(0,result.getText().length()-1));
			}
			break;
		}
		case "=": {
			AnalysisService as = new AnalysisServiceImpl();
			result.setText(as.analysis(result.getText()));
			break;
		}
		default: {
			break;
		}
		}
	}
	
	public static void main(String[] args) {
		new FramTest();
	}
}
