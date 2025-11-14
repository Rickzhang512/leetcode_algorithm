import java.util.List;

public class Parser {
    private List<String> tokens;
    private int currentTokenIndex;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
        this.currentTokenIndex = 0;
    }

    private boolean hasNextToken() {
        return currentTokenIndex < tokens.size();
    }

    private String nextToken() {
        if (hasNextToken()) {
            return tokens.get(currentTokenIndex++);
        }
        throw new RuntimeException("No more tokens");
    }

    public void parse() {
        int result = parseExpression();
        System.out.println("Result: " + result);
    }

    private int parseExpression() {
        int value = parseTerm();
        while (hasNextToken()) {
            String token = nextToken();
            if (token.equals("+")) {
                value += parseTerm();
            } else if (token.equals("-")) {
                value -= parseTerm();
            } else {
                throw new RuntimeException("Unexpected token: " + token);
            }
        }
        return value;
    }

    private int parseTerm() {
        if (hasNextToken()) {
            String token = nextToken();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid number: " + token);
            }
        }
        throw new RuntimeException("No more tokens");
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        String input = "4 - 2 - 2";
        List<String> tokens = tokenizer.tokenize(input);

        Parser parser = new Parser(tokens);
        parser.parse();
    }
}
