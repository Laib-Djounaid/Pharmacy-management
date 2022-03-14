package client;

public abstract class Client {
	
	String nom_client , prenom_client ;
    int age_client ;
    
    
    public void setInfo(String n , String p , int age ) {
    	 this.age_client = age ;
    	 this.nom_client = n ;
    	 this.prenom_client =p ;
    	 
    }
    
    public String getName() {return this.nom_client ;}
    public String getPrenom() {return this.prenom_client ;} 
    public int getAge() {return this.age_client ;}
    
    
}
