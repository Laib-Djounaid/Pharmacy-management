import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import medic.*;
import client.*;

public class Main_Pharmacy {

	public static void main(String[] args) {
		
		//MAIN MENU
		
		System.out.println("\t\t\t\t GESTION VENTE PHARMACIE");
		System.out.println("\t\t\t\t =======================");
		
		System.out.println("1. Vente avec ordonnance ");
		System.out.println("2. Vente Sans ordonnace ");
	
		
		System.out.println("======================================");
		Scanner entree = new Scanner(System.in) ;
		System.out.println("Choisissez l'operation : ");
		String choix = entree.next(); 
         
		
		//CLIENTS PERMANENTS 
		
		ArrayList<Permanent> Client = new ArrayList<Permanent>();
		//C1
		Permanent C1 = new Permanent() ;
		C1.setInfo("C1", "C", 57);
		C1.setNumSecu(18234);
		C1.setSecu(true);
		C1.setChronique(false);
		C1.setTraitF("..\\src\\client\\traitements1.txt"); //LES TRAITEMENTS DANS LES FICHIERS ON ETE RAJOUTES MANUELLEMENT
		Client.add(C1);
		//C2
		Permanent C2 = new Permanent() ;
		C2.setInfo("C2", "C", 68);
		C2.setNumSecu(0);
		C2.setSecu(false);
		C2.setChronique(false);
		C2.setTraitF("..\\src\\client\\traitements2.txt"); //LES TRAITEMENTS DANS LES FICHIERS ON ETE RAJOUTES MANUELLEMENT
		Client.add(C2);
		
		

		// MEDICAMENTS INTERNES
		
		
		ArrayList<Medic_interne> Interne = new ArrayList<Medic_interne>() ;
		
		//I1
		Medic_interne I1 = new Medic_interne() ;
		I1.setInfo("I1", "pomade", "peau", false);
		I1.setPrice(500);
		I1.setTaux(0.0);
		I1.setSansOrdo(false);
		Interne.add(I1);
		//I2
		Medic_interne I2 = new Medic_interne() ;
		I2.setInfo("I2", "tizane", "avaler", true);
		I2.setPrice(300);
		I2.setTaux(0.3);
		I2.setSansOrdo(true);
		Interne.add(I2);
		
		// MEDIC EXTERNES 
		
		ArrayList<Medic_stock> Externe = new ArrayList<Medic_stock>() ;
		//E1
		Medic_stock E1 = new Medic_stock() ;
		E1.setInfo("E1", "pillule", "avaler", false , "SARL1");
		E1.setPrice(200);
		E1.setNLot(0001);
		E1.setDate(7);
		E1.setTaux(0.0);
		E1.setSeuil(50);
		E1.setSansOrdo(false);
		
		//RECUPERATION DE LA QTE DEPUIS LE FICHIER E1.txt
		
	    try {
		        File myObj = new File("..\\src\\medic\\Quantity_medic\\E1.txt");
		        Scanner myReader1 = new Scanner(myObj);
		        
		        while (myReader1.hasNextLine()) {
		          String data = myReader1.nextLine();
		          
		          E1.setQte(Integer.parseInt(data)) ;
		           
		        }
		        myReader1.close();
		      } catch (FileNotFoundException e) {
		        e.printStackTrace();
		      }
		
		
		
		Externe.add(E1); //AJOUT DE E1 A LA LISTE DES MEDICAMENTS EXTERNES 
		
		
		//E2
		Medic_stock E2 = new Medic_stock() ;
		E2.setInfo("E2", "cerum", "nez", true , "SARL2");
		
		E2.setPrice(700);
		E2.setNLot(0055);
		E2.setDate(6);
		E2.setTaux(0.3);
		E2.setSeuil(70);
		E2.setSansOrdo(true);
		
		//RECUPERATION DE LA QTE DEPUIS LE FICHIER E1.txt
		
		try {
	        File myObj = new File("..\\src\\medic\\Quantity_medic\\E2.txt");
	        Scanner myReader1 = new Scanner(myObj);
	        while (myReader1.hasNextLine()) {
	          String data = myReader1.nextLine();
	          E2.setQte(Integer.parseInt(data)) ;
	           
	        }
	        myReader1.close();
	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }
		
		
		Externe.add(E2); //AJOUT DE E2 A LA LISTE DES MEDICAMENTS EXTERNES 
		
		
		
		//PRODUITS PARAPHARMACEUTIQUES
		
		ArrayList<Parapharma> Para = new ArrayList<Parapharma>();
		//P1
		Parapharma P1 =new Parapharma() ;
		P1.setName("bavette");
		P1.setPrice(50); 
		
		//RECUPERATION DE LA QTE DEPUIS LE FICHIER P1.txt
	    
		try {
	        File myObj = new File("..\\src\\Quantity_para\\P1.txt");
	        Scanner myReader1 = new Scanner(myObj);
	        while (myReader1.hasNextLine()) {
	          String data = myReader1.nextLine();
	          P1.setQte(Integer.parseInt(data)) ;
	          
	        }
	       
	        myReader1.close();
	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }
		
		
		Para.add(P1); //AJOUT DE P1 A LA LISTE DES PRODUITS PARAPHARMACEUTIQUES
	    
	    
	    
	    //P2 
	    Parapharma P2 =new Parapharma() ;
		P2.setName("gel");
		P2.setPrice(500);
		
		
		//RECUPERATION DE LA QTE DEPUIS LE FICHIER P2.txt
	    
				try {
			        File myObj = new File("..\\src\\Quantity_para\\P2.txt");
			        Scanner myReader1 = new Scanner(myObj);
			        
			        while (myReader1.hasNextLine()) {
			          String data = myReader1.nextLine();
			          P2.setQte(Integer.parseInt(data)) ;
			           
			        }
			        myReader1.close();
			      } catch (FileNotFoundException e) {
			        e.printStackTrace();
			      }
	    
		
		Para.add(P2); //AJOUT DE P2 A LA LISTE DES PRODUITS PARAPHARMACEUTIQUES
		
		
		switch (choix) {
		case "1" :
			
			//INFOS PATIENT 
			System.out.print("Nom : ");
			String nom =entree.next();
			System.out.print("Prenom : ");
			String prenom =entree.next();
			System.out.print("Age : ");
			String age =entree.next();
			System.out.print("Numero securite sociale (si non affilie ecrire 0): "); //IF NUMERO SECURITE=0 ALORS NON AFFILIE
			String securite =entree.next();
			
			//INFOS MEDECIN
			System.out.print("\n\n Nom Tbib : ");
			String nom_med =entree.next();
			System.out.print(" Prenom Tbib : ");
			String prenom_med =entree.next();
			System.out.print(" Specialite : ");
			String specialite =entree.next();
			System.out.print(" Adresse Medecin : ");
			String adresse =entree.next();
			//DATE CONSULTATION
			System.out.print(" Date de consultation : ");
			String date_consultation =entree.next();
			//NBR MEDICAMENTS PRESCRITS
			System.out.print("nombre de medicaments on ete prescrits : ");
			String nbr =entree.next();
			
			//METTRE LES MEDICAMENTS PRESCRITS DANS UNE LISTE DE Medic_prescrit
			
			ArrayList<Medic_prescrit> A = new ArrayList<Medic_prescrit>() ;
			
			for(int i =1 ; i< Integer.parseInt(nbr) +1 ; i++) {
				
				System.out.print("\n\n Nom du produit "+Integer.toString(i)+" : ");
				String nom_ =entree.next();
				System.out.print(" qte du produit "+Integer.toString(i)+" : ");
				String qte_ =entree.next();
				System.out.print(" duree du traitment "+Integer.toString(i)+" : "); // ECRIRE 0 POUR LES PRODUITS PHARMACEUTIQUES 
				String duree_ =entree.next();
				
				Medic_prescrit D = new Medic_prescrit() ;
				D.setNom(nom_);D.setQte(Integer.parseInt(qte_));
				D.setDuree(Integer.parseInt(duree_));
				
				A.add(D) ;
				
			}
			
			
			//VENTE EN PARCOURANT LA LISTE A DONT LES ELEMENTS SONT DE TYPE : Medic_precrit 
			
		    int i=0 ;
		    while(i<A.size()) {
		    	
		    //VENTE MEDICAMENTS INTERNES
		    	
		    	for(int j=0  ; j<Interne.size() ; j++) {
		    		
		    		
		    		if (Interne.get(j).getName().equals(A.get(i).getNom())) { //VERIFIER NOM
		    			
		    			if ((Interne.get(j).getRemboursable() == true )&&(securite != "0")) { // VERIFICATION AFFILIATION  ET SI LE MEDICAMENT EST REMBOURSABLE
		    				
		    				
		    				double payement = Interne.get(j).getPrice()*(1 - Interne.get(j).getTaux()) * A.get(i).getQte() ; // CALCUL PRIX A PAYER AEC REMBOURSEMENT
		    				
		    				System.out.println("Produit : "+Interne.get(j).getName()+" achete' avec succes , prix a payer (ce produit a ete rembourse' ) : "+ payement );
		    				
		    				i++ ; // AVANCER AU PROCHAIN MEDECIAMENT PRESCRIT S'IL EXISTE
		    				
		    				
		    				
		    				
		    				
		    				
		    			}
		    			else {
		    				
                             double payement = Interne.get(j).getPrice() * A.get(i).getQte() ;   // CALCUL PRIX A PAYER SANS  REMBOURSEMENT
		    				
		    				System.out.println("Produit : "+Interne.get(j).getName()+" achete' avec succes , prix a payer : "+ payement );
		    				
		    				i++ ; // AVANCER AU PROCHAIN MEDECIAMENT PRESCRIT S'IL EXISTE
		    				
		    			}
		    			
		    			
		    			
		    		} 
		    		
		    	}
		    	
		    	//JE N'AI RAJOUTE LA VERIFICATION DE L'EXIPIRATION QUE POUR LES EXTERNES 
		    	
		    	//VENTE MEDICAMENTS EXTERNES
		    	
		    		for(int k=0  ; k<Externe.size() ; k++) {
		    			
		    			// VERIFICATION DE LA QTE , ET DE LA DATE
		    			
		    			if((Externe.get(k).getName().equals(A.get(i).getNom()))&&(Externe.get(k).getQte()>Externe.get(k).getSeuil())&&(Externe.get(k).getDate() > A.get(i).getDuree())) {  
		    				
		    				
		    				if ((Externe.get(k).getRemboursable() == true )&&(securite != "0")) { 
		    					
		    					
                                double payement = Externe.get(k).getPrice()*(1 - Externe.get(k).getTaux()) * A.get(i).getQte() ;
			    				
			    				System.out.println("Produit : "+Externe.get(k).getName()+" achete' avec succes , prix a payer (ce produit a ete rembourse' ) : "+ payement );
			    				 
			    				Externe.get(k).setQte(Externe.get(k).getQte()-A.get(i).getQte()); // ON PEUT UTILISER UN FICHIER POUR ACTUALISER A CHAQUE FOIS
			    				
			    				//ACTUAISATION QTE
			    				
			    				try {
								      FileWriter myWriter = new FileWriter("..\\src\\medic\\Quantity_medic\\"+Externe.get(k)+".txt");
								      myWriter.write(Integer.toString(Externe.get(k).getQte()));
								      myWriter.close();
								    } catch (IOException e1) {
								      e1.printStackTrace();
								    }
			    				
			    				
			    				i++ ;
		    					
		    					
		    					
		    			
		    				}
		    				
		    				else {
			    				
                                double payement = Externe.get(k).getPrice() * A.get(i).getQte() ;
			    				
			    				System.out.println("Produit : "+Externe.get(k).getName()+" achete' avec succes , prix a payer : "+ payement );
			    			     
			    				Externe.get(k).setQte(Externe.get(k).getQte()-A.get(i).getQte()); 
			    				
			    				//ASCTUALISATION QTE
			    				
			    				try {
								      FileWriter myWriter = new FileWriter("medic\\Quantity_medic\\"+Externe.get(k)+".txt");
								      myWriter.write(Integer.toString(Externe.get(k).getQte()));
								      myWriter.close();
								    } catch (IOException e1) {
								      e1.printStackTrace();
								    }
			 
			    				
			    				i++ ;
	                              
			    				
			    			}
		    				
		    				
		    				
		    				
		    			}
		    			
		    			// SI IL Y A UNE RUPTURE DE STOCK ET SI LE CLIENT EST ENREGISTRE IL PEUT PASSER UNE COMMANDE	
		    			
		    			if(Externe.get(k).getQte()< Externe.get(k).getSeuil()) {
		    				
		    				for( i=0 ; i < Client.size() ; i++) {
		    					
		    					if((Client.get(i).getName().equals(nom))&&(Client.get(i).getNumSecu() == Integer.parseInt(securite))) {
		    						
		    						
		    						System.out.println("VOULEZ VOUS PASSER UNE COMMANDE ?") ;
		    						String commande =entree.next();
		    						
		    						if (commande.toUpperCase() == "OUI") {
		    							
		    							System.out.println("COMMANDE PASSEE ") ;
		    							
		    						}
		    						
		    					}
		    					
		    				}
		    				
		    			}
		    			
		    			
		    			
		    		}
		    		
		    		
		    		
		    		//VENTE PRODUITS PARAPHARMACEUTIQUES
		    		
		    		for(int l=0  ; l<Para.size() ; l++) {
		    			
		    			if ((Para.get(l).getName().equals(A.get(i).getNom()))&&(Externe.get(l).getQte()>0)) {
		    				
		    				
		    				double payement = Para.get(l).getPrice() * A.get(i).getQte() ;
		    				
		    				System.out.println("Produit : "+Para.get(l).getName()+" achete' avec succes , prix a payer : "+ payement );
		    			     
		    				Para.get(l).setQte(Para.get(l).getQte()-A.get(i).getQte());
		    				
		    				//ACTUALIZATION QTE
		    				
		    				try {
							      FileWriter myWriter = new FileWriter("..\\src\\Quantity_para\\"+Para.get(l)+".txt");
							      myWriter.write(Integer.toString(Externe.get(l).getQte()));
							      myWriter.close();
							    } catch (IOException e1) {
							      e1.printStackTrace();
							    }
		    				
		    				i++ ;
		    			}
		    			
		    			
		    		}
		    		
		    		
		    		
		    	
		    }
		    	
		    	
		    	 
			break ;
		case "2" :
			
			//INFOS PRODUIT
			
			System.out.print("Nom produit : ");
			String nom_medic =entree.next();
			System.out.print("Qte  : ");
			String qte_medic =entree.next();
			System.out.print("Duree traitement : "); // ECRIRE 0 SI PRODUIT PARAPHARMACEUTIQUE
			String duree_medic =entree.next();
			System.out.print("Numero securite sociale (si non affilie ecrire 0): "); //IF SECURITE = 0 ALORS NON AFFILIE
			String security =entree.next();
			
		    
			//VENTE PRODUITS PARAPHARMACEUTIQUES
			
		    for(int l=0  ; l<Para.size() ; l++) {
    			
    			if ((Para.get(l).getName().equals(nom_medic))&&(Para.get(l).getQte() > Integer.parseInt(qte_medic) )) { // VERIFIER QTE
    				
    				
    				double payement = Para.get(l).getPrice() * Integer.parseInt(qte_medic) ;
    				
    				System.out.println("Produit : "+Para.get(l).getName()+" achete' avec succes , prix a payer : "+ payement );
    			     
    				Para.get(l).setQte(Para.get(l).getQte()-Integer.parseInt(qte_medic)); 
    				
    				// ACTUALISER QTE
    				
    				try {
					      FileWriter myWriter = new FileWriter("..\\src\\Quantity_para\\"+Para.get(l)+".txt");
					      myWriter.write(Integer.toString(Externe.get(l).getQte()));
					      myWriter.close();
					    } catch (IOException e1) {
					      e1.printStackTrace();
					    }
  				
    				
    			}
    			
		    }
			
		  
		   //VENTE PRODUITS EXTERNES
		    
		    for(int k=0  ; k<Externe.size() ; k++) {
    			
    			
    			if((Externe.get(k).getName().equals(nom_medic))&&(Externe.get(k).getQte()>Externe.get(k).getSeuil())&&(Externe.get(k).getDate() > Integer.parseInt(duree_medic))) { 
    				
    				
    				if(Externe.get(k).getSansOrdo()==true) {
    					

        				if ((Externe.get(k).getRemboursable() == true )&&(security != "0")) {
        					
        					
                            double payement = Externe.get(k).getPrice()*(1 - Externe.get(k).getTaux()) * Integer.parseInt(qte_medic) ;
    	    				
    	    				System.out.println("Produit : "+Externe.get(k).getName()+" achete' avec succes , prix a payer (ce produit a ete rembourse' ) : "+ payement );
    	    				 
    	    				Externe.get(k).setQte(Externe.get(k).getQte()-Integer.parseInt(qte_medic));
    	    				
    	    				//ACTUALISER LA QTE
    	    				try {
							      FileWriter myWriter = new FileWriter("..\\src\\medic\\Quantity_medic"+Externe.get(k)+".txt");
							      myWriter.write(Integer.toString(Externe.get(k).getQte()));
							      myWriter.close();
							    } catch (IOException e1) {
							      e1.printStackTrace();
							    }
        					
        					
        			
        				}
        				
        				else {
    	    				
                           double payement = Externe.get(k).getPrice() * Integer.parseInt(qte_medic) ;
    	    				
    	    				System.out.println("Produit : "+Externe.get(k).getName()+" achete' avec succes , prix a payer : "+ payement );
    	    			     
    	    				Externe.get(k).setQte(Externe.get(k).getQte()-Integer.parseInt(qte_medic)); 
    	    				
    	    				// ACTUALISER LA QTE
    	    				try {
							      FileWriter myWriter = new FileWriter("..\\src\\medic\\Quantity_medic"+Externe.get(k)+".txt");
							      myWriter.write(Integer.toString(Externe.get(k).getQte()));
							      myWriter.close();
							    } catch (IOException e1) {
							      e1.printStackTrace();
							    }
                             
    	    				
    	    			}
    					
    				}
    				
    				else {
    					
    					System.out.println("Le medicament :"+Externe.get(k).getName()+" ne peut pas etre vendu sans ordonnance  ");
    					
    				}
    				
    				
    				
    			}
    			
    			
    			
    			if(Externe.get(k).getQte()< Externe.get(k).getSeuil()) { // VERIFICATION QTE
    					
    				for(i=0 ; i < Client.size() ; i++) {
    					
    					if((Client.get(i).getName().equals(nom_medic))&&(Client.get(i).getNumSecu() == Integer.parseInt(security))) {
    						
    						
    						System.out.println("VOULEZ VOUS PASSER UNE COMMANDE ?") ;
    						String commande =entree.next();
    						
    						if (commande.toUpperCase() == "OUI") {
    							
    							System.out.println("COMMANDE PASSEE ") ;
    							
    						}
    						
    					}
    					
    				}
    				
    			}
    			
    			
    			
    		}
		    
		    //VENTE PRODUITS INTERNES
		    
		    
		    for(int j=0  ; j<Interne.size() ; j++) {
	    		
	    		
	    		if (Interne.get(j).getName().equals(nom_medic)) {
	    			
	    			if(Interne.get(j).getSansOrdo()==true) { // VERIFICATION DE SI LE PRODUIT PEUT ETRE VENDU SANS ORDONNANCE 
	    				
	    				if ((Interne.get(j).getRemboursable() == true )&&(security != "0")) { // VERIFICATION DE L'AFFILIATION 
		    				
	    					 double payement = Interne.get(j).getPrice()*(1 - Interne.get(j).getTaux()) * Integer.parseInt(qte_medic) ;
			    				
		    				 System.out.println("Produit : "+Interne.get(j).getName()+" achete' avec succes , prix a payer (ce produit a ete rembourse' ) : "+ payement );	
		    				
		    			}
		    			else {
		    				
                            double payement = Interne.get(j).getPrice() * Integer.parseInt(qte_medic) ;
		    				
		    				System.out.println("Produit : "+Interne.get(j).getName()+" achete' avec succes , prix a payer : "+ payement );
		    							
		    			}
	    				
	    			}
	    			else {
	    				
	    				System.out.println("Le medicament :"+Interne.get(j).getName()+" ne peut pas etre vendu sans ordonnance  ");
	    			}
	    			
	    			
	    			
	    			
	    		} 
	    		
	    	}
		    
			
			
			
			break ;
			
		default :
			
			System.out.println("Veuillez taper sur 1 ou 2  ");
			
			break ;	
		
		
		}
	
	}

}
