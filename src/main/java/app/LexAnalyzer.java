package app;

import lombok.Data;

import java.util.List;

@Data
public class LexAnalyzer {
    private final List<Character> constraints;
    private final List<Integer> numbers;
    private final List<Lexeme> lexemes;

    public LexAnalyzer(app.Data data) {
        constraints = app.Data.getConstraints();
        numbers = data.getNumbers();
        lexemes = data.getLexemes();
    }

    public void analyze(String in) throws InvalidDataException {
        validate(in);
        int pos = 0;
        while (pos < in.length()) {
            char c = in.charAt(pos);
            if (c == '#') {
                break;
            }
            if (c <= '9' && c >= '0') {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append(c);
                    pos++;
                    if (pos >= in.length()) {
                        break;
                    }
                    c = in.charAt(pos);
                } while (c <= '9' && c >= '0');
                lexemes.add(new Lexeme(LexType.NUMBER, getNumberIndex(Integer.valueOf(sb.toString()))));
            } else {
                int index = constraints.indexOf(c);
                if (index > -1) {
                    lexemes.add(new Lexeme(LexType.CONSTRAINT, index));
                } else {
                    if (c != ' ' && c != '\n' && c != '\t') {
                        throw new InvalidDataException("invalid symbol at pos: " + pos);
                    }
                }
                pos++;
            }

        }
    }  

    

    private void validate(String str) throws InvalidDataException {
        if (str.contains("#")) return;
        throw new InvalidDataException("symbol '#' not found");
    }

    private int getNumberIndex(Integer value) {
        int index = numbers.indexOf(value);
        if (index > -1) {
            return index;
        }
        numbers.add(value);
        return numbers.size() - 1;
    }
}
