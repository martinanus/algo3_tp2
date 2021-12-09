package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CuartelGeneral {




    public void  asignarMision(Policia policia){

    }

    public void emitirOrden(ArrayList<Ladron> ladronesPosibles, Policia policia) {
        if(ladronesPosibles.size()==1)
            policia.emitirOrdenArresto();
            //else : Imprime las listas de nombres de los sospechoso, "Sigue buscando mas pistas capo"
    }
}
