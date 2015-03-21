package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/taum-and-bday
 * @author Milan
 *
 */
public class TaumBday {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long t;
       
        long B,W;
        long X,Y,Z;
        t = in.nextInt();
        long BInitial;
        long WInitial;
        for (int i=0;i<t;i++) {
        	BInitial = in.nextInt();
            WInitial = in.nextInt();
            X = in.nextInt();
            Y = in.nextInt();
            Z = in.nextInt();
            
            B=BInitial;
            W=WInitial;
            
            long min=(BInitial*X)+(WInitial*Y);
            long diff=(X)-(Y);
            
            long j=1;
            boolean isW=false;
            boolean flag=true;
            
            
            if(X ==0 || Y==0){
            	min=0;
            }else
            while(flag){
            	
                if(diff<0 && !isW){
                	
                    B=B+1;
                    W=W-1;
                    long amt=((B*X)+(Z*j))+(W*Y);
                    if(min > amt && W>=0 ){
                        min=amt;
                      
                        
                    }
                    else{
                    	flag=false;
                        break;
                    }
                }
                else {
                	 
                    W=W+1;
                    B=B-1;
                    isW=true;
                    long amt=((B*X))+((W*Y)+(Z*j));
                    
                    if(min > amt && B>=0 ){
                        min=amt;
                      
                       
                    }else{
                    	flag=false;
                        break;
                    }
                }
                
                j++;
                
            }
            

            System.out.println(min);
            
            
        }
    }
    
}