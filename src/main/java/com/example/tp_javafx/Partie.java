package com.example.tp_javafx;


import java.io.Serializable;

public class Partie implements Serializable {

   private Joueur JoueurCourant;
   //private PlateauView plateauView;
   //private PrimaryPageView primaryPageView;
   // private LoginView loginView;
   //private SignUpView signUpView;
   private PlateauModel  PlateauModel;
   private Dés dé;
  // private DefintionView defintionView;
  // private ImageClassView imageClassView;

   //private boolean Continuer;

    // Getters and Setters


    public Joueur getJoueurCourant() {
        return JoueurCourant;
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        JoueurCourant = joueurCourant;
    }
/*
    public PlateauView getPlateauView() {return plateauView;}

    public void setPlateauView(PlateauView plateauView) {
        this.plateauView = plateauView;
    }

    public PrimaryPageView getPrimaryPageView() {
        return primaryPageView;
    }

    public void setPrimaryPageView(PrimaryPageView primaryPageView) {
        this.primaryPageView = primaryPageView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }
*/
    public com.example.tp_javafx.PlateauModel getPlateauModel() {
        return PlateauModel;
    }

    public void setPlateauModel(com.example.tp_javafx.PlateauModel plateauModel) {
        PlateauModel = plateauModel;
    }

    public Dés getDé() {
        return dé;
    }

    public void setDé(Dés dé) {
        this.dé = dé;
    }
/*
    public DefintionView getDefintionView() {
        return defintionView;
    }

    public void setDefintionView(DefintionView defintionView) {
        this.defintionView = defintionView;
    }

    public ImageClassView getImageClassView() {
        return imageClassView;
    }

    public void setImageClassView(ImageClassView imageClassView) {
        this.imageClassView = imageClassView;
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }

    public void setSignUpView(SignUpView signUpView) {
        this.signUpView = signUpView;
    }
*/

}
