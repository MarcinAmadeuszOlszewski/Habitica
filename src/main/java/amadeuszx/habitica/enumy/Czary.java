package amadeuszx.habitica.enumy;

/**
 *
 * @author MarcinAmadeuszOlszewski
 */
public enum Czary{

    BLESSING("healAll"),
    FIREBALL("fireball"),
    ETERYCZNY("mpheal");

    private String id;

    private Czary(String id){
        this.id = id;
    }

    public String idCzaru(){
        return id;
    }
}
