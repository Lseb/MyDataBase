package com.lsebastien.mydatabase;

// Cette classe est notre modèle et contient les données que nous allons enregistrer dans la base
// de données, et afficher dans l'interface utilisateur.

public class Data {
    private int id;
    private int  idAvatar;
    private String  deadzoneYaw;
    private String  deadzonePitch;
    private String  deadzoneRoll;
    private String  deadzoneUpDown;
    private String  gainYaw;
    private String  gainPitch;
    private String  gainRoll;
    private String  gainUpDown;


    public int  getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getIdAvatar() {
        return idAvatar;
    }
    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getDeadzoneYaw() {
        return deadzoneYaw;
    }
    public void setDeadzoneYaw(String deadzoneYaw) {
        this.deadzoneYaw = deadzoneYaw;
    }

    public String getDeadzonePitch() {
        return deadzonePitch;
    }
    public void setDeadzonePitch(String deadzonePitch) {
        this.deadzonePitch = deadzonePitch;
    }

    public String getDeadzoneRoll() {
        return deadzoneRoll;
    }
    public void setDeadzoneRoll(String deadzoneRoll) {
        this.deadzoneRoll = deadzoneRoll;
    }

    public String getDeadzoneUpDown() {
        return deadzoneUpDown;
    }
    public void setDeadzoneUpDown(String deadzoneUpDown) {
        this.deadzoneUpDown = deadzoneUpDown;
    }

    public String getGainYaw() {
        return gainYaw;
    }
    public void setGainYaw(String gainYaw) {
        this.gainYaw = gainYaw;
    }

    public String getGainPitch() {
        return gainPitch;
    }
    public void setGainPitch(String gainPitch) {
        this.gainPitch = gainPitch;
    }

    public String getGainRoll() {
        return gainRoll;
    }
    public void setGainRoll(String gainRoll) {
        this.gainRoll = gainRoll;
    }

    public String getGainUpDown() {
        return gainUpDown;
    }
    public void setGainUpDown(String gainUpDown) {
        this.gainUpDown = gainUpDown;
    }
    /*
    @Override
    public String toString() {
        return "Avatar: " + idAvatar + "\n Axe: "+ axe + "\n Deadzone: " + deadzone +"\n Gain: " + gain;
    }
    */
}
