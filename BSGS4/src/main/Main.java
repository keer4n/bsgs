package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import bsgs.BSGS;

public class Main {

	public static void main(String[] args) {
		try {
			String fileName = args[0];
			FileReader fr;
			BigInteger h, g, p;

			fr = new FileReader(fileName);

			BufferedReader br = new BufferedReader(fr);

			h = new BigInteger(br.readLine());
			g = new BigInteger(br.readLine());
			p = new BigInteger(br.readLine());
			br.close();
			fr.close();
//		   BigInteger h= new BigInteger("184091");
//
//		   BigInteger g= new BigInteger("233529");
//		   BigInteger p= new BigInteger("329746");


			BSGS test = new BSGS(h, g, p);
		Instant s = Instant.now();
			BigInteger exp1 = test.calculateExponent1();
			Instant e = Instant.now();
			Duration d = Duration.between(s, e);
			Instant s1 = Instant.now();
			BigInteger exp2 = test.calculateExponent2();
			Instant e1 = Instant.now();
			Duration d1 = Duration.between(s1, e1);
			
			System.out.println("Exp 2: " + exp2);
			System.out.format("2nd Algorithm: %02dh:%02dm:%02ds.%04dms ", d1.toHours(), d1.toMinutes(), d1.getSeconds(), d1.toMillis());
			System.out.println();
			System.out.println("Exp 1: " + exp1);
			System.out.format("1st Algorithm: %02dh:%02dm:%02ds.%04dms ", d.toHours(), d.toMinutes(), d.getSeconds(), d.toMillis());
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
