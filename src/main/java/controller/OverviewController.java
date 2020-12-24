package controller;

import database.CardDAO;
import database.Database;
import states.UIStates;

import java.text.NumberFormat;

import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class OverviewController implements Controller {
	@FXML
	private TextField AA;

	@FXML
	private TextField saMultiplier;

	@FXML
	private TextField leaderSkill;

	@FXML
	private TextField startPassive;

	@FXML
	private TextField activeSkill;

	@FXML
	private TextField atkStat;

	@FXML
	private TextField CRIT;

	@FXML
	private TextField kiMultiplier;

	@FXML
	private TextField links;

	@FXML
	private TextField buildUP;

	@FXML
	private TextField support;

	@FXML
	private Label aptTEXT;

	@FXML
	private CheckBox SE;

	@FXML
	private Label numberAALABEL;

	@FXML
	private Label saCHANCELABEL;

	@FXML
	private TextField numberAAFIELD;

	@FXML
	private TextField saCHANCEFIELD;

	@FXML
	private CheckBox builtAA;

	@FXML
	private CheckBox guardBreak;

	@FXML
	private TextField saRAISE;

	@FXML
	private Label passivecritLABEL;

	@FXML
	private CheckBox critCHECKBOX;

	@FXML
	private TextField linkCRIT;

	@FXML
	private TextField passiveCRIT;

	@FXML
	private Label linkcritLABEL;

	@FXML
	private CheckBox gAA;

	@FXML
	private TextField builtAAchanceFIELD;

	@FXML
	private Label builtAAchanceLABEL;

	@FXML
	private Label beforecounterL;

	@FXML
	private Label aftercounterL;

	@FXML
	private Label multipliercounterL;

	@FXML
	private TextField beforecounterF;

	@FXML
	private TextField multipliercounterF;

	@FXML
	private TextField aftercounterF;

	@FXML
	private CheckBox countercheckbox;

	@FXML
	private TextField delayF;

	@FXML
	private TextField enemychanceFIELD;

	@FXML
	private Label enemychanceLABEL;

	@FXML
	private Label counterchanceLABEL;

	@FXML
	private TextField counterChanceFIELD;

	@FXML
	private CheckBox counterSAcheckbox;

	@FXML
	private Label kiLRLABEL;

	@FXML
	private Label saLRLABEL;

	@FXML
	private TextField kiLRFIELD;

	@FXML
	private TextField saraiseLRFIELD;

	@FXML
	private Label saraiseLRLABEL;

	@FXML
	private TextField saLRFIELD;

	@FXML
	private CheckBox LRcheckbox;
	
	@FXML
	void calculate(ActionEvent event) {
		
	//	CardDAO dao = new CardDAO();
	//	dao.closeConnection();
		
		double D_leaderSkill;
		double D_atkStat;
		double D_startPassive;
		double D_support;
		double D_links;
		double D_activeSkill;
		double D_kiMultiplier;
		double D_buildUP;
		double D_saMultiplier;
		double D_AA;
		double D_CRIT;
		double D_APT;
		double D_AASA;
		double D_AANA;
		double D_kiAPT;
		double D_TABNOCRIT = 1.131725;
		double D_TABCRIT = 2.03;
		double D_SE = 1.624;
		double D_numberAAFIELD;
		double D_saCHANCEFIELD;
		double atkstatSA;
		double D_GB = 1.22;
		double D_saRAISE;
		double D_passiveCRIT;
		double D_linkCRIT;
		double D_builtAAchance;
		double D_countermultiplier;
		double D_aftercounter;
		double D_beforecounter;
		double D_guaranteedAAsaraise = 0;
		double D_counterChance;
		double D_enemyChance;
		double D_saRAISELR;
		double D_delay = Double.valueOf(delayF.getText());
		double D_kiMultiplierLR = Double.valueOf(kiLRFIELD.getText());
		double D_saMultiplierLR = Double.valueOf(saLRFIELD.getText());
		if (LRcheckbox.isSelected() == true) {
			D_saRAISELR = Double.valueOf(saraiseLRFIELD.getText());
		} else {
			D_saRAISELR = 0;
		}

		System.out.println("ATK STAT");
		D_atkStat = Double.valueOf(atkStat.getText());

		System.out.println("Leader Skill");
		D_leaderSkill = Double.valueOf(leaderSkill.getText());
		D_leaderSkill = ((D_leaderSkill * 2) / 100) + 1;
		D_APT = D_atkStat * D_leaderSkill;
		D_APT = Math.floor(D_APT);
		System.out.println("Current APT " + D_APT);

		System.out.println("Start of Turn and Support Buff");
		D_startPassive = Double.valueOf(startPassive.getText());
		D_support = Double.valueOf(support.getText());
		D_APT = D_APT * (1 + ((D_startPassive / 100) + (D_support / 100)));
		D_APT = Math.floor(D_APT);
		System.out.println("Current APT " + D_APT);

		System.out.println("Links");
		D_links = Double.valueOf(links.getText());
		D_APT = D_APT * (1 + (D_links / 100));
		D_APT = Math.floor(D_APT);
		System.out.println("Current APT " + D_APT);

		System.out.println("Active Skill");
		D_activeSkill = Double.valueOf(activeSkill.getText());
		D_APT = D_APT * (1 + (D_activeSkill / 100));
		D_APT = Math.floor(D_APT);
		System.out.println("Current APT " + D_APT);

		if (D_delay < 0) {
			System.out.println("BuildUP/OnSA");
			D_buildUP = Double.valueOf(buildUP.getText());
			D_APT = D_APT * (1 + (D_buildUP / 100));
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);
		}

		double D_kiAPT2 = D_APT;

		System.out.println("Ki Multiplier");
		D_kiMultiplier = Double.valueOf(kiMultiplier.getText());
		D_APT = D_APT * (D_kiMultiplier / 100);
		D_APT = Math.ceil(D_APT);
		D_kiAPT = D_APT;
		System.out.println("kiapt " + D_kiAPT);

		//////////////////////////// LR////////////////////////

		if (LRcheckbox.isSelected() == true) {
			D_buildUP = Double.valueOf(buildUP.getText());
			System.out.println("kiapt2 " + D_kiAPT2);
			System.out.println("Ki Multiplier 2");
			D_kiAPT2 = D_kiAPT2 * (D_kiMultiplierLR / 100);
			D_kiAPT2 = Math.ceil(D_kiAPT2);
			System.out.println("kiapt2 " + D_kiAPT2);
			D_kiAPT2 = D_kiAPT2 * (1 + (D_buildUP / 100));
			D_kiAPT2 = Math.floor(D_kiAPT2);
			System.out.println("kiapt2 " + D_kiAPT2);
		}

		/////////////////////////// LR////////////////////////

		if (D_delay >= 0) {
			System.out.println("BuildUP/OnSA");
			D_buildUP = Double.valueOf(buildUP.getText());
			D_APT = D_APT * (1 + (D_buildUP / 100));
			D_APT = Math.floor(D_APT);
			D_kiAPT = D_APT;
			System.out.println("Current APT " + D_APT);
		}

		System.out.println("Current APT " + D_APT);

		///////////////////////////// SUPER ATTACK PART
		///////////////////////////// //////////////////////////////////////////////
		D_AA = Double.valueOf(AA.getText());

		if (builtAA.isSelected()) {
			D_AA = Double.valueOf(AA.getText());
			D_numberAAFIELD = Double.valueOf(numberAAFIELD.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());
			D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100));
			D_AA = (D_AA * 100) / 2;
			System.out.println("AA " + D_AA);
		}
		D_saRAISE = Double.valueOf(saRAISE.getText());

		System.out.println("SA Multiplier");
		D_saMultiplier = Double.valueOf(saMultiplier.getText());
		D_APT = D_APT * ((D_saMultiplier + D_saRAISE) / 100);
		D_APT = Math.floor(D_APT);
		System.out.println("Current APT " + D_APT);
		atkstatSA = D_APT;
		System.out.println("SA RAISE " + D_saRAISE);

		///////////////////////////// ADDITIONAL PART //////////////////////////////
		///////////////////////////// //////////////////////////////////////////////

		D_numberAAFIELD = Double.valueOf(numberAAFIELD.getText());
		D_builtAAchance = Double.valueOf(builtAAchanceFIELD.getText());
		D_beforecounter = Double.valueOf(beforecounterF.getText());
		D_aftercounter = Double.valueOf(aftercounterF.getText());
		D_countermultiplier = Double.valueOf(multipliercounterF.getText());
		D_counterChance = Double.valueOf(counterChanceFIELD.getText());
		D_enemyChance = Double.valueOf(enemychanceFIELD.getText());

////////////////////////////////////////////////////////////////////////////////////////////
		if (builtAA.isSelected() && D_numberAAFIELD == 1) {
			System.out.println("Additional Attack");
			D_AA = Double.valueOf(AA.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());
			double D_saRaiseAUX = D_saRAISE * (D_saCHANCEFIELD / 100);
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_saMultiplierLR + D_saRAISE + D_saRAISELR) / 100) * (D_saCHANCEFIELD / 100)
						* (D_builtAAchance / 100);
			} else {
				D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE) / 100) * (D_saCHANCEFIELD / 100)
						* (D_builtAAchance / 100);

			}

			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + (D_saRAISE / 100)) * (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			System.out.println("Current APT " + D_APT);

			if (D_builtAAchance == 100) {
				D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100));
				D_AA = (D_AA * 100) / 2;
			} else {
				D_AA = 1 - ((D_AA * 2) / 100);
				D_builtAAchance = 1 - ((D_builtAAchance / 100));
				System.out.println("AA " + D_AA + " AA CHANCE 2 " + D_builtAAchance);
				D_AA = 1 - (D_AA * D_builtAAchance) - (D_AA * D_AA * (1 - D_builtAAchance));
				D_AA = (D_AA * 100) / 2;

			}
			double auxAA = D_saCHANCEFIELD / 100;
			System.out.println("AA " + D_AA);
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_saMultiplierLR + D_saRAISE + D_saRAISELR + (D_saRAISELR * auxAA)) / 100)
						* (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + (D_saRAISELR * auxAA)) / 100));
			} else {
				D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE + (D_saRAISE * auxAA)) / 100)
						* (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + (D_saRAISE * auxAA)) / 100));
			}

			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);

			///////////////////////////////////////////////////////////////////////////////////////
		} else if (builtAA.isSelected() && D_numberAAFIELD == 2 && gAA.isSelected() == false) {
			System.out.println("Additional Attack");

			D_AA = Double.valueOf(AA.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());
			double D_saRaiseAUX = D_saRAISE * (D_saCHANCEFIELD / 100);
			double builtaux = (D_saCHANCEFIELD / 100);

			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_saMultiplierLR + D_saRAISE + D_saRAISELR) / 100) * (D_saCHANCEFIELD / 100)
						* (D_builtAAchance / 100);
			} else {
				D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE) / 100) * (D_saCHANCEFIELD / 100)
						* (D_builtAAchance / 100);

			}

			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + (D_saRAISE / 100)) * (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			double auxAA = D_saCHANCEFIELD / 100;
			System.out.println("Current APT " + D_APT);
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_saMultiplierLR + D_saRAISE + D_saRAISELR + (D_saRAISELR * auxAA)) / 100)
						* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
				D_AANA = D_kiAPT * (D_builtAAchance / 100) * (1 - (D_saCHANCEFIELD / 100))* (1 + ((D_saRAISE + (D_saRAISELR * auxAA)) / 100));
			} else {
				D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE + (D_saRAISE * auxAA)) / 100)
						* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
				D_AANA = D_kiAPT * (D_builtAAchance / 100) * (1 - (D_saCHANCEFIELD / 100))* (1 + ((D_saRAISE + (D_saRAISE * auxAA)) / 100));
			}
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100));
			D_AA = (D_AA * 100) / 2;
			System.out.println("AA " + D_AA);
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_saMultiplierLR + D_saRAISE + D_saRAISELR + D_saRAISELR * builtaux
						+ D_saRAISELR * builtaux) / 100) * (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100)
						* (1 + ((D_saRAISE + D_saRAISELR * builtaux + D_saRAISELR * builtaux) / 100));

			} else {
				D_AASA = D_kiAPT
						* ((D_saMultiplier + D_saRAISE + D_saRAISE + D_saRAISE * builtaux + D_saRAISE * builtaux) / 100)
						* (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100)
						* (1 + ((D_saRAISE + D_saRAISE * builtaux + D_saRAISE * builtaux) / 100));
			}

			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		} else if (builtAA.isSelected() && D_numberAAFIELD == 2 && gAA.isSelected() == true && D_builtAAchance == 100) {
			System.out.println("Additional Attack");

			D_AA = Double.valueOf(AA.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());

			double builtaux = (D_saCHANCEFIELD / 100);

			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE) / 100) * (D_saCHANCEFIELD / 100)
					* (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + (D_saRAISE / 100)) * (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRAISE + D_saRAISE * builtaux) / 100)
					* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + ((D_saRAISE + D_saRAISE * builtaux) / 100))
					* (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100));
			D_AA = (D_AA * 100) / 2;
			System.out.println("AA " + D_AA);
			D_AASA = D_kiAPT
					* ((D_saMultiplier + D_saRAISE + D_saRAISE + D_saRAISE * builtaux + D_saRAISE * builtaux) / 100)
					* (D_AA / 100);
			D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + D_saRAISE * builtaux + D_saRAISE * builtaux) / 100));
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);

			/////////////////////////////////////////////////////////////////////////////////////
		} else if (builtAA.isSelected() && D_numberAAFIELD == 2 && gAA.isSelected() && D_builtAAchance != 100) {
			System.out.println("Additional Attack");
			D_AA = Double.valueOf(AA.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());
			double D_buildAAchanceaux = D_builtAAchance;
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE * 2) / 100) * (D_saCHANCEFIELD / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + ((D_saRAISE * 1) / 100));
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE * 2 + (D_saRAISE * (D_saCHANCEFIELD / 100))) / 100)
					* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100))
					* (1 + ((D_saRAISE * 1 + (D_saRAISE * (D_saCHANCEFIELD / 100))) / 100)) * ((D_builtAAchance) / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			if (D_builtAAchance == 100 && countercheckbox.isSelected() == false) {
				D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100));
				D_AA = (D_AA * 100) / 2;
			} else if (countercheckbox.isSelected() == true) {
				double D_AAaux1 = ((D_AA * 2) / 100);
				double D_AAaux2 = 1 - ((D_AA * 2) / 100);
				if (D_beforecounter <= 1) {
					D_AA = 1 - (D_AAaux2 * D_AAaux2 * (1 - (D_AAaux1 * (D_builtAAchance / 100)))
							* (Math.pow(D_AAaux2, D_beforecounter)));
				}

				else if (D_beforecounter > 1) {
					double D_counteraux = D_beforecounter - Math.floor(D_beforecounter);
					double D_counteraux2 = Math.pow(D_AAaux2, Math.floor(D_beforecounter));
					D_AA = (1 - D_AAaux2 * (D_counteraux2) * (D_counteraux2) * (1 - D_counteraux * D_AAaux1)
							* (1 - (D_builtAAchance / 100) * D_AAaux1));
				}
				System.out.println("D_AAaux1 " + D_AAaux1 + "D_AAaux2 " + D_AAaux2 + "AA " + D_AA + "D_builtAAchance "
						+ D_builtAAchance);
				D_AA = (D_AA * 100) / 2;
				System.out.println("AA " + D_AA);
			} else {
				D_AA = 1 - ((D_AA * 2) / 100);
				D_builtAAchance = 1 - ((D_builtAAchance / 100));
				System.out.println("AA " + D_AA + " AA CHANCE 2 " + D_builtAAchance);
				D_AA = 1 - (D_AA * D_AA * D_builtAAchance) - (D_AA * D_AA * D_AA * (1 - D_builtAAchance));
				D_AA = (D_AA * 100) / 2;

			}
			System.out.println("AA " + D_AA);
			double aux1 = ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100) * (D_buildAAchanceaux / 100) + 1
					+ (D_saRAISE / 100) + ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100)));
			D_guaranteedAAsaraise = ((D_saRAISE + D_saRAISE * (D_saCHANCEFIELD / 100)
					+ D_saRAISE * (D_saCHANCEFIELD / 100) * (D_buildAAchanceaux / 100) + 50 * (D_AA / 100)));
			D_guaranteedAAsaraise = (D_guaranteedAAsaraise / 100) + 1;
			System.out.println("TEST  " + D_guaranteedAAsaraise);
			System.out.println("TEST  " + aux1);
			D_AASA = D_kiAPT * (D_AA / 100)
					* ((D_saMultiplier / 100) + (D_saRAISE * 2 / 100) + ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100))
							+ ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100) * (D_buildAAchanceaux / 100)));
			System.out.println("test 2 "
					+ ((D_saMultiplier / 100) + (D_saRAISE * 2 / 100) + ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100))
							+ ((D_saRAISE / 100) * (D_saCHANCEFIELD / 100) * (D_buildAAchanceaux / 100))));
			D_AANA = D_kiAPT * (D_AA / 100) * aux1;
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);

			///////////////////////////////////////////////////////////////////
		} else if (builtAA.isSelected() && D_numberAAFIELD == 3) {
			System.out.println("Additional Attack");
			D_AA = Double.valueOf(AA.getText());
			D_saCHANCEFIELD = Double.valueOf(saCHANCEFIELD.getText());
			double D_saRaiseAUX = D_saRAISE * (D_saCHANCEFIELD / 100);
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRaiseAUX) / 100) * (D_saCHANCEFIELD / 100)
					* (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + (D_saRAISE / 100)) * (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRaiseAUX + D_saRaiseAUX) / 100)
					* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + ((D_saRAISE + D_saRaiseAUX) / 100))
					* (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AASA = D_kiAPT * ((D_saMultiplier + D_saRAISE + D_saRaiseAUX + D_saRaiseAUX + D_saRaiseAUX) / 100)
					* (D_saCHANCEFIELD / 100) * (D_builtAAchance / 100);
			D_AANA = D_kiAPT * (1 - (D_saCHANCEFIELD / 100)) * (1 + ((D_saRAISE + D_saRaiseAUX + D_saRaiseAUX) / 100))
					* (D_builtAAchance / 100);
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;

			System.out.println("Current APT " + D_APT);
			D_AA = 1 - (((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100) * ((100 - (D_AA * 2)) / 100))
					* ((100 - (D_AA * 2)) / 100);
			D_AA = (D_AA * 100) / 2;
			System.out.println("AA " + D_AA);
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2
						* ((D_saMultiplierLR + D_saRAISE + D_saRAISELR + D_saRaiseAUX + D_saRaiseAUX + D_saRaiseAUX)
								/ 100)
						* (D_AA / 100);
			} else {
				D_AASA = D_kiAPT
						* ((D_saMultiplier + D_saRAISE + D_saRAISELR + D_saRaiseAUX + D_saRaiseAUX + D_saRaiseAUX)
								/ 100)
						* (D_AA / 100);
			}
			D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + D_saRaiseAUX + D_saRaiseAUX + D_saRaiseAUX) / 100));
			System.out.println("AASA " + D_AASA);
			System.out.println("AANA " + D_AANA);
			D_APT = D_APT + D_AASA + D_AANA;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);

			//////////////////////////////////////////////////////////////////
		} else {
			System.out.println("Additional Attack");
			D_AA = Double.valueOf(AA.getText());
			if (countercheckbox.isSelected() == true && counterSAcheckbox.isSelected() == false) {
				double D_AAaux = (((100 - (D_AA * 2)) / 100));
				double D_counteraux = D_beforecounter - Math.floor(D_beforecounter);
				double D_counteraux2 = Math.pow(D_AAaux, Math.floor(D_beforecounter));
				D_AA = 1 - (D_AAaux * D_counteraux2 * (1 - (D_counteraux * (1 - D_AAaux))));
				System.out.println("D_AAaux-1 " + (1 - D_AAaux) + "D_counteraux " + D_counteraux);
				D_AA = (D_AA * 100) / 2;
				System.out.println("AA " + D_AA);
			} else if (countercheckbox.isSelected() == true && counterSAcheckbox.isSelected() == true) {
				double D_AAaux = (((100 - (D_AA * 2)) / 100));
				double D_counteraux3 = D_beforecounter * (D_enemyChance / 100) * (D_counterChance / 100);
				double D_counteraux = D_counteraux3 - Math.floor(D_counteraux3);
				double D_counteraux2 = Math.pow(D_AAaux, Math.floor(D_counteraux3));
				D_AA = 1 - (D_AAaux * D_counteraux2 * (1 - (D_counteraux * (1 - D_AAaux))));
				System.out.println("SA Counter chance:" + D_counteraux3);
				D_AA = (D_AA * 100) / 2;
				System.out.println("AA " + D_AA);
			}
			if (LRcheckbox.isSelected() == true) {
				D_AASA = D_kiAPT2 * ((D_delay + D_saMultiplierLR + D_saRAISE + D_saRAISELR) / 100) * (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + D_delay) / 100));
				D_APT = D_APT + D_AASA + D_AANA;
				D_APT = Math.floor(D_APT);
				System.out.println("Current APT " + D_APT);
			} else {
				D_AASA = D_kiAPT * ((D_delay + D_saMultiplier + D_saRAISE + D_saRAISE) / 100) * (D_AA / 100);
				D_AANA = D_kiAPT * (D_AA / 100) * (1 + ((D_saRAISE + D_delay) / 100));
				D_APT = D_APT + D_AASA + D_AANA;
				D_APT = Math.floor(D_APT);
				System.out.println("Current APT " + D_APT);
			}

		}
		////////////////////////// Counter PART
		///////////////////////////////////////////////////////////////////////////
		if (counterSAcheckbox.isSelected() == true) {
			D_beforecounter = D_beforecounter * (D_enemyChance / 100) * (D_counterChance / 100);
			D_aftercounter = D_aftercounter * (D_enemyChance / 100) * (D_counterChance / 100);

		}
		if (countercheckbox.isSelected()) {
			double counter1 = D_kiAPT * (D_countermultiplier / 100) * D_beforecounter;
			System.out.println("counter 1 " + counter1);
			if (builtAA.isSelected()) {
				double counter2 = D_kiAPT * (D_countermultiplier / 100) * D_aftercounter * D_guaranteedAAsaraise;
				System.out.println("counter 2 " + counter2);
				D_APT = D_APT + counter1 + counter2;
			} else {
				if (D_saRAISE == 0) {
					D_saRAISE = D_delay;
				}
				double countermultiaux = 1 + (D_saRAISE / 100) + ((D_saRAISE / 100) * (D_AA / 100));
				System.out.println("counter aux " + countermultiaux);
				double counter2 = D_kiAPT * (D_countermultiplier / 100) * D_aftercounter * countermultiaux;
				System.out.println("counter 2 " + counter2);
				D_APT = D_APT + counter1 + counter2;

				if (counterSAcheckbox.isSelected() == true) {
					// D_APT = Math.floor(D_APT);
				}

			}

		}

		///////////////////////////// CRIT PART
		///////////////////////////// //////////////////////////////////////////////
		if (critCHECKBOX.isSelected()) {
			D_passiveCRIT = Double.valueOf(passiveCRIT.getText());
			D_linkCRIT = Double.valueOf(linkCRIT.getText());

		} else {
			D_passiveCRIT = 0;
			D_linkCRIT = 0;

		}
		D_CRIT = Double.valueOf(CRIT.getText());
		D_CRIT = 1 - (((100 - (D_CRIT * 2)) / 100) * ((100 - D_passiveCRIT) / 100) * (((100 - D_linkCRIT)) / 100));
		D_CRIT = D_CRIT * 100;
		System.out.println("Current CRIT " + D_CRIT);
		D_CRIT = D_CRIT / 2;

		if (SE.isSelected()) {
			System.out.println("Crit");
			D_SE = D_APT * D_SE * ((100 - (D_CRIT * 2)) / 100);
			D_TABCRIT = D_APT * D_TABCRIT * ((D_CRIT * 2) / 100);
			D_SE = Math.floor(D_SE);
			D_TABCRIT = Math.floor(D_TABCRIT);
			D_APT = D_TABCRIT + D_SE;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);
		} else if (guardBreak.isSelected() && SE.isSelected() == false) {
			System.out.println("Crit");
			D_GB = D_APT * D_GB * ((100 - (D_CRIT * 2)) / 100);
			D_TABCRIT = D_APT * D_TABCRIT * ((D_CRIT * 2) / 100);
			D_GB = Math.floor(D_GB);
			D_TABCRIT = Math.floor(D_TABCRIT);
			D_APT = D_TABCRIT + D_GB;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);
		}

		else {
			System.out.println("Crit");
			D_TABNOCRIT = D_APT * D_TABNOCRIT * ((100 - (D_CRIT * 2)) / 100);
			D_TABCRIT = D_APT * D_TABCRIT * ((D_CRIT * 2) / 100);
			D_APT = D_TABCRIT + D_TABNOCRIT;
			D_APT = Math.floor(D_APT);
			System.out.println("Current APT " + D_APT);
		}

		System.out.println("--------------------------------------------------------");
		System.out.println("Final APT " + D_APT);

		String S_APT = String.valueOf((int) D_APT);

		aptTEXT.setText(S_APT);
		aptTEXT.setText(NumberFormat.getNumberInstance(Locale.US).format((int) D_APT));
		
		double LeaderSkill = Double.valueOf(leaderSkill.getText());
		double critUI = Double.valueOf(CRIT.getText());
		double addUI = Double.valueOf(AA.getText());
		UIStates.apt = (int) D_APT;
		UIStates.support = (float) D_support;
		UIStates.leader = (int) LeaderSkill;
		UIStates.links = (float) D_links;
		UIStates.crit = (int) critUI;
		UIStates.add = (int)  addUI;
		

	}

	@FXML
	void checkboxAction(ActionEvent event) {
		CheckBox source = (CheckBox) event.getSource();

		saCHANCEFIELD.setVisible(source.isSelected());
		saCHANCELABEL.setVisible(source.isSelected());
		numberAAFIELD.setVisible(source.isSelected());
		numberAALABEL.setVisible(source.isSelected());
		builtAAchanceLABEL.setVisible(source.isSelected());
		builtAAchanceFIELD.setVisible(source.isSelected());
		gAA.setVisible(source.isSelected());

	}

	@FXML
	void showCrit(ActionEvent event) {
		CheckBox box = (CheckBox) event.getSource();
		passivecritLABEL.setVisible(box.isSelected());
		linkcritLABEL.setVisible(box.isSelected());
		linkCRIT.setVisible(box.isSelected());
		passiveCRIT.setVisible(box.isSelected());

	}

	@FXML
	void showCOUNTER(ActionEvent event) {
		CheckBox checkbox = (CheckBox) event.getSource();
		beforecounterL.setVisible(checkbox.isSelected());
		aftercounterF.setVisible(checkbox.isSelected());
		aftercounterL.setVisible(checkbox.isSelected());
		beforecounterF.setVisible(checkbox.isSelected());
		multipliercounterL.setVisible(checkbox.isSelected());
		multipliercounterF.setVisible(checkbox.isSelected());
		counterSAcheckbox.setVisible(checkbox.isSelected());

	}

	@FXML
	void counterSA(ActionEvent event) {
		CheckBox counterbox = (CheckBox) event.getSource();
		counterChanceFIELD.setVisible(counterbox.isSelected());
		counterchanceLABEL.setVisible(counterbox.isSelected());
		enemychanceFIELD.setVisible(counterbox.isSelected());
		enemychanceLABEL.setVisible(counterbox.isSelected());

	}

	@FXML
	void showLR(ActionEvent event) {
		CheckBox lrbox = (CheckBox) event.getSource();
		saLRLABEL.setVisible(lrbox.isSelected());
		saLRFIELD.setVisible(lrbox.isSelected());
		kiLRLABEL.setVisible(lrbox.isSelected());
		kiLRFIELD.setVisible(lrbox.isSelected());
		saraiseLRLABEL.setVisible(lrbox.isSelected());
		saraiseLRFIELD.setVisible(lrbox.isSelected());
	}
	

    @FXML
    void showCardInfo(ActionEvent event) {
    System.out.println("DEBUGGING");
    UIStates.changeView("CharacterMenu.fxml");
     
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 UIStates.changeStyle(UIStates.theme+".css");

	}

}
