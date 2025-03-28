package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarcher();
		if(infosMarche.length==0) {
			System.out.println("Le marche est vide revenez plus tard.\n");
		}else {
			System.out.println(nomAcheteur+" vous trouverez au marche : \n");
			for(int i=0;i<infosMarche.length;i++) {
				System.out.println("- "+infosMarche[i]+" qui vend "+infosMarche[++i]+" "+infosMarche[++i]+"\n");
			}
		}
	}
}
