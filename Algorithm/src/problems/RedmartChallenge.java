package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * In Progress not completed yet
 * @author Milan
 *
 */
public class RedmartChallenge {

	public static int X=4;
	public static int Y=4;
	public static int[][] data;
	public static int startX;
	public static int startY;
	public static List<Integer> path=new ArrayList<Integer>();
	
	public static void init(){
		data=new int[X][Y];
		
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
        
        path.add(data[startX][startY]);
        
	}
	
	public static boolean findNearest(int x,int y){
		
		if(x<0 || y<0)
			return false;
		
		System.out.println(path.toString());
		int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,top=Integer.MAX_VALUE,bottom=Integer.MAX_VALUE;
		int current=data[x][y];
	
			
		
		if(x-1 >0 && data[x-1][y]>=current){//top
			top=data[x-1][y];
			top=top-current;
		}
		if(x+1 < data.length && data[x+1][y] >= current){//bottom
			bottom=data[x+1][y];
			bottom-=current;
		}
		if(y-1 > 0 && data[x][y-1] >= current){//left
			left=data[x][y-1];
			left-=current;
		}
		if(y+1 < data.length && data[x][y+1]  >= current){//right
			right=data[x][y+1];
			right-=current;
		}
		
		
		
		if(left <= right && left <= top && left <= bottom){
			path.add(data[x][y-1]);			
			return findNearest(x, y-1);
		}
		if(right <= left && right <= top && right <= bottom){
			path.add(data[x][y+1]);
			return findNearest(x, y+1);
		}
		if(top <= right && top <= left && top <= bottom){
			path.add(data[x-1][y]);
			return findNearest(x-1, y);
		}
		if(bottom <= right && bottom <= top && bottom <= left){
			path.add(data[x+1][y]);
			return findNearest(x+1, y);
		}
		
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		init();
		findStartXY();
		findNearest(startX, startY);
	}
	
}
