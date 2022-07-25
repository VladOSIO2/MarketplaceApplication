package utility;

import dbemulator.DBEmulator;

import java.math.BigDecimal;

public class CommandHandler {
    private static final String NOT_ENOUGH_ARGS_MSG = "Not enough arguments!";
    private static final String HELP_MSG = """
    List of available commands:
    /help
    \tprints list of available commands
    /users_list
    \tprints info about all users
    /products_list
    \tprints info about all products
    /purchase <USER_ID> <PRODUCT_ID>
    \tmakes a purchase of chosen product for a chosen user
    /add_user <FIRST_NAME> <LAST_NAME> <MONEY>
    \tcreates a new user with corresponding FIRST_NAME, LAST_NAME, MONEY properties
    /add_product <NAME> <PRICE>
    \tcreates a new product with corresponding NAME & PRICE
    /delete_product <PRODUCT_ID>
    \tdeletes product with PRODUCT_ID from the database
    """;

    public static String handle(String command) {
        String[] args = command.split("\\s+");
        if (args.length < 1) {
            return "Command must not be empty!";
        }
        try {
            return switch (args[0]) {
                case "/help" -> HELP_MSG;
                case "/users_list" -> DBEmulator.getUsersAsString();
                case "/products_list" -> DBEmulator.getProductsAsString();
                case "/purchase" -> handlePurchase(args);
                case "/add_user" -> handleAddUser(args);
                case "/add_product" -> handleAddProduct(args);
                case "/delete_product" -> handleDeleteProduct(args);
                default -> "Unknown command: " + args[0];
            };
        } catch (NumberFormatException e) {
            return "Number parsing error: " + e.getMessage();
        }
    }

    private static String handlePurchase(String[] args) {
        if (args.length < 3) {
            return NOT_ENOUGH_ARGS_MSG;
        }
        return DBEmulator.addPurchase(
                Integer.parseInt(args[1]),  //userID
                Integer.parseInt(args[2])   //productID
        );
    }

    private static String handleAddUser(String[] args) {
        if (args.length < 4) {
            return NOT_ENOUGH_ARGS_MSG;
        }
        return DBEmulator.addUser(
                args[1],                    //first name
                args[2],                    //last name
                new BigDecimal(args[3])     //money
        );
    }

    private static String handleAddProduct(String[] args) {
        if (args.length < 3) {
            return NOT_ENOUGH_ARGS_MSG;
        }
        return DBEmulator.addProduct(
                args[1],                //name
                new BigDecimal(args[2]) //price
        );
    }

    private static String handleDeleteProduct(String[] args) {
        if (args.length < 2) {
            return NOT_ENOUGH_ARGS_MSG;
        }
        return DBEmulator.deleteProductByID(Integer.parseInt(args[1]));
    }
}
