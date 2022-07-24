# MarketplaceApplication
IntelliStart practical task application

The CLI program creates some empty arrays for users and products
and allows filling them with data, working with that data and deleting that data via CLI.
Program usage is based on entering certain commands.

List of currently available commands:
    /help
    	prints list of available commands
    /users_list
    	prints info about all users
    /products_list
    	prints info about all products
    /purchase <USER_ID> <PRODUCT_ID>
    	makes a purchase of chosen product for a chosen user
    /add_user <FIRST_NAME> <LAST_NAME> <MONEY>
    	creates a new user with corresponding FIRST_NAME, LAST_NAME, MONEY properties
    /add_product <NAME> <PRICE>
    	creates a new product with corresponding NAME & PRICE
    /delete_product <PRODUCT_ID>
    	deletes product with PRODUCT_ID from the database
