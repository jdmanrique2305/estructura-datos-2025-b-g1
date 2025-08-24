import java.math.BigInteger;
public class Ejercicio4_ConversorBases {
    
    public static void convertir(String numero, int baseOrigen) {
        numero = numero.toUpperCase();

        if (!esValido(numero, baseOrigen)) {
            System.out.println("Número inválido para la base " + baseOrigen);
            return;
        }

        boolean usoBigInteger = false;
        long valorLong = 0;
        BigInteger valorBig = null;

        try {
            valorLong = Long.parseLong(numero, baseOrigen);
        } catch (NumberFormatException e) {
            valorBig = new BigInteger(numero, baseOrigen);
            usoBigInteger = true;
        }

        if (!usoBigInteger) {
            if (baseOrigen != 10) {
                System.out.println("Decimal: " + valorLong);
            }
            if (baseOrigen != 2) {
                System.out.println("Binario: " + Long.toString(valorLong, 2));
            }
            if (baseOrigen != 16) {
                System.out.println("Hexadecimal: " + Long.toString(valorLong, 16).toUpperCase());
            }
        } else {
            if (baseOrigen != 10) {
                System.out.println("Decimal: " + valorBig.toString(10));
            }
            if (baseOrigen != 2) {
                System.out.println("Binario: " + valorBig.toString(2));
            }
            if (baseOrigen != 16) {
                System.out.println("Hexadecimal: " + valorBig.toString(16).toUpperCase());
            }
        }

        System.out.println("¿Usó BigInteger? " + usoBigInteger);
    }

    private static boolean esValido(String numero, int base) {
        String digitos = "0123456789ABCDEF";
        String permitidos = digitos.substring(0, base);

        for (char c : numero.toCharArray()) {
            if (permitidos.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}

