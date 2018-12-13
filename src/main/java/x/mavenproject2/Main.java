/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.mavenproject2;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
    public static void main (String[] args) {
            
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
                
                /** создание калькулятора*/
                Calc calculator= new Calc(); 
                WorkOnStr n=new WorkOnStr();
                
                /** изменение в префиксную запись*/
		List<String> str = n.work(s);
                /** корректна ли строка*/
		boolean flag = n.flag;
		if (flag) 
                {
			for (String x : str) System.out.print(x);
			System.out.println();
			System.out.println(calculator.calc(str));
		}
	}
}
