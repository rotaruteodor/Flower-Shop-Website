import axios from 'axios'

const MAIN_USERS_URL = "http://localhost:8080/flowershop_backend/v1/users"
const ADD_USER_URL = "http://localhost:8080/flowershop_backend/v1/add-user"
const GET_USER_BY_CREDENTIALS_URL = "http://localhost:8080/flowershop_backend/v1/users/findByCredentials"
const DELETE_USER_URL = "http://localhost:8080/flowershop_backend/v1/delete-user"

class UsersService {

    getAllUsers(){
        return axios.get(MAIN_USERS_URL);
    }

    getUserById(userId){
        return axios.get(MAIN_USERS_URL + '/' + userId);
    }

    addUser(user){
        return axios.post(ADD_USER_URL, user);
    }

    updateUser(userId, user){
        return axios.put(MAIN_USERS_URL + '/' + userId, user);
    }

    getUserByEmailAndPassword(emailToSearch, passwordToSearch){
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            { params: {
                email: emailToSearch,
                password: passwordToSearch
              }
            })
    }

    getUserByEmail(emailToSearch){
        return axios.get(GET_USER_BY_CREDENTIALS_URL,
            { params: {
                email: emailToSearch
              }
            })
    }

    deleteUserById(userId){
        return axios.delete(DELETE_USER_URL + '/' + userId)
    }

}

export default new UsersService()