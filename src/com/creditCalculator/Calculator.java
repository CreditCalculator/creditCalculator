package com.creditCalculator;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.creditCalculator.Callback;
import com.creditCalculator.WindowsType;
import com.creditCalculator.Resources;
import com.creditCalculator.CalculatorController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calculator {

	private JPanel calculatorPanel;
	private JTextField creditSum;
	private JTextField creditTerm;
	private JTextField oneTimeFee;
	private JTextField interestRate;
	private Callback changeWindow;
	
	private CalculatorController controller;
	
	public Calculator(Callback callback) {
		changeWindow = callback;
		controller = new CalculatorController();
		
		initialize();
	}

	private void initialize() {
		 calculatorPanel = new JPanel();
		 calculatorPanel.setLayout(new FormLayout(new ColumnSpec[] {
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		ColumnSpec.decode("max(30dlu;pref):grow"),
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		ColumnSpec.decode("max(30dlu;pref):grow"),
		 		FormSpecs.RELATED_GAP_COLSPEC,},
		 	new RowSpec[] {
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,}));
		 
		 Box creditSumBox = Box.createVerticalBox();
		 calculatorPanel.add(creditSumBox, "2, 2, fill, center");
		 
		 Box creditSumVerticalBox = Box.createVerticalBox();
		 creditSumBox.add(creditSumVerticalBox);
		 
		 JLabel creditSumLabel = new JLabel(Resources.creditSum.getText() + ":");
		 creditSumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 creditSumVerticalBox.add(creditSumLabel);
		 
		 Box creditSumHorizontalBox = Box.createHorizontalBox();
		 creditSumHorizontalBox.setAlignmentY(0.5f);
		 creditSumHorizontalBox.setAlignmentX(0.0f);
		 creditSumVerticalBox.add(creditSumHorizontalBox);
		 
		 creditSum = new JTextField();
		 creditSum.setToolTipText(Resources.money.getText());
		 creditSum.setColumns(10);
		 creditSumHorizontalBox.add(creditSum);
		 
		 Box paymentTypeBox = Box.createVerticalBox();
		 calculatorPanel.add(paymentTypeBox, "4, 2, fill, center");
		 
		 Box paymentTypeVerticalBox = Box.createVerticalBox();
		 paymentTypeBox.add(paymentTypeVerticalBox);
		 
		 JLabel paymentTypeLabel = new JLabel(Resources.paymentType.getText() + ":");
		 paymentTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 paymentTypeVerticalBox.add(paymentTypeLabel);
		 
		 Box paymentTypeHorizontalBox = Box.createHorizontalBox();
		 paymentTypeHorizontalBox.setAlignmentX(0.0f);
		 paymentTypeVerticalBox.add(paymentTypeHorizontalBox);
		 
		 JComboBox<String> paymentType = new JComboBox<String>();
		 paymentType.setModel(new DefaultComboBoxModel<String>(Resources.getPaymentTypes()));
		 paymentType.setMaximumRowCount(Resources.getPaymentTypes().length);
		 paymentTypeHorizontalBox.add(paymentType);
		 
		 Box creditTermBox = Box.createVerticalBox();
		 calculatorPanel.add(creditTermBox, "2, 4, fill, center");
		 
		 Box creditTermVerticalBox = Box.createVerticalBox();
		 creditTermBox.add(creditTermVerticalBox);
		 
		 JLabel creditTermLabel = new JLabel(Resources.creditTerm.getText() + ":");
		 creditTermLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 creditTermVerticalBox.add(creditTermLabel);
		 
		 Box creditTermHorizontalBox = Box.createHorizontalBox();
		 creditTermHorizontalBox.setAlignmentY(0.5f);
		 creditTermHorizontalBox.setAlignmentX(0.0f);
		 creditTermVerticalBox.add(creditTermHorizontalBox);
		 
		 creditTerm = new JTextField();
		 creditTerm.setToolTipText(Resources.years.getText() + "/" + Resources.months.getText());
		 creditTerm.setColumns(10);
		 creditTermHorizontalBox.add(creditTerm);
		 
		 JComboBox<String> creditTermComboBox = new JComboBox<String>();
		 creditTermComboBox.setModel(new DefaultComboBoxModel<String>(Resources.getCreditTerms()));
		 creditTermComboBox.setMaximumRowCount(Resources.getCreditTerms().length);
		 creditTermHorizontalBox.add(creditTermComboBox);
		 
		 Box oneTimeFeeBox = Box.createVerticalBox();
		 calculatorPanel.add(oneTimeFeeBox, "4, 4, fill, center");
		 
		 Box oneTimeFeeVerticalBox = Box.createVerticalBox();
		 oneTimeFeeBox.add(oneTimeFeeVerticalBox);
		 
		 JLabel oneTimeFeeLabel = new JLabel(Resources.oneTimeFee.getText() + ":");
		 oneTimeFeeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 oneTimeFeeVerticalBox.add(oneTimeFeeLabel);
		 
		 Box oneTimeFeeHorizontalBox = Box.createHorizontalBox();
		 oneTimeFeeHorizontalBox.setAlignmentY(0.5f);
		 oneTimeFeeHorizontalBox.setAlignmentX(0.0f);
		 oneTimeFeeVerticalBox.add(oneTimeFeeHorizontalBox);
		 
		 oneTimeFee = new JTextField();
		 oneTimeFee.setToolTipText(Resources.percentOfCreditSum.getText());
		 oneTimeFee.setColumns(10);
		 oneTimeFeeHorizontalBox.add(oneTimeFee);
		 
		 JComboBox<String> oneTimeFeeComboBox = new JComboBox<String>();
		 oneTimeFeeComboBox.setModel(new DefaultComboBoxModel<String>(Resources.getOneTimeFees()));
		 oneTimeFeeComboBox.setMaximumRowCount(Resources.getOneTimeFees().length);
		 oneTimeFeeHorizontalBox.add(oneTimeFeeComboBox);
		 
		 Box interestRateBox = Box.createVerticalBox();
		 calculatorPanel.add(interestRateBox, "2, 6, fill, center");
		 
		 Box interestRateVerticalBox = Box.createVerticalBox();
		 interestRateBox.add(interestRateVerticalBox);
		 
		 JLabel interestRateLabel = new JLabel(Resources.interestRate.getText() + ":");
		 interestRateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 interestRateVerticalBox.add(interestRateLabel);
		 
		 Box interestRateHorizontalBox = Box.createHorizontalBox();
		 interestRateHorizontalBox.setAlignmentX(0.0f);
		 interestRateVerticalBox.add(interestRateHorizontalBox);
		 
		 interestRate = new JTextField();
		 interestRate.setToolTipText(Resources.percentInYear.getText() + "/" + Resources.months.getText().toLowerCase());
		 interestRate.setHorizontalAlignment(SwingConstants.LEFT);
		 interestRate.setColumns(10);
		 interestRate.setAlignmentX(0.0f);
		 interestRateHorizontalBox.add(interestRate);
		 
		 JComboBox<String> interestRateComboBox = new JComboBox<String>();
		 interestRateComboBox.setModel(new DefaultComboBoxModel<String>(Resources.getInterestRates()));
		 interestRateComboBox.setMaximumRowCount(Resources.getInterestRates().length);
		 interestRateHorizontalBox.add(interestRateComboBox);
		 
		 Box monthlyFeeBox = Box.createVerticalBox();
		 calculatorPanel.add(monthlyFeeBox, "4, 6, fill, center");
		 
		 Box monthlyFeeVerticalBox = Box.createVerticalBox();
		 monthlyFeeBox.add(monthlyFeeVerticalBox);
		 
		 JLabel monthlyFeeLabel = new JLabel(Resources.monthlyFee.getText() + ":");
		 monthlyFeeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 monthlyFeeVerticalBox.add(monthlyFeeLabel);
		 
		 Box monthlyFeeHorizontalBox = Box.createHorizontalBox();
		 monthlyFeeHorizontalBox.setAlignmentY(0.5f);
		 monthlyFeeHorizontalBox.setAlignmentX(0.0f);
		 monthlyFeeVerticalBox.add(monthlyFeeHorizontalBox);
		 
		 JTextField monthlyFee = new JTextField();
		 monthlyFee.setToolTipText(Resources.percentInYear.getText() + "/" + Resources.months.getText().toLowerCase());
		 monthlyFee.setColumns(10);
		 monthlyFeeHorizontalBox.add(monthlyFee);
		 
		 JComboBox<String> monthlyFeeComboBox = new JComboBox<String>();
		 monthlyFeeComboBox.setModel(new DefaultComboBoxModel<String>(Resources.getMonthlyFees()));
		 monthlyFeeComboBox.setMaximumRowCount(Resources.getMonthlyFees().length);
		 monthlyFeeHorizontalBox.add(monthlyFeeComboBox);
		 
		 Box startPaymentBox = Box.createVerticalBox();
		 calculatorPanel.add(startPaymentBox, "2, 8, 3, 1, fill, center");
		 
		 Box startPaymentVerticalBox = Box.createVerticalBox();
		 startPaymentBox.add(startPaymentVerticalBox);
		 
		 JLabel startPaymentLabel = new JLabel(Resources.startPayment.getText() + ":");
		 startPaymentLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 startPaymentVerticalBox.add(startPaymentLabel);
		 
		 Box startPaymentHorizontalBox = Box.createHorizontalBox();
		 startPaymentHorizontalBox.setAlignmentX(0.0f);
		 startPaymentVerticalBox.add(startPaymentHorizontalBox);
		 
		 JComboBox<String> startPaymentMonth = new JComboBox<String>();
		 startPaymentMonth.setModel(new DefaultComboBoxModel<String>(Resources.getMonths()));
		 startPaymentMonth.setMaximumRowCount(12);
		 startPaymentHorizontalBox.add(startPaymentMonth);
		 
		 JComboBox<Integer> startPaymentDay = new JComboBox<Integer>();
		 startPaymentDay.setModel(new DefaultComboBoxModel<Integer>(Resources.getDays(startPaymentMonth.getSelectedItem().toString())));
		 startPaymentDay.setMaximumRowCount(Resources.getDays(startPaymentMonth.getSelectedItem().toString()).length);
		 startPaymentHorizontalBox.add(startPaymentDay);
		 
		 Box paymentBox = Box.createVerticalBox();
		 calculatorPanel.add(paymentBox, "2, 10, fill, center");
		 
		 Box paymentVerticalBox = Box.createVerticalBox();
		 paymentBox.add(paymentVerticalBox);
		 
		 JLabel monthlyPayment = new JLabel(Resources.monthlyPayment.getText() + ": " + controller.getMonthlyPayment());
		 paymentVerticalBox.add(monthlyPayment);
		 
		 Component paymentGlue = Box.createVerticalGlue();
		 paymentGlue.setMinimumSize(new Dimension(0, 10));
		 paymentVerticalBox.add(paymentGlue);
		 
		 JLabel overPayment = new JLabel(Resources.overPayment.getText() + ": " + controller.getOverPayment());
		 paymentVerticalBox.add(overPayment);
		 
		 Box paymentScheduleBtnBox = Box.createVerticalBox();
		 calculatorPanel.add(paymentScheduleBtnBox, "4, 10, right, bottom");
		 
		 Box paymentScheduleBtnVerticalBox = Box.createVerticalBox();
		 paymentScheduleBtnVerticalBox.setAlignmentX(1.0f);
		 paymentScheduleBtnBox.add(paymentScheduleBtnVerticalBox);
		 
		 JButton paymentScheduleBtn = new JButton(Resources.paymentSchedule.getText());
		 paymentScheduleBtn.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		changeWindow.changeWindow(WindowsType.ScheduleWindow);
		 	}
		 });
		 paymentScheduleBtnVerticalBox.add(paymentScheduleBtn);
	}
	
	public JPanel getWindow() {
		return calculatorPanel;
	}

}
