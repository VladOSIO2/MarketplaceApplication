package utility;

import dbemulator.DBEmulator;

public class CommandHandler {
    private static final String HELP_MESSAGE = """
    List of available commands:
    /help
    \tprints list of available commands
    /users_list
    \tprints info about all users
    /products_list
    \tprints info about all products
    /purchase <USER_ID> <PRODUCT_ID>
    \tmakes a purchase of chosen product for a chosen user
    """;

    //TODO
    public static String handle(String command) {
        String[] args = command.split("\\s+");
        if (args.length < 1) {
            return "Command must not be empty!";
        }
        return switch (args[0]) {
            case "/help" -> HELP_MESSAGE;
            case "/users_list" -> DBEmulator.getUsersAsString();
            case "/products_list" -> DBEmulator.getProductsAsString();
            default -> "";
        };
    }
}
