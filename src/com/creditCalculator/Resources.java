package com.creditCalculator;

public enum Resources {
	annuity("Аннуитетный"),
	percentInMonth("% в месяц"),
	percentInYear("% в год"),
	money("Рублей"),
	percentOfCreditSum("% от суммы кредита"),
	months("Месяцев"),
	years("Лет"),
	creditSum("Сумма кредита"),
	creditTerm("Срок кредита"),
	interestRate("Процентная ставка"),
	paymentType("Вид платежа"),
	oneTimeFee("Единовременные комиссии"),
	monthlyFee("Ежемесячные комиссии"),
	startPayment("Начало выплат"),
	overPayment("Переплата по кредиту"),
	monthlyPayment("Ежемесячный платеж"),
	paymentSchedule("График выплат"),
	back("Назад"),
	differentiated("Дифференцированный"),
	notFound("Не найдено"),
	january("Январь"),
	february("Февраль"),
	march("Март"),
	april("Апрель"),
	may("Май"),
	june("Июнь"),
	july("Июль"),
	august("Август"),
	september("Сентябрь"),
	october("Октябрь"),
	november("Ноябрь"),
	december("Декабрь");
	
    private final String name;
    
    private Resources(final String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }
    
    public static String[] getMonths() {
		String[] result = new String[12];
		
		result[0] = january.getText();
		result[1] = february.getText();
		result[2] = march.getText();
		result[3] = april.getText();
		result[4] = may.getText();
		result[5] = june.getText();
		result[6] = july.getText();
		result[7] = august.getText();
		result[8] = september.getText();
		result[9] = october.getText();
		result[10] = november.getText();
		result[11] = december.getText();

		return result;
	}
    
    public static String[] getPaymentTypes() {
    	String[] result = new String[2];
		
		result[0] = annuity.getText();
		result[1] = differentiated.getText();

		return result;
    }
    
    public static String[] getCreditTerms() {
    	String[] result = new String[2];
		
		result[0] = years.getText();
		result[1] = months.getText();

		return result;
    }
    
    public static String[] getOneTimeFees() {
    	String[] result = new String[2];
		
		result[0] = percentOfCreditSum.getText();
		result[1] = money.getText();

		return result;
    }
    
    public static String[] getInterestRates() {
    	String[] result = new String[2];
		
		result[0] = percentInYear.getText();
		result[1] = percentInMonth.getText();

		return result;
    }
    
    public static String[] getMonthlyFees() {
    	String[] result = new String[2];
		
		result[0] = percentOfCreditSum.getText();
		result[1] = money.getText();

		return result;
    }
    
    public static Integer[] getDays(String month) {
    	Resources value = Resources.permissiveValueOf(month);
    	
    	if(value == january || value == march || value == may || value == july || 
    	    value == august || value == october || value == december) {
    		return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
    							   16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
    							   29, 30, 31 };
    	} else if(value == april || value == june || value == september || value == november) {
    		return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
					   15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
					   28, 29, 30 };	
    	} else if(value == february) {
    		return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
					   15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
					   28, 29 };	
    	}
    	
		return new Integer[] { 0 };
    }
    
    public static Resources permissiveValueOf(String name) {
        for (Resources e : values()) {
            if (e.getText().equals(name)) {
                return e;
            }
        }
        return null;
    }
}
