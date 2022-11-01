import axios from 'axios'

const SHOPPING_CART_MAIN_URL = "http://localhost:8080/flowershop-backend/shopping-carts";

class ShoppingCartService {

    getAll() {
        return axios.get(SHOPPING_CART_MAIN_URL);
    }

    updateById(id, shoppingCart) {
        return axios.put(SHOPPING_CART_MAIN_URL + '/' + id, shoppingCart)
    }

}

export default new ShoppingCartService()