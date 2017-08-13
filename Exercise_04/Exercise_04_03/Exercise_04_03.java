/*
(Geography: estimate areas) Find the GPS locations for Atlanta, Georgia;
Orlando, Florida; Savannah, Georgia; and Charlotte, North Carolina from
www.gps-data-team.com/map/ and compute the estimated area enclosed by these
four cities. (Hint: Use the formula in Programming Exercise 4.2 to compute the
distance between two cities. Divide the polygon into two triangles and use the
formula in Programming Exercise 2.19 to compute the area of a triangle.)
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter_04;
import java.util.Scanner;
/**
 *
 * @author ManuelJose
 */
public class Ex04_03 {
    //Geography: estimate areas
    public static void main(String[] args) {
        //Atlanta: 40.41044,-99.40505000000002
        //Orlando: 28.5383355,-81.37923649999999
        //Savannah: 32.0835407,-81.09983419999998
        //Charlotte: 35.2270869,-80.84312669999997
        double x0 = 40.41044;
        double y0 = -99.40505000000002;
        double x1 = 28.5383355;
        double y1 = -81.37923649999999;
        double x2 = 32.0835407;
        double y2 = -81.09983419999998;
        double x3 = 35.2270869;
        double y3 = -80.84312669999997;
        
        double d1 = 6371.01 * Math.acos(Math.sin(x0)*Math.sin(x1)+Math.cos(x0)*Math.cos(x1)*Math.cos(y0-y1));
        double d2 = 6371.01 * Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
        double d3 = 6371.01 * Math.acos(Math.sin(x0)*Math.sin(x2)+Math.cos(x0)*Math.cos(x2)*Math.cos(y0-y2));
        double d4 = 6371.01 * Math.acos(Math.sin(x2)*Math.sin(x3)+Math.cos(x2)*Math.cos(x3)*Math.cos(y2-y3));
        double d5 = 6371.01 * Math.acos(Math.sin(x3)*Math.sin(x0)+Math.cos(x3)*Math.cos(x0)*Math.cos(y3-y0));
        
        double s1 = (d1 + d2 + d3) / 2;
        double area1 = Math.sqrt(s1 * (s1-d1)*(s1-d2)*(s1-d3));
        
        double s2 = (d3 + d4 + d5) / 2;
        double area2 = Math.sqrt(s2 * (s2-d5)*(s2-d4)*(s2-d3));
        System.out.printf("Area total: %.2f km^2\n", area1+area2);
        
    }
}
