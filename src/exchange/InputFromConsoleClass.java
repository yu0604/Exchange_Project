package exchange;

import java.util.Scanner;

public class InputFromConsoleClass {
	Scanner scanner = null;

	InputFromConsoleClass() {
		scanner = new Scanner(System.in);
	}

	protected void finalize() {
		scanner.close();
	}

	public void inputWon(ExchangeType exType) {
		System.out.print("*받은 원화 입력 : ");
		exType.w = scanner.nextInt();
	}

	public void inputType(ExchangeType exType) {
		System.out.print("환전할 종류 선택 (0:종료, 1:USD, 2:EUR, 3:JPY) ? ");
		exType.type = scanner.nextInt();
		if (exType.type == ConstValueClass.EX_TYPE_USD) {
			exType.exchange_type = "USD";
		} else if (exType.type == ConstValueClass.EX_TYPE_EUR) {
			exType.exchange_type = "EUR";
		} else if (exType.type == ConstValueClass.EX_TYPE_JPY) {
			exType.exchange_type = "JPY";
		}
		
	}
}
