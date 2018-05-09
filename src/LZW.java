import java.io.InputStream;
import java.io.OutputStream;

public class LZW {

    public static void compress(InputStream is, OutputStream os) throws Exception {
        Casilla diccionario [] = new Casilla[256];
        int valorActual;
        int indice=1;
        StringBuilder sb = new StringBuilder();

        while ((valorActual=is.read())!= -1) {

            if (diccionario[1]==null){
                Casilla caracteres = new  Casilla(0,valorActual);
                diccionario[indice]= caracteres;
            }

            for (int i = 0; i < diccionario.length; i++) {
                Casilla casilla = new Casilla(0,valorActual);
                if (diccionario[i]==casilla){

                }
            }

        }
    }

    public static void decompress(InputStream is, OutputStream os) throws Exception {

    }

    static class Casilla {
        int valorActual;
        int indice;

        public Casilla(int indice, int valorActual) {
            indice = this.indice;
            valorActual = this.valorActual;
        }
    }
}
