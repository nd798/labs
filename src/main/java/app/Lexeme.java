package app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Lexeme {
    private final LexType type;
    private final int index;

    @Override
    public String toString() {
        return "type = " + type + ", index = " + index;
    }
}
