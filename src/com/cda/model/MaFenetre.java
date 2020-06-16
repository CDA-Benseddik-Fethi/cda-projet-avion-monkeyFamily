package com.cda.model;

import javax.swing.*;

public class MaFenetre extends JFrame {
    public final static int FENETRE_WIDTH = 600;
    public final static int FENETRE_HEIGHT = 800;
    public static BackgroundWindow vBackgroundWindow;

    public MaFenetre() {
        setSize(FENETRE_WIDTH, FENETRE_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test");
        setResizable(false);
        vBackgroundWindow = new BackgroundWindow(this);
        //Vaisseau vVaisseau = new Vaisseau();
        //this.getContentPane().add(vVaisseau);
        this.getContentPane().add(vBackgroundWindow);
        //this.addKeyListener(new EcouteurClavier(vVaisseau));
        setVisible(true);
    }
}