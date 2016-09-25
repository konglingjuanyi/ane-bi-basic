package com.ane56.bi.port;

class A {

	public void start(){
		System.out.println("TestA");
	}
}

public class B extends A{
	public void start(){
		System.out.println("TestB");
	}
	public static void main(String[] args) {
	((A)	new B()).start();
	}
}