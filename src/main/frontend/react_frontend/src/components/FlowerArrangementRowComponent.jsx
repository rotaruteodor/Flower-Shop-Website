import React from 'react'
import { useNavigate } from "react-router-dom";
import ShoppingCartFlowerArrangementService from '../services/ShoppingCartFlowerArrangementService';
import { useLocation } from 'react-router-dom';

export const FlowerArrangementRowComponent = (props) => {

    const location = useLocation();
    let navigate = useNavigate();

    function seeFlowerArrangementDetailsPage() {
        navigate('flowerArrangementDetails', {
            state: {
                flowerArrangement: props.flowerArrangement,
                user: props.user
            }
        })
    }

    function addFlowerArrangementToCart() {
        ShoppingCartFlowerArrangementService.add({ quantity: 1 },
            props.user.shoppingCart.id,
            props.flowerArrangement.id)
            .then(res => {
                props.updateShoppingCartLength(props.user.shoppingCart.shoppingCartFlowerArrangements.push(res.data).length)
                props.updateShoppingCartTotalPrice(props.user.shoppingCart.totalPrice += props.flowerArrangement.price)
            })
            .catch((error) => alert(error.response.status))
    }

    return (
        <div className="product_row">
            <div className="product_image">
                <img src={props.flowerArrangement.imageUrl}
                    alt="Img not found"
                    width="300px"
                    height="220px"
                    onClick={seeFlowerArrangementDetailsPage}
                />
            </div>
            <div className="product_detail">
                <h4>{props.flowerArrangement.name}</h4>
                <div className="product_price">
                    {"$" + props.flowerArrangement.price}
                </div>
            </div>
            <button className='add_to_cart_buttons' onClick={addFlowerArrangementToCart}>Add to cart</button>
        </div>
    )
}