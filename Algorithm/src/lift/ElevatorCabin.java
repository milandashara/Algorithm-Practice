package lift;

import java.util.TreeSet;

public class ElevatorCabin {
	
	public int currentFloor = 0;
	public UpDownEnum direction = UpDownEnum.UP;
	public TreeSet<Integer> callingFloorList  = new TreeSet<Integer>();
	
	public void add(Integer floor){
		callingFloorList.add(floor);
	}
	
	public Integer gotoNext(){
		Integer nextFloor = currentFloor;
		switch(direction){
		case UP:
			//go up to next floor
			for (Integer floor : callingFloorList) {
				if(floor > nextFloor){
					nextFloor = floor;
					direction = UpDownEnum.UP;
					break;
				}
			}
			
			//if reached top change direction to down
			if(nextFloor == currentFloor){
				for (Integer floor : callingFloorList.descendingSet()) {
					if(floor < nextFloor){
						nextFloor = floor;
						direction = UpDownEnum.DOWN;
						break;
					}
				}
			}
			break;
		case DOWN:
			//go down to next floor
			for (Integer floor : callingFloorList.descendingSet()) {
				if(floor < nextFloor){
					nextFloor = floor;
					direction = UpDownEnum.DOWN;
					break;
				}
			}
			
			//if reached bottom change direction to up
			if(nextFloor == currentFloor){
				for (Integer floor : callingFloorList) {
					if(floor > nextFloor){
						nextFloor = floor;
						direction = UpDownEnum.UP;
						break;
					}
				}
			}
		}
		
		//remove current floor from calling floor list
		callingFloorList.remove(nextFloor);
		//set current floor
		currentFloor = nextFloor;
		return nextFloor;
	}
}