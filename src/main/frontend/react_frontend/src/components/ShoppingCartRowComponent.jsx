import React from 'react'
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import ShoppingCartFlowerArrangementService from '../services/ShoppingCartFlowerArrangementService';

export const ShoppingCartRowComponent = (props) => {

    let navigate = useNavigate();

    const [currentQuantity, setCurrentQuantity] = useState(props.shoppingCartFlowerArrangement.quantity);


    const onQuantityChange = event => {
        setCurrentQuantity(event.target.value);
        ShoppingCartFlowerArrangementService.updateQuantityById(
            props.shoppingCartFlowerArrangement.id, event.target.value)

    }

    function seeFlowerArrangementDetailsPage() {
        navigate('flowerArrangementDetails', {
            state:
                { flowerArrangement: props.shoppingCartFlowerArrangement.flowerArrangement }
        })
    }

    function removeShoppingCartFlowerArrangement() {
        ShoppingCartFlowerArrangementService.deleteById(props.shoppingCartFlowerArrangement.id)
        props.shoppingCart.shoppingCartFlowerArrangements =
            props.shoppingCart.shoppingCartFlowerArrangements
                .filter(item => item.id != props.shoppingCartFlowerArrangement.id)

        props.setShoppingCart(props.shoppingCart)
        props.updateShoppingCartFlowerArrangements()
        props.updateShoppingCartTotalPrice(
            props.shoppingCart.totalPrice -=
            props.shoppingCartFlowerArrangement.flowerArrangement.price)
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
                    {"Total: $" + (currentQuantity * props.shoppingCartFlowerArrangement.flowerArrangement.price).toFixed(2)}
                </div>
            </div>

            <div id='remove_flower_arrg_from_shopping_cart' onClick={removeShoppingCartFlowerArrangement}>Remove</div>
        </div>
    )
}
