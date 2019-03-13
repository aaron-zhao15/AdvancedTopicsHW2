/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedtopicshw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

/**
 *
 * @author XingLu
 */
public class AdvancedTopicsHW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        print2();
    }

    

    
    public static ArrayList<Double> function1(int in){
        ArrayList<Double> arr = new ArrayList<Double>();
        for(double i = 1; i <= in; i++){
                if((i*i)%in == 7){
                    arr.add(i);
                }
            }
        return arr;
    }
    public static double function1Count(int in){
        double count = 0;
        for(double i = 1; i <= in; i++){
                if((i*i)%in == 7){
                    count++;
                }
            }
        return count;
    }
    
    public static ArrayList<Integer> calc2(int num){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 1; i < num; i++){
            if((i*i)%num==7){
                temp.add(i);
            }
        }
        return temp;
    }
    
    public static int calc5(int num) {
        int temp = 0;
        for (int i = 0; i < num; i++) {
            if (i % 3 == 1 && i % 4 == 2 && i % 5 == 3) {
                temp = i;
            }
        }
        return temp;
    }
    
    
    public static int calc6WithoutZeroSides(int num){
        int[][] temp = new int[num-1][num-1];
        for(int i = 0; i < num-1; i++){
            for(int j = 0; j < num-1; j++){
                temp[i][j] = (i+1)*(j+1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < num-1; i++){
            for(int j = 0; j < num-1; j++){
                if(temp[i][j]%num==0){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int calc6(int num){
        int[][] temp = new int[num][num];
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                temp[i][j] = i*j;
            }
        }
        
        int count = 0;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(temp[i][j]%num==0){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int kFunction(int num){
        int count = 0;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(i*j%num==0){
                    count++;
                }
            }
        }
        return count;
    }
    

    
    public static void print1(){
        for(int i = 0; i <=1000; i=i+1){
            System.out.println(i + ": " + function1Count(i) + ": " + function1(i));
        }
    }
    
    public static void print2(){
        ArrayList<Integer> temp = primeNumbersBruteForce(100);
        for(int i : temp){
            System.out.print(i + ": ");
            System.out.println(calc2(i));
        }
    }
    
    public static void print6(){
        ArrayList<Integer> temp = primeNumbersBruteForce(20);
        for(int i : temp){
            System.out.println("p: " + i);
            for(int j = 1; j <= 3; j++){
                int num = (int)Math.pow(i, j);
                System.out.print("p^"+j+": " + num + " | ");
                System.out.println("k(): " + calc6(num));
            }
            System.out.print("\n");
        }
    }
    
    public static void print6Empiric(){
        ArrayList<Integer> temp = primeNumbersBruteForce(20);
        for(int p = 0; p < temp.size(); p++){
            System.out.println("p: " + temp.get(p));
            for(int n = 1; n <= 3; n++){
                int num = (int)Math.pow(p, n);
                System.out.print("p^"+n+": " + num + " | ");
                System.out.println("k(): " + 
                        (kFunction((int)Math.pow(temp.get(p), n-1))*temp.get(p) +
                                (int)Math.pow(temp.get(p),n-1)*(temp.get(p)-1)));
            }
            System.out.print("\n");
        }
    }
    
    public static ArrayList<Integer> primeNumbersBruteForce(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (isPrimeBruteForce(i)) {
                primeNumbers.add(i);
            }
        }
        for (int i : primeNumbers) {
            temp.add(i);
        }
        return temp;
    }

    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
