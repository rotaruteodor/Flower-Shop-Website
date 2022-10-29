import React from 'react'
import { FlowerArrangementRowComponent } from './FlowerArrangementRowComponent'

export const ShoppingCartComponent = ({ openPopup, shoppingCart }) => {
    return (

        <div className="shoppingCartBackground">
            <div className="shoppingCartContainer" id="shoppingCartForm">
                <div className="CloseBtn">
                    <button id="btnCloseShoppingCartForm" onClick={() => openPopup(false)}> X </button>
                </div>
            
                {
                    shoppingCart.shoppingCartFlowerArrangements.map(scfa => <FlowerArrangementRowComponent flowerArrangement={scfa.flowerArrangement} />)
                }
            </div>
        </div>
    )
}
