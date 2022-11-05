package com.cucumber.stepdefs;

public class Ex {
	public static void main(String args[])
	{
		String a="$101 - $1,000";
		System.out.println(a.split(" - ")[0].replace("$",""));
		System.out.println(a.split(" - ")[1].replace("$", ""));
		System.out.println(Math.round(152.05));
	}

}
