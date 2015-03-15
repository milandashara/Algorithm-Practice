package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * In Progress not completed yet
 * @author Milan
 *
 */
public class RedmartChallenge {

	//public static int X=4;
	//public static int Y=4;
	public static int[][] data;
	public static int startX;
	public static int startY;
	//public static List<String> path=new ArrayList<String>();
	public static Set<String> visitedNode=new HashSet<String>();
	public static List<List<String>> listOfPath=new ArrayList<List<String>>();
	public static void init(){
		data=new int[4][4];
		
		data[0][0]=4;
		data[0][1]=8;
		data[0][2]=7;
		data[0][3]=3;
		data[1][0]=2;
		data[1][1]=5;
		data[1][2]=9;
		data[1][3]=3;
		data[2][0]=6;
		data[2][1]=3;
		data[2][2]=2;
		data[2][3]=5;
		data[3][0]=4;
		data[3][1]=4;
		data[3][2]=1;
		data[3][3]=6;		
		
		
	}
	
	public static void readTxt() throws FileNotFoundException{
		//File inFile = new File(new InputStreamReader(RedmartChallenge.class.getClassLoader().getResourceAsStream("SomeTextFile.txt")));
	    //InputStream is=RedmartChallenge.class.getClassLoader().getResourceAsStream("map.txt");
		
	    File file = new File("C:\\Users\\Milan\\git\\Algorithm-Practice\\Algorithm\\src\\problems\\map.txt");
	    Scanner in = new Scanner(file);
	    in.useDelimiter("[/n]");

	    String line = "";
	    int lineCount = 0;
//		while (in.hasNextLine()) {
//			line = in.nextLine().trim();
//		    Scanner lineIn = new Scanner(line);
//		    //The initial case - this first line is used to determine the size of the array
//		    if(lineIn.hasNext()) {				
//		        //Create a String array by splitting by spaces
//		        String[] s = lineIn.nextLine().split(" ");
//		        //Reinitialize the array to hold all of your subarrays
//		        matrix = new int[s.length];
//		        for (int i = 0; i < s.length; i++) {
//		            //Reinitialize each subarray to hold the numbers
//		            matrix[i] = new int[i];
//		            //Finally, parse your data from the String array
//		            matrix[0][i] = Integer.parseInt(s[i]);
//		        }
//		    }
//		    
//		}
		
	    String firstLine=in.nextLine();
	    Scanner firstLineScanner=new Scanner(firstLine);
	    Integer x=Integer.parseInt(firstLineScanner.next());
	    Integer y=Integer.parseInt(firstLineScanner.next());
	   // X=x;
	    //Y=y;
	    data=new int[x][y];
		//Repeat the steps now that all of your arrays have been initialized
	    for (int j = 0; j < data.length; j++) {
	        String[] s = in.nextLine().split(" ");
	        for (int i = 0; i < s.length; i++) {
	            data[j][i] = Integer.parseInt(s[i]);
	        }
	    }
	}
	
	public static void findStartXY(){
        int min = data[0][0];
        startX=0;
        startY=0;
        for (int col = 0; col < data.length; col++) {
            for (int row = 0; row < data[col].length; row++) { 
                if (min > data[col][row]) {
                    min = data[col][row];
                    startX=col;
                    startY=row;
                    System.out.println("Starting Point : data["+ startX +","+startY+"]= " + data[startX][startY]);
                }
            }
        }
        
        List<String> path=new ArrayList<String>();
        path.add(startX+" "+startY);
        listOfPath.add(new ArrayList<String>(path));
        
	}
	
	public static boolean findNearest(int x,int y){
		
		if(visitedNode.contains(x+""+y))
			return false;
		
		if(x<0 || y<0)
			return false;
		
		//System.out.println(path.toString());
		int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,top=Integer.MAX_VALUE,bottom=Integer.MAX_VALUE;
		int current=data[x][y];
	
			
		
		if(x-1 >-1 && data[x-1][y]>current){//top
			top=data[x-1][y];
			top=top-current;
		}
		if(x+1 < data.length && data[x+1][y] > current){//bottom
			bottom=data[x+1][y];
			bottom-=current;
		}
		if(y-1 > -1 && data[x][y-1] > current){//left
			left=data[x][y-1];
			left-=current;
		}
		if(y+1 < data.length && data[x][y+1]  > current){//right
			right=data[x][y+1];
			right-=current;
		}
		
		
		
	//	if(left != Integer.MAX_VALUE && left < right && left < top && left < bottom){
		if(left != Integer.MAX_VALUE && left >0){
			//path.add(x+""+(y-1));
			visitedNode.add(x+""+y);
			//listOfPath.add(new ArrayList<String>(path));
			addNodeToPathEnding(x, y, x, y-1);
			 findNearest(x, y-1);
		}
		//if(right != Integer.MAX_VALUE && right < left && right < top && right < bottom){
		if(right != Integer.MAX_VALUE && right >0){
			//path.add(x+""+(y+1));
			visitedNode.add(x+""+y);
			//listOfPath.add(new ArrayList<String>(path));
			addNodeToPathEnding(x, y, x, y+1);
			 findNearest(x, y+1);
		}
	//	if(top != Integer.MAX_VALUE && top < right && top < left && top < bottom){
		if(top != Integer.MAX_VALUE && top >0){
		//path.add((x-1)+""+y);
			visitedNode.add(x+""+y);
			//listOfPath.add(new ArrayList<String>(path));
			addNodeToPathEnding(x, y, x-1, y);
			 findNearest(x-1, y);
		}
	//	if(bottom != Integer.MAX_VALUE && bottom < right && bottom < top && bottom < left){
		if(bottom != Integer.MAX_VALUE && bottom >0){
		//path.add((x+1)+""+y);
			visitedNode.add(x+""+y);
			//listOfPath.add(new ArrayList<String>(path));
			addNodeToPathEnding(x, y, x+1, y);
			 findNearest(x+1, y);
		}
		
		
		return false;
		
	}
	
	public static void addNodeToPathEnding(int x,int y,int x1,int y1){
		for(List<String> path:listOfPath){
			if(path.get(path.size()-1).equals(x+" "+y)){
				ArrayList<String> newPath=new ArrayList<String>(path);
				newPath.add(x1+" "+y1);
				listOfPath.add(newPath);
				return;
			}
		}
		
		ArrayList<String> newPath=new ArrayList<String>();
		newPath.add(x1+" "+y1);
		listOfPath.add(newPath);
		
	}
	
	public static void  findLongestAndSteeperPath(){
		List<Integer> maxIndex=new ArrayList<Integer>();
		int max=0;
		int i=0;
		for(List<String> path:listOfPath){
			if(path.size()>=max ){
//				String xyMin=path.get(0);
//				int x=Character.getNumericValue((xyMin.charAt(0)));
//				int y=Character.getNumericValue(xyMin.charAt(1));
//				
//				String xyMax=path.get(path.size()-1);
//				int x1=Character.getNumericValue(xyMax.charAt(0));
//				int y1=Character.getNumericValue(xyMax.charAt(1));
//				
//				int diff=data[x1][y1]-data[x][y];
//				int diffCurrent=0;
//				if(maxIndex.size()>0){
//					 xyMin=listOfPath.get(maxIndex.get(0)).get(0);
//					 x=Character.getNumericValue(xyMin.charAt(0));
//					 y=Character.getNumericValue(xyMin.charAt(1));
//					
//					 xyMax=path.get(path.size()-1);
//					 x1=Character.getNumericValue(xyMax.charAt(0));
//					 y1=Character.getNumericValue(xyMax.charAt(1));
//					
//					 diffCurrent=data[x1][y1]-data[x][y];
//					 
//					 if(diff > diffCurrent){
//							maxIndex.clear();
//							
//							maxIndex.add(i);
//						}
//				}
//				else{
//					
//					maxIndex.add(i);
//				}
				
				if(path.size()!=max ){
					maxIndex.clear();
				}
				
				max=path.size();
				
				maxIndex.add(i);
				
				
				
			}
			i++;
		}
		
		
		int maxDiff=0;
		List<String> steepestAndLongestPath=listOfPath.get(maxIndex.get(0));
		for(Integer index:maxIndex){
			
			List<String> path=listOfPath.get(index);
			
			int x=Integer.parseInt(((path.get(0).split(" ")[0])));
			int y=Integer.parseInt(((path.get(0).split(" ")[1])));
			
			String xyMax=path.get(path.size()-1);
			int x1=Integer.parseInt(xyMax.split(" ")[0]);
			int y1=Integer.parseInt(xyMax.split(" ")[1]);
			
			int diff=data[x1][y1]-data[x][y];
			
			if(diff>maxDiff){
				maxDiff=diff;
				steepestAndLongestPath=path;
			}
		}
		
		//print steepest and longest path
		//List<String> steepestAndLongestPath=listOfPath.get(maxIndex.get(0));
		for(String xy:steepestAndLongestPath){
			
			int x=Integer.parseInt(xy.split(" ")[0]);
			int y=Integer.parseInt(xy.split(" ")[1]);
			System.out.println(data[x][y]);
		}
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//init();
		//readTxt();
		//findStartXY();
		for(int i=0;i<1000;i=i+30)
			for(int j=0;j<1000;j=j+30){
				long start=System.currentTimeMillis();
		System.out.print(i+j);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
			}
//		for(List path:listOfPath){
//			System.out.println(path.toString());
//		}
//		findLongestAndSteeperPath();
		
	}
	
}
