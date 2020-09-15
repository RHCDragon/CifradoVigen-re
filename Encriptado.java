package Tarea1;

public class Encriptado {
    
    public static void main(String[] args) {
        Encriptado en = new Encriptado();
        System.out.println(en.encriptar(en.chars("ABCde")));
        System.out.println(en.desencriptar(en.chars("hgEDC")));
        System.out.println(en.encriptar(en.chars("abcABC1")));
        
    }
    
    
     char [] chars(String code){
        char [] temp = new char[code.length()];
        
        for (int i = 0; i < code.length(); i++) {
            temp [i] = code.charAt(i);
        }
        return temp;
    }

    public String encriptar(char pase[]){
        String salida = "";

        //primer parte
        for (int i = 0; i < pase.length; i++) {
            if((pase[i] >= 65 && pase[i]<=90) || (pase[i] >= 97 && pase[i]<=122)){
            pase [i] += 3;
            }   
        }//Las letras se recorren 3 lugares
        //segunda parte
        pase = invertir(pase);
        //tercera parte
        int partido = Math.round(pase.length/2);
        for (int i = partido; i < pase.length; i++) {
            if((pase[i] >= 65 && pase[i]<=90) || (pase[i] >= 97 && pase[i]<=122)){
            pase [i] -= 1;
            }   
        }
        //Armado del String
        for (int i = 0; i < pase.length; i++) {
            salida = salida + "" + pase[i];
        }
        return salida;
    }
    
    public String desencriptar (char pase[]){
        String salida = "";

        
        //Primera parte
        int partido = Math.round(pase.length/2);
        for (int i = partido; i < pase.length; i++) {
            if((pase[i] >= 65 && pase[i]<=90) || (pase[i] >= 97 && pase[i]<=122)){
            pase [i] += 1;
            }   
        }
        //Segunda parte
        pase = invertir(pase);

        //Tercera parte
        for (int i = 0; i < pase.length; i++) {
            if((pase[i] >= 65 && pase[i]<=90) || (pase[i] >= 97 && pase[i]<=122)){
            pase [i] -= 3;
            }   
        }//Las letras se recorren 3 lugares
        
                
//Armado del String
        for (int i = 0; i < pase.length; i++) {
            salida = salida + "" + pase[i];
        }
        return salida;
    }
    
    public char [] invertir(char pase[]){
        char [] invertido = new char[pase.length];
        for(int i = 0; i < pase.length; i++){
            invertido[i] = pase[pase.length-1-i];
        }
        return invertido;
    }
    
}
