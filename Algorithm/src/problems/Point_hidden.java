//package problems;
//
//public class Point_hidden {
//
//	public Integer x;
//	
//	public Integer y;
//	
//	private Point_hidden next;
//	
//	public int leftCount;
//	
//	public int getLeftCount() {
//		return leftCount;
//	}
//
//	public void setLeftCount(int leftCount) {
//		
//		this.leftCount = leftCount;
//	}
//
//	public int getRightCount() {
//		return rightCount;
//	}
//
//	public void setRightCount(int rightCount) {
//		
//		this.rightCount = rightCount;
//	}
//
//	public int getTopCount() {
//		return topCount;
//	}
//
//	public void setTopCount(int topCount) {
//		this.topCount = topCount;
//	}
//
//	public int getBottomCount() {
//		return bottomCount;
//	}
//
//	public void setBottomCount(int bottomCount) {
//		this.bottomCount = bottomCount;
//	}
//
//	public int rightCount;
//	
//	public int topCount;
//	
//	public int bottomCount;
//	
//	public Point_hidden rightPoint;
//	
//	public Point_hidden leftPoint;
//	
//	public Point_hidden topPoint;
//	
//	public Point_hidden bottomPoint;
//	
//	public Point_hidden(Integer x,Integer y) {
//		this.x=x;
//		this.y=y;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		Point_hidden p=(Point_hidden) obj;
//		return this.x.equals(p.x) && this.y.equals(p.y);
//	}
//	
////	@Override
////	public int hashCode() {
////		// TODO Auto-generated method stub
////		return x+y+right()+top()+bootom()+left();
////	}
//	
//	public int value(){
//		return RedmartChallenge.data[x][y];
//	}
//	
//	public int top(){
//		if(x-1==-1)
//			return -1;
//		return RedmartChallenge.data[x-1][y];
//	}
//	public int bootom(){
//		if(x+1 >= RedmartChallenge.data.length)
//			return -1;
//		return RedmartChallenge.data[x+1][y];
//	}
//	public int left(){
//		if(y-1==-1)
//			return -1;
//		return RedmartChallenge.data[x][y-1];
//	}
//	public int right(){
//		if(y+1 >= RedmartChallenge.data.length)
//			return -1;
//		return RedmartChallenge.data[x][y+1];
//	}
//	
//	public Point_hidden rightPoint(){
//		if(y+1 >= RedmartChallenge.data.length)
//			return null;
//		if(this.rightPoint!=null)
//			return rightPoint;
//		
//		rightPoint=new Point_hidden(x, y+1);
//		return rightPoint;
//	}
//	
//	public Point_hidden leftPoint(){
//		if(y-1==-1)
//			return null;
//		if(this.leftPoint!=null)
//			return leftPoint;
//		leftPoint= new Point_hidden(x, y-1);
//		return leftPoint;
//	}
//	
//	public Point_hidden topPoint(){
//		if(x-1==-1)
//			return null;
//		if(this.topPoint!=null)
//			return topPoint;
//		
//		topPoint= new Point_hidden(x-1, y);
//		return topPoint;
//	}
//	
//	public Point_hidden bottomPoint(){
//		if(x+1 >= RedmartChallenge.data.length)
//			return null;
//		
//		if(this.bottomPoint!=null)
//			return bottomPoint;
//		this.bottomPoint =new Point_hidden(x+1, y);
//		return this.bottomPoint;
//	}
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return x+","+y;
//	}
//	
//	public void setNext(Point_hidden next){
//		this.next=next;
//	}
//	
//	public Point_hidden next(){
//		return next;
//	}
//	
//}
