import React from 'react'
import { ShoppingCartRowComponent } from './ShoppingCartRowComponent'
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const ShoppingCartComponent = (props) => {

    let navigate = useNavigate();

    const [shoppingCart, setShoppingCart] = useState(props.shoppingCart);
    const [shoppingCartTotalPrice, setShoppingCartTotalPrice] = useState(props.shoppingCart.totalPrice);

    function onCloseShoppingCartForm() {
        props.openPopup(false)

    }

    function displayShoppingCartFlowerArrangements() {
        return shoppingCart.shoppingCartFlowerArrangements.map(scfa => <ShoppingCartRowComponent
            shoppingCartFlowerArrangement={scfa}
            shoppingCart={shoppingCart}
            setShoppingCart={setShoppingCart}
            updateShoppingCartFlowerArrangements={displayShoppingCartFlowerArrangements}
            updateShoppingCartTotalPrice={setShoppingCartTotalPrice}
        />)
    }

    function onCheckOutButtonClick() {
        navigate('checkout', { state: { shoppingCart: shoppingCart, user: props.user } })
    }

    return (
        <div className="shoppingCartBackground">
            <div className="shoppingCartContainer" id="shoppingCartForm">
                <h1>Shopping cart</h1>

                <div id='shoppingCartButtons'>
                    <div>
                        <button id="btnCheckOut" onClick={onCheckOutButtonClick}> Check out </button>
                    </div>

                    <div>
                        <button id="btnCloseShoppingCartForm" onClick={onCloseShoppingCartForm}> Continue shopping  </button>
                    </div>
                </div>
                {displayShoppingCartFlowerArrangements()}
            </div>
        </div>
    )
}
