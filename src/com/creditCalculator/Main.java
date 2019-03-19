package com.creditCalculator;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;

import com.creditCalculator.PaymentSchedule;
import com.creditCalculator.Calculator;
import com.creditCalculator.WindowsType;

import java.awt.CardLayout;

public class Main implements com.creditCalculator.Callback{

	private JFrame creditCalcFrame;
	private JPanel calculator;
	private JPanel schedule;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.creditCalcFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		
		calculator = new Calculator(this).getWindow();
		schedule = new PaymentSchedule(this).getWindow();
		
		openWindow(WindowsType.CalculatorWindow);
		
		creditCalcFrame = new JFrame();
		creditCalcFrame.setResizable(false);
		creditCalcFrame.getContentPane().setBounds(new Rectangle(10, 10, 10, 10));
		
		creditCalcFrame.getContentPane().add(calculator);
		creditCalcFrame.getContentPane().add(schedule);
		creditCalcFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		creditCalcFrame.setTitle("\u041A\u0440\u0435\u0434\u0438\u0442\u043D\u044B\u0439 \u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440");
		creditCalcFrame.setBounds(100, 100, 510, 276);
		creditCalcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void changeWindow(WindowsType type) {
		openWindow(type);
	}

	private void openWindow(WindowsType type)
	{
		boolean isCalculatorWindow = true;
		
		switch(type) {
		case CalculatorWindow:
			isCalculatorWindow = true;
		break;
		case ScheduleWindow:
			isCalculatorWindow = false;
		break;
		}	
		
		calculator.setVisible(isCalculatorWindow);
		schedule.setVisible(!isCalculatorWindow);
	}
}
