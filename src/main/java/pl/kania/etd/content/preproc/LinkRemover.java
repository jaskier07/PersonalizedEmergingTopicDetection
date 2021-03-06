package pl.kania.etd.content.preproc;

public class LinkRemover {

    private static final String PATTERN = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";

    static String remove(String text) {
        text = text.replaceAll(PATTERN, " ");
        text = text.replaceAll("https", " ");
        text = text.replaceAll("http", " ");
        return text;
    }
}
