/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dt.mycours;

/**
 *
 * @author HP
 */
public class NextAiinc {

    public static void main(String[] args) {
        int basepay=30000;
        int hoursworked=51;
        System.out.println("Contractor A= Total pay"+ calculation(basepay,hoursworked));
        
        basepay=20000;
        hoursworked=40;
        System.out.println("Contractor B= Total pay"+ calculation(basepay,hoursworked));
        
        basepay=35000;
        hoursworked=96;
        System.out.println("Contractor C= Total pay"+ calculation(basepay,hoursworked));
    }
    public static String calculation(double basepay, int hoursworked){
     if (hoursworked>72){
         return "Error message:hoursworked exceeded the 72-hour limit.";
     }
     else if (basepay<29000){return"Error message: Base pay is below the minimum required rate.";
     }
     else {
      int regularhours=Math.min(hoursworked,48);
      int overtime=hoursworked-regularhours;
      double totalpay=(regularhours*basepay)+(overtime*(basepay*1.5));
      return"Total pay = UGX" +totalpay;
     }
    }
}

    

