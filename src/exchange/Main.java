package exchange;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		ExchangeType exType;
		
		ProcessingClass pc = new ProcessingClass();
		InputFromConsoleClass inputConsole = new InputFromConsoleClass();
		FileWriteClass fwc = new FileWriteClass();
		
		fwc.headerWrite();

		do {
			exType = new ExchangeType();
			inputConsole.inputType(exType);
			
			if (exType.type == ConstValueClass.EX_TYPE_EXIT) {
				break;
			}
			inputConsole.inputWon(exType);
			
			if (exType.type == ConstValueClass.EX_TYPE_USD) {
				pc.exchangeUSD(exType);
			} else if (exType.type == ConstValueClass.EX_TYPE_EUR) {
				pc.exchangeEUR(exType);
			} else if (exType.type == ConstValueClass.EX_TYPE_JPY) {
				pc.exchangeJPY(exType);
			}
			pc.returnWon(exType);
			
			fwc.dataWrite(exType);

		} while (exType.type != ConstValueClass.EX_TYPE_EXIT);
		
		fwc.fileClose();
	}	

}
