package sk.stuba.fei.uim.oop;


public class Colors {
    public static final String RESET = "\033[0m";  // Text Reset
    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String LIGHT_PURPLE = "\033[38;2;200;0;200m"; //LIGHT PURPLE
    public static final String TEAL = "\033[38;2;0;225;221m"; //TEAL
    public static final String ORANGE = "\033[38;2;225;153;0m"; //ORANGE
    public static final String LIGHT_GREEN = "\033[38;2;136;255;0m"; //LIGHT GREEN
    public static final String LIGHT_BLUE = "\033[38;2;120;172;255m"; //LIGHT BLUE
    public static final String DARK_BLUE = "\033[38;2;72;0;255m"; //DARK BLUE
    public static final String ROSY_PINK = "\033[38;2;255;0;162m"; //ROSY PINK
    public static final String BROWN = "\033[38;2;135;82;62m"; //BROWN
    public static final String FOREST_GREEN = "\033[38;2;62;135;81m"; //FOREST GREEN
    public static final String BANANA_YELLOW = "\033[38;2;240;238;113m"; //BANANA YELLOW
    public static final String DARK_RED = "\033[38;2;145;40;16m"; //DARK RED
    public static final String LIGHT_PINK = "\033[38;2;255;153;240m"; //LIGHT PINK

    public static String chooseColor(String color){
        switch (color) {
            case "BLACK":
                return Colors.BLACK;
            case "RED":
                return RED;
            case "GREEN":
                return GREEN;
            case "YELLOW":
                return YELLOW;
            case "BLUE":
                return BLUE;
            case "PURPLE":
                return PURPLE;
            case "CYAN":
                return CYAN;
            case "WHITE":
                return WHITE;
            case "LIGHT_GREEN":
                return LIGHT_GREEN;
            case "LIGHT_BLUE":
                return LIGHT_BLUE;
            case "ORANGE":
                return ORANGE;
            case "BROWN":
                return BROWN;
            case "TEAL":
                return TEAL;
            default:
                return RESET;
        }
    }

}