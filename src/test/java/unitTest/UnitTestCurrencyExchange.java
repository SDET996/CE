package unitTest;

import secondREST.ExchangeCurrencyService;

public class UnitTestCurrencyExchange {
	
	ExchangeCurrencyService ecs = new ExchangeCurrencyService();
	
	public void testDTE () {
		
		ecs.convertDollarToEuro(100.00).getEntity();
	}

}
