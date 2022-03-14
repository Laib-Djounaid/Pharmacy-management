package medic;

public abstract class Medicament {


	String nom, type , mode_de_prise ;
	Boolean remboursable ;
    Boolean sans_ordo ;
    double taux_remboursement ;
    
    public void setSansOrdo(Boolean b) {this.sans_ordo = b ;}
    public Boolean getSansOrdo() {return this.sans_ordo ; }	
}
