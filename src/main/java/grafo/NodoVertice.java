package grafo;
import árbolBB.*;
import java.util.*;

public class NodoVertice{
    public int vertice;                 //Almacena el dato del vértice
    public boolean visitado;            //Indica si el vértice ha sido visitado o no
    public LinkedList <Nodo> aristas;   //Almacena la lista de aristas del vértice
    ABB arbolito;
    
    public NodoVertice(){
        this.vertice = 0;
        this.visitado = false;
        this.aristas  = new LinkedList<Nodo>();
        this.arbolito = new ABB();
    }//fin del constructor Nodo

    public NodoVertice(int v){
        this.vertice = v;
        this.visitado = false;
        this.aristas  = new LinkedList<Nodo>();
        this.arbolito = new ABB();
    }//fin del constructor Nodo

    public String aCadena(){
        return "|" + this.vertice + "|" + "|->";
    }//fin método aCadena

}//fin class NodoVertice
