import React from 'react'
import imageUnavailable from '../media/imageUnavailable.png'

export const ProductRowComponent = () => {
    return (
        <div className="product_row">
            <div className="product_image">
                <img src={imageUnavailable} alt="Sample Image" height="100" />
            </div>
            <div className="product_detail">
                <h4>Product name</h4>
                <p>Availability</p>
                <div className="product_price">
                    Price
                </div>
            </div>

        </div>
    )
}
