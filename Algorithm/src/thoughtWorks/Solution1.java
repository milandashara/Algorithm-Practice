package thoughtWorks;

import java.util.*;

public class Solution1 {




	public static void main(String a[]){
		//Scanner
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());                // Reading input from STDIN

		int serverCount = 0;
		List<SalesTime> salesTimes = new ArrayList<>();
		for (int i = 0;i<n;i++){
			String str = s.nextLine();
			SalesTime startSaleTime = getSalesTime(str);
			salesTimes.add(startSaleTime);

		}

		//SalesTime prevSaleTime = salesTimes.get(0);
		serverCount = merge(salesTimes);

		System.out.println(serverCount);
	}

	public static  int merge(List<SalesTime> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(intervals.size() == 0)
			return 0;
		if(intervals.size() == 1)
			return 1;

		Collections.sort(intervals, new SaleTimeComparator());

		SalesTime first = intervals.get(0);

		int serverCount=1;
		ArrayList<SalesTime> result = new ArrayList<SalesTime>();
		SalesTime prevSaleTime = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++){
			SalesTime salesTime = intervals.get(0);
			if (prevSaleTime.getEndHr() > salesTime.getStartHr()) {
				serverCount++;
				break;
			} else if (prevSaleTime.getEndHr() == salesTime.getStartHr()) {
				if (prevSaleTime.getEndMt() + 5 > salesTime.getStartMt()) {
					serverCount++;
					break;
				}
			}

		}



		return serverCount;

	}

	public static SalesTime getSalesTime(String s){
		String temp[]=s.split("\\s");
		SalesTime salesTime = new SalesTime();
		salesTime.setStartHr(Integer.parseInt(temp[0]));
		salesTime.setStartMt(Integer.parseInt(temp[1]));
		salesTime.setEndHr(Integer.parseInt(temp[2]));
		salesTime.setEndMt(Integer.parseInt(temp[3]));
		return salesTime;
	}



}

class SalesTime {
	private int startHr;
	private int startMt;
	private int endHr;
	private int endMt;

	public int getStartHr() {
		return startHr;
	}

	public void setStartHr(int startHr) {
		this.startHr = startHr;
	}

	public int getStartMt() {
		return startMt;
	}

	public void setStartMt(int startMt) {
		this.startMt = startMt;
	}

	public int getEndHr() {
		return endHr;
	}

	public void setEndHr(int endHr) {
		this.endHr = endHr;
	}

	public int getEndMt() {
		return endMt;
	}

	public void setEndMt(int endMt) {
		this.endMt = endMt;
	}
}

class SaleTimeComparator implements Comparator{
	public int compare(Object o1, Object o2){
		SalesTime i1 = (SalesTime)o1;
		SalesTime i2 = (SalesTime)o2;

		if (i1.getEndHr() < i2.getStartHr()) {
			return -1;
		} else if (i1.getEndHr() == i2.getStartHr()) {
			if (i1.getEndMt()< i2.getStartMt()) {
				return -1;
			}else {
				return 1;
			}
		}else if (i1.getEndHr() > i2.getStartHr()){
			return 1;
		}

		return 0;


	}
}