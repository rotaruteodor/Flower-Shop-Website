import React from 'react'
import { useLocation } from 'react-router-dom';
import ShoppingCartFlowerArrangementService from '../services/ShoppingCartFlowerArrangementService';
import { useState } from "react";

export const FlowerArrangementDetails = () => {

    const location = useLocation();
    const [componentDesc, setComponentDesc] = useState("Hover over contents to see their description :)");

    function addFlowerArrangementToCart() {
        ShoppingCartFlowerArrangementService.add({ quantity: 1 },
            location.state.user.shoppingCart.id,
            location.state.flowerArrangement.id)
            .then(res => {
                // location.state.updateShoppingCartLength(
                //     location.state.user.shoppingCart.shoppingCartFlowerArrangements.push(res.data).length)
                // location.state.updateShoppingCartTotalPrice(
                //     location.state.user.shoppingCart.totalPrice += location.state.flowerArrangement.price)
            })
            .catch((error) => alert(error.response.status))
    }

    return (
        <div className="product_row_detailed">
            <div className="product_image">
                <img src={location.state.flowerArrangement.imageUrl}
                    alt="Img not found"
                    width="400px"
                    height="400px"
                />
            </div>
            <div className="product_detail">
                <h4 id='flowerArrgNameDetails'>{location.state.flowerArrangement.name}</h4>
                <div className="product_price_details">
                    {"$" + location.state.flowerArrangement.price}
                </div>
            </div>
            <button className='add_to_cart_buttons_details' onClick={addFlowerArrangementToCart}>Add to cart</button>
            <h1 id='flowerArrgContentsTag'>Contents</h1>
            <table id='flowerArrgContentsTable'>
                <tr id='flowerArrgContentsTableHead'>
                    <th>Name</th>
                    <th>Color</th>
                    <th>Quantity</th>
                </tr>
                {
                    location.state.flowerArrangement.components
                        .map(c =>
                            <tr onMouseOver={() =>
                                setComponentDesc(c.flowerArrangementComponentGeneralInfo.description)}>
                                <td>{c.flowerArrangementComponentGeneralInfo.name}</td>
                                <td style={{
                                    color: c.color.hex
                                }}>{c.color.name}</td>
                                <td>{c.quantity}</td>
                            </tr>
                        )
                }
            </table> <br />
            <text id='flowerArrgComponentDescription'>{componentDesc} </text>
        </div>
    )
}
