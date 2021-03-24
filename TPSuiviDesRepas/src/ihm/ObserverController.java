package ihm;

/**
 * Observeur de Controlleur Swing. 
 * Cet observeur peut être un écran ou tout autre classe
 * @author Emmanuel Malabry
 *
 * @param <M> Le modèle de notre MVC
 */
public interface ObserverController<M> {
	/**
	 * Méthode de l'observeur permettant de mettre à jour des éléments à partir du modèle
	 * @param model le modèle
	 */
	public void fromModel(M model);
	
	/**
	 * Méthode de l'observeur permettant d'alimenter le modèle récupéré en argument par des éléments
	 * de l'observeur (ex : valeur de champs de formulaire)
	 * @param model le modèle
	 * @return le modèle alimenté
	 */
	public M populateModel(M model);
}
