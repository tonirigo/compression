import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class RLE {
    public static void compress(InputStream is, OutputStream os) throws Exception {
        int valorActual;
        LinkedList <Integer> Lista = new LinkedList<>();
        while ((valorActual=is.read())!=(-1)){
            if (Lista.isEmpty()){
                Lista.add(valorActual);
            }
            else{
                if (valorActual==Lista.peek()){
                    Lista.add(valorActual);
                    int valorsiguiente;
                    int cnt = 0;

                    while ((valorsiguiente=is.read())!=(-1)) {
                        if (valorsiguiente == Lista.peek()) {
                            cnt++;
                            if (cnt == 255) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (valorsiguiente!=valorActual&&valorsiguiente!=(-1)){
                        os.write(Lista.poll());
                        os.write(Lista.poll());
                        os.write(cnt);
                        Lista.push(valorsiguiente);
                    }else {
                        os.write(Lista.poll());
                        os.write(Lista.poll());
                        os.write(cnt);
                    }
                }else {
                    os.write(Lista.poll());
                    Lista.push(valorActual);
                }

            }
        }
        if (!Lista.isEmpty()){
            os.write(Lista.poll());
        }

    }

    public static void decompress(InputStream is, OutputStream os) throws Exception {
        int valorActual;
        int valorAnterior = 0;
        while ((valorActual=is.read())!=(-1)){
            if (valorActual==valorAnterior){
                if ((valorActual=is.read())==(0)){
                    os.write(valorAnterior);
                }else{
                    while(valorActual!=-1){
                        os.write(valorAnterior);
                        valorActual--;
                    }
                }
            }
            else {
                os.write(valorActual);
            }
            valorAnterior=valorActual;
        }
    }
}
