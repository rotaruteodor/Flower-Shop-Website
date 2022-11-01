import React from 'react'
import { ShoppingCartRowComponent } from './ShoppingCartRowComponent'
import { useState } from "react";

export const ShoppingCartComponent = (props) => {

    const [shoppingCart, setShoppingCart] = useState(props.shoppingCart);

    function onCloseShoppingCartForm() {
        props.openPopup(false)

    }

    return (
        <div className="shoppingCartBackground">
            <div className="shoppingCartContainer" id="shoppingCartForm">
                <h1>Shopping cart</h1>

                <div id='shoppingCartButtons'>
                    <div>
                        <button id="btnCheckOut" onClick={() => alert("todo")}> Check out </button>
                    </div>

                    <div>
                        <button id="btnCloseShoppingCartForm" onClick={onCloseShoppingCartForm}> Continue shopping  </button>
                    </div>
                </div>
                {
                    shoppingCart.shoppingCartFlowerArrangements.map(scfa => <ShoppingCartRowComponent
                        shoppingCartFlowerArrangement={scfa}
                        shoppingCart={shoppingCart}
                    />)
                }
            </div>
        </div>
    )
}
