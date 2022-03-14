package medic;

public class Medic_interne extends Medicament  {

	
	int prix ;
	String nom_matiere_premiere ;
	
	public void setInfo(String name ,String t , String mode , Boolean rembours){
		
		super.nom = name  ;
		super.type = t;
		super.mode_de_prise = mode;
		super.remboursable =  rembours ;
		
	}
	
	 public String getName() {return super.nom ;}
  	 public String getType() {return super.type ;}
  	 public String getMode() {return super.mode_de_prise ;}
  	 public Boolean getRemboursable() {return super.remboursable ; }
  	 
  	public  void setPrice(int p) {this.prix = p ;}
  	public int getPrice() {return this.prix ;}
  	
  	
  	public  void setTaux(double d) {super.taux_remboursement= d ; }
  	public  double getTaux() {return super.taux_remboursement ; }	
	
  	
	

	
	
}
