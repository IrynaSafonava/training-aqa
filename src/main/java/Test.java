public class Test {

    public static void main(String[] args) {


        String result = "Total Estimated Cost: USD 1,288.71 per 1 month";
        System.out.println(result.substring(result.indexOf(':') + 6, result.indexOf('p')-1));
        String result2 = "Estimated Monthly Cost: USD 1,082.77";
        System.out.println(result2.substring(result.indexOf(':') + 8));

    }
}
