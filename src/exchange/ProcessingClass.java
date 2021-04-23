package exchange;

public class ProcessingClass {
	OutputClass outClass = null;

	ProcessingClass() {
		outClass = new OutputClass();
	}

	public void returnWon(ExchangeType exType) {
		int cwResult;
		cwResult = (int) exType.cw;
		int won10000, won5000, returnWon;
		int won1000, won500, won100, won10;

		returnWon = (int) (exType.cw / 10) * 10;
		won10000 = cwResult / 10000;
		won5000 = cwResult % 10000 / 5000;
		won1000 = cwResult % 10000 % 5000 / 1000;
		won500 = cwResult % 10000 % 5000 % 1000 / 500;
		won100 = cwResult % 10000 % 5000 % 1000 % 500 / 100;
		won10 = cwResult % 10000 % 5000 % 1000 % 500 % 100 / 10;

		outClass.printWon(exType.cw, returnWon, won10000, won5000, won1000, won500, won100, won10);

		exType.returnwon = returnWon;
	}

	public void exchangeUSD(ExchangeType exType) {
		double exchangeResult;
		double ex_rate;
		int usd;
		int usd100, usd50, usd20, usd10, usd5, usd2, usd1;
		ex_rate = ConstValueClass.EX_RATE_USD;
		exchangeResult = exType.w / ex_rate;

		usd = (int) exchangeResult;
		exType.return_exchange = usd;
		usd100 = usd / 100;
		usd50 = usd % 100 / 50;
		usd20 = usd % 100 % 50 / 20;
		usd10 = usd % 100 % 50 % 20 / 10;
		usd5 = usd % 100 % 50 % 20 % 10 / 5;
		usd2 = usd % 100 % 50 % 20 % 10 % 5 / 2;
		usd1 = usd % 100 % 50 % 20 % 10 % 5 % 2 / 1;

		exType.cw = exType.w - usd * ex_rate;

		outClass.printUSD(exchangeResult, usd, usd100, usd50, usd20, usd10, usd5, usd2, usd1);
	}

	public void exchangeEUR(ExchangeType exType) {
		double exchangeResult;
		double ex_rate;
		int eur, eur500, eur200, eur100, eur50, eur20, eur10, eur5;
		ex_rate = ConstValueClass.EX_RATE_EUR;
		exchangeResult = exType.w / ex_rate;

		eur = (int) exchangeResult - ((int) exchangeResult % 5);

		exType.return_exchange = eur;
		eur500 = eur / 500;
		eur200 = eur % 500 / 200;
		eur100 = eur % 500 % 200 / 100;
		eur50 = eur % 500 % 200 % 100 / 50;
		eur20 = eur % 500 % 200 % 100 % 50 / 20;
		eur10 = eur % 500 % 200 % 100 % 50 % 20 / 10;
		eur5 = eur % 500 % 200 % 100 % 50 % 20 % 10 / 5;

		exType.cw = exType.w - eur * ex_rate;

		outClass.printEURO(exchangeResult, eur, eur500, eur200, eur100, eur50, eur20, eur10, eur5);
	}

	public void exchangeJPY(ExchangeType exType) {
		double exchangeResult;
		double ex_rate;
		int jpy, jpy10000, jpy5000, jpy2000, jpy1000;
		ex_rate = ConstValueClass.EX_RATE_JPY;
		exchangeResult = exType.w / ex_rate;

		jpy = (int) exchangeResult - ((int) exchangeResult % 1000);

		exType.return_exchange = jpy;

		jpy10000 = jpy / 10000;
		jpy5000 = jpy % 10000 / 5000;
		jpy2000 = jpy % 10000 % 5000 / 2000;
		jpy1000 = jpy % 10000 % 5000 % 2000 / 1000;

		exType.cw = exType.w - jpy * ex_rate;

		outClass.printJPY(exchangeResult, jpy, jpy10000, jpy5000, jpy2000, jpy1000);
	}
}
