package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Milan Dilipbhai Ashara
 * 
 * Working code. Need Refactoring.
 * Improved.. Can be improved by using same data structure for visited path as well as all Points
 *
 */
public class RedmartChallenge {

	//public static int[][] data;
	public static HashMap<Point, Integer> visitedPath=new HashMap<Point, Integer>();
	public static List<Point> longestPathStartingPoint=new ArrayList<Point>();
	public static HashMap<String, Point> allPoints=new HashMap<String, Point>();
	public static int length=0;

	public static void init(){
		length=4;
		
		allPoints.put(0+" "+0,new Point(0,0,4));
		allPoints.put(0+" "+1,new Point(0,1,8));
		allPoints.put(0+" "+2,new Point(0,2,7));
		allPoints.put(0+" "+3,new Point(0,3,3));
		allPoints.put(1+" "+0,new Point(1,0,2));
		allPoints.put(1+" "+1,new Point(1,1,5));
		allPoints.put(1+" "+2,new Point(1,2,9));
		allPoints.put(1+" "+3,new Point(1,3,3));
		allPoints.put(2+" "+0,new Point(2,0,6));
		allPoints.put(2+" "+1,new Point(2,1,3));
		allPoints.put(2+" "+2,new Point(2,2,2));
		allPoints.put(2+" "+3,new Point(2,3,5));
		allPoints.put(3+" "+0,new Point(3,0,4));
		allPoints.put(3+" "+1,new Point(3,1,4));
		allPoints.put(3+" "+2,new Point(3,2,1));
		allPoints.put(3+" "+3,new Point(3,3,6));
	
	
			
	}
	
	public static void traverseNode(Point p){
		if(visitedPath.containsKey(p)){
			return;
		}
		int value=p.value();
		
		boolean noDescendingPoint=true;
		
		if(p.rightPoint() !=null && value > p.rightPoint().value()){
			noDescendingPoint=false;
			if(visitedPath.containsKey(p.rightPoint())){
				int count=visitedPath.get(p.rightPoint());
				
				if(visitedPath.containsKey(p)){
					if(visitedPath.get(p)>count+1){
						//count=visitedPath.get(p);
						//do nothing
					}
					else if(visitedPath.get(p)==count+1){
						//do nothing
					}
					else{
						//p.rightPoint=allPoint.get(allPoint.indexOf(p.rightPoint()));
						//p.rightPoint=getPoint(p.rightPoint);
						p.rightCount=count;	
						p.setNext(getPoint(p.rightPoint));
						visitedPath.put(p, ++count);
						//allPoints.put(p.x+" "+p.y, p);
					}
				}
				else{
					
					//p.rightPoint=allPoint.get(allPoint.indexOf(p.rightPoint()));
					//p.rightPoint=getPoint(p.rightPoint);
					p.rightCount=count;
					p.setNext(getPoint(p.rightPoint));
				visitedPath.put(p, ++count);
				//allPoints.put(p.x+" "+p.y, p);
				}
			}
			else{
				if(p.rightPoint!=null)
				traverseNode(p.rightPoint());
				if(visitedPath.containsKey(p.rightPoint())){
					int count=visitedPath.get(p.rightPoint());
					
					if(visitedPath.containsKey(p)){
						if(visitedPath.get(p)>count+1){
							//count=visitedPath.get(p);
							//do nothing
						}
						else if(visitedPath.get(p)==count+1){
							//do nothing
						}
						else{
							//p.rightPoint=allPoint.get(allPoint.indexOf(p.rightPoint()));
							//p.rightPoint=getPoint(p.rightPoint);
							p.rightCount=count;	
							visitedPath.put(p, ++count);
							//allPoints.put(p.x+" "+p.y, p);
						}
					}
					else{
						//p.rightPoint=allPoint.get(allPoint.indexOf(p.rightPoint()));
						//p.rightPoint=getPoint(p.rightPoint);
						p.rightCount=count;
						p.setNext(getPoint(p.rightPoint));
					visitedPath.put(p, ++count);
					//allPoints.put(p.x+" "+p.y, p);
					}
				}
			}
		}
		
		if(p.leftPoint() != null && value > p.leftPoint().value()){
			noDescendingPoint=false;
			if(visitedPath.containsKey(p.leftPoint())){
				int count=visitedPath.get(p.leftPoint());
				
				if(visitedPath.containsKey(p)){
					if(visitedPath.get(p)>count+1){
						//count=visitedPath.get(p);
						//do nothing
					}
					else if(visitedPath.get(p)==count+1){
						//do nothing
					}
					else{
					//	p.leftPoint=allPoint.get(allPoint.indexOf(p.leftPoint()));
						//p.leftPoint=getPoint(p.leftPoint);
						p.leftCount=count;	
						p.setNext(getPoint(p.leftPoint));
						visitedPath.put(p, ++count);
						//allPoints.put(p.x+" "+p.y, p);
					}
				}
				else{
					//p.leftPoint=allPoint.get(allPoint.indexOf(p.leftPoint()));
					//p.leftPoint=getPoint(p.leftPoint);
					p.leftCount=count;		
					p.setNext(getPoint(p.leftPoint));
					visitedPath.put(p, ++count);
				//	allPoints.put(p.x+" "+p.y, p);
				}
			}
			else{
				if(p.leftPoint!=null)
				traverseNode(p.leftPoint());
				if(visitedPath.containsKey(p.leftPoint())){
					int count=visitedPath.get(p.leftPoint());
					
					if(visitedPath.containsKey(p)){
						if(visitedPath.get(p)>count+1){
							//count=visitedPath.get(p);
							//do nothing
						}
						else if(visitedPath.get(p)==count+1){
							//do nothing
						}
						else{
							//p.leftPoint=allPoint.get(allPoint.indexOf(p.leftPoint()));
							//p.leftPoint=getPoint(p.leftPoint);
							p.leftCount=count;		
							p.setNext(getPoint(p.leftPoint));
							visitedPath.put(p, ++count);
						//	allPoints.put(p.x+" "+p.y, p);
						}
					}
					else{
						//p.leftPoint=allPoint.get(allPoint.indexOf(p.leftPoint()));
						//p.leftPoint=getPoint(p.leftPoint);
						p.leftCount=count;		
						p.setNext(getPoint(p.leftPoint));
						visitedPath.put(p, ++count);
						//allPoints.put(p.x+" "+p.y, p);
					}
				}
			}
		}
		
		if(p.topPoint()!=null && value > p.topPoint().value()){
			noDescendingPoint=false;
			if(visitedPath.containsKey(p.topPoint())){
				int count=visitedPath.get(p.topPoint());
				
				if(visitedPath.containsKey(p)){
					if(visitedPath.get(p)>count+1){
						//count=visitedPath.get(p);
						//do nothing
					}
					else if(visitedPath.get(p)==count+1){
						//do nothing
					}
					else{
						//p.topPoint=allPoint.get(allPoint.indexOf(p.topPoint()));
						//p.topPoint=getPoint(p.topPoint);
						p.topCount=count;
						p.setNext(getPoint(p.topPoint));
						visitedPath.put(p, ++count);
					//	allPoints.put(p.x+" "+p.y, p);
					}
				}
				else{
					//p.topPoint=allPoint.get(allPoint.indexOf(p.topPoint()));
					//p.topPoint=getPoint(p.topPoint);
					p.topCount=count;
					p.setNext(getPoint(p.topPoint));
				visitedPath.put(p, ++count);
			//	allPoints.put(p.x+" "+p.y, p);
				}
			}
			else{
				if(p.topPoint!=null)
				traverseNode(p.topPoint());
				if(visitedPath.containsKey(p.topPoint())){
					int count=visitedPath.get(p.topPoint());
					
					if(visitedPath.containsKey(p)){
						if(visitedPath.get(p)>count+1){
							//count=visitedPath.get(p);
							//do nothing
						}
						else if(visitedPath.get(p)==count+1){
							//do nothing
						}
						else{
							
							//p.topPoint=allPoint.get(allPoint.indexOf(p.topPoint()));
							//p.topPoint=getPoint(p.topPoint);
							p.topCount=count;
							p.setNext(getPoint(p.topPoint));
							visitedPath.put(p, ++count);
							//allPoints.put(p.x+" "+p.y, p);
						}
					}
					else{
						//p.topPoint=allPoint.get(allPoint.indexOf(p.topPoint()));
						//p.topPoint=getPoint(p.topPoint);
						p.topCount=count;
						p.setNext(getPoint(p.topPoint));
					visitedPath.put(p, ++count);
					//allPoints.put(p.x+" "+p.y, p);
					}
				}
			}
		}
		
		if(p.bottomPoint() != null && value > p.bottomPoint().value()){
			noDescendingPoint=false;
			if(visitedPath.containsKey(p.bottomPoint())){
				int count=visitedPath.get(p.bottomPoint());
				
				if(visitedPath.containsKey(p)){
					if(visitedPath.get(p)>count+1){
						//count=visitedPath.get(p);
						//do nothing
					}
					else if(visitedPath.get(p)==count+1){
						//do nothing
					}
					else{
						
						//p.bottomPoint=allPoint.get(allPoint.indexOf(p.bottomPoint()));
						//p.bottomPoint=getPoint(p.bottomPoint);
						p.bottomCount=count;
						p.setNext(getPoint(p.bottomPoint));
						visitedPath.put(p, ++count);
						//allPoints.put(p.x+" "+p.y, p);
					}
				}
				else{
					
					//p.bottomPoint=allPoint.get(allPoint.indexOf(p.bottomPoint()));
					//p.bottomPoint=getPoint(p.bottomPoint);
					p.bottomCount=count;
					p.setNext(getPoint(p.bottomPoint));
				visitedPath.put(p, ++count);
				//allPoints.put(p.x+" "+p.y, p);
				}
			}
			else{
				if(p.bottomPoint!=null)
				traverseNode(p.bottomPoint());
				if(visitedPath.containsKey(p.bottomPoint())){
					int count=visitedPath.get(p.bottomPoint());
					
					if(visitedPath.containsKey(p)){
						if(visitedPath.get(p)>count+1){
							//count=visitedPath.get(p);
							//do nothing
						}
						else if(visitedPath.get(p)==count+1){
							//do nothing
						}
						else{
							//p.bottomPoint=allPoint.get(allPoint.indexOf(p.bottomPoint()));
							//p.bottomPoint=getPoint(p.bottomPoint);
							p.bottomCount=count;
							p.setNext(getPoint(p.bottomPoint));
							visitedPath.put(p, ++count);
							//allPoints.put(p.x+" "+p.y, p);
						}
					}
					else{
						//p.bottomPoint=allPoint.get(allPoint.indexOf(p.bottomPoint()));
						//p.bottomPoint=getPoint(p.bottomPoint);
						p.bottomCount=count;
						p.setNext(getPoint(p.bottomPoint));
					visitedPath.put(p, ++count);
					//allPoints.put(p.x+" "+p.y, p);
					}
				}
			}
		}
		
		if(noDescendingPoint){
			visitedPath.put(p, 0);
			//allPoints.put(p.x+" "+p.y, p);

		}
		

		
		
		
	}
	
	public static Point getPoint(Point point){

		return allPoints.get(point.x+" "+point.y);
	}
	
	public static void readTxt() throws FileNotFoundException{

		
	    File file = new File("src/problems/map.txt");
	    Scanner in = new Scanner(file);
	    in.useDelimiter("[/n]");

	    String line = "";
	    int lineCount = 0;

	    String firstLine=in.nextLine();
	    Scanner firstLineScanner=new Scanner(firstLine);
	    Integer x=Integer.parseInt(firstLineScanner.next());
	    Integer y=Integer.parseInt(firstLineScanner.next());
	    length=x;
	   // X=x;
	    //Y=y;
	    //data=new int[x][y];
		//Repeat the steps now that all of your arrays have been initialized
	    for (int j = 0; j < length; j++) {
	        String[] s = in.nextLine().split(" ");
	        for (int i = 0; i < s.length; i++) {
	          //  data[j][i] = Integer.parseInt(s[i]);
	            allPoints.put(j+" "+i, new Point(j,i,Integer.parseInt(s[i])));
	        }
	    }
	}
	
	public static void findLongestPathStartingPoints(){
		int max=0;
		for(Point p:visitedPath.keySet()){
			if(visitedPath.get(p) == max){
				longestPathStartingPoint.add(p);
			}
			if(visitedPath.get(p) > max){
				longestPathStartingPoint.clear();
				max=visitedPath.get(p);
				longestPathStartingPoint.add(p);
			}
			
		}
	}
	
//	public static void printLongestPath(Point p){
//		if(p==null)
//			return;
//		
//		int maxNeboureValue=Math.max(p.leftCount, Math.max(p.rightCount,Math.max(p.topCount,p.bottomCount)));
//		//System.out.println("value ="+p.value() +" "+maxNeboureValue);
//		
//		if(maxNeboureValue==0)
//			if(p!=null)
//				if(p.rightPoint()!=null)
//					printLongestPath(p.rightPoint());
//				else if(p.leftPoint()!=null)
//					printLongestPath(p.leftPoint());
//				else if(p.topPoint()!=null)
//					printLongestPath(p.topPoint());
//				else if(p.bottomPoint()!=null)
//					printLongestPath(p.bottomPoint());
//			
//			
//		
//		if(p.leftCount==maxNeboureValue){
//			printLongestPath(p.leftPoint);
//		}else if(p.rightCount==maxNeboureValue){
//
//			printLongestPath(p.rightPoint);
//		}
//		else if(p.topCount== maxNeboureValue){
//
//			printLongestPath(p.topPoint);
//			
//		}else if(p.bottomCount== maxNeboureValue){
//
//			printLongestPath(p.bottomPoint);
//			
//		}
//	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//init();
		
		//read matrix
		readTxt();
		long startTime=System.currentTimeMillis();
		//find paths
		for(int i=0;i<length;i++)
			for(int j=0;j<length;j++){

				Point p=allPoints.get(i+" "+j);
				if(!visitedPath.containsKey(p)){
					traverseNode(p);
				}
				//System.out.println(i+" "+j);
				

			}
		

		//find longest
		findLongestPathStartingPoints();

		
		//find steepest
		Point steepest=null;
		int max=0;
		for(Point p:longestPathStartingPoint){
			int first=p.value();
			int end=p.value();
			Point firstPoint=p;
			while(p!=null){
			//	System.out.print(p.value());
				int value=p.value();
				p=p.next();
				if(p==null)
				end=value;
			}
			if((first-end)>max){
			max=first-end;
			steepest=firstPoint;
			}
		
			
			//printLongestPath(p);
		}
		
		//found
		if(steepest!=null){
			while(steepest!=null){
				System.out.print(steepest.value()+",");
				
				steepest=steepest.next();
				
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Time in Milliseconds :");
		System.out.println(endTime-startTime+" ms");
		
		
	}
}

