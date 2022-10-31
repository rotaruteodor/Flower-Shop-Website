import React from 'react'
import { useNavigate } from "react-router-dom";
import { useState } from "react";

export const ShoppingCartRowComponent = (props) => {

    let navigate = useNavigate();

    const [currentQuantity, setCurrentQuantity] = useState(props.shoppingCartFlowerArrangement.quantity);

    const onQuantityChange = event => {
        setCurrentQuantity(event.target.value);
        document.getElementById('shopping_cart_item_total_price')
            .innerHTML = "Total: $" + (currentQuantity * props.shoppingCartFlowerArrangement.flowerArrangement.price).toFixed(2)
    }

    function seeFlowerArrangementDetailsPage() {
        navigate('flowerArrangementDetails', { state: { flowerArrangement: props.shoppingCartFlowerArrangement.flowerArrangement } })
    }

    function removeShoppingCartFlowerArrangement(){

    }

    return (
        <div className="shopping_cart_row">
            <div className="shopping_cart_item_image">
                <img src={props.shoppingCartFlowerArrangement.flowerArrangement.imageUrl}
                    alt="Img not found"
                    width="300px"
                    height="220px"
                    onClick={seeFlowerArrangementDetailsPage}
                />
            </div>

            <div className="shopping_cart_item_detail">
                <div id='flowerArrangementName'>{props.shoppingCartFlowerArrangement.flowerArrangement.name}</div>
                <div className="shopping_cart_item_price" onClick={() => alert(props.shoppingCartFlowerArrangement.quantity)}>
                    {"Unit price: $" + props.shoppingCartFlowerArrangement.flowerArrangement.price}
                </div>
                <div className="shopping_cart_item_quantity">
                    Quantity:
                    <input id='shopping_cart_item_quantity_input'
                        type="number"
                        value={currentQuantity}
                        min="1"
                        onChange={onQuantityChange}
                    />
                </div>
                <div id="shopping_cart_item_total_price">
                    {"Total: $" + props.shoppingCartFlowerArrangement.quantity * props.shoppingCartFlowerArrangement.flowerArrangement.price}
                </div>
            </div>

            <div id='remove_flower_arrg_from_shopping_cart' onClick={removeShoppingCartFlowerArrangement}>Remove</div>
        </div>
    )
}
