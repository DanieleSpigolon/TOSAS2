////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class User {
    
    private String id;
    private String nome;
    private String cognome;
    private int eta;
    
    public User(String id,String nome,String cognome,int eta)
    {
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.eta=eta;
    }
    String getId(){
        return id;
    }
    String getNome(){
        return nome;
    }
    String getCognome(){
        return cognome;
    }
    int getEta(){
        return eta;
    }
}

