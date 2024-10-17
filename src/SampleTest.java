public class SampleTest {
    public static void main(String[] args) {
        String str = "abcd";
        int strLength = str.length() - 1;
        StringBuilder sb = new StringBuilder( strLength );
        for( int i = strLength; i-- >= 0; )
        {

            System.out.println(str.charAt(i));
            sb.append(str.charAt(i));
            strLength += i;
        };
        System.out.println(sb.toString());

    }
}
