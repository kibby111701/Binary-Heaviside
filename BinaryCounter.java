import java.util.*;

public class BinaryCounter{ //This is a program to represent counting in binary
    
    public static void main(String[] args) { //The main function is just how the countBinary function gets called up
        countBinary(5, 31);
    }

    public static void countBinary(int bitCount, int countTo){ //This is where the actual binary counting 
       
        int[] bits = new int[bitCount]; //Creates an array of numbers which will be either 0 or 1, with each number being a bit
                                        //Under normal circumstances, large bits are on the left, decreasing to the right. This array has small bits on the left and increases. 
                                        //It's just a little more convenient
        int sum = 0;
        System.out.println(Arrays.toString(bits) + "\t" + "\t" + sum);
        
        if (countTo < Math.pow(2, bitCount)){ //Makes sure we can actually count to this number with the bits we have
                
            for (int n = 1; n <= countTo; n++){ //Our stand-in for the equation's n in this case
                    
                sum = 0;
                    
                for (int i = 0; i < bits.length; i++){ //Applying the Heaviside Function to each bit
                        
                    double checker = Math.pow(2.0, i+1);
                    double upSubtract = Math.pow(2.0, i);     
                  
                    if ((n - upSubtract) % checker == 0){
                        bits[i] = 1;
                    }
                    if (n % checker == 0){
                        bits[i] = 0;
                    }
                        
                    if (bits[i] == 1){
                        sum += Math.pow(2.0, i);
                    }
                }
                    
                System.out.println(Arrays.toString(bits) + "\t" + "\t" + sum);
            }
        }else{
            System.out.println("We can't count that high with the bits we have");
        }
        
    }
}