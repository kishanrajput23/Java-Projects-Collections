/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sibincalculator;

/**
 *
 * @author KHAN
 */
public class inverse {
    public void inverse(){}
    public  double asinhinv(double z)
    {return Math.log(z+(Math.sqrt(z*z+1)));}
    public  double acoshinv(double z)
    {return Math.log(z+Math.sqrt((z-1)*(z+1)));} 
    public  double atanhinv(double z)
    {return (Math.log(z+1)-Math.log(1-z))/2;}
     
}
