import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {

    public List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();

        // 定义分隔符
        String delimiters = " ,.!?;:\"()[]{}";

        // 使用 StringTokenizer 来拆分字符串
        StringTokenizer tokenizer = new StringTokenizer(input, delimiters);

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        String input = "75 + 5 * 5 = 100";
        List<String> tokens = tokenizer.tokenize(input);

        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
