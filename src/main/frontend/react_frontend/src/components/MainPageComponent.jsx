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
  const [shoppingCart, setShoppingCart] = useState(location.state.user.shoppingCart);

  useEffect(() => {
    const getFlowerArrangements = async () => {
      const res = await FlowerArrangementService.getAll();
      setFlowerArrangementsArray(res.data);
    };

    getFlowerArrangements();
    document.getElementById("shopping_cart_button").innerHTML = "Shopping cart<br/>Products: " +
      shoppingCart.shoppingCartFlowerArrangements.length +
      " | Total: $" +
      shoppingCart.totalPrice
  }, []);

  return (
    <div>
      <span id='span_current_user' >{"Logged in as: ".concat(location.state.user.firstName)}</span><br />
      <button id='shopping_cart_button' onClick={() => setOpenShoppingCartPopup(true)}></button><br />
      {openShoppingCart && <ShoppingCartComponent openPopup={setOpenShoppingCartPopup} shoppingCart={location.state.user.shoppingCart} />}
      {
        flowerArrangementsArray.map(fa => <FlowerArrangementRowComponent flowerArrangement={fa}/>)
      }
    </div>
  )
}
