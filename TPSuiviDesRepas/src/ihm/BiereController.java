package ihm;


import bll.BrasserieManagerSingleton;
import bll.IBrasserieManager;
import bo.Brasserie;
import dal.DALException;
import dal.DAOFact;

public class BiereController extends Controller<BiereModel> {
	
	public BiereController() {
		myModel = new BiereModel();
	}
	// partie singleton

	public BiereModel getMyModel() {
		return myModel;
	}

	private BiereModel myModel;
	private static BiereController instance;

	public static BiereController getInstance() {
		if (instance == null) {
			instance = new BiereController();
		}
		return instance;
	}

	// partie actions
	private IBrasserieManager manager = BrasserieManagerSingleton.getInstance();

	String message = "";

	public void startAjoutBiere() {
		myModel = new BiereModel();
		
		updateAll(myModel);
	}

	public void addBiere() {
		
		myModel = populateAll(myModel);
		try {
			Brasserie b = DAOFact.getBrasserieDAO().selectById(myModel.getIdBrasserie());
			if(b!= null) {
			manager.insererBiere(myModel.getCurrentBiere());
			
			
			myModel.setMessage("INSERTION REUSSIE MAGGLE!");
			}
			else {
				myModel.setMessage("Cette brasserie n'existe pas");
			}
		} catch (DALException e) {
			message = e.getMessage();
			myModel.setMessage(e.getMessage());
		}
		
		updateAll(myModel);

	}

	public String getMessage() {
		return message;
	}
	@Override
	public void action(String action) {
		switch (action) {
		case "START_AJOUT":
			startAjoutBiere();
			break;
		case "ADD_BIERE":
			addBiere();
			break;
		}
		
	}

}
