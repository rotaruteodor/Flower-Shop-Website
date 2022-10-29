import axios from 'axios'

const FLOWER_ARRANGEMENT_MAIN_URL = "http://localhost:8080/flowershop-backend/flower-arrangements"

class FlowerArrangementService {

    getAll() {
        return axios.get(FLOWER_ARRANGEMENT_MAIN_URL);
    }

    getById(flowerArrangementId) {
        return axios.get(FLOWER_ARRANGEMENT_MAIN_URL + '/' + flowerArrangementId);
    }

}

export default new FlowerArrangementService()