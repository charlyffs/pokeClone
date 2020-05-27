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
    
//        pokeDex.get(pokeDex.size() - 1).setCurrentHP(9999999);
//        pokeDex.get(pokeDex.size() - 1).getAttacks().get(0).setHp(9999999);
//        pokeDex.get(pokeDex.size() - 1).setLevel(9)
        pokeDex.add(new Pokemon(16, "Pidgey",  40, 0, "Tackle", true));
        pokeDex.add(new Pokemon(17, "Pidgeotto",  63, 0, "Gust", true));
        pokeDex.add(new Pokemon(18, "Pidgeot",  83, 0, "Gust", false));
        pokeDex.add(new Pokemon(19, "Rattata",  30, 0, "Tackle", true));
        pokeDex.add(new Pokemon(20, "Raticate",  55, 0, "Counter", false));
        pokeDex.add(new Pokemon(21, "Spearow",  40, 0, "Peck", true));
        pokeDex.add(new Pokemon(22, "Fearow",  65, 0, "Drill Run", false));
        pokeDex.add(new Pokemon(35, "Clefairy",  70, 0, "Charm", true));
        pokeDex.add(new Pokemon(36, "Clefable",  95, 0, "After You", false));
        pokeDex.add(new Pokemon(39, "Jigglypuff",  115, 0, "Sing", true));
        pokeDex.add(new Pokemon(40, "Wigglytuff",  140, 0, "Bide", false));
        pokeDex.add(new Pokemon(52, "Meowth",  40, 0, "Fake Out", false));
        pokeDex.add(new Pokemon(53, "Persian",  65, 0, "Fake Out", false));
        pokeDex.add(new Pokemon(83, "Farfetch'd",  52, 0, "Peck", false));
        pokeDex.add(new Pokemon(84, "Doduo",  35, 0, "Growl", true));
        pokeDex.add(new Pokemon(85, "Dodrio",  60, 0, "Growl", false));
        pokeDex.add(new Pokemon(108, "Lickitung",  90, 0, "Lick", false));
        pokeDex.add(new Pokemon(113, "Chansey",  250, 0, "Growl", false));
        pokeDex.add(new Pokemon(115, "Kangaskhan",  105, 0, "Comet Punch", false));
        pokeDex.add(new Pokemon(128, "Tauros",  75, 0, "Tackle", false));
        pokeDex.add(new Pokemon(132, "Ditto",  48, 0, "Transform", false));
        pokeDex.add(new Pokemon(133, "Eevee",  55, 0, "Covet", true));
        pokeDex.add(new Pokemon(137, "Porygon",  65, 0, "Tackle", false));
        pokeDex.add(new Pokemon(143, "Snorlax",  160, 0, "Covet", false));
        pokeDex.add(new Pokemon(4, "Charmander",  39, 1, "Scratch", true));;
        pokeDex.add(new Pokemon(5, "Charmeleon",  58, 1, "Ember", true));
        pokeDex.add(new Pokemon(6, "Charizard",  78, 1, "Ember", false));
        pokeDex.add(new Pokemon(37, "Vulpix",  38, 1, "Ember", true));
        pokeDex.add(new Pokemon(38, "Ninetales",  73, 1, "Fire Blast", false));
        pokeDex.add(new Pokemon(58, "Growlithe",  55, 1, "Ember", true));
        pokeDex.add(new Pokemon(59, "Arcanine",  90, 1, "Burn Up", false));
        pokeDex.add(new Pokemon(77, "Ponyta",  50, 1, "Tackle", true));
        pokeDex.add(new Pokemon(78, "Rapidash",  65, 1, "Ember", false));
        pokeDex.add(new Pokemon(126, "Magmar",  65, 1, "Ember", false));
        pokeDex.add(new Pokemon(136, "Flareon",  65, 1, "Double-Edge", false));
        pokeDex.add(new Pokemon(146, "Moltres",  90, 1, "Ember", false));
        pokeDex.add(new Pokemon(7, "Squirtle",  44, 2, "Tackle", true));
        pokeDex.add(new Pokemon(8, "Wartortle",  59, 2, "Water Gun", true));
        pokeDex.add(new Pokemon(9, "Blastoise",  79, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(54, "Psyduck",  50, 2, "Scratch", true));
        pokeDex.add(new Pokemon(55, "Golduck",  80, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(60, "Poliwag",  40, 2, "Bubble", true));
        pokeDex.add(new Pokemon(61, "Poliwhirl",  65, 2, "Bubble", true));
        pokeDex.add(new Pokemon(62, "Poliwrath",  90, 2, "Bubble", false));
        pokeDex.add(new Pokemon(72, "Tentacool",  40, 2, "Poison Sting", true));
        pokeDex.add(new Pokemon(73, "Tentacruel",  80, 2, "Acid", false));
        pokeDex.add(new Pokemon(79, "Slowpoke",  90, 2, "Tackle", true));
        pokeDex.add(new Pokemon(80, "Slowbro",  95, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(86, "Seel",  65, 2, "Headbutt", true));
        pokeDex.add(new Pokemon(87, "Dewgong",  90, 2, "Aqua Jet", false));
        pokeDex.add(new Pokemon(90, "Shellder",  30, 2, "Water Gun", true));
        pokeDex.add(new Pokemon(91, "Cloyster",  50, 2, "Hydro Pump", false));
        pokeDex.add(new Pokemon(98, "Krabby",  30, 2, "Water Gun", true));
        pokeDex.add(new Pokemon(99, "Kingler",  55, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(116, "Horsea",  30, 2, "Bubble", true));
        pokeDex.add(new Pokemon(117, "Seadra",  55, 2, "Bubble", false));
        pokeDex.add(new Pokemon(118, "Goldeen",  45, 2, "Peck", true));
        pokeDex.add(new Pokemon(119, "Seaking",  80, 2, "Water Pulse", false));
        pokeDex.add(new Pokemon(120, "Staryu",  30, 2, "Tackle", true));
        pokeDex.add(new Pokemon(121, "Starmie",  60, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(130, "Gyarados",  95, 2, "Bite", false));
        pokeDex.add(new Pokemon(131, "Lapras",  130, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(134, "Vaporeon",  130, 2, "Water Gun", false));
        pokeDex.add(new Pokemon(129, "Magikarp", 20, 2, "Splash", true));
        pokeDex.add(new Pokemon(1, "Bulbasaur",  45, 3, "Tackle", true));
        pokeDex.add(new Pokemon(2, "Ivysaur",  60, 3, "Vine Whip", true));
        pokeDex.add(new Pokemon(3, "Venusaur",  80, 3, "Petal Blizzard", false));
        pokeDex.add(new Pokemon(43, "Oddish",  45, 3, "Absorb", true));
        pokeDex.add(new Pokemon(44, "Gloom",  60, 3, "Absorb", true));
        pokeDex.add(new Pokemon(45, "Vileplume",  75, 3, "Giga Drain", false));
        pokeDex.add(new Pokemon(69, "Bellsprout",  50, 3, "Vine Whip", true));
        pokeDex.add(new Pokemon(70, "Weepinbell",  65, 3, "Vine Whip", true));
        pokeDex.add(new Pokemon(71, "Victreebel",  80, 3, "Power Whip", false));
        pokeDex.add(new Pokemon(102, "Exeggcute",  60, 3, "Barrage", true));
        pokeDex.add(new Pokemon(103, "Exeggutor",  95, 3, "Power Whip", false));
        pokeDex.add(new Pokemon(114, "Tangela",  65, 3, "Absorb", false));
        pokeDex.add(new Pokemon(25, "Pikachu",  35, 4, "Nuzzle", true));
        pokeDex.add(new Pokemon(26, "Raichu",  60, 4, "Discharge", false));
        pokeDex.add(new Pokemon(81, "Magnemite",  25, 4, "Tackle", true));
        pokeDex.add(new Pokemon(82, "Magneton",  50, 4, "Thunder Shock", false));
        pokeDex.add(new Pokemon(100, "Voltorb",  40, 4, "Tackle", true));
        pokeDex.add(new Pokemon(101, "Electrode",  60, 4, "Thunder Shock", false));
        pokeDex.add(new Pokemon(125, "Electabuzz",  65, 4, "Thunder Shock", false));
        pokeDex.add(new Pokemon(135, "Jolteon",  65, 4, "Bite", false));
        pokeDex.add(new Pokemon(145, "Zapdos",  90, 4, "Thunder Shock", false));
        pokeDex.add(new Pokemon(124, "Jynx",  65, 5, "Pound", false));
        pokeDex.add(new Pokemon(144, "Articuno",  90, 5, "Ice Shard", false));
        pokeDex.add(new Pokemon(56, "Mankey",  40, 6, "Scratch", true));
        pokeDex.add(new Pokemon(57, "Primeape",  65, 6, "Counter", false));
        pokeDex.add(new Pokemon(66, "Machop",  70, 6, "Low Kick", true));
        pokeDex.add(new Pokemon(67, "Machoke",  80, 6, "Revenge", true));
        pokeDex.add(new Pokemon(68, "Machamp",  90, 6, "Low Kick", false));
        pokeDex.add(new Pokemon(106, "Hitmonlee",  50, 6, "Brick Break", false));
        pokeDex.add(new Pokemon(107, "Hitmonchan",  50, 6, "Drain Punch", false));
        pokeDex.add(new Pokemon(23, "Ekans",  30, 7, "Poison Sting", true));
        pokeDex.add(new Pokemon(24, "Arbok",  60, 7, "Poison Sting", false));
        pokeDex.add(new Pokemon(29, "Nidoran ♀",  55, 7, "Scratch", true));
        pokeDex.add(new Pokemon(30, "Nidorina",  70, 7, "Poison Sting", true));
        pokeDex.add(new Pokemon(31, "Nidoqueen",  90, 7, "Poison Sting", false));
        pokeDex.add(new Pokemon(32, "Nidoran ♂",  46, 7, "Peck", true));
        pokeDex.add(new Pokemon(33, "Nidorino",  61, 7, "Poison Sting", true));
        pokeDex.add(new Pokemon(34, "Nidoking",  81, 7, "Peck", false));
        pokeDex.add(new Pokemon(41, "Zubat",  40, 7, "Absorb", true));
        pokeDex.add(new Pokemon(42, "Golbat",  75, 7, "Bite", false));
        pokeDex.add(new Pokemon(88, "Grimer",  80, 7, "Poison Gas", true));
        pokeDex.add(new Pokemon(89, "Muk",  105, 7, "Poison Gas", false));
        pokeDex.add(new Pokemon(109, "Koffing",  40, 7, "Poison Gas", true));
        pokeDex.add(new Pokemon(110, "Weezing",  65, 7, "Smog", false));
        pokeDex.add(new Pokemon(27, "Sandshrew",  50, 8, "Scratch", true));
        pokeDex.add(new Pokemon(28, "Sandslash",  75, 8, "Counter", false));
        pokeDex.add(new Pokemon(50, "Diglett",  10, 8, "Sand Attack", true));
        pokeDex.add(new Pokemon(51, "Dugtrio",  35, 8, "Astonish", false));
        pokeDex.add(new Pokemon(104, "Cubone",  50, 8, "Tail Whip", true));
        pokeDex.add(new Pokemon(105, "Marowak",  60, 8, "Bone Club", false));
        pokeDex.add(new Pokemon(111, "Rhyhorn",  80, 8, "Tackle", true));
        pokeDex.add(new Pokemon(112, "Rhydon",  105, 8, "Bulldoze", false));
        pokeDex.add(new Pokemon(63, "Abra",  25, 10, "Teleport", true));
        pokeDex.add(new Pokemon(64, "Kadabra",  40, 10, "Confusion", true));
        pokeDex.add(new Pokemon(65, "Alakazam",  55, 10, "Barrier", false));
        pokeDex.add(new Pokemon(96, "Drowzee",  60, 10, "Hypnosis", true));
        pokeDex.add(new Pokemon(97, "Hypno",  85, 10, "Confusion", false));
        pokeDex.add(new Pokemon(122, "Mr. Mime",  40, 10, "Guard Swap", false));
        pokeDex.add(new Pokemon(150, "Mewtwo",  106, 10, "Confusion", false));
        pokeDex.add(new Pokemon(151, "Mew",  100, 10, "Pound", false));
        pokeDex.add(new Pokemon(10, "Caterpie",  45, 11, "Tackle", true));
        pokeDex.add(new Pokemon(12, "Butterfree",  60, 11, "Bug Bite", false));
        pokeDex.add(new Pokemon(13, "Weedle",  40, 11, "Poison Sting", true));
        pokeDex.add(new Pokemon(15, "Beedrill",  65, 11, "Twineedle", false));
        pokeDex.add(new Pokemon(46, "Paras",  35, 11, "Scratch", true));
        pokeDex.add(new Pokemon(47, "Parasect",  60, 11, "Leech Seed", false));
        pokeDex.add(new Pokemon(48, "Venonat",  60, 11, "Tackle", true));
        pokeDex.add(new Pokemon(49, "Venomoth",  70, 11, "Confusion", false));
        pokeDex.add(new Pokemon(123, "Scyther",  70, 11, "Quick Attack", false));
        pokeDex.add(new Pokemon(127, "Pinsir",  65, 11, "Vise Grip", false));
        pokeDex.add(new Pokemon(11, "Metapod",  50, 11, "Harden", true));
        pokeDex.add(new Pokemon(14, "Kakuna",  45, 11, "Harden", true));
        pokeDex.add(new Pokemon(74, "Geodude",  40, 12, "Tackle", true));
        pokeDex.add(new Pokemon(75, "Graveler",  55, 12, "Sand Attack", true));
        pokeDex.add(new Pokemon(76, "Golem",  80, 12, "Mega Punch", false));
        pokeDex.add(new Pokemon(95, "Onix",  35, 12, "Rock Throw", false));
        pokeDex.add(new Pokemon(138, "Omanyte",  35, 12, "Constrict", true));
        pokeDex.add(new Pokemon(139, "Omastar",  70, 12, "Bide", false));
        pokeDex.add(new Pokemon(140, "Kabuto",  30, 12, "Scratch", true));
        pokeDex.add(new Pokemon(141, "Kabutops",  60, 12, "Absorb", false));
        pokeDex.add(new Pokemon(142, "Aerodactyl",  80, 12, "Bite", false));
        pokeDex.add(new Pokemon(92, "Gastly",  30, 13, "Lick", true));
        pokeDex.add(new Pokemon(93, "Haunter",  45, 13, "Lick", true));
        pokeDex.add(new Pokemon(94, "Gengar",  60, 13, "Lick", false));
        pokeDex.add(new Pokemon(147, "Dratini",  41, 14, "Wrap", true));
        pokeDex.add(new Pokemon(148, "Dragonair",  61, 14, "Dragon Rage", true));
        pokeDex.add(new Pokemon(149, "Dragonite",  91, 14, "Aqua Jet", false));
        
        pokeDex.get(60).getAttacks().get(0).setHp(0);
        pokeDex.get(125).getAttacks().get(0).setHp(0);
        pokeDex.get(128).getAttacks().get(0).setHp(0);
    }
    
    public static Pokemon getPokemon(int index) {
        return pokeDex.get(index);
    }
    
    public static ArrayList<Pokemon> getPokeDex() {
        return pokeDex;
    }
    
}