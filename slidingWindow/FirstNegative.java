package zeus.slidingWindow;

import java.util.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}

    //using Deque too solve the same apporach
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Deque<Integer> negativeIndices = new ArrayDeque<>();
        int resultIndex = 0;

        long[] result = new long[N - K + 1];

        for (int j = 0; j < N; j++) {
            // Remove indices that are out of the current window
            while (!negativeIndices.isEmpty() && negativeIndices.peekFirst() < j - K + 1) {
                negativeIndices.removeFirst();
            }

            if (A[j] < 0) {
                negativeIndices.addLast(j);
            }

            // Check if the first element in the deque is within the current window
            if (j >= K - 1) {
                result[resultIndex++] = negativeIndices.isEmpty() ? 0 : A[negativeIndices.peekFirst()];
            }
        }

        return result;
    }
}




class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        List<Long> negativeList = new ArrayList<>();

        int j =0;
        int i = 0;
        long[] result = new long[N - K + 1];
        while(j<N){
            
            if(A[j] < 0){
                negativeList.add(A[j]);
            }
            
            if(j-i+1 < K){
                j++;
                
            }
            else if(j-i+1 == K){
                
                if(negativeList.size()==0){
                    result[i] = 0;
                }else{
                    result[i] = negativeList.get(0); 
                }
                
                if(A[i] == negativeList.get(0)){
                    negativeList.remove(0);
                }
                i++;
                j++;
                
            }
        }
                        return result;

    }


    public long[] printFirstNegativeIntegers(long A[], int N, int K)
    {
        List<Long> negativeList = new ArrayList<>();

        int j =0;
        int i = 0;
        long[] result = new long[N - K + 1];
       
        while(j<N){
            
            if(A[j] < 0){
                negativeList.add(A[j]);
            }
            
            if(j-i+1 < K){
                j++;
                
            }
            else if(j-i+1 == K){
                
                if(negativeList.size()==0){
                    result[i] = 0;
                }else{
                    result[i] = negativeList.get(0); 
                
                
                if(A[i] == negativeList.get(0)){
                    negativeList.remove(0);
                }
                i++;
                j++;
                    
                }
                
            }
        }
                     
                     return result;
                        

    }
}

