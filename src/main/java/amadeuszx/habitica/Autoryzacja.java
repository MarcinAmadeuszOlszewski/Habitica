package amadeuszx.habitica;

import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MarcinAmadeuszOlszewski
 */
public class Autoryzacja{

    static String[] dane(){
        String login = null;
        String haslo = null;

        try{
            File sciezkaKonfiguracji = new File(Grafika.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            File file = new File(sciezkaKonfiguracji.getParent() + "\\konfig.txt");
            if(!file.exists()){
                file.createNewFile();
                while(login == null || haslo == null){
                    login = JOptionPane.showInputDialog("Podaj login");
                    haslo = JOptionPane.showInputDialog("Podaj haslo");
                }
                try (FileWriter fr = new FileWriter(file, false);){
                    fr.write(login + "\n" + haslo);
                }
            }else{
                try (BufferedReader br = new BufferedReader(new FileReader(file));){
                    login = br.readLine();
                    haslo = br.readLine();
                }
            }

        }catch(URISyntaxException | IOException ex){
            Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String[]{login, haslo};
    }
}
