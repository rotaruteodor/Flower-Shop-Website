import React from 'react'
import { FlowerArrangementRowComponent } from './FlowerArrangementRowComponent'
import { useState, useEffect } from "react";
import { useLocation } from 'react-router-dom';
import FlowerArrangementService from '../services/FlowerArrangementService';
import { ShoppingCartComponent } from './ShoppingCartComponent';

export const MainPageComponent = (props) => {

  const location = useLocation();
  const [openShoppingCart, setOpenShoppingCartPopup] = useState(false);
  const [flowerArrangementsArray, setFlowerArrangementsArray] = useState([]);
  const [shoppingCart, setShoppingCart] = useState(location.state != null ?
    location.state.user.shoppingCart : null);
  const [shoppingCartLength, setShoppingCartLength] = useState(location.state != null ?
    location.state.user.shoppingCart.shoppingCartFlowerArrangements.length : null);
  const [shoppingCartTotalPrice, setShoppingCartTotalPrice] = useState(location.state != null ?
    location.state.user.shoppingCart.totalPrice : null);

  useEffect(() => {
    const getFlowerArrangements = async () => {
      const res = await FlowerArrangementService.getAll();
      setFlowerArrangementsArray(res.data);
    };

    if (location.state != null) {
      getFlowerArrangements();
    }
  }, []);

  if (location.state != null) {
    return (
      <div>
        <span id='span_current_user' >{"Logged in as: ".concat(location.state.user.firstName)}</span><br />
        <button id='shopping_cart_button' onClick={() => setOpenShoppingCartPopup(true)}>{"Shopping cart"} <br />
          {"Products: " +
            location.state.user.shoppingCart.shoppingCartFlowerArrangements.length +
            " | Total: $" +
            location.state.user.shoppingCart.totalPrice.toFixed(2)
          }
        </button><br />
        {
          openShoppingCart && <ShoppingCartComponent
            openPopup={setOpenShoppingCartPopup}
            shoppingCart={location.state.user.shoppingCart} />
        }
        {
          flowerArrangementsArray.map(fa => <FlowerArrangementRowComponent
            flowerArrangement={fa}
            updateShoppingCartLength={setShoppingCartLength}
            updateShoppingCartTotalPrice={setShoppingCartTotalPrice}
            user={location.state.user} />)
        }
      </div>
    )
  } else {
    return (
      <h1>Acess Denied! Please log in first</h1>
    )
  }
}
