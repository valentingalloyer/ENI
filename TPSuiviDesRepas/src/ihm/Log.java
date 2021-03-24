package ihm;



public class Log implements ObserverController<BiereModel> {

	private Controller<BiereModel> controller;
	
	public Log(Controller<BiereModel> controller) {
		this.controller = controller;
		this.controller.addObserver(this);
	}
	@Override
	public void fromModel(BiereModel model) {
		System.out.println(model);
		
	}

	@Override
	public BiereModel populateModel(BiereModel model) {
		// TODO Auto-generated method stub
		return model;
	}

}
