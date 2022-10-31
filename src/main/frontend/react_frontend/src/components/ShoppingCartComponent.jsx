import React from 'react'
import { ShoppingCartRowComponent } from './ShoppingCartRowComponent'

export const ShoppingCartComponent = ({ openPopup, shoppingCart }) => {
    return (
        <div className="shoppingCartBackground">
            <div className="shoppingCartContainer" id="shoppingCartForm">
                <h1>Shopping cart</h1>

                <div id='shoppingCartButtons'>
                    <div>
                        <button id="btnCloseShoppingCartForm" onClick={() => alert("todo")}> Check out </button>
                    </div>

                    <div>
                        <button id="btnCloseShoppingCartForm" onClick={() => openPopup(false)}> Continue shopping  </button>
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
