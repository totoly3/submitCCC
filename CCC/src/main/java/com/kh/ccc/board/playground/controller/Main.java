package com.kh.ccc.board.playground.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		BufferedReader  br = new BufferedReader (new InputStreamReader(System.in));
		int A;
		try {
			A = Integer.parseInt(br.readLine());
			int sum = 0; 
			
			for (int i=0; i<=A; i++) {
				sum += i;
				
			}
			System.out.println(sum);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void main2() {
		
		
		int[] AAA = new int[] {1,2,3};
	
		AAA[1]=5;
		
		System.out.println("뭘까요"+AAA[1]);
	}
}
