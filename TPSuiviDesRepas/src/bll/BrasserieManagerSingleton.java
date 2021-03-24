package bll;

public class BrasserieManagerSingleton {

	private static BrasserieManager instance;
	
	public static IBrasserieManager getInstance() {
        if (instance == null) {
            instance = new BrasserieManager();
        }
        return instance;
    }
}
