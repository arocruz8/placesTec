package árbolBB;

import java.util.Vector;
public class ABB {
    Integer raiz;
    ABB subABizq;
    ABB subABder;

    // Constructor de un arbol vacio
    public ABB() {
        raiz = null;
        subABizq = null;
        subABder = null;
    }

    // constructor de una hoja
    public ABB( Integer raiz ) {
        this.raiz = new Integer( raiz );
        subABizq = null;
        subABder = null;
    }

    private boolean esVacio() {
        boolean vacio = true;

        if ( raiz != null )
            vacio = false;

        return vacio;
    }

    public void insertar( Integer nuevo ) {
        if( esVacio() ) {
            raiz = new Integer( nuevo );
            subABizq = new ABB();
            subABder = new ABB();
        } else {
            if( nuevo < raiz ) {
                subABizq.insertar(nuevo);
            } else if ( nuevo > raiz ) {
                subABder.insertar(nuevo);
            }
        }
    }

    public ABB buscar( Integer x ) {
        ABB buscado = null;

        if( !esVacio() ) {
            if( x < raiz ) {
                buscado = subABizq.buscar(x);
            } else if ( x > raiz ) {
                buscado = subABder.buscar(x);
            } else {
                return this;
            }
        }

        return buscado;
    }


    private ABB buscarMin() {
        ABB arbolActual = this;

        while( !arbolActual.subABizq.esVacio() ) {
            arbolActual = arbolActual.subABizq;
        }

        return arbolActual;
    }

    private boolean esHoja() {
        boolean hoja = false;

        if( subABizq.esVacio() && subABder.esVacio() ) {
            hoja = true;
        }

        return hoja;
    }

    public void eliminar( Integer a ) {
        ABB aEliminar = buscar(a);

        if (aEliminar != null) {
            if( aEliminar.esHoja() ) {
                aEliminar.raiz = null;
            } else {
                ABB min =  aEliminar.subABder.buscarMin();
                aEliminar.raiz = min.raiz;
                min.eliminar(min.raiz);
            }
        }
    }

    public void preOrden() {
        if( !esVacio() ) {
            System.out.println( raiz );
            subABizq.preOrden();
            subABder.preOrden();
        }
    }

    public void enOrden() {
        if( !esVacio() ) {
            subABizq.enOrden();
            System.out.println( raiz );
            subABder.enOrden();
        }
    }

    public void postOrden() {
        if( !esVacio() ) {
            subABizq.postOrden();
            subABder.postOrden();
            System.out.println( raiz );
        }
    }


    public void porNivel() {
        Vector<ABB> cola = new Vector<ABB>();
        ABB arbol;

        cola.add(this);
        while( !cola.isEmpty() ) {
            arbol = cola.elementAt(0);
            cola.remove(0);
            System.out.println( arbol.raiz );
            if ( !arbol.subABizq.esVacio() ) cola.add( arbol.subABizq );
            if (!arbol.subABder.esVacio() ) cola.add( arbol.subABder );
        }
    }

}