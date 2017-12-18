/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wtc.swingy.view.gui;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Monster;

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

        dlgMenu = new javax.swing.JDialog();
        btnNext = new javax.swing.JButton();
        btnCLI = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnChangeHero = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnFight = new javax.swing.JButton();
        btnFlee = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();
        cmbDirection = new javax.swing.JComboBox<>();
        pnlLables = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlComponents = new javax.swing.JPanel();
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
        pnlEnemyStats = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txfEnName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txfEnClass = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txfEnLevel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txfEnExperience = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txfEnAttack = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txfEnDefence = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txfEnHitPoints = new javax.swing.JTextField();

        dlgMenu.setTitle("Menu");
        dlgMenu.setMaximumSize(new java.awt.Dimension(193, 215));
        dlgMenu.setMinimumSize(new java.awt.Dimension(193, 215));

        btnNext.setText("NEXT MAP");

        btnCLI.setText("CLI");

        btnQuit.setText("QUIT");

        btnChangeHero.setText("CHANGE HERO");

        javax.swing.GroupLayout dlgMenuLayout = new javax.swing.GroupLayout(dlgMenu.getContentPane());
        dlgMenu.getContentPane().setLayout(dlgMenuLayout);
        dlgMenuLayout.setHorizontalGroup(
            dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCLI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangeHero, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgMenuLayout.setVerticalGroup(
            dlgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNext)
                .addGap(18, 18, 18)
                .addComponent(btnCLI)
                .addGap(18, 18, 18)
                .addComponent(btnChangeHero)
                .addGap(18, 18, 18)
                .addComponent(btnQuit)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFight.setText("Fight");

        btnFlee.setText("Flee");

        btnMove.setText("Move");
        btnMove.setToolTipText("");

        cmbDirection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "North", "East", "South", "West" }));

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
                .addContainerGap(712, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLables.setLayout(new java.awt.GridLayout(1, 0));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Hero");
        pnlLables.add(jLabel24);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("GameLog");
        pnlLables.add(jLabel22);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Enemy");
        pnlLables.add(jLabel23);

        pnlComponents.setLayout(new java.awt.GridLayout(1, 0));

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

        pnlComponents.add(pnlHeroStats);

        txaGameLog.setEditable(false);
        txaGameLog.setColumns(20);
        txaGameLog.setRows(5);
        jScrollPane1.setViewportView(txaGameLog);

        javax.swing.GroupLayout pnlGameLogLayout = new javax.swing.GroupLayout(pnlGameLog);
        pnlGameLog.setLayout(pnlGameLogLayout);
        pnlGameLogLayout.setHorizontalGroup(
            pnlGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGameLogLayout.setVerticalGroup(
            pnlGameLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pnlComponents.add(pnlGameLog);

        pnlEnemyStats.setLayout(new java.awt.GridLayout(10, 2));

        jLabel12.setText("Name");
        pnlEnemyStats.add(jLabel12);

        txfEnName.setEditable(false);
        pnlEnemyStats.add(txfEnName);

        jLabel13.setText("Class");
        pnlEnemyStats.add(jLabel13);

        txfEnClass.setEditable(false);
        pnlEnemyStats.add(txfEnClass);

        jLabel14.setText("Level");
        pnlEnemyStats.add(jLabel14);

        txfEnLevel.setEditable(false);
        pnlEnemyStats.add(txfEnLevel);

        jLabel15.setText("Experience");
        pnlEnemyStats.add(jLabel15);

        txfEnExperience.setEditable(false);
        pnlEnemyStats.add(txfEnExperience);

        jLabel16.setText("Attack");
        pnlEnemyStats.add(jLabel16);

        txfEnAttack.setEditable(false);
        pnlEnemyStats.add(txfEnAttack);

        jLabel17.setText("Defence");
        pnlEnemyStats.add(jLabel17);

        txfEnDefence.setEditable(false);
        pnlEnemyStats.add(txfEnDefence);

        jLabel18.setText("Hit Points");
        pnlEnemyStats.add(jLabel18);

        txfEnHitPoints.setEditable(false);
        pnlEnemyStats.add(txfEnHitPoints);

        pnlComponents.add(pnlEnemyStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(pnlComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
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

	public void setNextListner(ActionListener listner){ btnNext.addActionListener(listner);}

	public void setCLIListner(ActionListener listner){btnCLI.addActionListener(listner);}

	public void setChangeHeroListner(ActionListener listener){btnChangeHero.addActionListener(listener);}

	public void setQuitListner(ActionListener listner){btnQuit.addActionListener(listner);}

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

	public void displayEnemyStats(Monster enemy) {
		if (enemy != null) {
			txfEnName.setText(enemy.getName());
			txfEnClass.setText(enemy.getType().toString());
			txfEnLevel.setText(enemy.getLevel() + "");
			txfEnExperience.setText(enemy.getExperience() + "");
			txfEnAttack.setText(enemy.getAttack() + "");
			txfEnDefence.setText(enemy.getDefense() + "");
			txfEnHitPoints.setText(enemy.getHitPoints() + "");
		}
		else{
			txfEnName.setText("");
			txfEnClass.setText("");
			txfEnLevel.setText("");
			txfEnExperience.setText("");
			txfEnAttack.setText("");
			txfEnDefence.setText("");
			txfEnHitPoints.setText("");
		}
	}

	public void appendGameLog(String text){
		txaGameLog.append(text);
	}

	public void setGameLog(String text){
		txaGameLog.setText(text);
	}

	public void displayMenu(boolean state){
		//this.setFocusable(false);
		dlgMenu.setVisible(state);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLI;
    private javax.swing.JButton btnChangeHero;
    private javax.swing.JButton btnFight;
    private javax.swing.JButton btnFlee;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnQuit;
    private javax.swing.JComboBox<String> cmbDirection;
    private javax.swing.JDialog dlgMenu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlComponents;
    private javax.swing.JPanel pnlEnemyStats;
    private javax.swing.JPanel pnlGameLog;
    private javax.swing.JPanel pnlHeroStats;
    private javax.swing.JPanel pnlLables;
    private javax.swing.JTextArea txaGameLog;
    private javax.swing.JTextField txfArmor;
    private javax.swing.JTextField txfAttack;
    private javax.swing.JTextField txfClass;
    private javax.swing.JTextField txfDefence;
    private javax.swing.JTextField txfEnAttack;
    private javax.swing.JTextField txfEnClass;
    private javax.swing.JTextField txfEnDefence;
    private javax.swing.JTextField txfEnExperience;
    private javax.swing.JTextField txfEnHitPoints;
    private javax.swing.JTextField txfEnLevel;
    private javax.swing.JTextField txfEnName;
    private javax.swing.JTextField txfExperience;
    private javax.swing.JTextField txfHelm;
    private javax.swing.JTextField txfHitPoints;
    private javax.swing.JTextField txfLevel;
    private javax.swing.JTextField txfName;
    private javax.swing.JTextField txfWeapon;
    // End of variables declaration//GEN-END:variables
}
