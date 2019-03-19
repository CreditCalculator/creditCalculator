package com.creditCalculator;

import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;

import com.creditCalculator.Callback;
import com.creditCalculator.WindowsType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.creditCalculator.Resources;

public class PaymentSchedule {

	private JTable paymentsTable;
	private JPanel paymentPanel;
	private Callback changeWindow;
	public PaymentSchedule(Callback callback) {
		changeWindow = callback;
		initialize();
	}

	private void initialize() {
		paymentPanel = new JPanel();
		paymentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(50dlu;pref):grow"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;pref)"),
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		
		Box paymentTableBox = Box.createVerticalBox();
		paymentPanel.add(paymentTableBox, "2, 2, fill, top");
		
		paymentsTable = new JTable();
		paymentsTable.setColumnSelectionAllowed(true);
		paymentsTable.setFillsViewportHeight(true);
		paymentsTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		paymentTableBox.add(paymentsTable);
		paymentsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		paymentsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u041C\u0435\u0441\u044F\u0446", "\u0421\u0443\u043C\u043C\u0430", "\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0434\u043E\u043B\u0433", "\u041F\u0440\u043E\u0446\u0435\u043D\u0442\u044B", "\u041E\u0441\u0442\u0430\u0442\u043E\u043A"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		paymentsTable.getColumnModel().getColumn(0).setResizable(false);
		paymentsTable.getColumnModel().getColumn(1).setResizable(false);
		paymentsTable.getColumnModel().getColumn(2).setResizable(false);
		paymentsTable.getColumnModel().getColumn(3).setResizable(false);
		paymentsTable.getColumnModel().getColumn(4).setResizable(false);
		Box backBtnbox = Box.createVerticalBox();
		paymentPanel.add(backBtnbox, "2, 4, right, bottom");
		
		JButton backBtn = new JButton(Resources.back.getText());
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
		 	public void mousePressed(MouseEvent e) {
		 		changeWindow.changeWindow(WindowsType.CalculatorWindow);
		 	}
		});
		backBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		backBtnbox.add(backBtn);
	}
	
	public JPanel getWindow()
	{
		return paymentPanel;
	}
}
