/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wtc.swingy.view;

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
		this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		lstHeroes = new javax.swing.JList<>();
		btnSelect = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jScrollPane1.setViewportView(lstHeroes);

		btnSelect.setText("Select");
		btnSelect.setEnabled(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addGap(164, 164, 164)
								.addComponent(btnSelect)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnSelect)
								.addContainerGap())
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void setModel(List<Hero> heroes){
		DefaultListModel<Hero> model = new DefaultListModel<>();
		for (Hero hero : heroes) {
			model.addElement(hero);
		}
		lstHeroes.setModel(model);
	}

	public void addListListner( ListSelectionListener listner){
		lstHeroes.addListSelectionListener(listner);
	}

	public void addButtonListner(ActionListener listener){
		btnSelect.addActionListener(listener);
	}

	public Hero getSelected(){
		return lstHeroes.getSelectedValue();
	}

	public void enableSelect(){
		if (!btnSelect.isEnabled()) {
			btnSelect.setEnabled(true);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnSelect;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList<Hero> lstHeroes;
	// End of variables declaration//GEN-END:variables
}
