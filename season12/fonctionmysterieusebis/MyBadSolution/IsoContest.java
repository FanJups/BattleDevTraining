/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N= Integer.parseInt(sc.nextLine());
		double Nsur2 =  ((double) N) / 2;
		List<Double> image = new ArrayList<>();
		line = sc.nextLine();

		image = Arrays.stream(line.split(" ")).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
						
		int k= Integer.parseInt(sc.nextLine());
		int nbreEntrees = 0;

		String result = ""; // Initialisation du résultat

		

		List<Double> imageIteree = new ArrayList<>();

		

		for (int i = 0; i < image.size(); i++) {

			double x = fonctionIteree(k, i, image);

			imageIteree.add(x);
		}

		///////////////////////

		for (int i = 0; i <= N - 1; i++) {

			double fiIteree;
			double fiplusunIteree;
			double fiItereePrec;
			double fiplusunItereePrec;

			// intervalle i < x < i+1

			int kinit = 1;

			while (kinit <= k) {

				if (kinit == 1) {

					// Les antécédents sont i et i+1

					// Etant donné que i et i+1 se suivent f est soit croissante soit décroissante

					fiIteree = fonctionIteree(kinit, i, image);

					fiplusunIteree = fonctionIteree(kinit, i + 1, image);

					// f croissante

					// fiIteree < fx < fiplusunIteree

					if (fiIteree < fiplusunIteree)

						if (k == kinit)
							if (fiIteree < Nsur2 && Nsur2 < fiplusunIteree)
								nbreEntrees++;

					// f décroissante

					// fiplusunIteree < fx < fiIteree

					if (fiplusunIteree < fiIteree)
						if (k == kinit)
							if (fiplusunIteree < Nsur2 && Nsur2 < fiIteree)
								nbreEntrees++;

				} else {

					// kinit >=2

					// Les antécédents sont fiItereePrec et fiplusunItereePrec

					fiItereePrec = fonctionIteree(kinit - 1, i, image);

					fiplusunItereePrec = fonctionIteree(kinit - 1, i + 1, image);

					/*
					 * Les images sont :
					 * 
					 * fiIteree = fonctionIteree(kinit, i, image);
					 * 
					 * fiplusunIteree = fonctionIteree(kinit, i + 1, image);
					 */

					// Comportement de f borné par les anté fiItereePrec & fiplusunItereePrec

					// f est soit croissante soit décroissante soit un mix des 2

					// 2 cas possibles

					// 0...N

					int min = (int) Math.min(fiItereePrec, fiplusunItereePrec);

					int max = (int) Math.max(fiItereePrec, fiplusunItereePrec);

					for (int j = min; j < max; j++) {

						double fj = image.get(j);

						double fjplusun = image.get(j + 1);

						// f croissante
						if (fj < fjplusun)
							if (k == kinit)
								if (fj < Nsur2 && Nsur2 < fjplusun)
									nbreEntrees++;

						// f décroissante
						if (fjplusun < fj)
							if (k == kinit)
								if (fjplusun < Nsur2 && Nsur2 < fj)
									nbreEntrees++;

					}

				} // else kinit >=2

				kinit++;

			} // while

		} // for

		nbreEntrees = nbreEntrees + Collections.frequency(imageIteree, Nsur2);

		result = nbreEntrees%1000 + "";

		System.err.println("liste  : " + image);

		System.err.println("liste itérée : " + imageIteree);

		System.out.println(result);

		///////////////////////

	}

	public static double fonctionIteree(int k, int indice, List<Double> image) {
		if (k == 1)
			return image.get(indice);
		else {
			return image.get((int) fonctionIteree(k - 1, indice, image));
		}

	}
}