import axios from 'axios'

const ORDERS_MAIN_URL = "http://localhost:8080/flowershop-backend/orders";

class OrderService {

    getAll() {
        return axios.get(ORDERS_MAIN_URL);
    }

    add(order, userId) {
        return axios.post(ORDERS_MAIN_URL + '/' + userId, order)
    }

}

export default new OrderService()