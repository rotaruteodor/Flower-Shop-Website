import React from 'react'
import UsersService from '../services/UsersService';
import { useState } from "react";

export const NewAccountComponent = ({openPopup}) => {

    function onAccountSuccessfullyCreated(firstName){
        hideAllInputs()
        document.getElementById("h1RegisterTitle").style.color = "green";
        document.getElementById("h1RegisterTitle").innerHTML = "Account succesfully created! Welcome " + firstName
        document.getElementById("registerForm").style.height = "150px";
        document.getElementById('labelRegisterEmail').style.display = 'none'    }

    function hideAllInputs() {
        document.getElementById("textBoxRegisterFirstName").style.display = "none";
        document.getElementById("textBoxRegisterLastName").style.display = "none";
        document.getElementById("textBoxRegisterEmail").style.display = "none";
        document.getElementById("textBoxRegisterPassword").style.display = "none";
        document.getElementById("btnRegister").style.display = "none";
    }

    function areInputsValid() {
        if (document.getElementById('textBoxRegisterFirstName').value.trim().length < 3) {
            document.getElementById('labelRegisterFirstName').style.display = 'block';
            return false;
        }
        else {
            document.getElementById('labelRegisterFirstName').style.display = 'none';
        }

        if (document.getElementById('textBoxRegisterLastName').value.trim().length < 3) {
            document.getElementById('labelRegisterLastName').style.display = 'block';
            return false;
        }
        else {
            document.getElementById('labelRegisterLastName').style.display = 'none';
        }

        if (document.getElementById('textBoxRegisterPassword').value.trim().length < 3) {
            document.getElementById('labelRegisterPassword').style.display = 'block';
            return false;
        }
        else {
            document.getElementById('labelRegisterPassword').style.display = 'none';
        }

        return true;
    }

    function isEmailPatternValid(email) {
        const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return pattern.test(String(email).toLowerCase());
    }

    function addUserToDatabase() {
        if (isEmailPatternValid(document.getElementById('textBoxRegisterEmail').value.trim())) {
            let email = document.getElementById('textBoxRegisterEmail').value.trim()

            UsersService.getUserByEmail(email)
                .then(() => {
                    document.getElementById('labelRegisterEmail').innerHTML = 'There is already an account for this email';
                    document.getElementById('labelRegisterEmail').style.display = 'block';
                })
                .catch(() => {
                    if (areInputsValid()) {
                        let newUser = {
                            firstName: document.getElementById('textBoxRegisterFirstName').value.trim(),
                            lastName: document.getElementById('textBoxRegisterLastName').value.trim(),
                            emailAddress: document.getElementById('textBoxRegisterEmail').value.trim(),
                            password: document.getElementById('textBoxRegisterPassword').value.trim(),
                            orders: [],
                            shoppingCart: {flowerArrangements: []}
                        }

                        UsersService.addUser(newUser)
                        .then(response => {
                            onAccountSuccessfullyCreated(response.data.firstName)
                        })
                        .catch((error) => alert(error.response.status))
                    }
                })
        } else {
            document.getElementById('labelRegisterEmail').style.display = 'block';
            return false;
        }
    }

    return (
        <div className="registerBackground">
            <div className="registerContainer" id="registerForm">
                <div className="CloseBtn">
                    <button id="btnCloseRegisterForm" onClick={() => openPopup(false)}> X </button>
                </div>

                <h1 id="h1RegisterTitle">Register here!</h1>

                <input id="textBoxRegisterFirstName" className="body" type="text" placeholder="First name" ></input>
                <label id="labelRegisterFirstName" className="registerLabels" style={{display: "none"}}>Firstname too short</label>

                <input id="textBoxRegisterLastName" className="body" type="text" placeholder="Last name" ></input>
                <label id="labelRegisterLastName" className="registerLabels" style={{display: "none"}}>Lastname too short</label>

                <input id="textBoxRegisterEmail" className="body" type="text" placeholder="Email"  ></input>
                <label id="labelRegisterEmail" className="registerLabels" style={{display: "none"}}>Invalid Email</label>

                <input id="textBoxRegisterPassword" className="body" type="password" placeholder="Password"></input>
                <label id="labelRegisterPassword" className="registerLabels" style={{display: "none"}}>Password too short</label>

                <div className="footer">
                    <button id="btnRegister" className="footer" type="button" onClick={addUserToDatabase}>Register</button>
                </div>

            </div>
        </div>
    )
}
