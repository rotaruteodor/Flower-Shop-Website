import React from 'react'
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import {NewAccountComponent} from './NewAccountComponent'
import UsersService from '../services/UsersService';


export const LoginComponent = () => {

    const [openNewAccountPopup, setOpenNewAccountPopup] = useState(false);
    let navigate = useNavigate();

    function loginButtonClick() {
        let email = document.getElementById('textBoxInputEmail').value.trim()
        let password = document.getElementById('textBoxInputPassword').value.trim()

        UsersService.getUserByCredentials(email, password)
            .then((response) => {
                navigate('mainPage', { state: { user: response.data } })
            })
            .catch(document.getElementById('labelLoginWrongCreditentials').style.display = 'block')
    }

    return (
        <div id="loginDiv">
            <p className="Login" id="loginText">Login</p>
            <input id="textBoxInputEmail" className="Login" type="text" placeholder="Email address"></input>
            <input id="textBoxInputPassword" className="Login" type="password" placeholder="Password"></input>
            <button id="btnLogin" className="Login" type="button" onClick={loginButtonClick}>Enter</button>
            <label id="labelLoginWrongCreditentials" className="NewAccountLabels" style={{display: "none"}}>Wrong creditentials</label>
            <p id="paragraphNoAccount" className="Login">Don't have an account yet?</p>
            <button id="openNewAccountPopupBtn" onClick={() => setOpenNewAccountPopup(true)}>Create one</button>
            {openNewAccountPopup && <NewAccountComponent openPopup={setOpenNewAccountPopup} />}
        </div>
    )
}
