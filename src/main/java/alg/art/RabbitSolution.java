package alg.art;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class RabbitSolution {

	public static void main(String[] args) {
		new RabbitSolution().solution(5, 6);
	}

	private class Rabbit {
		private int age;

		public Rabbit(int age) {
			this.age = age;
		}

		public String toString() {
			return String.valueOf(age);
		}
	}

	private void solution(int maxAge, int year) {
		List<Rabbit> rabbitList = new ArrayList<>();
		rabbitList.add(new Rabbit(0));
		rabbitList.add(new Rabbit(0));

		for (int i = 1; i <= year; i++) {
			calAge(rabbitList);
			calDead(rabbitList, maxAge);
			calIncrease(rabbitList, maxAge);
			if (rabbitList.size() > 20) {
				Iterator<Rabbit> iter = rabbitList.iterator();
				for (int j = 1; j <= 4; j++) {
					iter.remove();
				}
			}
		}

		int totalAge = 0;
		for (Rabbit rabbit : rabbitList) {
			totalAge += rabbit.age;
		}

		System.out.println(totalAge);
	}

	private void calIncrease(List<Rabbit> rabbitList, int maxAge) {
		List<Rabbit> newRabbitList = new ArrayList<>();
		for (Rabbit rabbit : rabbitList) {
			if (rabbit.age >= 2 && rabbit.age < maxAge) {
				newRabbitList.add(new Rabbit(0));
			}
		}
		rabbitList.addAll(newRabbitList);
	}

	private void calDead(List<Rabbit> rabbitList, int maxAge) {
		Iterator<Rabbit> iter = rabbitList.iterator();
		while (iter.hasNext()) {
			Rabbit rabbit = iter.next();
			if (rabbit.age >= maxAge) {
				iter.remove();
			}
		}
	}

	private void calAge(List<Rabbit> rabbitList) {
		for (Rabbit rabbit : rabbitList) {
			rabbit.age++;
		}
	}
}
