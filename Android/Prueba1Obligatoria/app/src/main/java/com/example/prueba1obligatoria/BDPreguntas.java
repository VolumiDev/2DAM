package com.example.prueba1obligatoria;

public class BDPreguntas {
    private String[] preguntas;
    private String[] respuestas;
    private String[] recurso;

    public BDPreguntas(int nivel){
        preguntas = new String[5];
        respuestas = new String[5];
        recurso = new String[5];
        switch(nivel){
            case 0:
                preguntasFaciles();
                break;
            case 1:
                preguntasMedias();
                break;
            case 2:
                preguntasDificiles();
                break;
        }
    }
// GENERAMOS LAS PREGUNTAS Y LAS RESPUESTAS SEGUN EL NIVEL SELECCIONADO
    private void preguntasFaciles() {
        String[] src = {"f0","f1","f2","f3","f4"};
        for (int i = 0; i < recurso.length; i++) {
            recurso[i] = src[i];
        }

        String[] pre = {
                "¿Qué vemos en la imagen?",//anillo
                "¿A que lugar pertenece este sonido?", //comarca
                "¿De quién es este ojo?", //ojo de sauron
                "¿Quién dijo esta frase?", //gandalf
                "¿Quién es este personaje?"//frodo
        };
        for (int i = 0; i < pre.length; i++) {
            preguntas[i] = pre[i];
        }

        String[] resp = {
                "El anillo único-Un anillo de los hombres-La corona de Sauron-Una rotonda",
                "La comarca-Mordor-Abismo de Helm-Numenor",
                "Sauron-Saruman-Es una hoguera-Melkor",
                "Gandalf-Aragorn-Elrond-Gimly",
                "Frodo-Aragorn-Elrond-Gimly"
        };
        for (int i = 0; i < respuestas.length; i++) {
            respuestas[i] = resp[i];
        }
    }

    private void preguntasMedias(){

        String[] src = {"m0","m1","m2","m3","m4"};
        for (int i = 0; i < recurso.length; i++) {
            recurso[i] = src[i];
        }

        String[] pre={
                "¿Cómo es el nombre de esta espada?",//anduril
                "¿Quién dice esta frase?", //barbol
                "¿Qué lugar es este?", //minas tirith
                "¿Qué personaje es el que habla?",//ReyTheoden
                "¿Quién es el personaje de la imagen?"//Rey Brujo
        };
        for (int i = 0; i < pre.length; i++) {
            preguntas[i] = pre[i];
        }

        String[] resp={
                "Anduril-Elendil-Espada dardo-Glamdring",
                "Barbol-Saruman-Gandalf-Tom Bombadil",
                "Minas Tirith-Eregion-Gondor-Moria",
                "Rey Théoden-Elrond-Éowyn-Éomer",
                "Rey brujo-Sauron-Isildur-Azog"
        };
        for (int i = 0; i < respuestas.length; i++) {
            respuestas[i] = resp[i];
        }
    }

    private void preguntasDificiles(){

        String[] src = {"d0","d1","d2","d3","d4"};
        for (int i = 0; i < recurso.length; i++) {
            recurso[i] = src[i];
        }
        String[] pre={
                "¿Quién es este istar?",//Radagsat
                "¿Qué personaje habla?", //Éowyn
                "¿Qué representa esta imagen?", //Puerta de Durin
                "¿Qué ocurre en este sonido?",//Carga de los rohirrim
                "¿Qué lugar es este?"//Rivendell
        };
        for (int i = 0; i < pre.length; i++) {
            preguntas[i] = pre[i];
        }

        String[] resp={
                "Radagast-Pallando-Gandalf-Alatar",
                "Éowyn-Arwen-Galadriel-Mirta",
                "La puerta de Durin-Isengard-Fangor-Monte del destino",
                "Carga de los Rohirrim-Ataque a Mordor-Ataque abismo de Helm-Persecucion Nazgul",
                "Rivendell-Bree-Campos de Pelenor-Lothlorien"
        };
        for (int i = 0; i < respuestas.length; i++) {
            respuestas[i] = resp[i];
        }
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String[] preguntas) {
        this.preguntas = preguntas;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }
}
