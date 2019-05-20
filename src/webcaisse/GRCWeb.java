/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcaisse;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author rlaroussi
 */
public class GRCWeb {
    
    public ArrayList<Conso> listeConsoAFideliser() throws SQLException {
        
        ArrayList <Conso> lesConsos = new ArrayList <Conso>() ;	
        
	//Connexion à la base de données
        String dbURL = "jdbc:mysql://localhost:3306/webcaisse";
        String adminUser = "root";
        String adminPwd ="";
        ResultSet result;
        
        try {
        
            Connection dbConnect = DriverManager.getConnection(dbURL, adminUser, adminPwd);             
            java.sql.Statement dbStatement = dbConnect.createStatement();

	//Création de la requête
        
	String requete="select distinct nom, prenom, tel, mail"
			+ " from Conso "
			+ "join Vente on idConso = Conso.id"
			+ " where Conso.id not in (select id from ConsoFidele)"
			+ " and datediff(now(), dateVente)<30" ;

	//Exécution de la requête
	result = dbStatement.executeQuery(requete);

	//Pour chaque enregistrement résultat de la requête
	while (result.next()) {
            
        //Création d’un objet de la classe Conso avec les données 
        Conso leConso = new Conso(result.getString(1), result.getString(2) , result.getString(3) , result.getString(4)) ;
        
        //ajout du Consommateur à la liste des Consommateurs
        lesConsos.add(leConso) ;
	}
	// fermeture de la connexion à la BD
	result.close();
	dbConnect.close() ;
        
        } 
        catch(SQLException e) {
            e.printStackTrace();
        }
        return lesConsos ;
 }

    private class dbStatement {

        public dbStatement() {
        }
    }

}
