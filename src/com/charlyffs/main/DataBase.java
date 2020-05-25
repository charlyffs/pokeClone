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
        pokeDex.add(new Pokemon("Pidgey", 40, 0, "Tackle"));
        pokeDex.add(new Pokemon("Pidgeotto", 63, 0, "Tackle"));
        pokeDex.add(new Pokemon("Pidgeot", 83, 0, "Tackle"));
        pokeDex.add(new Pokemon("Rattata", 30, 0, "Tackle"));
        pokeDex.add(new Pokemon("Raticate", 55, 0, "Tackle"));
        pokeDex.add(new Pokemon("Spearow", 40, 0, "Tackle"));
        pokeDex.add(new Pokemon("Fearow", 65, 0, "Tackle"));
        pokeDex.add(new Pokemon("Clefairy", 70, 0, "Tackle"));
        pokeDex.add(new Pokemon("Clefable", 95, 0, "Tackle"));
        pokeDex.add(new Pokemon("Jigglypuff", 115, 0, "Tackle"));
        pokeDex.add(new Pokemon("Wigglytuff", 140, 0, "Tackle"));
        pokeDex.add(new Pokemon("Meowth", 40, 0, "Tackle"));
        pokeDex.add(new Pokemon("Persian", 65, 0, "Tackle"));
        pokeDex.add(new Pokemon("Farfetch'd", 52, 0, "Tackle"));
        pokeDex.add(new Pokemon("Doduo", 35, 0, "Tackle"));
        pokeDex.add(new Pokemon("Dodrio", 60, 0, "Tackle"));
        pokeDex.add(new Pokemon("Lickitung", 90, 0, "Tackle"));
        pokeDex.add(new Pokemon("Chansey", 250, 0, "Tackle"));
        pokeDex.add(new Pokemon("Kangaskhan", 105, 0, "Tackle"));
        pokeDex.add(new Pokemon("Tauros", 75, 0, "Tackle"));
        pokeDex.add(new Pokemon("Ditto", 48, 0, "Tackle"));
        pokeDex.add(new Pokemon("Eevee", 55, 0, "Tackle"));
        pokeDex.add(new Pokemon("Porygon", 65, 0, "Tackle"));
        pokeDex.add(new Pokemon("Snorlax", 160, 0, "Tackle"));
        pokeDex.add(new Pokemon("Charmander", 39, 1, "Tackle"));
        pokeDex.add(new Pokemon("Charmeleon", 58, 1, "Tackle"));
        pokeDex.add(new Pokemon("Charizard", 78, 1, "Tackle"));
        pokeDex.add(new Pokemon("Vulpix", 38, 1, "Tackle"));
        pokeDex.add(new Pokemon("Ninetales", 73, 1, "Tackle"));
        pokeDex.add(new Pokemon("Growlithe", 55, 1, "Tackle"));
        pokeDex.add(new Pokemon("Arcanine", 90, 1, "Tackle"));
        pokeDex.add(new Pokemon("Ponyta", 50, 1, "Tackle"));
        pokeDex.add(new Pokemon("Rapidash", 65, 1, "Tackle"));
        pokeDex.add(new Pokemon("Magmar", 65, 1, "Tackle"));
        pokeDex.add(new Pokemon("Flareon", 65, 1, "Tackle"));
        pokeDex.add(new Pokemon("Moltres", 90, 1, "Tackle"));
        pokeDex.add(new Pokemon("Squirtle", 44, 2, "Tackle"));
        pokeDex.add(new Pokemon("Wartortle", 59, 2, "Tackle"));
        pokeDex.add(new Pokemon("Blastoise", 79, 2, "Tackle"));
        pokeDex.add(new Pokemon("Psyduck", 50, 2, "Tackle"));
        pokeDex.add(new Pokemon("Golduck", 80, 2, "Tackle"));
        pokeDex.add(new Pokemon("Poliwag", 40, 2, "Tackle"));
        pokeDex.add(new Pokemon("Poliwhirl", 65, 2, "Tackle"));
        pokeDex.add(new Pokemon("Poliwrath", 90, 2, "Tackle"));
        pokeDex.add(new Pokemon("Tentacool", 40, 2, "Tackle"));
        pokeDex.add(new Pokemon("Tentacruel", 80, 2, "Tackle"));
        pokeDex.add(new Pokemon("Slowpoke", 90, 2, "Tackle"));
        pokeDex.add(new Pokemon("Slowbro", 95, 2, "Tackle"));
        pokeDex.add(new Pokemon("Seel", 65, 2, "Tackle"));
        pokeDex.add(new Pokemon("Dewgong", 90, 2, "Tackle"));
        pokeDex.add(new Pokemon("Shellder", 30, 2, "Tackle"));
        pokeDex.add(new Pokemon("Cloyster", 50, 2, "Tackle"));
        pokeDex.add(new Pokemon("Krabby", 30, 2, "Tackle"));
        pokeDex.add(new Pokemon("Kingler", 55, 2, "Tackle"));
        pokeDex.add(new Pokemon("Horsea", 30, 2, "Tackle"));
        pokeDex.add(new Pokemon("Seadra", 55, 2, "Tackle"));
        pokeDex.add(new Pokemon("Goldeen", 45, 2, "Tackle"));
        pokeDex.add(new Pokemon("Seaking", 80, 2, "Tackle"));
        pokeDex.add(new Pokemon("Staryu", 30, 2, "Tackle"));
        pokeDex.add(new Pokemon("Starmie", 60, 2, "Tackle"));
        pokeDex.add(new Pokemon("Magikarp", 20, 2, "Tackle"));
        pokeDex.add(new Pokemon("Gyarados", 95, 2, "Tackle"));
        pokeDex.add(new Pokemon("Lapras", 130, 2, "Tackle"));
        pokeDex.add(new Pokemon("Vaporeon", 130, 2, "Tackle"));
        pokeDex.add(new Pokemon("Bulbasaur", 45, 3, "Tackle"));
        pokeDex.add(new Pokemon("Ivysaur", 60, 3, "Tackle"));
        pokeDex.add(new Pokemon("Venusaur", 80, 3, "Tackle"));
        pokeDex.add(new Pokemon("Oddish", 45, 3, "Tackle"));
        pokeDex.add(new Pokemon("Gloom", 60, 3, "Tackle"));
        pokeDex.add(new Pokemon("Vileplume", 75, 3, "Tackle"));
        pokeDex.add(new Pokemon("Bellsprout", 50, 3, "Tackle"));
        pokeDex.add(new Pokemon("Weepinbell", 65, 3, "Tackle"));
        pokeDex.add(new Pokemon("Victreebel", 80, 3, "Tackle"));
        pokeDex.add(new Pokemon("Exeggcute", 60, 3, "Tackle"));
        pokeDex.add(new Pokemon("Exeggutor", 95, 3, "Tackle"));
        pokeDex.add(new Pokemon("Tangela", 65, 3, "Tackle"));
        pokeDex.add(new Pokemon("Pikachu", 35, 4, "Tackle"));
        pokeDex.add(new Pokemon("Raichu", 60, 4, "Tackle"));
        pokeDex.add(new Pokemon("Magnemite", 25, 4, "Tackle"));
        pokeDex.add(new Pokemon("Magneton", 50, 4, "Tackle"));
        pokeDex.add(new Pokemon("Voltorb", 40, 4, "Tackle"));
        pokeDex.add(new Pokemon("Electrode", 60, 4, "Tackle"));
        pokeDex.add(new Pokemon("Electabuzz", 65, 4, "Tackle"));
        pokeDex.add(new Pokemon("Jolteon", 65, 4, "Tackle"));
        pokeDex.add(new Pokemon("Zapdos", 90, 4, "Tackle"));
        pokeDex.add(new Pokemon("Jynx", 65, 5, "Tackle"));
        pokeDex.add(new Pokemon("Articuno", 90, 5, "Tackle"));
        pokeDex.add(new Pokemon("Mankey", 40, 6, "Tackle"));
        pokeDex.add(new Pokemon("Primeape", 65, 6, "Tackle"));
        pokeDex.add(new Pokemon("Machop", 70, 6, "Tackle"));
        pokeDex.add(new Pokemon("Machoke", 80, 6, "Tackle"));
        pokeDex.add(new Pokemon("Machamp", 90, 6, "Tackle"));
        pokeDex.add(new Pokemon("Hitmonlee", 50, 6, "Tackle"));
        pokeDex.add(new Pokemon("Hitmonchan", 50, 6, "Tackle"));
        pokeDex.add(new Pokemon("Ekans", 30, 7, "Tackle"));
        pokeDex.add(new Pokemon("Arbok", 60, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidoran", 55, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidorina", 70, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidoqueen", 90, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidoran", 46, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidorino", 61, 7, "Tackle"));
        pokeDex.add(new Pokemon("Nidoking", 81, 7, "Tackle"));
        pokeDex.add(new Pokemon("Zubat", 40, 7, "Tackle"));
        pokeDex.add(new Pokemon("Golbat", 75, 7, "Tackle"));
        pokeDex.add(new Pokemon("Grimer", 80, 7, "Tackle"));
        pokeDex.add(new Pokemon("Muk", 105, 7, "Tackle"));
        pokeDex.add(new Pokemon("Koffing", 40, 7, "Tackle"));
        pokeDex.add(new Pokemon("Weezing", 65, 7, "Tackle"));
        pokeDex.add(new Pokemon("Sandshrew", 50, 8, "Tackle"));
        pokeDex.add(new Pokemon("Sandslash", 75, 8, "Tackle"));
        pokeDex.add(new Pokemon("Diglett", 10, 8, "Tackle"));
        pokeDex.add(new Pokemon("Dugtrio", 35, 8, "Tackle"));
        pokeDex.add(new Pokemon("Cubone", 50, 8, "Tackle"));
        pokeDex.add(new Pokemon("Marowak", 60, 8, "Tackle"));
        pokeDex.add(new Pokemon("Rhyhorn", 80, 8, "Tackle"));
        pokeDex.add(new Pokemon("Rhydon", 105, 8, "Tackle"));
        pokeDex.add(new Pokemon("Abra", 25, 10, "Tackle"));
        pokeDex.add(new Pokemon("Kadabra", 40, 10, "Tackle"));
        pokeDex.add(new Pokemon("Alakazam", 55, 10, "Tackle"));
        pokeDex.add(new Pokemon("Drowzee", 60, 10, "Tackle"));
        pokeDex.add(new Pokemon("Hypno", 85, 10, "Tackle"));
        pokeDex.add(new Pokemon("Mr. Mime", 40, 10, "Tackle"));
        pokeDex.add(new Pokemon("Mewtwo", 106, 10, "Tackle"));
        pokeDex.add(new Pokemon("Mew", 100, 10, "Tackle"));
        pokeDex.add(new Pokemon("Caterpie", 45, 11, "Tackle"));
        pokeDex.add(new Pokemon("Metapod", 50, 11, "Tackle"));
        pokeDex.add(new Pokemon("Butterfree", 60, 11, "Tackle"));
        pokeDex.add(new Pokemon("Weedle", 40, 11, "Tackle"));
        pokeDex.add(new Pokemon("Kakuna", 45, 11, "Tackle"));
        pokeDex.add(new Pokemon("Beedrill", 65, 11, "Tackle"));
        pokeDex.add(new Pokemon("Paras", 35, 11, "Tackle"));
        pokeDex.add(new Pokemon("Parasect", 60, 11, "Tackle"));
        pokeDex.add(new Pokemon("Venonat", 60, 11, "Tackle"));
        pokeDex.add(new Pokemon("Venomoth", 70, 11, "Tackle"));
        pokeDex.add(new Pokemon("Scyther", 70, 11, "Tackle"));
        pokeDex.add(new Pokemon("Pinsir", 65, 11, "Tackle"));
        pokeDex.add(new Pokemon("Geodude", 40, 12, "Tackle"));
        pokeDex.add(new Pokemon("Graveler", 55, 12, "Tackle"));
        pokeDex.add(new Pokemon("Golem", 80, 12, "Tackle"));
        pokeDex.add(new Pokemon("Onix", 35, 12, "Tackle"));
        pokeDex.add(new Pokemon("Omanyte", 35, 12, "Tackle"));
        pokeDex.add(new Pokemon("Omastar", 70, 12, "Tackle"));
        pokeDex.add(new Pokemon("Kabuto", 30, 12, "Tackle"));
        pokeDex.add(new Pokemon("Kabutops", 60, 12, "Tackle"));
        pokeDex.add(new Pokemon("Aerodactyl", 80, 12, "Tackle"));
        pokeDex.add(new Pokemon("Gastly", 30, 13, "Tackle"));
        pokeDex.add(new Pokemon("Haunter", 45, 13, "Tackle"));
        pokeDex.add(new Pokemon("Gengar", 60, 13, "Tackle"));
        pokeDex.add(new Pokemon("Dratini", 41, 14, "Tackle"));
        pokeDex.add(new Pokemon("Dragonair", 61, 14, "Tackle"));
        pokeDex.add(new Pokemon("Dragonite", 91, 14, "Tackle"));
    }
    
    public static Pokemon getPokemon(int index) {
        return pokeDex.get(index);
    }
    
    public static ArrayList<Pokemon> getPokeDex() {
        return pokeDex;
    }
    
}