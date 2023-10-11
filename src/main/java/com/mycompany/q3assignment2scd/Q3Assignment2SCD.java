
package com.mycompany.q3assignment2scd;
//merger class

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Merger{
    
    public List<int[]> mergeIntervals(List<int[]> intervals)
    {
        //first check if the list is empty or not
        if(intervals.isEmpty())
        {
            System.out.println("List is empty");
            return intervals;
        }
        //get current interval
        int[] CurrentInterval=intervals.get(0);
        //iterate through intervals
        for(int i=1;i<intervals.size();i++)
        {
            int[] NextInterval =intervals.get(i);
            //checking the overlapping condition
            if(NextInterval[0]<=CurrentInterval[1])
            {
                if(CurrentInterval[1]<NextInterval[1])
                {
                  CurrentInterval[1]=NextInterval[1];//update only if value is less
                  intervals.remove(i);
                  --i;
                }
                else
                {
                  intervals.remove(i);
                  --i;
                }
            }
            else
            {
                CurrentInterval=NextInterval;
                if(i!=intervals.size()-1&&i<intervals.size())//to avoid index out of bound at last index
                {
                NextInterval=intervals.get(i);
                }
            }
        }
        return intervals;
    }
    void display(List<int[]> intervals1)
    {
        for(int[] x:intervals1)
        {
            System.out.print("["+x[0]+","+x[1]+"],");
        }
        System.out.println("]");
    }
}
public class Q3Assignment2SCD {

    public static void main(String[] args) {
        List<int[]> intervals= new ArrayList<>();
        Merger m1=new Merger();

        /******** intervals ************/
        System.out.println("ENTER INTERVALS");
        System.out.print("Enter the number of intervals you want to add : ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=0;i<a;i++)
        {
            System.out.print("Enter the start time of the interval "+(i+1)+": ");
            int StartTime=sc.nextInt();
            System.out.print("Enter the end time of the interval "+(i+1)+": ");
            int EndTime=sc.nextInt();
            intervals.add(new int[]{StartTime,EndTime});
        }
        System.out.print("The actual intervals are: [");
        m1.display(intervals); 
        List<int[]> intervals1=m1.mergeIntervals(intervals);
        System.out.print("The merged intervals are: [");
        m1.display(intervals1);
    }
}
