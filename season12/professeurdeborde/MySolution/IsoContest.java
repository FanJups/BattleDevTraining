/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/

// NOT WORKING
package com.isograd.exercise;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
		ArrayList<Integer> listeSizes = new ArrayList<Integer>();
		
		while(sc.hasNextLine()) {
		    
		    line = sc.nextLine();
			int creneau1 = Integer.parseInt(line.split(" ")[0]);
			int creneau2 = Integer.parseInt(line.split(" ")[1]);
			String identifiant = UUID.randomUUID().toString();
			Etudiant elt = new Etudiant(creneau1,creneau2,identifiant);
			listeEtudiants.add(elt);
			
		}

		for(int j=0; j<listeEtudiants.size();j++)
		{
			int actuel = j;

			for(int k=0;k<listeEtudiants.size();k++)
			{
				if(k != actuel)
				{
					listeEtudiants.get(actuel).traitementListeCreneaux( listeEtudiants.get(k) );
				}
			}
		}

		for(int j=0; j<listeEtudiants.size();j++)
		{

			
			listeSizes.add( listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau1().size() );
			
			listeSizes.add( listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau2().size() );
		}

		//System.out.println(Collections.max(listeSizes));

		if( Collections.max(listeSizes) == N )
		{

			LinkedHashMap<Etudiant, Integer> newList = new LinkedHashMap<>(); // liste size == N

			for(int j=0; j<listeEtudiants.size();j++)
			{
				if(  listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau1().size() == N )
				{

					newList.putAll( listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau1() );

					break;

				}

				if(  listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau2().size() == N )
				{

					newList.putAll( listeEtudiants.get(j).getListeEtudiantsCompatiblesCreneau2() );

					break;

				}

			}

			LinkedHashMap<Etudiant, Integer> newList2 = new LinkedHashMap<>(); // Etudiant + type créneau

			for (Map.Entry<Etudiant, Integer> entry : newList.entrySet()) {

				if( entry.getValue() == entry.getKey().getCreneau1() )
				{
					if(  newList2.containsKey( entry.getKey() ) == false )
					{
						newList2.put( entry.getKey(),1 );
					}
				}

				if( entry.getValue() == entry.getKey().getCreneau2() )
				{
					if(  newList2.containsKey( entry.getKey() ) == false )
					{

						newList2.put( entry.getKey(),2 );

					}

				}


			}

			/// Ordre d'entrée

			LinkedHashMap<Etudiant, Integer> finalList = new LinkedHashMap<>();

			for(int j=0; j<listeEtudiants.size();j++)
			{

				for (Map.Entry<Etudiant, Integer> entry : newList2.entrySet()) {

					if( listeEtudiants.get(j).equals( entry.getKey() )  )
					{
						if(  finalList.containsKey( entry.getKey() ) == false )
						{
							finalList.put( entry.getKey(),entry.getValue() );
						}
					}
				
			    }

			} 

			//Affichage 

			for (Map.Entry<Etudiant, Integer> entry : finalList.entrySet()) {

				System.out.println(entry.getValue());
			} 

		}else{

			System.out.println("KO");


		}

	}



	static class Etudiant 
	{
		private int creneau1;
		private int creneau2;
		private int fin1;
		private int fin2;
		private String idEtudiant;
		private LinkedHashMap<Etudiant, Integer> listeEtudiantsCompatiblesCreneau1 = new LinkedHashMap<>();
		private LinkedHashMap<Etudiant, Integer> listeEtudiantsCompatiblesCreneau2 = new LinkedHashMap<>();
		

		public Etudiant(int creneau1,int creneau2,String idEtudiant)
		{
			this.creneau1 = creneau1;
			this.creneau2 = creneau2;
			this.fin1 = creneau1 +60;
			this.fin2 = creneau2 +60;
			this.idEtudiant = idEtudiant;

			this.listeEtudiantsCompatiblesCreneau1.put(this,this.creneau1);
			this.listeEtudiantsCompatiblesCreneau2.put(this,this.creneau2);

		}

		public int getCreneau1()
		{
			return creneau1;
		}

		public int getCreneau2()
		{
			return creneau2;
		}

		public String getIdEtudiant()
		{
			return idEtudiant;
		}

		public LinkedHashMap<Etudiant, Integer> getListeEtudiantsCompatiblesCreneau1()
		{
			return listeEtudiantsCompatiblesCreneau1;
		}

		public LinkedHashMap<Etudiant, Integer> getListeEtudiantsCompatiblesCreneau2()
		{
			return listeEtudiantsCompatiblesCreneau2;
		}

		

		@Override
		public boolean equals(Object object) {
			if (object == null) {
				return false;
			} else if (!(object instanceof Etudiant)) {
				return false;
			} else {
				Etudiant etudiant = (Etudiant) object;
				if (idEtudiant == etudiant.getIdEtudiant() && creneau1 == etudiant.getCreneau1() 
					&& creneau2 == etudiant.getCreneau2()) {
					return true;
				}
			}
			return false;
		}

		

		public static boolean siCreneauxCompatibles(int creneauDeCetEtudiant, int creneauAutreEtudiant)
		{
			boolean test =false;
			 

			int finCreneauDeCetEtudiant = creneauDeCetEtudiant + 60;

			int finCreneauAutreEtudiant = creneauAutreEtudiant + 60;

			if( (finCreneauAutreEtudiant > finCreneauDeCetEtudiant && finCreneauAutreEtudiant > creneauDeCetEtudiant &&  
				creneauAutreEtudiant > finCreneauDeCetEtudiant && creneauAutreEtudiant > creneauDeCetEtudiant) || 
				(finCreneauAutreEtudiant < finCreneauDeCetEtudiant && finCreneauAutreEtudiant < creneauDeCetEtudiant &&
				 creneauAutreEtudiant < finCreneauDeCetEtudiant && creneauAutreEtudiant < creneauDeCetEtudiant) )
			{
				test =true;

			}



			return test;
		}

		

		

		public void traitementListeCreneaux(Etudiant autreEtudiant)
		{

			// idée : créer liste 1 & 2 simultanément multithreading


			// Creneau 1 de cet étudiant this

			if( Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau1() ) && 
				Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau2() ) )
			{

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1 , autreEtudiant,autreEtudiant.getCreneau1());

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1 , autreEtudiant,autreEtudiant.getCreneau2());
				
			} 

			if( Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau1() ) == true && 
				Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau2() ) == false )
			{
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1 , autreEtudiant,autreEtudiant.getCreneau1());
				
			} 

			if( Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau1() ) == false && 
				Etudiant.siCreneauxCompatibles(this.creneau1,autreEtudiant.getCreneau2() ) == true )
			{
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1 , autreEtudiant,autreEtudiant.getCreneau2());
			}
	
			// Creneau 2 de cet étudiant this

			if( Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau1() ) && 
				Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau2() ) )
			{
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2 , autreEtudiant,autreEtudiant.getCreneau1());

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2 , autreEtudiant,autreEtudiant.getCreneau2());

			}

			if( Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau1() ) == true && 
				Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau2() ) == false )
			{
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2 , autreEtudiant,autreEtudiant.getCreneau1());

			}

			if( Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau1() ) == false && 
				Etudiant.siCreneauxCompatibles(this.creneau2,autreEtudiant.getCreneau2() ) == true )
			{
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2 , autreEtudiant,autreEtudiant.getCreneau2());

			}

		}

		public static void sortingAscendingOrder(LinkedHashMap<Etudiant, Integer> list)
		{
			LinkedHashMap<Etudiant, Integer> newList = new LinkedHashMap<>(); 

			list.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> newList.put(x.getKey(), x.getValue()));

			list.clear();

			list.putAll(newList);

			

		}

		public static void ajouterEtudiantDansUneListe (LinkedHashMap<Etudiant, Integer> list, Etudiant autreEtudiant , int creneau)
		{

			if(list.containsKey(autreEtudiant) == false &&
				 list.containsValue(creneau) == false  )
				{

					

					if(list.size() == 1 )
					{

						list.put(autreEtudiant,creneau);

					}else{

						// size > 1

						//Object maxEntry = Collections.max(sortedEncheresMap.entrySet(), Map.Entry.comparingByValue()).getKey(); 

						// int min = Collections.min(list.entrySet(),
					// Map.Entry.comparingByValue()).getValue();

					int min = list.values().stream().parallel().min(Integer::compare).get();

					// int max = Collections.max(list.entrySet(),
					// Map.Entry.comparingByValue()).getValue();

					int max = list.values().stream().parallel().max(Integer::compare).get();

						if(creneau < min)
						{
							if( Etudiant.siCreneauxCompatibles(min,creneau ) == true )
							{
								list.put(autreEtudiant,creneau);

							}
						} 

						if(creneau > max)
						{
							if( Etudiant.siCreneauxCompatibles(max,creneau ) == true )
							{
								list.put(autreEtudiant,creneau);

							}

						}

						if( ! ( creneau < min || creneau > max  ) )
						{
							List<Integer> smallerThan = new ArrayList<Integer>();

							List<Integer> biggerThan = new ArrayList<Integer>();

							/*

							for (Map.Entry<Etudiant, Integer> entry : list.entrySet()) {

    							

    							if(creneau > entry.getValue())
    							{
    								smallerThan.add(entry.getValue());
    							}

    							if(creneau < entry.getValue())
    							{
    								biggerThan.add(entry.getValue()); 
    							}

							}

							*/

							smallerThan = list.values().stream().parallel().filter(value -> value < creneau)
								.collect(Collectors.toList());

							biggerThan = list.values().stream().parallel().filter(value -> value > creneau)
								.collect(Collectors.toList());

							

							if(   Etudiant.siCreneauxCompatibles(Collections.max(smallerThan),creneau ) == true && 
								Etudiant.siCreneauxCompatibles(Collections.min(biggerThan),creneau ) == true  )
							{
								list.put(autreEtudiant,creneau);
							}

						} 


					}


				}




		}



	} // class etudiant
	
	
}