package com.lsebastien.mydatabase;

// Cette classe est notre modèle et contient les données que nous allons enregistrer dans la base
// de données, et afficher dans l'interface utilisateur.

public class Data {
    private int id;
    private String  idAvatar;
    private String  axe;
    private String  deadzone;
    private String  gain;

    public int  getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getIdAvatar() {
        return idAvatar;
    }
    public void setIdAvatar(String idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getAxe() {
        return axe;
    }
    public void setAxe(String axe) {
        this.axe = axe;
    }

    public String getDeadzone() {
        return deadzone;
    }
    public void setDeadzone(String deadzone) {
        this.deadzone = deadzone;
    }

    public String getGain() {
        return gain;
    }
    public void setGain(String gain) {
        this.gain = gain;
    }

    // Sera utilisée par ArrayAdapter dans la ListView
    @Override
    public String toString() {
        return "Avatar: " + idAvatar + "\n Axe: "+ axe + "\n Deadzone: " + deadzone +"\n Gain: " + gain;
    }
}