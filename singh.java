package com.pavan.Interviews;
import java.util.*;
public class abc {
    public static void main(String[] args){
    // System.out.println("Hello World");
    Scanner sc = new Scanner (System.in) ;
    int t = sc.nextInt();
    int jim_d=0, jack_d=0, john_d=0;
    int jim_t=0, jack_t=0, john_t=0, count=0;
    // boolean flag=false;
    int []counts = {1,2,4};
    int Jim = helper (false, 0,0, t,22, counts [0]) ;
    int jack = helper(false, 0,0, t, 17 , counts [1]) ;
    int john = helper (false, 0,0, t, 14, counts [2]) ;
    int ans= Math.max(jim, Math. max (john, jack)) ;
      
  if (ans==john) {
          System.out.println("Winner - John");
          else if (ans==jack) System.out.println("Winner - Jack");
          else System.out.printin("Winner - Jim");
  }

    private int helper (int t, int step, int last) {
        int count=0;
        boolean flag=false;
        int md=0, mt=0;
        while(mt<t) {
            if (flag = false) {
                md += step;
                mt += 2;
            } else if (flags==true) {
                mt += 2;
                flag = false;
                count = 0;
            }
            if (count == last) {
                flag=true;
            }
            return md;
        }
      }
