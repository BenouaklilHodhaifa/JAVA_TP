package com.example.tp_javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;


public class jeuxController {

    private Stage stage;
    private Scene scene = new Scene(new  Group(), 1157, 747);
    private PrimaryPageView primaryPageView ;
    private LoginView loginView;
    private SignUpView signUpView;
    private PlateauView plateauView ;
    private PlateauModel plateauModel;
    private Joueur joueur;
    private Dés dé;
    private DefintionView defintionView;
    private ImageClassView imageClassView;
    private Partie  partie;
    private Jeux EtatDuJeux;
    private Serialiser SerialisationDesDonnes;
    private File f;
    private ArrayList<String> TabImages = null;
    private ArrayList<String> TabNoms = null;
    private ArrayList<Def> TabDef = null;

    //private boolean rollDice = true;




    public jeuxController(Stage stage) throws  InvalidClassException {

        ObjectOutputStream out = null;
        ObjectInputStream in = null;


        this.f = null;

        this.SerialisationDesDonnes = new Serialiser(in, out);


        try {

            File file1 = new File("FichierImage.dat");

            if (file1.createNewFile() || file1.length() == 0) System.out.println("Le fichier est creer");

            else
                if (file1.length() != 0) { TabImages = SerialisationDesDonnes.DeserialiserTableauImage(file1);
                     System.out.println(TabImages.get(0));
                }


        } catch(NullPointerException e) {
            e.printStackTrace();}
        catch (Exception e) {
            System.err.println(e);
        }

        try {

            File file2 = new File("FichierNoms.dat");

            if (file2.createNewFile() || file2.length() == 0) System.out.println("Le fichier est creer");

            else
            if (file2.length() != 0) { TabNoms = SerialisationDesDonnes.DeserialiserTableauImage(file2);
                System.out.println(TabNoms.get(0));
            }


        } catch(NullPointerException e) {
            e.printStackTrace();}
        catch (Exception e) {
            System.err.println(e);
        }

        try {

            File file4 = new File("Definition.dat");

            if (file4.createNewFile() || file4.length() == 0) System.out.println("Le fichier est creer");

            else
            if (file4.length() != 0) { TabDef = SerialisationDesDonnes.DeserialiserTableauDef(file4);
                System.out.println(TabDef.get(0).getRep());
            }


        } catch(NullPointerException e) {
            e.printStackTrace();}
        catch (Exception e) {
            System.err.println(e);
        }




        try {

            this.f = new File("example.dat");

            if (f.createNewFile() || f.length() == 0){
                ArrayList<Joueur> ListeDesJoueur = new ArrayList<>();
                this.EtatDuJeux = new Jeux(ListeDesJoueur,0);
            }

           // else{
             //  if (f.length() != 0)  this.EtatDuJeux = SerialisationDesDonnes.Deserialiser(f);
           // }

        } catch(NullPointerException e) {
            e.printStackTrace();}
        catch (Exception e) {
            System.err.println(e);
        }

        // creation du nouveau partie
        partie = new Partie();
        this.stage = stage;
        this.stage.setScene(scene);
       // joueur = new  Joueur("Abderrezague", 0,1, 0, 1); // test
       // partie.setJoueurCourant(joueur);

        dé = new Dés();
        partie.setDé(dé);

        dé.setRollDice(true);

        primaryPageView = new PrimaryPageView();
       // partie.setPrimaryPageView(primaryPageView);

        try {
            primaryPageView.load();
            primaryPageView.activate(stage, new Login(), new SignUp());
            //primaryPageView.getJouerButton().setOnAction(new Jouer());


        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            //System.out.println("IOexception in jeuxController cunstructor");
        }
    }


    private class Login implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            loginView = new LoginView();
            //partie.setLoginView(loginView);

            try {
                loginView.load();
                loginView.activate(stage, new onStartLogin());
            }
            catch (IOException exception){
                System.out.println("io exception in event handler 'Login'");
            }

        }
    }

    private class SignUp implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            signUpView = new SignUpView();
           // partie.setSignUpView(signUpView);

            try {
                signUpView.load();
                signUpView.activate(stage, new onStartSignUp());
            }
            catch (IOException exception){
                System.out.println("io exception in event handler 'Login'");
            }

        }
    }

    private class onStartLogin implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            String Nom = loginView.getUser_Name().getText();
           if (EtatDuJeux != null) {Joueur joueur = EtatDuJeux.ChercherJoueur(Nom);}
            if (joueur != null) {
                partie = joueur.getPartieCourante();
                partie.setJoueurCourant(joueur);
               // plateauView = partie.getPlateauView();


                try {
                    plateauView.load();
                    plateauView.activate(stage, new OnClickLancerDes(), new OnClickArreter());
                    plateauModel = partie.getPlateauModel();
                    plateauModel.genererCases(new OnClickCase());
                    plateauModel.remplire(plateauView.getGrid());
                    plateauView.setNameLabel(joueur.getNom());
                    plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));
                    plateauView.setMscoreLabel(Long.toString(EtatDuJeux.getMeilleurScore()));

                } catch (IOException exception) {
                    System.out.println("io exception in event handler 'onStartLogin'");
                }

            }
            else{
                new Error("Ce joueur nexiste pas !!");
            }
        }
    }

    private class onStartSignUp implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            String Nom = signUpView.getUser_Name().getText();
            joueur = new Joueur(Nom , 0,1,0, 1);
           if (Nom != null) {
               partie.setJoueurCourant(joueur);
               plateauView = new PlateauView();
               //partie.setPlateauView(plateauView);


               try {
                   plateauView.load();
                   plateauView.activate(stage, new OnClickLancerDes(), new OnClickArreter());
                   plateauModel = new PlateauModel();
                   partie.setPlateauModel(plateauModel);
                   plateauModel.genererCases(new OnClickCase());
                   plateauModel.remplire(plateauView.getGrid());
                   plateauView.setNameLabel(joueur.getNom());
                   plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));
                   plateauView.setMscoreLabel(Long.toString(EtatDuJeux.getMeilleurScore()));
                   joueur.setPartieCourante(partie);
                   EtatDuJeux.AjouterJoueur(joueur);
                   EtatDuJeux.afficher();
               } catch (IOException exception) {
                   System.out.println("io exception in event handler 'onStartSignUp'");
               }
           }
        }
    }


    private class OnClickCase implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent){

            Case caseClicker ;


            Boolean trouve = false;
            int cpt =0;
            while (! trouve && cpt < 100){
                if( plateauModel.getTableauCases()[cpt].button == actionEvent.getSource() ){
                    trouve = true;

                    caseClicker = plateauModel.getTableauCases()[cpt];

                    // vérifier que c'est la case volu sinon message d'erreur
                    System.out.println("Case clické position:"+caseClicker.position);
                    if(joueur.getProchainePosition() == caseClicker.position){0

                        joueur.ChangerPosition();

                        if(caseClicker.getClass() != Definition.class && caseClicker.getClass() != Image.class){ // il faut d'abord récuperer la réponse
                            caseClicker.traiter(joueur, dé);
                        }



                        // remove the border
                        Button b;
                        b = plateauModel.getTableauCases()[joueur.getPosition()-1].button;
                        b.setStyle(b.getStyle()+ "-fx-boder-width: 0px; -fx-border-color: transparent;");

                        if(caseClicker.getClass() == Saut.class || caseClicker.getClass() == Bonus.class || caseClicker.getClass() == Malus.class){
                            b = plateauModel.getTableauCases()[joueur.getProchainePosition()-1].button;

                            b.setStyle(b.getStyle()+"-fx-border-width: 5px; -fx-border-color: black;");

                        }

                        if(caseClicker.getClass() == Definition.class){

                            defintionView = new DefintionView();
                           // partie.setDefintionView(defintionView);

                            try {
                                defintionView.load();
                            }
                            catch (IOException e){
                                System.out.println("error dans OnclickerCase definitionView.load()");
                                System.out.println(e.getMessage());
                                System.out.println(e.getStackTrace());
                            }
                            defintionView.activate(stage, new onClickBack());
                            defintionView.setPhraseToDefine(((Definition) caseClicker).GetQuestion(TabDef));
                            defintionView.setHbox(((Definition) caseClicker).getReponse().length());
                            defintionView.getSubmit().setOnAction(new OnClickSubmitDefinition(defintionView.getWord_box(), ((Definition) caseClicker).getReponse().length(), caseClicker));

                        }
                        else if(caseClicker.getClass() == Image.class){

                            imageClassView = new ImageClassView();
                          //  partie.setImageClassView(imageClassView);

                            try {
                                imageClassView.load();
                            }
                            catch (IOException e){
                                System.out.println("error dans OnclickerCase imageClassView.load()");
                                System.out.println(e.getMessage());
                                System.out.println(e.getStackTrace());
                            }

                            ((Image)caseClicker).getImage(TabImages, TabNoms);

                            imageClassView.activate(stage, new OnclickImage(((Image)caseClicker)));


                            imageClassView.setMot(((Image)caseClicker).getReponseJuste());
                            String[] tabImage = ((Image)caseClicker).getTabImages();


                            try {
                                imageClassView.setImage1(tabImage[0]);
                                imageClassView.setImage2(tabImage[1]);
                                imageClassView.setImage3(tabImage[2]);
                                imageClassView.setImage4(tabImage[3]);

                            }catch (FileNotFoundException e){
                                e.printStackTrace();
                            }

                        }

                        int row = plateauModel.getTableauCases()[joueur.getPosition()-1].gridRow;
                        int column = plateauModel.getTableauCases()[joueur.getPosition()-1].gridColumn;
                        plateauView.addCircleInGridPane(column, row);

                    }else{
                      System.out.println("vous avez cliquer sur une autre case ve devez cliquer sur la case N°"+ joueur.getProchainePosition());
                    }

                    plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));
                    plateauView.setProchainePositionLabel(Long.toString(joueur.getProchainePosition()));
                }
                cpt++;
            }


        }
    }

    private class OnClickLancerDes implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if (dé.getRollDice() == true){
                int num1 = dé.LancerDé();
                int num2 = dé.LancerDé();
                try {
                    plateauView.setImageDes(num1, num2);
                }
                catch (FileNotFoundException e){
                    System.out.println("Didn't find the dice images error in 'OnClickLancerDes'");
                }
                joueur.ChangerProchainPosition(num1+num2);
                dé.setRollDice(false);  // he can't roll dice now
                plateauView.setProchainePositionLabel(Long.toString(joueur.getProchainePosition()));
                // colorer le botton de la prochaine position
                Button b;
                b = plateauModel.getTableauCases()[joueur.getProchainePosition()-1].button;
                
                b.setStyle(b.getStyle()+"-fx-border-width: 5px; -fx-border-color: black;");
            }



        }
    }

    private class onClickBack implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                plateauView.activate(stage, new OnClickLancerDes(), new OnClickArreter());
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println("L'image du circle n'est pas trouvé ");
            }

            plateauView.setNameLabel(joueur.getNom());
            plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));

            Button b = plateauModel.getTableauCases()[joueur.getProchainePosition()-1].button;

            b.setStyle(b.getStyle()+"-fx-border-width: 5px; -fx-border-color: black;");

        }
    }

    private class OnclickImage implements EventHandler<MouseEvent>{

        private Image caseClicker;

        public OnclickImage(Image caseClicker){
            this.caseClicker = caseClicker;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            try {
                plateauView.activate(stage, new OnClickLancerDes(), new OnClickArreter());
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println("L'image du circle n'est pas trouvé ");
            }
            plateauView.setNameLabel(joueur.getNom());
            plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));

            boolean trouv = false;
            int i=0;
            ImageView img=null;
            System.out.println(mouseEvent.getSource());
            while (! trouv && i<4 ){
                if(((ImageView)(mouseEvent.getSource())).getId() == imageClassView.getImage(i).getId()){
                    trouv = true;
                    img = imageClassView.getImage(i);
                }
                i++;
            }
            String imgId = img.getId();

            System.out.println("URL clicker :"+imgId);

            String[] tab = new String[4];

            tab = caseClicker.getTabImages();

            int indice =0;

            if(imgId.equals("img1")){
                indice = 0;
            }
            else if(imgId.equals("img2")){
                indice =1;
            }
            else if(imgId.equals("img3")){
                indice =2;
            }
            else if(imgId.equals("img4")){
                indice =3;
            }

            System.out.println("La reponse: "+caseClicker.getTabrep()[indice]);
            System.out.println("La reponse juste: "+ caseClicker.getReponseJuste());

            joueur.setReponse(caseClicker.getTabrep()[indice]);


            // f la fin
            caseClicker.traiter(joueur, dé);
            plateauView.setNameLabel(joueur.getNom());
            plateauView.setScoreLabel(Long.toString(joueur.getScoreActuelle()));

            Button b = plateauModel.getTableauCases()[joueur.getProchainePosition()-1].button;

            b.setStyle(b.getStyle()+"-fx-border-width: 5px; -fx-border-color: black;");
        }
    }


    private class OnClickArreter implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            ObjectOutputStream out = null;

                 try {

                     try{
                         out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
                         out.writeObject(EtatDuJeux);
                         out.close();
                     }
                     catch(FileNotFoundException e){e.printStackTrace();}
                     catch(IOException e){e.printStackTrace();}

                 } catch (NullPointerException exception) {
                     exception.printStackTrace();
                 }



            }



        }
    private class OnClickSubmitDefinition implements EventHandler<ActionEvent>{
        private int len;
        private HBox word_box;
        private Case caseClicker;
        public OnClickSubmitDefinition(HBox word_box, int len, Case caseClicker){
            this.len = len;
            this.word_box = word_box;
            this.caseClicker = caseClicker;
        }
        @Override
        public void handle(ActionEvent actionEvent) {
            TextField textField=new TextField();
            String word_enter="";
            for (int i = 0; i < len; i++) {
                textField=(TextField) word_box.getChildren().get(i);
                word_enter+=textField.getText();
            }
            System.out.println(word_enter);
            joueur.setReponse(word_enter.toLowerCase(Locale.ROOT));
            // hna ydir traiter
            caseClicker.traiter(joueur, dé);

        }
    }
    }



