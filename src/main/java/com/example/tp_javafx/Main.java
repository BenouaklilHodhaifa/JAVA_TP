package com.example.tp_javafx;

import javafx.application.Application;
import javafx.scene.effect.Light;
import javafx.stage.Stage;
import java.io.*;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application implements  Serializable {
    @Override
    public void start(Stage stage) throws IOException {

        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        jeuxController jeux = new jeuxController(stage);
        Serialiser Sauvgarde = new Serialiser(in , out);
        /*File img = new File("FichierImage.dat");
        File noms = new File("FichierNoms.dat");

        ArrayList<String> vv = new ArrayList<>();
        ArrayList<String> cc = new ArrayList<>();
        cc.add("dog");
        cc.add("cat");
        cc.add("sheep");
        cc.add("cow");
        cc.add("lion");
        cc.add("tiger");
        cc.add("leopard");
        cc.add("panda");
        cc.add("water");
        cc.add("juice");
        cc.add("milk");
        cc.add("soda");
        cc.add("kiwi");
        cc.add("olive");
        cc.add("orange");
        cc.add("tomate");
        Sauvgarde.serialiser(noms, cc);

        for(int i=0 ; i<16 ; i++){
            vv.add("D:\\BACKUP_houdhaifah\\Documents\\ESI\\2CP\\Moi\\S4\\POO\\TP\\TP_POO\\TP_POO\\src\\main\\java\\com\\example\\tp_javafx\\ressource\\"+Integer.toString(i)+".jpg");
        }

        Sauvgarde.serialiser(img, vv);*/


    }
}














