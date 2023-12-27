package zeus;

import java.util.ArrayList;
import java.util.Random;

class SlidingWindow{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        
        int staringPoiter = 0;
        int endingPointer = 0;
        int maximumSum = 0;
        int sum = 0;
        while(endingPointer<Arr.size()){
            sum = sum + Arr.get(endingPointer);
            if(endingPointer - staringPoiter +1 < K){
                endingPointer ++;
            }
            else if(endingPointer - staringPoiter +1 == K){
                
                maximumSum = Math.max(maximumSum,sum);
                sum = sum - Arr.get(staringPoiter);
                staringPoiter++;
                endingPointer++;
                
            }
        }
        return maximumSum;
    }
    public static void main(String[] args){
                Random rand = new Random();
        ArrayList<Integer> intArray = new ArrayList<>();
        for(int i = 0;i<10;i++){
            intArray.add(rand.nextInt(1000));
        }
        System.out.println();
        
       System.out.println("maximum of all sub arrays is : " + maximumSumSubarray(3,intArray,intArray.size()));
    }

}