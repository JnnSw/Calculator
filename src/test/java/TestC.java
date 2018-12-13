/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import x.mavenproject2.Calc;
import x.mavenproject2.WorkOnStr;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TestC {
    
    public TestC() {
    }
    
    @org.junit.Test
    public void calculate()
    {
                Calc calculator= new Calc(); 
                WorkOnStr n=new WorkOnStr();
                

		List<String> str = n.work("1+1");
		if (n.flag) 
                {assertTrue(2.0==calculator.calc(str));}

                str = n.work("(1 + 1 * 2)*3");
                if (n.flag)
                {assertTrue(calculator.calc(str)==9.0);}
                
                str = n.work("1+2*3+5/1");
                if (n.flag)
                {assertTrue(calculator.calc(str)==12.0);}
                
                str = n.work("1-2*3+2*(6/2-1)");
                if (n.flag)
                {assertTrue(calculator.calc(str)==-1.0);}
                
    }
}
