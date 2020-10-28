package Model;

import java.util.Random;

public class Die {

    private int faces;
    private int faceValue;

    public Die(int faces, int faceValue){
        this.faces = faces;
        this.faceValue = faceValue;
    }

    public int roll(){
        Random r = new Random();
        setFaceValue(r.nextInt((faces)+1));
        return faceValue;
    }

    public int getFaces() { return faces; }

    public void setFaces(int faces) { this.faces = faces; }

    public int getFaceValue() { return faceValue; }

    public void setFaceValue(int faceValue) { this.faceValue = faceValue; }
}
