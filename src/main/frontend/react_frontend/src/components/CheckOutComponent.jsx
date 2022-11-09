import React from 'react'
import { useLocation } from 'react-router-dom';
import { ShoppingCartRowComponent } from './ShoppingCartRowComponent'

export const CheckOutComponent = () => {

    const location = useLocation();

    function onFinishOrderButtonClick() {

    }

    return (
        <div>
            <h1 id="h1CheckOutInfoTag">Order information</h1>
            <textarea name="inputOrderAddress" cols='35' rows='8' className='body' placeholder='Full Address'></textarea> <br/>
            <span id='totalOrderValueTag'>{"Total: $" + location.state.shoppingCart.totalPrice}</span> <br/>
            <button id='finishOrder' onClick={onFinishOrderButtonClick}> Finish order </button >
        </div>
    )
}
