// package arrays;

import java.util.ArrayList;

/***
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 */
class MergeIntervals {

    

    /***
     *  if(st==end) {
     *   if st eqauls number return
     *  else 
     *   return -1
     * }
     * find mid
     *     if mid > number then end =mid find (st,end)
     *     else mid > number  st= mid find (st,end)
     *     else return mid
     * 
     * @param intervals
     * @param st
     * @param end
     * @param number
     * @return
     */
    int findInterval(ArrayList<Interval> intervals,int st,int end,int number){
        if(st>end || st< 0 || end>=intervals.size() ){
            return -1;
        } 
        int mid= (st+end)/2;
    //    System.out.println("st "+st+ " mid "+mid+ " end"+ end);
        Interval interval=intervals.get(mid);
        if(isGreater(interval,number)){
            mid=findInterval(intervals, st, mid-1, number);
        }else if(isSmaller(interval, number)){
            mid=findInterval(intervals, mid+1, end, number);
        }
        return mid;

    
    }
    boolean isGreater(Interval interval,int number){
        if(interval.start>number) return true;
        return false;
    }

    boolean isSmaller(Interval interval,int number){
        if(interval.end<number) return true;
        return false;
    }

/**
 *  possible case 
 * 1.  new Interval is not overlapping in any interval
 *          if the interval end is less than current inteval start then it means the new interval is great than current one
 *             , so jut count such smaller intervals and at the end if it matched the size of existing list then add at end 
 *           if it is less than fisrt  interval insert before
 *          
 * 2.  overlaps
 *       remove the overlapped interval
 *       set new interval to be added  with min of the both start and max of both end
 * @param intervals
 * @param newInterval
 * @return
 */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while(i < intervals.size()){
            Interval in = intervals.get(i);
            if(in.end < current.start){ // (7,10) (6,8)
                i++;
            }else if(in.start > current.end){
                intervals.add(i, current);
                break;
            }else{
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(current);
        }
        return intervals;
    }

public static void main(String[] args) {
   
    MergeIntervals mergeIntervals=  new MergeIntervals();
//    System.out.println( mergeIntervals.findInterval(input, 0, input.size()-1, 8));
//    System.out.println( mergeIntervals.findInterval(input, 0, input.size()-1, 6));
//    System.out.println( mergeIntervals.findInterval(input, 0, input.size()-1, 14));
  {  System.out.println();
    ArrayList<Interval>  input= get();
   ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(5,9));
   for(Interval interval:outList){
       System.out.println(interval);
   }
}
{
    System.out.println();
    ArrayList<Interval>  input= get();
    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(1,14));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }
 {  System.out.println();
    ArrayList<Interval>  input= get();
    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(15,16));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }
 {
    System.out.println();
    ArrayList<Interval>  input= get();
    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(-5,0));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }
 
 {
    System.out.println();
    ArrayList<Interval>  input= get();
    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(-5,10));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }
 {
    System.out.println();
    ArrayList<Interval>  input= get();
    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(10,20));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }
 {
    System.out.println();
    ArrayList<Interval>  input= get();

    ArrayList<Interval>  outList=mergeIntervals.insert(input, new Interval(-5,20));
    for(Interval interval:outList){
        System.out.println(interval);
    }
 }


}

public static  ArrayList<Interval> get(){
    ArrayList<Interval>  input=new ArrayList<>();
    input.add(new Interval(1,3));
    input.add(new Interval(4,7));
    input.add(new Interval(8,12));
    input.add(new Interval(13,14));
    return input;
}

}


 class Interval {
        int start;
         int end;
    Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    @Override
    public String toString(){
        return "("+start+","+end+")";
    }
}