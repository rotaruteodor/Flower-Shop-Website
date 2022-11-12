import React from 'react'
import { useLocation } from 'react-router-dom';
import { ShoppingCartRowComponent } from './ShoppingCartRowComponent'
import OrderService from '../services/OrderService.js'

export const CheckOutComponent = () => {

    const location = useLocation();

    function onFinishOrderButtonClick() {
        let order = {
            creationDate: new Date().toISOString(),
            status: "CREATED",
            deliveryAddress: document.getElementById('orderAddress').value,
            shoppingCartFlowerArrangements: location.state.shoppingCart.shoppingCartFlowerArrangements
        }
        alert(JSON.stringify(order))
        alert(location.state.user.id)
        OrderService.add(order, location.state.user.id)
            .then(res => {
                alert("Your order was successfully created! Order id: " + res.id)
            })
            .catch(alert("Oh no, something went wrong while creating your order!\nPlease try again"))
    }

    return (
        <div>
            <h1 id="h1CheckOutInfoTag">Order information</h1>
            <textarea id='orderAddress'
                name="inputOrderAddress"
                cols='35'
                rows='8'
                className='body'
                placeholder='Full Address'></textarea> <br />
            <span id='totalOrderValueTag'>{"Total: $" + location.state.shoppingCart.totalPrice}</span> <br />
            <button id='finishOrder' onClick={onFinishOrderButtonClick}> Finish order </button >
        </div>
    )
}
