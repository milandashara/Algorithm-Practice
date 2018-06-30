package babylon;

		import java.util.PriorityQueue;
		import java.util.Scanner;

/**
 * Created by milanashara on 5/20/17.
 * <p>
 * Vacination clinic
 */
public class Solution3 {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine().trim();
		String[] temp = firstLine.split(" ");
		int numOfCity = Integer.parseInt(temp[0]);
		int numOfClinic = Integer.parseInt(temp[1]);
		int i, pop;
		City city;
		PriorityQueue<City> pq = new PriorityQueue<City>();
		for (i = 0; i < numOfCity; i++) {
			pop = in.nextInt();
			city = new City(pop);
			pq.add(city);
		}
		for (i = 0; i < (numOfClinic - numOfCity); i++) {
			city = pq.poll();
			city.clinics++;
			city.numOfPeopleVaccinated = city.population / city.clinics;
			if (!(city.population % city.clinics == 0)) {
				city.numOfPeopleVaccinated++;
			}
			pq.add(city);
		}
		city = pq.peek();
		System.out.println(city.numOfPeopleVaccinated);


	}


}

class City implements Comparable<City> {
	int population;
	int clinics;
	int numOfPeopleVaccinated;

	City(int pop) {
		population = pop;
		clinics = 1;
		numOfPeopleVaccinated = population;
	}

	@Override
	public int compareTo(City other) {
		if (this.numOfPeopleVaccinated > other.numOfPeopleVaccinated) {
			return -1;
		}
		if (this.numOfPeopleVaccinated < other.numOfPeopleVaccinated) {
			return 1;
		}
		return 0;
	}
}
