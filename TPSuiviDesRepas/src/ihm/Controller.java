package ihm;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite permettant définir un controller Swing
 * @author Emmanuel Malabry
 *
 * @param <M> le modèle qui sera utilisé dans le MVC
 */
public abstract class Controller<M>{
	private List<ObserverController<M>> listObserver = new ArrayList<ObserverController<M>>();
	
	/**
	 * Cette méthode va aiguiller vers une action (méthode) en fonction d'un code 
	 * @param action le code 
	 */
	public abstract void action(String action);
	
	
	/**
	 * Ajoute un observeur à notre controlleur
	 * @param ob l'observeur
	 */
	public void addObserver(ObserverController ob) {
		listObserver.add(ob);
	}
	
	/**
	 * Met à jour le model sur tous les observeurs
	 * @param model le modèle
	 */
	public void updateAll(M model) {
		for (ObserverController<M> voteObserver : listObserver) {
			voteObserver.fromModel(model);
			
		}
	}
	
	/**
	 * Parcours tous les observeurs pour qu'ils alimentent le modèle
	 * @param model le modèle
	 * @return
	 */
	public M populateAll(M model) {
		for (ObserverController<M> voteObserver : listObserver) {
			model = voteObserver.populateModel(model);
		}
		return model;
	}
}
