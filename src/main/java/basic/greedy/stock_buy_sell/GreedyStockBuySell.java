package basic.greedy.stock_buy_sell;

public class GreedyStockBuySell {

	public static int [] stock_prices1 = {7, 1, 5, 3, 6, 4};
	public static int [] stock_prices2 = {1, 2, 3, 4, 5};
	public static int [] stock_prices3 = {7, 6, 4, 3, 1};

	public int maxProfit(int[] prices) {
		int stockCnt = 0; 	// 주식의 갯수
		int totalIncome = 0; // 누적수익
		int buyPrice = 0;

		for(int i=0; i<prices.length-1; i++){
			int today_price = prices[i];			// i 	= 0, 1, 2, 3 (arr.length == 5 일때)
			int tommorrow_price = prices[i+1];		// i+1 	= 1, 2, 3, 4 (arr.length == 5 일때)

			if (today_price < tommorrow_price){		// 비교해보니 내일 오른다. buy
				if(i==0) stockCnt++; 	// buy (첫날은 주식 갯수 0개인데 다음날 올라가므로 사야한다.)
				if(stockCnt > 0){		// 어제보다 오늘 올랐지만, 내일 또 오르게 되는 경우, 가지고 있는 주식을 처분한다.
					totalIncome = totalIncome + (tommorrow_price - today_price);
					stockCnt--;			// sell
				}
				stockCnt++;
			}
			else{		// 보합이거나, 오늘 가격이 내일에 비해 고점. sell
				if(stockCnt > 0){
					totalIncome = totalIncome + (tommorrow_price - today_price);
					stockCnt--;
				}
			}
		}

		return totalIncome;
	}

	public static void main(String [] args){
		GreedyStockBuySell g = new GreedyStockBuySell();
//		int answer = g.maxProfit(stock_prices1);
		int answer = g.maxProfit(stock_prices2);
//		int answer = g.maxProfit(stock_prices3);
		System.out.println("answer = " + answer);
	}
}
