package ExchangePackage;

import java.io.IOException;

public class MoneyExchange {
	public static void main(String[] args) throws IOException {
		ExchangeType exType;
		
		ProcessingClass pc = new ProcessingClass();
		InputFromConsoleClass inputConsole = new InputFromConsoleClass();
		FileWriteClass fwc = new FileWriteClass();
		
		fwc.headerWrite();

		do {
			exType = new ExchangeType();
			exType.w = inputConsole.inputWon();
			exType.type = inputConsole.inputType();
			
			if (exType.type == ConstValueClass.EX_TYPE_EXIT) {
				break;
			}

			if (exType.type == ConstValueClass.EX_TYPE_USD) {
				exType.cw = pc.exchangeUSD(exType.w);
				exType.ex_rate = ConstValueClass.EX_RATE_USD;
				exType.exchange_type = "USD";
			} else if (exType.type == ConstValueClass.EX_TYPE_EUR) {
				exType.cw = pc.exchangeEUR(exType.w);
				exType.ex_rate = ConstValueClass.EX_RATE_EUR;
				exType.exchange_type = "EUR";
			} else if (exType.type == ConstValueClass.EX_TYPE_JPY) {
				exType.cw = pc.exchangeJPY(exType.w);
				exType.ex_rate = ConstValueClass.EX_RATE_JPY;
				exType.exchange_type = "JPY";
			}
			
			exType.returnwon = pc.returnWon(exType.cw);
			
			fwc.dataWrite(exType);

		} while (exType.type != ConstValueClass.EX_TYPE_EXIT);
		
		fwc.fileClose();
	}	

}
