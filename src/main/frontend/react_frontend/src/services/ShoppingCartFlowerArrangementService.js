import axios from 'axios'

const SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL = "http://localhost:8080/flowershop-backend/shopping-cart-flower-arrangements"

class ShoppingCartFlowerArrangementService {

    getAll() {
        return axios.get(SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL);
    }

    getById(id) {
        return axios.get(SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL + '/' + id);
    }

    add(shoppingCartFlowerArrangement, shoppingCartId, flowerArrangementId) {
        return axios.post(SHOPPING_CART_FLOWER_ARRANGEMENT_MAIN_URL +
            '/' + shoppingCartId +
            '/' + flowerArrangementId,
            shoppingCartFlowerArrangement)
    }

}

export default new ShoppingCartFlowerArrangementService()