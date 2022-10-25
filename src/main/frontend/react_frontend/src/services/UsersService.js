import axios from 'axios'

const USERS_MAIN_URL = "http://localhost:8080/flowershop-backend/users"
const GET_USER_BY_CREDENTIALS_URL = USERS_MAIN_URL + "/findByCredentials"

class UsersService {

    getAllUsers() {
        return axios.get(USERS_MAIN_URL);
    }

    getUserById(userId) {
        return axios.get(USERS_MAIN_URL + '/' + userId);
    }

    addUser(user) {
        return axios.post(USERS_MAIN_URL, user);
    }

    updateUser(userId, user) {
        return axios.put(USERS_MAIN_URL + '/' + userId, user);
    }

    getUserByCredentials(emailToSearch, passwordToSearch) {
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            {
                params: {
                    email: emailToSearch,
                    password: passwordToSearch
                }
            })
    }

    getUserByEmail(emailToSearch) {
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            {
                params: {
                    email: emailToSearch
                }
            })
    }

    deleteUserById(userId) {
        return axios.delete(USERS_MAIN_URL + '/' + userId)
    }

}

export default new UsersService()