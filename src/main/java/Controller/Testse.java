package Controller;

import java.util.Arrays;
import java.util.Random;

public class Testse {

    boolean init[]=new boolean [20];
    Random ra=new Random();


    int foNyKort() {
        int i=ra.nextInt(20);
        while (init[i])
            i=ra.nextInt(20);
        init[i]=true;
        return i;
    }

    void Shuffle(){
        int[] Bunke=new int[20];
        for (int i=0; i < Bunke.length  ; i++) {
            Bunke[i]=foNyKort();
            System.out.println(Arrays.toString(Bunke));
        }}

    public static void main(String[] args) {
        Testse c=new Testse();
        System.out.println(c.foNyKort());

    }}

