import axios from 'axios'

const USERS_MAIN_URL = "http://localhost:8080/flowershop-backend/users"
const GET_USER_BY_CREDENTIALS_URL = USERS_MAIN_URL + "/findByCredentials"

class UsersService {

    getAll() {
        return axios.get(USERS_MAIN_URL);
    }

    getById(userId) {
        return axios.get(USERS_MAIN_URL + '/' + userId);
    }

    add(user) {
        return axios.post(USERS_MAIN_URL, user);
    }

    update(userId, user) {
        return axios.put(USERS_MAIN_URL + '/' + userId, user);
    }

    getByCredentials(emailToSearch, passwordToSearch) {
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            {
                params: {
                    email: emailToSearch,
                    password: passwordToSearch
                }
            })
    }

    getByEmail(emailToSearch) {
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            {
                params: {
                    email: emailToSearch
                }
            })
    }

    deleteById(userId) {
        return axios.delete(USERS_MAIN_URL + '/' + userId)
    }

}

export default new UsersService()