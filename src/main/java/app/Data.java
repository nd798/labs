package app;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Data {
    @Getter
    private final static List<Character> constraints = new ArrayList<>(Arrays.asList('+', '-', '*', '/', '(', ')'));
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Lexeme> lexemes = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lexemes.forEach(lex -> {
            switch (lex.getType()) {
                case NUMBER:
                    sb.append(lex).append(", value = \"").append(numbers.get(lex.getIndex())).append("\"\n");
                    break;
                case CONSTRAINT:
                    sb.append(lex).append(", value = \"").append(constraints.get(lex.getIndex())).append("\"\n");
                    break;
            }
        });
        return sb.toString();
    }
}
