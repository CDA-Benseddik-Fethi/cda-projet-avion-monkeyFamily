package com.cda.model;

import com.cda.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelFin extends JPanel {
	ImageIcon icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
	Image imgBoutonQuit = icoBoutonQuit.getImage();
	ImageIcon icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER));
	Image imgBoutonRejouer = icoBoutonRejouer.getImage();
	ImageIcon icoBoutonScore = new ImageIcon(getClass().getResource(Constantes.BOUTON_SCORES));
	Image imgBoutonScore = icoBoutonScore.getImage();
	private final ImageIcon icoBandeFond;
	private final Image imgBandeFond;

	public PanelFin(final MaFenetre cdaFenetre) {
		this.setLayout(null);
		JPanel boutonQuitter = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgBoutonQuit, 0, 0, 200, 50, null);
			}
		};
		JPanel boutonRejouer = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgBoutonRejouer, 0, 0, 200, 50, null);
			}
		};
		JPanel boutonScores = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgBoutonScore, 0, 0, 200, 50, null);
			}
		};
		boutonQuitter.setBounds(200, 510, 200, 50);
		boutonRejouer.setBounds(200, 390, 200, 50);
		boutonScores.setBounds(200, 450, 200, 50);
		boutonQuitter.setOpaque(false);
		boutonRejouer.setOpaque(false);
		boutonScores.setOpaque(false);
		this.add(boutonQuitter);
		this.add(boutonRejouer);
		this.add(boutonScores);
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND_FIN));
		this.imgBandeFond = this.icoBandeFond.getImage();
		boutonQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER_HOVER));
				imgBoutonQuit = icoBoutonQuit.getImage();
				boutonQuitter.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
				imgBoutonQuit = icoBoutonQuit.getImage();
				boutonQuitter.repaint();

			}
		});

		boutonRejouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Program.vMaFenetre.rejouer();
				Chrono.pause = false;
				MaFenetre.monSonIntro.stopMusique();
				MaFenetre.monSon.startMusique();
				MaFenetre.vBackgroundWindow.vaisseau.setxPos(Constantes.POSITIONX_DEPART_AVION);
				MaFenetre.vBackgroundWindow.vaisseau.setyPos(Constantes.POSITIONY_DEPART_AVION);
				GestionCollision.setCompteurGlobal(0);
				GestionCollision.setVie(3);
				GestionCollision.scoreReinit();
				Bouclier.setNbreBouclier(4);
				MaFenetre.vBackgroundWindow.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER_HOVER));
				imgBoutonRejouer = icoBoutonRejouer.getImage();
				boutonRejouer.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER));
				imgBoutonRejouer = icoBoutonRejouer.getImage();
				boutonRejouer.repaint();

			}
		});
		boutonScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Program.vMaFenetre.afficheScore();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBoutonScore = new ImageIcon(getClass().getResource(Constantes.BOUTON_SCORES_HOVER));
				imgBoutonScore = icoBoutonScore.getImage();
				boutonScores.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBoutonScore = new ImageIcon(getClass().getResource(Constantes.BOUTON_SCORES));
				imgBoutonScore = icoBoutonScore.getImage();
				boutonScores.repaint();

			}
		});
		setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
	}
}
