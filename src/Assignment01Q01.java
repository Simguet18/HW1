public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String s : args) {
            if (s.charAt(0) % 5 == 0) {
                System.out.println(s.charAt(0));
            } 
        }
    }
}
