import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SetTheoryGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetTheoryGUI window = new SetTheoryGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetTheoryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourSets = new JLabel("Enter your subsets :");
		lblEnterYourSets.setBounds(10, 106, 350, 14);
		frame.getContentPane().add(lblEnterYourSets);
		
		textField = new JTextField();
		textField.setBounds(10, 146, 313, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheNumber_1 = new JLabel("Enter the number of the first set :");
		lblEnterTheNumber_1.setBounds(10, 190, 373, 14);
		frame.getContentPane().add(lblEnterTheNumber_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 215, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEnterTheNumber_2 = new JLabel("Enter the number of the second set (if Not complment) :");
		lblEnterTheNumber_2.setBounds(10, 246, 386, 14);
		frame.getContentPane().add(lblEnterTheNumber_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 271, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Union");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetTheory union = new SetTheory();
				String universe = textField.getText();
				String firstSet = textField_2.getText();
				String secondSet = textField_3.getText();
				String bigUniverse = textField_4.getText();
				ArrayList<ArrayList<String>> targetSet = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> universeSet = new ArrayList<ArrayList<String>>();
				targetSet = changeToArrayList(universe);
				universeSet = changeToArrayList(bigUniverse);
				for(int i=0;i<targetSet.size();i++){
					ArrayList<String> temp = new ArrayList<String>();
					temp = targetSet.get(i);
					for(int z=0;z<temp.size();z++){
						boolean check = false;
						for(int j=0;j<universeSet.get(0).size();j++){
							if(temp.get(z).equals(universeSet.get(0).get(j))){
								check = true;
						}
					}
						if(check ==false){
							
							JOptionPane.showMessageDialog(null,"The number "+temp.get(z)+ " doesn't exist in the universe");
									temp.remove(z);
						}
					}
				
				}
				ArrayList<String> target = new ArrayList<String>();
				if(Integer.parseInt(firstSet)>targetSet.size()||Integer.parseInt(firstSet)<=0||Integer.parseInt(secondSet)>targetSet.size()||Integer.parseInt(secondSet)<=0){
					JOptionPane.showMessageDialog(null,"Invalid number of sets");
				}
				target = union.Union(targetSet,Integer.parseInt(firstSet),Integer.parseInt(secondSet));
				
				textField_1.setText(SetTheoryGUI.this.toString(target));
				
			}
		});
		btnNewButton.setBounds(10, 302, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Intersection");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetTheory intersection = new SetTheory();
				String universe = textField.getText();
				String firstSet = textField_2.getText();
				String secondSet = textField_3.getText();
				String bigUniverse = textField_4.getText();
				ArrayList<ArrayList<String>> targetSet = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> universeSet = new ArrayList<ArrayList<String>>();
				targetSet = changeToArrayList(universe);
				universeSet = changeToArrayList(bigUniverse);
				for(int i=0;i<targetSet.size();i++){
					ArrayList<String> temp = new ArrayList<String>();
					temp = targetSet.get(i);
					for(int z=0;z<temp.size();z++){
						boolean check = false;
						for(int j=0;j<universeSet.get(0).size();j++){
							if(temp.get(z).equals(universeSet.get(0).get(j))){
								check = true;
						}
					}
						if(check ==false){
							
							JOptionPane.showMessageDialog(null,"The number "+temp.get(z)+ " doesn't exist in the universe");
									temp.remove(z);
						}
					}
				
				}
				
				ArrayList<String> target = new ArrayList<String>();
				if(Integer.parseInt(firstSet)>targetSet.size()||Integer.parseInt(firstSet)<=0||Integer.parseInt(secondSet)>targetSet.size()||Integer.parseInt(secondSet)<=0){
					JOptionPane.showMessageDialog(null,"Invalid number of sets");
				}
				target = intersection.intersection(targetSet,Integer.parseInt(firstSet),Integer.parseInt(secondSet));
				
				textField_1.setText(SetTheoryGUI.this.toString(target));
				
		}
		});
		btnNewButton_1.setBounds(139, 302, 118, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Complement");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetTheory complement = new SetTheory();
				String universe = textField.getText();
				String firstSet = textField_2.getText();
				String bigUniverse = textField_4.getText();
				ArrayList<ArrayList<String>> targetSet = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> universeSet = new ArrayList<ArrayList<String>>();
				targetSet = changeToArrayList(universe);
				universeSet = changeToArrayList(bigUniverse);
				for(int i=0;i<targetSet.size();i++){
					ArrayList<String> temp = new ArrayList<String>();
					temp = targetSet.get(i);
					for(int z=0;z<temp.size();z++){
						boolean check = false;
						for(int j=0;j<universeSet.get(0).size();j++){
							if(temp.get(z).equals(universeSet.get(0).get(j))){
								check = true;
						}
					}
						if(check ==false){
							
							JOptionPane.showMessageDialog(null,"The number "+temp.get(z)+ " doesn't exist in the universe");
									temp.remove(z);
						}
					}
				
				}
				ArrayList<String> target = new ArrayList<String>();
				if(Integer.parseInt(firstSet)>targetSet.size()||Integer.parseInt(firstSet)<=0){
					JOptionPane.showMessageDialog(null,"Invalid number of sets");
				}
				target = complement.Complement(targetSet,universeSet.get(0),Integer.parseInt(firstSet));
				
				textField_1.setText(SetTheoryGUI.this.toString(target));
			}
		});
		btnNewButton_2.setBounds(278, 302, 118, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Example: [1,2,3,4]/[1,4] ... (with no SPACES)");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(10, 121, 373, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(84, 343, 239, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterTheUniverse = new JLabel("Enter the universe:");
		lblEnterTheUniverse.setBounds(10, 25, 247, 14);
		frame.getContentPane().add(lblEnterTheUniverse);
		
		JLabel lblExampleaaya = new JLabel("Example: [1,2,3,a,aya] ... (with no SPACES and with no DUPLICATES)");
		lblExampleaaya.setForeground(Color.GRAY);
		lblExampleaaya.setBounds(10, 43, 386, 14);
		frame.getContentPane().add(lblExampleaaya);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 68, 313, 33);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
	
	public ArrayList<ArrayList<String>> changeToArrayList(String target){
		List<String> list = new ArrayList<String>();
		target = target.replaceAll("/", " ");
		list = Arrays.asList(target.trim().split(" "));
		ArrayList<String> targetSet = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			 targetSet.add(list.get(i));
		}
		ArrayList<ArrayList<String>> targetSet2 = new ArrayList<ArrayList<String>>();
		
		for(int i=0;i<targetSet.size();i++){
			List<String> list2 = new ArrayList<String>();
			String temp = targetSet.get(i);
			temp = temp.replaceAll("[,]", " ");
			temp = temp.replace('[', ' ');
			temp = temp.replace(']', ' ');
			list2 = Arrays.asList(temp.trim().split(" "));
			ArrayList<String> answer = new ArrayList<String>();
			for(int j=0;j<list2.size();j++){
			  answer.add(list2.get(j));
			}
			targetSet2.add(answer);	
		}
		return targetSet2;
		
	}
	public String toString(ArrayList<String> target){
		  String res1 = "[";
		  String res = String.join(",", target);
		  String res2 = "]";
	      return res1 + res + res2;
	}
}
