public class HumanReadableTime {
    public static void main(String[] args) {
        System.out.println(humanReadableTime(123132));
    }

    public static String humanReadableTime(int c) {
        int hoursInSeconds = 3600;
        int minutesSeconds = 60;

        StringBuilder a = new StringBuilder();

        int hours = c / hoursInSeconds;
        int minutes = (c % hoursInSeconds) / minutesSeconds;
        int seconds = c % minutesSeconds;

        if (String.valueOf(hours).length() == 1) {
            a.append("0");
        }
        a.append(hours).append(":");

        if (String.valueOf(minutes).length() == 1) {
            a.append("0");
        }
        a.append(minutes).append(":");
        if (String.valueOf(seconds).length() == 1) {
            a.append("0");
        }
        a.append(seconds);

        return String.valueOf(a);
    }

}
