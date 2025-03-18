package com.etl.etl.Utils;

import java.text.Normalizer;

public class Normalizador {

    public static String normalizar(String texto){
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("\\p{M}","").replace("ç","c");
    }
}
