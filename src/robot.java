public class robot {
    public static void main(String[] args) {
        robot("DOWN UP 2xRIGHT DOWN 3xLEFT");
    }

    public static void robot (String moves) {
        StringBuilder finalString = new StringBuilder();
        if (moves.contains(" ")) {
            String[] movesStr = moves.split(" ");
            for (int j =0; j<movesStr.length; j++) {
                if (movesStr[j].contains("x")) {
                    finalString.append(getString(movesStr[j]));
                } else {
                    finalString.append(movesStr[j].charAt(0));
                }
            }
        } else {
            finalString.append(moves);
        }
        if (finalString.length() == 0) {
            System.out.println("(0,0)");
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < finalString.length(); i++) {
            if (finalString.charAt(i) == 'U') {
                y++;
            } else if (finalString.charAt(i) == 'D') {
                y--;
            } else if (finalString.charAt(i) == 'L') {
                x--;
            } else if (finalString.charAt(i) == 'R') {
                x++;
            }
        }
        System.out.println(x+","+y);
    }


    public static StringBuilder getString(String move) {
        String[] countStr = move.split("x");
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(countStr[0]); i++) {
            resultString.append(countStr[1].charAt(0));
        }
        return resultString;
    }
}
