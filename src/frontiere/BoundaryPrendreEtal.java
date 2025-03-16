package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis desolee "+nomVendeur+" mais il faut etre un habitant de notre village poue commercer ici\n");
		}else{
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un etal\n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible){
				System.out.println("Desolee "+nomVendeur+"Je n'ai plus d'etal qui ne soit pas deja occupe\n");
			}else {
				this.installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un etal pour vous !\nIl me faudrait quelques renseignements");
				String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if(numeroEtal != -1) {
					System.out.println("Le vendeur "+ nomVendeur+" s'est installe a l'etal numero "+numeroEtal+"\n");
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
