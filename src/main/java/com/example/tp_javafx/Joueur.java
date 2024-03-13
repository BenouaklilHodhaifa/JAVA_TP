package com.example.tp_javafx;
import java.io.Serializable;
import java.util.Random;

public class Joueur implements  Serializable {
private String Nom;
private long  MeilleurScore;
private int Position;
private long scoreActuelle;
private int ProchainePosition;
private String Reponse; // la reponse de la definition
private Partie PartieCourante;

// score du joueur actuellement dans le jeux

// Le constructeur de joueur


public Joueur(String Nom , long MeilleurScore , int Position, long scoreActuelle, int ProchainePosition){
    this.Nom = Nom;
    this.MeilleurScore = MeilleurScore;
    this.Position = Position;
    this.scoreActuelle = scoreActuelle;
    this.ProchainePosition = ProchainePosition;
}



//------------------------------------ La liste des Méthodes ---------------------------------------------------



 // changer la position de joueur dans la partie du  jeux  vers la position de la paramétre en entrés

 public void ChangerProchainPosition(int diff){ // le nombre de cases a sauter
      ProchainePosition += diff;

     if (ProchainePosition >100){
         ProchainePosition = 100 - diff;
     }
     if(ProchainePosition <1){ProchainePosition = 1;}


 }

 // decrementer le scoreActuelle par "diff"

 public void decrementerScore(long diff){
    if ((scoreActuelle - diff) >= 0)
        scoreActuelle = scoreActuelle - diff;
    else scoreActuelle = 0;
 }

    // incrementer le scoreActuelle par "diff"

    public void incrementerScore(long diff){
        scoreActuelle += diff;
    }

    // Modifier La prochaine position de ce joueur

    public void ChangerPosition(){this.Position = ProchainePosition;}

 // Vérifier esque la case cliquer est la case volue
 public boolean CliquerCase(){
    boolean Cliquer=true;

    return Cliquer;
 }

 // fait le traitement de la case par l'appelation de la méthode traiter de chaque case selon le type de la case

 public void VérifierCase(CaseTraitable LaCasePrésent){}

    public void afficherj(){System.out.println(Nom);}


// getterrs setters



    public String getNom() {
        return Nom;
    }

    public int getPosition() {
        return Position;
    }
    public void setPosition(int position){this.Position = position;}
    public long getMeilleurScore() {
        return MeilleurScore;
    }
    public void setMeilleurScore(long  MeilleurScore){this.MeilleurScore = MeilleurScore;}

    public long getScoreActuelle() {
        return scoreActuelle;
    }
    public void setScoreActuelle(long scoreActuelle){this.scoreActuelle = scoreActuelle;}

    //  Envoyer la reponse de ce joueur

    public String GetReponse(){return Reponse;}

    //  Modification de la réponse de ce joueur

    public void setReponse(String reponse) {Reponse = reponse;}

    public int getProchainePosition() {
        return ProchainePosition;
    }

    public void setPartieCourante(Partie partieCourante) {PartieCourante = partieCourante;}

    public Partie getPartieCourante() {return PartieCourante;}
}

