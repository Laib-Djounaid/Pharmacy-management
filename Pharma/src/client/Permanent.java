package client;

public class Permanent extends Client {
	
	Boolean secu , chronique ;
    int num_secu ;
    
    String traitements_frequents ;

    
    public void setSecu(Boolean s ){this.secu = s ;}    
    public void setChronique(Boolean c) {this.chronique =c ;}
    public void setNumSecu(int n) {this.num_secu = n ;}
    public void setTraitF(String s) {this.traitements_frequents = s ;}
    
    public Boolean getSecu() {return this.secu ;}
    public Boolean getChronique() {return this.chronique ; }
    public int getNumSecu() {return this.num_secu ;}
    public String getTrait() {return this.traitements_frequents ; }
    

}
