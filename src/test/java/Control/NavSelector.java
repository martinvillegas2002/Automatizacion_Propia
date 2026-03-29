package Control;

import Constant.Navegador;
import static Constant.Navegador.Chrome;

public class NavSelector {
    static Navegador nav;

    public static Navegador seleccionNavegador(String navegador){
        switch (navegador.trim()){
            case "Chrome":
                nav = Chrome;
                return nav;
        }
        return Chrome;

    }
}
