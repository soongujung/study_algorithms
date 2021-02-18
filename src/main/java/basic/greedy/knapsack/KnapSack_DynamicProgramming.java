package basic.greedy.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KnapSack_DynamicProgramming {

	class Box {
		public Integer weight;
		public Integer price;
		public String label;

		public Box(int weight, int price, String label){
			this.weight = weight;
			this.price = price;
			this.label = label;
		}
	}

	public List<Box> getBoxes(){
		List<Box> boxes = Arrays.asList(
			new Box(12, 4, "A"),
			new Box(1, 2, "B"),
			new Box(4, 10, "C"),
			new Box(1, 1, "D"),
			new Box(2, 2, "E")
		);
		return boxes;
	}

	public PricePerKg newPricePerKg(double pricePerKg, Box box){
		return new PricePerKg(pricePerKg, box);
	}

	class PricePerKg {
		public Double dollarPerKg;
		public Box box;

		public PricePerKg (double dollarPerKg, Box box){
			this.dollarPerKg = dollarPerKg;
			this.box = box;
		}

		public Double getDollarPerKg() {
			return dollarPerKg;
		}
	}

	public static void main(String [] args){
		KnapSack_DynamicProgramming p = new KnapSack_DynamicProgramming();
		List<Box> boxes = p.getBoxes();
		List<PricePerKg> valueList = new ArrayList<>();
		final int MAX_WEIGHT = 15;
		int totalWeight = MAX_WEIGHT; // 15kg (배낭에 들어갈 수 있는 최대 무게)

		for(Box b : boxes){
			int kg = b.weight;
			int price = b.price;
			String label = b.label;

			double pricePerKg = price / (double)kg;

			PricePerKg value = p.newPricePerKg(pricePerKg, b);
			valueList.add(value);
		}

		List<PricePerKg> rSortedList = valueList.stream()
			.sorted(Comparator.comparingDouble(
				PricePerKg::getDollarPerKg).reversed()
			)
			.collect(Collectors.toList());

		double totalPrice = 0;
		for(PricePerKg temp : rSortedList){
			System.out.println("price/kg = " + temp.getDollarPerKg() + ", label = " + temp.box.label + ", weight = " + temp.box.weight);
			if(totalWeight - temp.box.weight >= 0){
				totalWeight = totalWeight - temp.box.weight;
				totalPrice = totalPrice + temp.box.price;
				System.out.println("totalPrice = " + totalPrice);
			}
			else{
				// 만약 가장 마지막에 남은 박스이거나,
				// 현재 순서의 박스의 무게가 남은 무게제한을 넘어섰을때
				// kg 당 price를 구하고, 남은 무게 x kg당 price
				// 그러면 일정 비율의 price를 구할수 있게 된다.
				double pricePerKg = temp.dollarPerKg;
				System.out.println("---");
				System.out.println("totalPrice = " + totalPrice + " + ("+ totalWeight + " * " + pricePerKg  +")" + " )");
				System.out.println("totalWeight * pricePerKg = " + totalWeight * pricePerKg);
				totalPrice = totalPrice + (totalWeight * pricePerKg);
				break;
			}

		}

		System.out.println("totalPrice = " + totalPrice + ", totalWeight = " + totalWeight);
	}
}
