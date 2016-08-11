package amadeuszx.habitica.enumy;

/**
 *
 * @author MarcinAmadeuszOlszewski
 */
public enum Czaty{

    DRUZYNA("party"), 
    POLAND("006c7f68-e07a-4a56-9dcf-fd64c90e3ef4");

    private String id;

    private Czaty(String id){
        this.id = id;
    }

    public String idCzatu(){
        return id;
    }

}
