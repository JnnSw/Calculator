/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.mavenproject2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class WorkOnStr {
    
    public String operators = "+-*/";
	public String delimiters = "() " + operators;
        /** проверка корректного выражения*/
	public boolean flag = true;
         /** 
         * проверка на соответствие разделителям
         */
	public boolean isDelimiter(String token) 
        {  
		if (token.length() != 1) return false;
		for (int i = 0; i < delimiters.length(); i++) 
                {
			if (token.charAt(0) == delimiters.charAt(i)) return true;
		}
		return false;
	}
	 /** 
         * проверка на соответствие операторам
         */
	public boolean isOperator(String token) 
        {
		for (int i = 0; i < operators.length(); i++) 
                {
			if (token.charAt(0) == operators.charAt(i)) return true;
		}
		return false;
	}
	

	
	 /** 
         *  возвращает приоритет 
         */
	public int priority(String token) 
        {
		if (token.equals("(")) return 1;
		if (token.equals("+") || token.equals("-")) return 2;
		if (token.equals("*") || token.equals("/")) return 3;
		return 4;
	}
	 /** 
         * переводит инфиксную запись в префиксную запись
         * @return возвращает префиксную запись
         */
	public List<String> work(String infix) 
        {
		List<String> postfix = new ArrayList<String>();
		Deque<String> stack = new ArrayDeque<String>();
		StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true); // строка и ее разделители
		String prev = "";
		String curr = ""; //считываем поочерёдно все лексемы, попутно убирая пробелы;

                
		while (tokenizer.hasMoreTokens()) //возвращает логическое значение true до тех пор, пока для извлечения еще имеются лексемы
                { 
			curr = tokenizer.nextToken();
                        //boolean check=true;
                        
			if (!tokenizer.hasMoreTokens() && isOperator(curr)) //если это последний символ выражения, то выражение некорректно
                        { 
				System.out.println("Некорректное выражение.");
				flag = false;
				return postfix;
			}
			if (curr.equals(" ")) continue; //пропуск пробела
                        
                        if (isDelimiter(curr)) 
                        {
				if (curr.equals("(")) stack.push(curr); // если лексема — это открывающая скобка, то добавляем её в стэк
				else if (curr.equals(")")) {
                                    /*
                                    если лексема — это закрывающая скобка, то:
                                    -помещаем элементы из стэка в результирующую строку пока не встретим открывающую скобку,
                                    открывающая скобка удаляется из стэка, но в результирующую строку не добавляется;
                                    -если на вершине стэка оказывается символ функции,
                                    то мы помещаем его из стэка в результирующую строку;
                                    -если открывающая скока не была встречена, то запись скобок некорректна.
                                    */
                                    if (stack.peek().equals("(")) 
                                    {
                                        //stack.pop(); 
                                        //check=false;
                                        postfix.add("0");
                                    }
                                       else 
					while (!stack.peek().equals("(")) 
                                        {
						postfix.add(stack.pop());
						if (stack.isEmpty()) 
                                                {
							System.out.println("Запись скобок некорректна.");
							flag = false;
							return postfix;
						}
					}
					stack.pop();
				}
				else { //если лексема — это оператор, то:
                                    
                                            /*
                                            выталкиваем верхние элементы стэка в результирующую строку
                                            пока приоритет текущего оператора меньше либо равен приоритету оператора
                                            находящегося на верине стэка
                                            
                                            */
						while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
							postfix.add(stack.pop());
						}
						
					//}
					stack.push(curr);  //помещаем текущий оператор в стэк;
				} 

			}
			
			else {
				postfix.add(curr);
			}
			
                       // if(check) prev = curr;
                       prev = curr;
		}
		
		while (!stack.isEmpty()) 
                {
			if (isOperator(stack.peek())) postfix.add(stack.pop()); //все данные считаны
                                                                                //выталкиваем все элементы стэка в результирующую строку
			else { //если в стэке оказались символы не операторов, то Запись скобок некорректна.
				System.out.println("Запись скобок некорректна.");
				flag = false;
				return postfix;
			}
		}
		return postfix;
	}
}
