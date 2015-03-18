package problems.redmart;

public class Point {

	public Integer x;
	
	public Integer y;
	
	private Point next;
	
	private int value;
	
	public int leftCount;
	
	public int getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(int leftCount) {
		
		this.leftCount = leftCount;
	}

	public int getRightCount() {
		return rightCount;
	}

	public void setRightCount(int rightCount) {
		
		this.rightCount = rightCount;
	}

	public int getTopCount() {
		return topCount;
	}

	public void setTopCount(int topCount) {
		this.topCount = topCount;
	}

	public int getBottomCount() {
		return bottomCount;
	}

	public void setBottomCount(int bottomCount) {
		this.bottomCount = bottomCount;
	}

	public int rightCount;
	
	public int topCount;
	
	public int bottomCount;
	
	public Point rightPoint;
	
	public Point leftPoint;
	
	public Point topPoint;
	
	public Point bottomPoint;
	
	public Point(Integer x,Integer y,int value) {
		this.x=x;
		this.y=y;
		this.value=value;
	}
	
	@Override
	public boolean equals(Object obj) {
		Point p=(Point) obj;
		return this.x.equals(p.x) && this.y.equals(p.y);
	}
	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return x+y+right()+top()+bootom()+left();
//	}
	
	public int value(){
		return this.value;
	}
	
//	public int top(){
//		if(x-1==-1)
//			return -1;
//		return RedmartChallenge1.data[x-1][y];
//	}
//	public int bootom(){
//		if(x+1 >= RedmartChallenge1.data.length)
//			return -1;
//		return RedmartChallenge1.data[x+1][y];
//	}
//	public int left(){
//		if(y-1==-1)
//			return -1;
//		return RedmartChallenge1.data[x][y-1];
//	}
//	public int right(){
//		if(y+1 >= RedmartChallenge1.data.length)
//			return -1;
//		return RedmartChallenge1.data[x][y+1];
//	}
	
	public Point rightPoint(){
		if(y+1 >= RedmartChallenge.length)
			return null;
		if(this.rightPoint!=null)
			return rightPoint;
		
		rightPoint=RedmartChallenge.allPoints.get(x+" "+(y+1));
		return rightPoint;
	}
	
	public Point leftPoint(){
		if(y-1==-1)
			return null;
		if(this.leftPoint!=null)
			return leftPoint;
		leftPoint=RedmartChallenge.allPoints.get(x+" "+(y-1)); 
		return leftPoint;
	}
	
	public Point topPoint(){
		if(x-1==-1)
			return null;
		if(this.topPoint!=null)
			return topPoint;
		
		topPoint=RedmartChallenge.allPoints.get((x-1)+" "+(y));  
		return topPoint;
	}
	
	public Point bottomPoint(){
		if(x+1 >= RedmartChallenge.length)
			return null;
		
		if(this.bottomPoint!=null)
			return bottomPoint;
		this.bottomPoint =RedmartChallenge.allPoints.get((x+1)+" "+(y));  
		return this.bottomPoint;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+","+y+","+value;
	}
	
	public void setNext(Point next){
		this.next=next;
	}
	
	public Point next(){
		return next;
	}
	
}
