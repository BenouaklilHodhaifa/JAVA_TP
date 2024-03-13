package com.example.tp_javafx;

import java.io.*;
import java.util.ArrayList;


public class Serialiser {

   private ObjectInputStream in;
   private ObjectOutputStream out;

    public Serialiser(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }



    public void serialiser(File f, ArrayList<String> tab){
        try {

            try{
                out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
                out.writeObject(tab);
                out.close();
            }
            catch(FileNotFoundException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    public void serialiserDef(File f, ArrayList<Def> tab){
        try {

            try{
                out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
                out.writeObject(tab);
                out.close();
            }
            catch(FileNotFoundException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }


    public Jeux Deserialiser(File file) {

        Jeux jeux = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                jeux = ((Jeux) in.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jeux;

    }

    public ArrayList<String> DeserialiserTableauImage(File file) {

        ArrayList<String> bb = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                bb = ((ArrayList<String>) in.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bb;

    }

    public ArrayList<Def> DeserialiserTableauDef(File file) {

        ArrayList<Def> bb = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                bb = ((ArrayList<Def>) in.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bb;

    }


}
