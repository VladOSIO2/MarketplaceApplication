package dbemulator;

import entities.Product;
import entities.User;
import utility.Util;

import java.math.BigDecimal;
import java.util.*;


/*Database emulator class
* Creates empty lists of products & users on each program launch
* and a map User:List of bought products
*/
public class DBEmulator {
    private static final List<Product> products = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static final HashMap<User, List<Product>> purchasesMap = new HashMap<>();

    private static int nextProductID = 1;
    private static int nextUserID = 1;

    public static String addProduct(String name, BigDecimal price) {
        if (Util.isInvalidString(name)) {
            return "Invalid name input!";
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            return "Price must be greater than 0!";
        }

        products.add(new Product(nextProductID, name, price));
        return "Added product with ID: " + nextProductID++;
    }


    public static String addUser(String firstName, String lastName, BigDecimal money) {
        if (Util.isInvalidString(firstName)
                || Util.isInvalidString(lastName)) {
            return "Invalid name input!";
        }

        if (Util.isInvalidMoneyAmount(money)) {
            return "Amount of user's money should be positive!";
        }

        users.add(new User(nextUserID, firstName, lastName, money));
        return "added user with ID: " + nextUserID++;
    }

    public static String addPurchase(int userID, int productID) {
        int userIndex = getUserIndex(userID);
        if (userIndex == -1) {
            return "No such user with ID: " + userID;
        }

        int productIndex = getProductIndex(productID);
        if (productIndex == -1) {
            return "No such product with ID: " + productID;
        }

        User user = users.get(userIndex);
        Product product = products.get(productIndex);
        if (!user.hasMoneyAmount(product.price())) {
            return "user %d doesn't have enough money to buy product %d"
                    .formatted(user.getId(), product.id());
        }

        /*
        adding a product to user's purchase list
        adding a user to a map if it's user's first purchase
         */
        if (!purchasesMap.containsKey(user)) {
            purchasesMap.put(user, new ArrayList<>());
        }
        purchasesMap.get(user).add(product);
        return "for user %d (%s): added purchase of product %d (%s)."
                .formatted(userID, user.getFirstName() + " " + user.getLastName(),
                        productID, product.name());
    }

    private static int getUserIndex(int userID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userID) {
                return i;
            }
        }
        return -1;
    }

    private static int getProductIndex(int userID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id() == userID) {
                return i;
            }
        }
        return -1;
    }

    /*
    deletes product with ID from input
    from the products list & purchases mpa
     */
    public static String deleteProductByID(int productID) {
        int productIndex = getProductIndex(productID);
        if (productIndex == -1) {
            return "No such product with ID: " + productID;
        }
        Product product = products.get(getProductIndex(productID));
        products.remove(product);
        for (List<Product> purchasedProducts : purchasesMap.values()) {
            //removing all purchases for a chosen product
            //in case one user bought one product many times
            purchasedProducts.removeIf(i -> Objects.equals(i, product));
        }
        return "Deleted product with ID: " + productID;
    }

    public static String getUsersAsString() {
        if (users.isEmpty()) {
            return "User list is empty";
        }
        StringBuilder sb = new StringBuilder("Users in database: " + users.size());
        for (User user : users) {
            sb.append(user.toString()).append("\n");
        }
        return sb.toString();
    }


    public static String getProductsAsString() {
        if (products.isEmpty()) {
            return "Product list is empty";
        }
        StringBuilder sb = new StringBuilder("Products in database: " + products.size());
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}
