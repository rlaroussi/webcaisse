/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcaisse;

/**
 *
 * @author rlaroussi
 */
public class Conso {
    	private String nom;
	private String prenom;
	private String mail;
	private String tel;
        
	public Conso (String nom, String prenom, String mail, String tel) {
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;
            this.tel = tel;
        }
	public boolean estFidele() { 
		return false;
	}
        

}
