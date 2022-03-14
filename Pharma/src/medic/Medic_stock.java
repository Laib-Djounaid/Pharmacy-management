package medic;


public class Medic_stock extends Medic_externe {
	
	int Qte , num_lot , prix , seuil_min , date ;

  	 public void setInfo(String name ,String t , String mode , Boolean rembours, String nf){
  		 super.nom = name ;
  	     super.type = t ;
  	     super.mode_de_prise = mode ;
  	     super.remboursable = rembours;
  	     super.nom_firme = nf ;
  	 }
  	
  	 public String getName() {return super.nom ;}
  	 public String getType() {return super.type ;}
  	 public String getMode() {return super.mode_de_prise ;}
  	 public Boolean getRemboursable() {return super.remboursable ; }
  	 public String getFirme() {return super.nom_firme ; }
  	 
  	public void setQte(int x){ this.Qte =x ; }
  	public  int getQte(){ return this.Qte ; }
  	public  void setNLot(int l) {this.num_lot =l ;}
  	public int getNLot() { return this.num_lot ;}
  	public  void setPrice(int p) {this.prix = p ;}
  	public int getPrice() {return this.prix ;}
  	public  void setDate(int d) {this.date =d ;}
  	public  int getDate() {return this.date ; }
  	public  void setTaux(double d) {super.taux_remboursement = d ; }
  	public  double getTaux() {return super.taux_remboursement ; }

  	public void setSeuil(int x) {this.seuil_min = x ;}
  	public int getSeuil() {return this.seuil_min ; }
  	
  	
}