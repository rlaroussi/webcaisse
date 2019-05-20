/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcaisse;

import java.util.Date;

/**
 *
 * @author rlaroussi
 */

class ConsoFidele extends Conso {
    
    	private Date dateNaiss;
	private double pointsFidelite = 0; // contient un nombre de points ou un montant
	private Date dateInscription;
        
	public  ConsoFidele(String nom, String prenom, String mail, String tel, Date dateNaiss, Date dateInsc) {
            super(nom, prenom, mail, tel);            
        }

        @Override
	public boolean estFidele() {
		return true; 
	}
        
	public void addFidelite(int typeFidelite, double montant)  {
	// typeFidelite contient le type de programme de fidélisation choisi (1, 2 ou 3)
	// montant contient la valeur du montant d’achat réalisé
        
	switch (typeFidelite) {
		case 1 : this.pointsFidelite++;
   			 break;
		case 2 : this.pointsFidelite += montant;
                         break;
		case 3 : if (montant >=100 && montant <=200)
				this.pointsFidelite += 10;
				else if (montant >200 && montant <=500)
					this.pointsFidelite += 20;
				else if (montant > 500)
					this.pointsFidelite += 50;
                         break;
            }   
        }

    public double getPointsFidelite() {
        return this.pointsFidelite;
    }
}


