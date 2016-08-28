/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amadeuszx.habitica.pomocnicze;

import java.util.Comparator;

/**
 *
 * @author Sylwunia
 */
public class Postac {

    private String imie;
    private int zdrowie;
    
    public Postac(String imie, int zdrowie) {
        this.imie = imie;
        this.zdrowie = zdrowie;
    }
public static Comparator<Postac> pobierzComparatorRanni(){
    return new Ranni();
}
    @Override
    public String toString() {
        return "Imie: " + imie + " hp: " + zdrowie; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getImie() {
        return imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }
    
    public int getZdrowie() {
        return zdrowie;
    }
    
    public void setZdrowie(int zdrowie) {
        this.zdrowie = zdrowie;
    }
    
}

class Ranni implements Comparator<Postac> {
    
    @Override
    public int compare(Postac o1, Postac o2) {
        if (o1.getZdrowie() != o2.getZdrowie()) {
            return  o2.getZdrowie()-o1.getZdrowie() ;
        } else {
            return o1.getImie().compareTo(o2.getImie());
        }
    }
    
}
