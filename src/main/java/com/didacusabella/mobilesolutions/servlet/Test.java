package com.didacusabella.mobilesolutions.servlet;

public class Test
{
	public static void main(String[] args)
	{
	String frase = "1234-5678-1234-5678";
	
	String a = frase.substring(0, 4);
	String b = frase.substring(5, 9);
	String c = frase.substring(10, 14);
	String d = frase.substring(15, 19);
	
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
	System.out.println(frase.length());

	}

}
