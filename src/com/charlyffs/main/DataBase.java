package com.charlyffs.main;
import java.util.ArrayList;

public class DataBase {
    
    private static final double[][] modifier = new double[17][17];
    private static final ArrayList<Pokemon> pokeDex = new ArrayList<>();
    
    public static void fillTable() {
        for (int i = 0; i < 17; i++) {
            for (int f = 0; f < 17; f++) {
                modifier[i][f] = 1;
            }
        }
        modifier[12][0] = .5;
        modifier[13][0] = 0;
        modifier[1][1] = .5;
        modifier[2][1] = .5;
        modifier[3][1] = 2;
        modifier[5][1] = 2;
        modifier[11][1] = 2;
        modifier[12][1] = .5;
        modifier[14][1] = .5;
        modifier[1][2] = 2;
        modifier[2][2] = .5;
        modifier[3][2] = .5;
        modifier[8][2] = 2;
        modifier[12][2] = 2;
        modifier[14][2] = .5;
        modifier[1][3] = .5;
        modifier[2][3] = 2;
        modifier[3][3] = .5;
        modifier[7][3] = .5;
        modifier[8][3] = 2;
        modifier[9][3] = .5;
        modifier[11][3] = .5;
        modifier[12][3] = 2;
        modifier[14][3] = .5;
        modifier[2][4] = 2;
        modifier[3][4] = .5;
        modifier[4][4] = .5;
        modifier[8][4] = 0;
        modifier[9][4] = 2;
        modifier[14][4] = .5;
        modifier[1][5] = .5;
        modifier[2][5] = .5;
        modifier[3][5] = 2;
        modifier[5][5] = .5;
        modifier[8][5] = 2;
        modifier[9][5] = 2;
        modifier[14][5] = 2;
        modifier[16][5] = .5;
        modifier[0][6] = 2;
        modifier[5][6] = 2;
        modifier[7][6] = .5;
        modifier[9][6] = .5;
        modifier[10][6] = .5;
        modifier[11][6] = .5;
        modifier[12][6] = 2;
        modifier[13][6] = 0;
        modifier[15][6] = 2;
        modifier[16][6] = 2;
        modifier[3][7] = 2;
        modifier[7][7] = .5;
        modifier[8][7] = .5;
        modifier[12][7] = .5;
        modifier[13][7] = .5;
        modifier[16][7] = 0;
        modifier[1][8] = 2;
        modifier[3][8] = .5;
        modifier[4][8] = 2;
        modifier[7][8] = 2;
        modifier[9][8] = 0;
        modifier[11][8] = .5;
        modifier[12][8] = 2;
        modifier[16][8] = 2;
        modifier[3][9] = 2;
        modifier[4][9] = .5;
        modifier[6][9] = 2;
        modifier[11][9] = 2;
        modifier[12][9] = .5;
        modifier[16][9] = .5;
        modifier[6][10] = 2;
        modifier[7][10] = 2;
        modifier[10][10] = .5;
        modifier[15][10] = 0;
        modifier[16][10] = .5;
        modifier[1][11] = .5;
        modifier[3][11] = 2;
        modifier[6][11] = .5;
        modifier[7][11] = .5;
        modifier[9][11] = .5;
        modifier[10][11] = 2;
        modifier[13][11] = .5;
        modifier[15][11] = 2;
        modifier[16][11] = .5;
        modifier[1][12] = 2;
        modifier[5][12] = 2;
        modifier[6][12] = .5;
        modifier[8][12] = .5;
        modifier[9][12] = 2;
        modifier[11][12] = 2;
        modifier[16][12] = .5;
        modifier[0][13] = 0;
        modifier[10][13] = 2;
        modifier[13][13] = 2;
        modifier[15][13] = .5;
        modifier[14][14] = 2;
        modifier[16][14] = .5;
        modifier[6][15] = .5;
        modifier[10][15] = 2;
        modifier[13][15] = 2;
        modifier[15][15] = .5;
        modifier[1][16] = .5;
        modifier[2][16] = .5;
        modifier[4][16] = .5;
        modifier[5][16] = 2;
        modifier[12][16] = 2;
        modifier[16][16] = .5;
        modifier[16][0] = .5;
        modifier[16][1] = 2;
        modifier[16][3] = .5;
    }
    
    public static double getModifier(int source, int target) {
        return modifier[target][source];
    }
    
    static void showTable() {
        System.out.print("   ");
        for (int x = 0; x < 17; x++) {
            System.out.print(x + (x < 10 ? "   " : "  "));
        }
        System.out.println();
        for (int i = 0; i < 17; i++) {
            System.out.print(i + " ");
            for (int f = 0; f < 17; f++) {
                System.out.print(modifier[f][i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void fillPokeDex() {
        //45 ,39, 44
        pokeDex.add(new Pokemon(200, 1, 3, "Bulbasaur"));
        pokeDex.add(new Pokemon(200, 1, 1, "Charmander"));
        pokeDex.add(new Pokemon(200,  1, 2, "Squirtle"));
        for (int i = 0; i < 3; i++) {
            pokeDex.get(i).addMove(1, 1, "Tackle", 25);
        }
    }
    
    public static Pokemon getPokemon(int index) {
        return pokeDex.get(index);
    }
    
    public static ArrayList<Pokemon> getPokeDex() {
        return pokeDex;
    }
    
}
