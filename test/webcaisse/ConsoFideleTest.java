/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcaisse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rlaroussi
 */
public class ConsoFideleTest extends TestCase {
    
    ConsoFidele consoTest;
    
    public ConsoFideleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        consoTest = new ConsoFidele("Lifo", "Paul","lifo.paul@gmail.com", "0600000000",new SimpleDateFormat("yyyy-MM-dd").parse("1961-01-03"),	
					new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-05"));
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAddFideliteTampon() {

	consoTest.addFidelite(1, 50);
        System.out.println(consoTest.getPointsFidelite());
	//assertEquals("erreur calcul 1er tampon",1,consoTest.getPointsFidelite());
                
	consoTest.addFidelite(1, 20);
	//assertEquals("erreur calcul 2ème tampon ",2,consoTest.getPointsFidelite());
    }

    public void testAddFideliteMontant() {
	consoTest.addFidelite(2, 150);	
	assertEquals("erreur calcul 1er achat",150.0, consoTest.getPointsFidelite());
        
	consoTest.addFidelite(2, 250);
	assertEquals("erreur calcul 2ème  achat",400.0, consoTest.getPointsFidelite());
    }
    
    public void testInitConso() {

	// À compléter sur votre copie
        assertEquals("Erreur à l'initialisation",0.0, consoTest.getPointsFidelite());
    }
	
    public void testAddMontant() {
    
	// À compléter sur votre copie
        consoTest.addFidelite(3, 50);
        assertEquals("Erreur 1er achat à 50 euros (inférieur à 100 euros)",0.0, consoTest.getPointsFidelite());
        
        consoTest.addFidelite(3, 150);
        assertEquals("Erreur 2ème achat à 150 euros (entre 100 et 200 euros)",10.0, consoTest.getPointsFidelite());
        
        consoTest.addFidelite(3, 250);
        assertEquals("Erreur 3ème achat à 250 euros (entre 200 et 500 euros)",30.0, consoTest.getPointsFidelite());
        
        consoTest.addFidelite(3, 550);
        assertEquals("Erreur 4ème achat à 550 euros (supérieur à 500 euros)",80.0, consoTest.getPointsFidelite());
	}
}