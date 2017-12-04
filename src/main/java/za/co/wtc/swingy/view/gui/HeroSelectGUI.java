/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wtc.swingy.view.gui;

import za.co.wtc.swingy.modle.charicters.Hero;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author rojones
 */
public class HeroSelectGUI extends javax.swing.JFrame {


	public HeroSelectGUI() {
		initComponents();
		//this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		lstHeroes = new javax.swing.JList<>();
		btnSelect = new javax.swing.JButton();
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

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jScrollPane1.setViewportView(lstHeroes);

		btnSelect.setText("Select");
		btnSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSelectActionPerformed(evt);
			}
		});

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

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addComponent(pnlHeroStats, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(pnlHeroStats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnSelect)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnSelectActionPerformed

	public void setModel(List<String> heroes) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String hero : heroes) {
			model.addElement(hero);
		}
		lstHeroes.setModel(model);
	}

	public void setSelectNone(){
		lstHeroes.setSelectedValue(null, true);
	}

	public void addListListner(ListSelectionListener listner) {
		lstHeroes.addListSelectionListener(listner);
	}

	public void addButtonListner(ActionListener listener) {
		btnSelect.addActionListener(listener);
	}

	public int getSelected() {
		return lstHeroes.getSelectedIndex();
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

	public void enableSelect(boolean state) {
			btnSelect.setEnabled(state);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnSelect;
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
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList<String> lstHeroes;
	private javax.swing.JPanel pnlHeroStats;
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
