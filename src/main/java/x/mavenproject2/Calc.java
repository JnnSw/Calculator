/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.mavenproject2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author User
 */
public class Calc {
    public double calc(List<String> postfix) 
    {
		Deque<Double> stack = new ArrayDeque<Double>(); //Двусвязная очередь
                /*
                если в записи встретили функцию, то :
                вытаскиваем из стэка верхний элемент;
                применяем функцию к нему;
                кладём элемент обратно в стэк;
                */
		for (String x : postfix) 
                { 
                        if (x.equals("+")) stack.push(stack.pop() + stack.pop());
			else if (x.equals("-")) 
                        {
				Double right = stack.pop(), left = stack.pop();
				stack.push(left - right);
			}
			else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
			else if (x.equals("/")) 
                        {
				Double right = stack.pop(), left = stack.pop();
				stack.push(left / right);
			}
			else stack.push(Double.valueOf(x)); //в записи встретили число
		}
		return stack.pop(); //выводим последний элемент стэка.
	}
}
