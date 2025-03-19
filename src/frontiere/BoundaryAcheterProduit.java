package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis desolee "+nomAcheteur+" mais il faut etre un habitant de notre village pour commercer ici.\n");
		}else {
			String produitAcheter = Clavier.entrerChaine("Quel produit voulez vous acheter ?");
			String [] propositionVendeurs = controlAcheterProduit.propositionVendeur(produitAcheter);
			int choixVendeur = Clavier.entrerEntier("Chez quel commercant voulez vous acheter des "+produitAcheter+"?");
			while(choixVendeur < 1 || choixVendeur > propositionVendeurs.length) {
				System.out.println("Ce numero n'est pas propose\n");
				choixVendeur  = Clavier.entrerEntier("Chez quel commercant voulez vous acheter des "+produitAcheter+"?");
			}
			String nomVendeur = propositionVendeurs[choixVendeur - 1];
			System.out.println(nomAcheteur+" se deplace jusqu'a l'etal du vendeur "+nomVendeur+".\n");
			int quantite = Clavier.entrerEntier("Bonjour "+nomAcheteur+"\nCombien de "+produitAcheter+" voulez-vous acheter ?\n");
			int resultatAchat = controlAcheterProduit.acheterProduit(nomVendeur,quantite);
			if(resultatAchat==0) {
				System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produitAcheter+", malheureusement il n'y en a plu!\n");
			}else if(resultatAchat==quantite) {
				System.out.println(nomAcheteur+" achete "+quantite+" a "+nomVendeur+".\n"); 
			}else {
				System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produitAcheter+"malheureusement, "+nomVendeur+ " n'en a plus que "+produitAcheter+". "+nomAcheteur+ "achete tout le stock de "+nomVendeur);
			}
		}
	}
}
