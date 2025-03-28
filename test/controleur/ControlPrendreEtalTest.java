package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void init() {
	village = new Village("le village des irréductibles", 10, 3);
	abraracourcix = new Chef("Abraracourcix", 10, village);
	village.setChef(abraracourcix);
	controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
	controlVerifierIdentite = new ControlVerifierIdentite(village);
	controlEmmenager = new ControlEmmenager(village);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		controlEmmenager.ajouterGaulois("Obelix", 5);
		controlPrendreEtal.prendreEtal("Obelix", "menhirs", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Abraracourcix", "poissons", 5);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
