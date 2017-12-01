/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wtc.swingy.view.gui;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.charicters.Hero;

import java.awt.event.ActionListener;

/**
 * @author rojones
 */
public class GameGUI extends javax.swing.JFrame {

	/**
	 * Creates new form GameGUI
	 */
	public GameGUI() {
		initComponents();
		//this.setVisible(true);
	}


	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		btnFight = new javax.swing.JButton();
		btnFlee = new javax.swing.JButton();
		btnMove = new javax.swing.JButton();
		cmbDirection = new javax.swing.JComboBox<>();
		pnlHeroStats = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txfName = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txfClass = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txfLevel = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		txfExperience = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txfAttack = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txfDefence = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txfHitPoints = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txfWeapon = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		txfArmor = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		txfHelm = new javax.swing.JTextField();
		pnlGameLog = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txaGameLog = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		btnFight.setText("Fight");

		btnFlee.setText("Flee");

		btnMove.setText("Move");
		btnMove.setToolTipText("");

		cmbDirection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"North", "East", "South", "West"}));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnFight)
								.addGap(18, 18, 18)
								.addComponent(btnFlee)
								.addGap(18, 18, 18)
								.addComponent(btnMove)
								.addGap(18, 18, 18)
								.addComponent(cmbDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnFight)
										.addComponent(btnFlee)
										.addComponent(btnMove)
										.addComponent(cmbDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(14, Short.MAX_VALUE))
		);

		pnlHeroStats.setLayout(new java.awt.GridLayout(10, 2));

		jLabel2.setText("Name");
		pnlHeroStats.add(jLabel2);

		txfName.setEditable(false);
		pnlHeroStats.add(txfName);

		jLabel3.setText("Class");
		pnlHeroStats.add(jLabel3);

		txfClass.setEditable(false);
		pnlHeroStats.add(txfClass);

		jLabel7.setText("Level");
		pnlHeroStats.add(jLabel7);

		txfLevel.setEditable(false);
		pnlHeroStats.add(txfLevel);

		jLabel8.setText("Experience");
		pnlHeroStats.add(jLabel8);

		txfExperience.setEditable(false);
		pnlHeroStats.add(txfExperience);

		jLabel4.setText("Attack");
		pnlHeroStats.add(jLabel4);

		txfAttack.setEditable(false);
		pnlHeroStats.add(txfAttack);

		jLabel5.setText("Defence");
		pnlHeroStats.add(jLabel5);

		txfDefence.setEditable(false);
		pnlHeroStats.add(txfDefence);

		jLabel6.setText("Hit Points");
		pnlHeroStats.add(jLabel6);

		txfHitPoints.setEditable(false);
		pnlHeroStats.add(txfHitPoints);

		jLabel9.setText("Weapon");
		pnlHeroStats.add(jLabel9);

		txfWeapon.setEditable(false);
		pnlHeroStats.add(txfWeapon);

		jLabel10.setText("Armor");
		jLabel10.setToolTipText("");
		pnlHeroStats.add(jLabel10);

		txfArmor.setEditable(false);
		txfArmor.setToolTipText("");
		pnlHeroStats.add(txfArmor);

		jLabel11.setText("Helm");
		pnlHeroStats.add(jLabel11);

		txfHelm.setEditable(false);
		pnlHeroStats.add(txfHelm);

		txaGameLog.setEditable(false);
		txaGameLog.setColumns(20);
		txaGameLog.setRows(5);
		jScrollPane1.setViewportView(txaGameLog);

		jLabel1.setText("GameLog");

		javax.swing.GroupLayout pnlGameLogLayout = new javax.swing.GroupLayout(pnlGameLog);
		pnlGameLog.setLayout(pnlGameLogLayout);
		pnlGameLogLayout.setHorizontalGroup(
				pnlGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlGameLogLayout.createSequentialGroup()
								.addGap(142, 142, 142)
								.addComponent(jLabel1)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(pnlGameLogLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
								.addContainerGap())
		);
		pnlGameLogLayout.setVerticalGroup(
				pnlGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlGameLogLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(112, 112, 112))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(pnlHeroStats, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(pnlGameLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pnlHeroStats, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
										.addComponent(pnlGameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void setFightInteracta(boolean state) {
		btnFight.setEnabled(state);
		btnFlee.setEnabled(state);
	}

	public void setMoveInteract(boolean state) {
		btnMove.setEnabled(state);
	}

	public String getMoveDirection() {
		return (String)(cmbDirection.getSelectedItem());
	}

	public void setFightListner(ActionListener listner) {
		btnFight.addActionListener(listner);
	}

	public void setFleeListner(ActionListener listner) {
		btnFlee.addActionListener(listner);
	}

	public void setMoveListner(ActionListener listner) {
		btnMove.addActionListener(listner);
	}

	public void displayHeroStats(Hero hero) {
		if (hero != null) {
			txfName.setText(hero.getName());
			txfClass.setText(hero.getType().toString());
			txfLevel.setText(hero.getLevel() + "");
			txfExperience.setText(hero.getExperience() + "");
			txfAttack.setText(hero.getAttack() + "");
			txfDefence.setText(hero.getDefense() + "");
			txfHitPoints.setText(hero.getHitPoints() + "");
			if (hero.getHelmet() != null) {
				txfHelm.setText(hero.getHelmet().getValue() + "");
			} else {
				txfHelm.setText("");
			}
			if (hero.getArmor() != null) {
				txfArmor.setText(hero.getArmor().getValue() + "");
			} else {
				txfArmor.setText("");
			}
			if (hero.getWeapon() != null) {
				txfWeapon.setText(hero.getWeapon().getValue() + "");
			} else {
				txfWeapon.setText("");
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnFight;
	private javax.swing.JButton btnFlee;
	private javax.swing.JButton btnMove;
	private javax.swing.JComboBox<String> cmbDirection;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel pnlGameLog;
	private javax.swing.JPanel pnlHeroStats;
	private javax.swing.JTextArea txaGameLog;
	private javax.swing.JTextField txfArmor;
	private javax.swing.JTextField txfAttack;
	private javax.swing.JTextField txfClass;
	private javax.swing.JTextField txfDefence;
	private javax.swing.JTextField txfExperience;
	private javax.swing.JTextField txfHelm;
	private javax.swing.JTextField txfHitPoints;
	private javax.swing.JTextField txfLevel;
	private javax.swing.JTextField txfName;
	private javax.swing.JTextField txfWeapon;
	// End of variables declaration//GEN-END:variables
}
