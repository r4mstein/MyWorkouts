package ua.r4mstein.myworkouts;

import java.util.Arrays;
import java.util.List;

public class MyUtils {

    public static final String PROGRAM_NAME = "program_name";
    public static final String PROGRAM_DAY = "program_day";
    public static final String PROGRAM_END = "end_of_program";
    public static final String IS_PROGRAM_SELECTED = "is_program_selected";

    public static String[] titles = new String[]{"Program 1", "Program 2", "Program 3",
            "Program 4", "Program 5", "Program 6", "Program 7", "Program 8", "Program 9",
            "Program 10", "Program 11", "Program 12", "Program 13", "Program 14", "Program 15"};

    /*
        Lists and constants for pushups
     */

    public static final String PUSHUPS_APP_PREFERENCES = "pushups_settings";
    public static final String EXERCISE_PUSHUPS = "exercise_pushups";

    public static String[] pushupsSubtitles = new String[]{"Less than 5 pushups?", "6 - 10 pushups?",
            "11 - 20 pushups?", "21 - 25 pushups?", "26 - 30 pushups?", "31 - 35 pushups?",
            "36 - 40 pushups?", "41 - 45 pushups?", "46 - 50 pushups?", "51 - 55 pushups?",
            "56 - 60 pushups?", "More than 60 pushups?"};

    public static List<int[]> pushupsProgram1 = Arrays.asList(new int[]{2, 3, 2, 2, 3},
            new int[]{3, 4, 2, 3, 4}, new int[]{4, 5, 4, 4, 5}, new int[]{5, 6, 4, 4, 6},
            new int[]{5, 6, 4, 4, 7}, new int[]{5, 7, 5, 5, 7});

    public static List<int[]> pushupsProgram2 = Arrays.asList(new int[]{5, 6, 4, 4, 5},
            new int[]{6, 7, 6, 6, 7}, new int[]{8, 10, 7, 7, 10}, new int[]{9, 11, 8, 8, 11},
            new int[]{10, 12, 9, 9, 13}, new int[]{12, 13, 10, 10, 15});

    public static List<int[]> pushupsProgram3 = Arrays.asList(new int[]{8, 9, 7, 7, 8},
            new int[]{9, 10, 8, 8, 10}, new int[]{11, 13, 9, 9, 13}, new int[]{12, 14, 10, 10, 15},
            new int[]{13, 15, 11, 11, 17}, new int[]{14, 16, 13, 13, 19});

    public static List<int[]> pushupsProgram4 = Arrays.asList(new int[]{12, 17, 13, 13, 17},
            new int[]{14, 19, 14, 14, 19}, new int[]{16, 21, 15, 15, 21}, new int[]{18, 22, 16, 16, 21},
            new int[]{20, 25, 20, 20, 23}, new int[]{23, 28, 22, 22, 25});

    public static List<int[]> pushupsProgram5 = Arrays.asList(new int[]{14, 18, 14, 14, 20},
            new int[]{20, 25, 15, 15, 23}, new int[]{20, 27, 18, 18, 25}, new int[]{21, 25, 21, 21, 27},
            new int[]{25, 29, 25, 25, 30}, new int[]{29, 33, 29, 29, 33});

    public static List<int[]> pushupsProgram6 = Arrays.asList(new int[]{17, 19, 15, 15, 20},
            new int[]{10, 10, 13, 13, 10, 10, 9, 25}, new int[]{13, 13, 15, 15, 12, 12, 10, 30});

    public static List<int[]> pushupsProgram7 = Arrays.asList(new int[]{22, 24, 20, 20, 25},
            new int[]{15, 15, 18, 18, 15, 15, 14, 30}, new int[]{18, 18, 20, 20, 17, 17, 15, 35});

    public static List<int[]> pushupsProgram8 = Arrays.asList(new int[]{27, 29, 25, 25, 35},
            new int[]{19, 19, 22, 22, 18, 18, 22, 35}, new int[]{20, 20, 24, 24, 20, 20, 22, 40});

    public static List<int[]> pushupsProgram9 = Arrays.asList(new int[]{30, 34, 30, 30, 40},
            new int[]{19, 19, 23, 23, 19, 19, 22, 37}, new int[]{20, 20, 27, 27, 21, 21, 21, 44});

    public static List<int[]> pushupsProgram10 = Arrays.asList(new int[]{30, 39, 35, 35, 42},
            new int[]{20, 20, 23, 23, 20, 20, 18, 18, 53}, new int[]{22, 22, 30, 30, 25, 25, 18, 18, 55});

    public static List<int[]> pushupsProgram11 = Arrays.asList(new int[]{30, 44, 40, 40, 55},
            new int[]{22, 22, 27, 27, 24, 23, 18, 18, 58}, new int[]{26, 26, 33, 33, 26, 26, 22, 22, 60});

    public static List<int[]> pushupsProgram12 = Arrays.asList(new int[]{35, 49, 45, 45, 55},
            new int[]{22, 22, 30, 30, 24, 24, 18, 18, 59}, new int[]{28, 28, 35, 35, 27, 27, 23, 23, 60});

    /*
        Lists and constants for pullups
     */

    public static final String PULLUPS_APP_PREFERENCES = "pullups_settings";
    public static final String EXERCISE_PULLUPS = "exercise_pullups";

    public static String[] pullupsSubtitles = new String[]{"Less than 4 pullups?", "4 - 5 pullups?",
            "6 - 8 pullups?", "9 - 11 pullups?", "12 - 15 pullups?", "16 - 20 pullups?",
            "21 - 25 pullups?", "26 - 30 pullups?", "31 - 35 pullups?", "36 - 40 pullups?",
            "More than 40 pullups?"};

    public static List<int[]> pullupsProgram1 = Arrays.asList(new int[]{2, 7, 5, 5, 7},
            new int[]{3, 8, 6, 6, 8}, new int[]{4, 9, 6, 6, 8}, new int[]{5, 8, 7, 7, 9},
            new int[]{5, 10, 8, 8, 10}, new int[]{6, 10, 8, 8, 11});  // pulldown

    public static List<int[]> pullupsProgram2 = Arrays.asList(new int[]{4, 9, 6, 6, 9},
            new int[]{5, 9, 7, 7, 9}, new int[]{6, 10, 8, 8, 10}, new int[]{6, 11, 8, 8, 11},
            new int[]{7, 12, 10, 10, 12}, new int[]{8, 14, 11, 11, 14});  // pulldown

    public static List<int[]> pullupsProgram3 = Arrays.asList(new int[]{2, 3, 2, 2, 3},
            new int[]{2, 3, 2, 2, 4}, new int[]{3, 4, 2, 2, 4}, new int[]{3, 4, 3, 3, 4},
            new int[]{3, 4, 3, 3, 5}, new int[]{4, 5, 4, 4, 6});

    public static List<int[]> pullupsProgram4 = Arrays.asList(new int[]{3, 5, 3, 3, 5},
            new int[]{4, 6, 4, 4, 6}, new int[]{5, 7, 5, 5, 6}, new int[]{5, 8, 5, 5, 8},
            new int[]{6, 9, 6, 6, 8}, new int[]{6, 9, 6, 6, 10});

    public static List<int[]> pullupsProgram5 = Arrays.asList(new int[]{6, 8, 6, 6, 8},
            new int[]{6, 9, 6, 6, 9}, new int[]{7, 10, 6, 6, 9}, new int[]{7, 10, 7, 7, 10},
            new int[]{8, 11, 8, 8, 10}, new int[]{9, 11, 9, 9, 11});

    public static List<int[]> pullupsProgram6 = Arrays.asList(new int[]{8, 11, 8, 8, 10},
            new int[]{9, 12, 9, 9, 11}, new int[]{9, 13, 9, 9, 12}, new int[]{10, 14, 10, 10, 13},
            new int[]{11, 15, 10, 10, 13}, new int[]{11, 15, 11, 11, 13}, new int[]{12, 16, 11, 11, 15},
            new int[]{12, 16, 12, 12, 16}, new int[]{13, 17, 13, 13, 16});

    public static List<int[]> pullupsProgram7 = Arrays.asList(new int[]{12, 16, 12, 12, 15},
            new int[]{13, 16, 12, 12, 16}, new int[]{13, 17, 12, 12, 16}, new int[]{14, 19, 13, 13, 18},
            new int[]{14, 19, 14, 14, 19}, new int[]{15, 20, 14, 14, 20}, new int[]{16, 20, 16, 16, 20},
            new int[]{16, 21, 16, 16, 20}, new int[]{17, 22, 16, 16, 21});

    public static List<int[]> pullupsProgram8 = Arrays.asList(new int[]{16, 18, 15, 15, 17},
            new int[]{16, 20, 16, 16, 19}, new int[]{17, 21, 16, 16, 20}, new int[]{17, 22, 17, 17, 22},
            new int[]{18, 23, 18, 18, 22}, new int[]{19, 25, 18, 18, 24}, new int[]{19, 26, 18, 18, 25},
            new int[]{19, 27, 19, 19, 26}, new int[]{20, 28, 20, 20, 28});

    public static List<int[]> pullupsProgram9 = Arrays.asList(new int[]{20, 25, 19, 19, 23},
            new int[]{22, 25, 21, 21, 25}, new int[]{23, 26, 23, 23, 25}, new int[]{24, 27, 24, 24, 26},
            new int[]{25, 28, 24, 24, 27}, new int[]{25, 29, 25, 25, 28}, new int[]{26, 29, 25, 25, 29},
            new int[]{26, 30, 26, 26, 30}, new int[]{26, 32, 26, 26, 32});

    public static List<int[]> pullupsProgram10 = Arrays.asList(new int[]{23, 27, 22, 22, 26},
            new int[]{24, 28, 24, 24, 28}, new int[]{25, 29, 24, 24, 29}, new int[]{26, 30, 25, 25, 30},
            new int[]{26, 31, 25, 25, 31}, new int[]{26, 31, 26, 26, 31}, new int[]{27, 31, 26, 26, 32},
            new int[]{28, 32, 26, 26, 32}, new int[]{28, 34, 27, 27, 34});

    public static List<int[]> pullupsProgram11 = Arrays.asList(new int[]{25, 28, 24, 24, 26},
            new int[]{25, 29, 25, 25, 28}, new int[]{25, 30, 25, 25, 29}, new int[]{26, 31, 25, 25, 31},
            new int[]{26, 32, 26, 26, 32}, new int[]{27, 32, 26, 26, 32}, new int[]{27, 34, 26, 26, 33},
            new int[]{28, 34, 26, 26, 34}, new int[]{29, 35, 27, 27, 35});

    /*
        Lists and constants for squats
     */

    public static final String SQUATS_APP_PREFERENCES = "squats_settings";
    public static final String EXERCISE_SQUATS = "exercise_squats";

    public static String[] squatsSubtitles = new String[]{"1 - 20 squats?", "21 - 40 squats?",
            "41 - 60 squats?", "61 - 80 squats?", "81 - 100 squats?", "101 - 125 squats?",
            "126 - 150 squats?", "151 - 175 squats?", "176 - 200 squats?", "201 - 220 squats?",
            "221 - 240 squats?", "241 - 260 squats?", "261 - 275 squats?", "246 - 290 squats?",
            "291 - 300 squats?"};

    public static List<int[]> squatsProgram1 = Arrays.asList(new int[]{4, 6, 6, 7, 7},
            new int[]{6, 6, 6, 8, 8}, new int[]{8, 6, 6, 8, 8}, new int[]{8, 8, 8, 6, 8},
            new int[]{8, 8, 6, 8, 10}, new int[]{8, 8, 8, 8, 10});

    public static List<int[]> squatsProgram2 = Arrays.asList(new int[]{8, 8, 8, 10, 10},
            new int[]{10, 10, 10, 8, 10}, new int[]{12, 10, 10, 12, 12}, new int[]{12, 12, 12, 12, 12},
            new int[]{12, 12, 14, 14, 16}, new int[]{14, 12, 14, 16, 15});

    public static List<int[]> squatsProgram3 = Arrays.asList(new int[]{16, 16, 16, 18, 16},
            new int[]{16, 14, 14, 18, 18}, new int[]{18, 18, 16, 16, 18}, new int[]{20, 20, 18, 18, 22},
            new int[]{22, 22, 18, 18, 22}, new int[]{22, 22, 20, 20, 24});

    public static List<int[]> squatsProgram4 = Arrays.asList(new int[]{22, 22, 22, 22, 24},
            new int[]{22, 22, 22, 24, 24}, new int[]{22, 24, 24, 22, 24}, new int[]{24, 24, 24, 22, 26},
            new int[]{24, 24, 24, 24, 26}, new int[]{26, 26, 24, 24, 28});

    public static List<int[]> squatsProgram5 = Arrays.asList(new int[]{26, 26, 26, 26, 28},
            new int[]{26, 26, 26, 28, 28}, new int[]{28, 26, 26, 28, 30}, new int[]{28, 28, 28, 28, 30},
            new int[]{28, 28, 30, 30, 30}, new int[]{30, 30, 28, 30, 32});

    public static List<int[]> squatsProgram6 = Arrays.asList(new int[]{32, 32, 30, 30, 32},
            new int[]{32, 32, 32, 32, 34}, new int[]{34, 32, 32, 34, 36}, new int[]{34, 34, 34, 36, 36},
            new int[]{36, 36, 34, 34, 36}, new int[]{36, 36, 36, 34, 38});

    public static List<int[]> squatsProgram7 = Arrays.asList(new int[]{38, 36, 36, 40, 40},
            new int[]{40, 38, 38, 38, 40}, new int[]{40, 38, 38, 40, 42}, new int[]{40, 40, 42, 40, 40},
            new int[]{40, 40, 42, 42, 40}, new int[]{42, 42, 40, 40, 46});

    public static List<int[]> squatsProgram8 = Arrays.asList(new int[]{44, 44, 40, 40, 46},
            new int[]{44, 44, 46, 46, 46}, new int[]{46, 46, 46, 44, 46}, new int[]{46, 46, 46, 44, 48},
            new int[]{46, 46, 46, 48, 48}, new int[]{48, 48, 46, 46, 50});

    public static List<int[]> squatsProgram9 = Arrays.asList(new int[]{50, 50, 48, 48, 50},
            new int[]{50, 50, 50, 48, 52}, new int[]{52, 52, 50, 50, 52}, new int[]{52, 52, 52, 50, 54},
            new int[]{54, 52, 52, 52, 56}, new int[]{52, 52, 54, 52, 60});

    public static List<int[]> squatsProgram10 = Arrays.asList(new int[]{52, 52, 54, 54, 60},
            new int[]{54, 54, 54, 54, 60}, new int[]{58, 54, 54, 54, 60}, new int[]{58, 58, 54, 54, 60},
            new int[]{58, 58, 56, 56, 60}, new int[]{58, 58, 58, 56, 62});

    public static List<int[]> squatsProgram11 = Arrays.asList(new int[]{50, 40, 42, 42, 42, 42, 44},
            new int[]{50, 50, 42, 42, 42, 42, 44}, new int[]{50, 50, 42, 42, 42, 42, 50},
            new int[]{52, 52, 44, 44, 44, 42, 52}, new int[]{44, 44, 52, 52, 50, 50, 54},
            new int[]{44, 44, 52, 52, 50, 50, 56});

    public static List<int[]> squatsProgram12 = Arrays.asList(new int[]{50, 50, 52, 52, 50, 50, 56},
            new int[]{50, 50, 52, 52, 54, 54, 56}, new int[]{54, 54, 52, 50, 50, 56, 56},
            new int[]{56, 56, 52, 50, 50, 56, 58}, new int[]{58, 58, 52, 52, 50, 56, 58},
            new int[]{58, 58, 52, 52, 52, 58, 60});

    public static List<int[]> squatsProgram13 = Arrays.asList(new int[]{60, 60, 52, 52, 52, 50, 60},
            new int[]{58, 58, 54, 58, 54, 60, 60}, new int[]{60, 60, 58, 54, 54, 60, 62},
            new int[]{60, 60, 58, 56, 56, 62, 62}, new int[]{60, 60, 58, 58, 58, 62, 62},
            new int[]{60, 60, 60, 60, 60, 62, 64});

    public static List<int[]> squatsProgram14 = Arrays.asList(new int[]{64, 64, 60, 60, 60, 60, 64},
            new int[]{64, 64, 64, 60, 60, 60, 64}, new int[]{64, 64, 64, 64, 60, 60, 64},
            new int[]{64, 64, 64, 64, 60, 64, 66}, new int[]{64, 64, 64, 64, 64, 64, 66},
            new int[]{66, 66, 64, 64, 64, 64, 68});

    public static List<int[]> squatsProgram15 = Arrays.asList(new int[]{66, 66, 66, 64, 64, 64, 68},
            new int[]{68, 68, 66, 66, 66, 64, 68}, new int[]{68, 68, 68, 68, 68, 64, 68},
            new int[]{68, 68, 68, 68, 68, 68, 70}, new int[]{70, 70, 68, 68, 68, 68, 72},
            new int[]{70, 70, 70, 70, 70, 72, 72});

    /*
        Lists and constants for squats
     */

    public static final String DIPS_APP_PREFERENCES = "dips_settings";
    public static final String EXERCISE_DIPS = "exercise_dips";

    public static String[] dipsSubtitles = new String[]{"Less than 5 dips?", "6 - 10 dips?",
            "11 - 20 dips?", "21 - 25 dips?", "26 - 30 dips?", "31 - 35 dips?",
            "36 - 40 dips?", "41 - 45 dips?", "46 - 50 dips?", "51 - 55 dips?",
            "56 - 60 dips?", "More than 60 dips?"};

    public static List<int[]> dipsProgram1 = Arrays.asList(new int[]{2, 3, 2, 2, 3},
            new int[]{3, 4, 2, 3, 4}, new int[]{4, 5, 4, 4, 5}, new int[]{5, 6, 4, 4, 6},
            new int[]{5, 6, 4, 4, 7}, new int[]{5, 7, 5, 5, 7});

    public static List<int[]> dipsProgram2 = Arrays.asList(new int[]{5, 6, 4, 4, 5},
            new int[]{6, 7, 6, 6, 7}, new int[]{8, 10, 7, 7, 10}, new int[]{9, 11, 8, 8, 11},
            new int[]{10, 12, 9, 9, 13}, new int[]{12, 13, 10, 10, 15});

    public static List<int[]> dipsProgram3 = Arrays.asList(new int[]{8, 9, 7, 7, 8},
            new int[]{9, 10, 8, 8, 10}, new int[]{11, 13, 9, 9, 13}, new int[]{12, 14, 10, 10, 15},
            new int[]{13, 15, 11, 11, 17}, new int[]{14, 16, 13, 13, 19});

    public static List<int[]> dipsProgram4 = Arrays.asList(new int[]{12, 17, 13, 13, 17},
            new int[]{14, 19, 14, 14, 19}, new int[]{16, 21, 15, 15, 21}, new int[]{18, 22, 16, 16, 21},
            new int[]{20, 25, 20, 20, 23}, new int[]{23, 28, 22, 22, 25});

    public static List<int[]> dipsProgram5 = Arrays.asList(new int[]{14, 18, 14, 14, 20},
            new int[]{20, 25, 15, 15, 23}, new int[]{20, 27, 18, 18, 25}, new int[]{21, 25, 21, 21, 27},
            new int[]{25, 29, 25, 25, 30}, new int[]{29, 33, 29, 29, 33});

    public static List<int[]> dipsProgram6 = Arrays.asList(new int[]{17, 19, 15, 15, 20},
            new int[]{10, 10, 13, 13, 10, 10, 9, 25}, new int[]{13, 13, 15, 15, 12, 12, 10, 30});

    public static List<int[]> dipsProgram7 = Arrays.asList(new int[]{22, 24, 20, 20, 25},
            new int[]{15, 15, 18, 18, 15, 15, 14, 30}, new int[]{18, 18, 20, 20, 17, 17, 15, 35});

    public static List<int[]> dipsProgram8 = Arrays.asList(new int[]{27, 29, 25, 25, 35},
            new int[]{19, 19, 22, 22, 18, 18, 22, 35}, new int[]{20, 20, 24, 24, 20, 20, 22, 40});

    public static List<int[]> dipsProgram9 = Arrays.asList(new int[]{30, 34, 30, 30, 40},
            new int[]{19, 19, 23, 23, 19, 19, 22, 37}, new int[]{20, 20, 27, 27, 21, 21, 21, 44});

    public static List<int[]> dipsProgram10 = Arrays.asList(new int[]{30, 39, 35, 35, 42},
            new int[]{20, 20, 23, 23, 20, 20, 18, 18, 53}, new int[]{22, 22, 30, 30, 25, 25, 18, 18, 55});

    public static List<int[]> dipsProgram11 = Arrays.asList(new int[]{30, 44, 40, 40, 55},
            new int[]{22, 22, 27, 27, 24, 23, 18, 18, 58}, new int[]{26, 26, 33, 33, 26, 26, 22, 22, 60});

    public static List<int[]> dipsProgram12 = Arrays.asList(new int[]{35, 49, 45, 45, 55},
            new int[]{22, 22, 30, 30, 24, 24, 18, 18, 59}, new int[]{28, 28, 35, 35, 27, 27, 23, 23, 60});
}

