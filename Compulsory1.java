public class Main {
    public static void main(String[] args) {
        System.out.print("Hello World!\n");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1000000);

        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;

        int r = 0;
        while(n > 10){
            while(n != 0){
                r = r + (n%10);
                n = n/10;
            }
            n = r;
            r = 0;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }
}
