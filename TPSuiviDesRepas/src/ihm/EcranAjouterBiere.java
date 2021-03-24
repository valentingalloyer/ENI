package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EcranAjouterBiere extends JFrame implements ObserverController<BiereModel> {

	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel brasserieLabel;
	private JLabel typeLabel;
	private JButton btnAjouter;
	private JButton btnVider;
	private JTextField typeTextField;
	private JTextField brasserieTextField;
	private JTextField nomTextField;
	private JLabel messageLabel;
	private Controller<BiereModel> controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiereController controller = new BiereController();
					EcranAjouterBiere frame = new EcranAjouterBiere(controller);
					frame.setVisible(true);
					Log log = new Log(controller);
					controller.action("START_AJOUTER");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EcranAjouterBiere(Controller<BiereModel> controller) {
		this.controller = controller;
		this.controller.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60, 116, 0};
		gbl_contentPane.rowHeights = new int[]{50, 50, 50, 50, 31, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		contentPane.add(getNameLabel(), gbc_nameLabel);
		GridBagConstraints gbc_nomTextField = new GridBagConstraints();
		gbc_nomTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nomTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomTextField.gridx = 1;
		gbc_nomTextField.gridy = 0;
		contentPane.add(getNomTextField(), gbc_nomTextField);
		GridBagConstraints gbc_brasserieLabel = new GridBagConstraints();
		gbc_brasserieLabel.anchor = GridBagConstraints.WEST;
		gbc_brasserieLabel.insets = new Insets(0, 0, 5, 5);
		gbc_brasserieLabel.gridx = 0;
		gbc_brasserieLabel.gridy = 1;
		contentPane.add(getBrasserieLabel(), gbc_brasserieLabel);
		GridBagConstraints gbc_brasserieTextField = new GridBagConstraints();
		gbc_brasserieTextField.insets = new Insets(0, 0, 5, 0);
		gbc_brasserieTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_brasserieTextField.gridx = 1;
		gbc_brasserieTextField.gridy = 1;
		contentPane.add(getBrasserieTextField(), gbc_brasserieTextField);
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.anchor = GridBagConstraints.WEST;
		gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_typeLabel.gridx = 0;
		gbc_typeLabel.gridy = 2;
		contentPane.add(getTypeLabel(), gbc_typeLabel);
		GridBagConstraints gbc_typeTextField = new GridBagConstraints();
		gbc_typeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_typeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeTextField.gridx = 1;
		gbc_typeTextField.gridy = 2;
		contentPane.add(getTypeTextField(), gbc_typeTextField);
		GridBagConstraints gbc_btnVider = new GridBagConstraints();
		gbc_btnVider.insets = new Insets(0, 0, 5, 5);
		gbc_btnVider.gridx = 0;
		gbc_btnVider.gridy = 3;
		contentPane.add(getBtnVider(), gbc_btnVider);
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 1;
		gbc_btnAjouter.gridy = 3;
		contentPane.add(getBtnAjouter(), gbc_btnAjouter);
		GridBagConstraints gbc_messageLabel = new GridBagConstraints();
		gbc_messageLabel.gridx = 1;
		gbc_messageLabel.gridy = 4;
		contentPane.add(getMessageLabel(), gbc_messageLabel);
	}


	private JLabel getNameLabel() {
		if (nameLabel == null) {
			nameLabel = new JLabel("Nom");
		}
		return nameLabel;
	}
	private JLabel getBrasserieLabel() {
		if (brasserieLabel == null) {
			brasserieLabel = new JLabel("idBrasserie");
		}
		return brasserieLabel;
	}
	private JLabel getTypeLabel() {
		if (typeLabel == null) {
			typeLabel = new JLabel("Type");
		}
		return typeLabel;
	}
	private JButton getBtnAjouter() {
		if (btnAjouter == null) {
			btnAjouter = new JButton("Ajouter");
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.action("ADD_BIERE");
				}
			});
		}
		return btnAjouter;
	}
	private JButton getBtnVider() {
		if (btnVider == null) {
			btnVider = new JButton("Vider");
			btnVider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.action("START_AJOUT");
				}
			});
		}
		return btnVider;
	}
	private JTextField getTypeTextField() {
		if (typeTextField == null) {
			typeTextField = new JTextField();
			typeTextField.setColumns(10);
		}
		return typeTextField;
	}
	private JTextField getBrasserieTextField() {
		if (brasserieTextField == null) {
			brasserieTextField = new JTextField();
			brasserieTextField.setColumns(10);
		}
		return brasserieTextField;
	}
	private JTextField getNomTextField() {
		if (nomTextField == null) {
			nomTextField = new JTextField();
			nomTextField.setColumns(10);
		}
		return nomTextField;
	}
	private JLabel getMessageLabel() {
		if (messageLabel == null) {
			messageLabel = new JLabel("");
		}
		return messageLabel;
	}
	

	@Override
	public void fromModel(BiereModel model) {
		getNomTextField().setText(model.getNom());
		getBrasserieTextField().setText( (  model.getIdBrasserie() != -1 ) ? String.valueOf(model.getIdBrasserie()) : "" );
		getTypeTextField().setText(model.getType());
		getMessageLabel().setText(model.getMessage());
	}

	@Override
	public BiereModel populateModel(BiereModel model) {
		model.setNom(getNomTextField().getText());
		model.setIdBrasserie(Integer.parseInt(getBrasserieTextField().getText()));
		model.setType(getTypeTextField().getText());
		
		return model;
	}

}
