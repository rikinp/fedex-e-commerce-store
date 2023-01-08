import { useEffect, useState } from "react"
import { Button, Offcanvas, Stack } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { useShoppingCart } from "../context/ShoppingCartContext"
import { formatCurrency } from "../utilities/formatCurrency"
import { CartItem } from "./CartItem"
//import storeItems from "../data/items.json"

type resultProps = {
  id: number
  imageUrl: string
  name: string
  price: number
}

type ShoppingCartProps = {
  isOpen: boolean
}

export function ShoppingCart({ isOpen }: ShoppingCartProps) {

  let navigate = useNavigate();
  
  const { closeCart, cartItems, emptyCart } = useShoppingCart()
    
  const[storeItems,setStoreItems] = useState<resultProps[]>([]);

  const api = async () => {
    const response = await fetch("/estore/getAll", {
      method: "GET",
      headers: { 
        accept: "application/json",
      },
    });
    const jsonData = await response.json();
    setStoreItems(jsonData);
  }
  
  useEffect(() => {
    api();
  }, []);

  const totalprice = cartItems.reduce((total, cartItem) => {
    const item = storeItems.find(i => i.id === cartItem.id)
    return total + (item?.price || 0) * cartItem.quantity
  }, 0)

  const handleClick=()=>{

    
    const order={
      totalPrice: totalprice
    }
    console.log(order)
    fetch("/order/submitOrder",{
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(order)
    }).then(() =>{
      console.log("Order is saved successfully")
      console.log(JSON.stringify(order))
    })

    navigate('/OrderDetails');

    closeCart();
    emptyCart();

  }

  return (
    <Offcanvas show={isOpen} onHide={closeCart} placement="end">
      <Offcanvas.Header closeButton>
        <Offcanvas.Title>Cart</Offcanvas.Title>
      </Offcanvas.Header>
      <Offcanvas.Body>
        <Stack gap={3}>
          {cartItems.map(item => (
            <CartItem key={item.id} {...item} />
          ))}
          <div className="ms-auto fw-bold fs-5">
            Total{" "}
            {formatCurrency(
              cartItems.reduce((total, cartItem) => {
                const item = storeItems.find(i => i.id === cartItem.id)
                return total + (item?.price || 0) * cartItem.quantity
              }, 0)
            )}
          </div>
          <Button className="w-100" onClick={handleClick} disabled={totalprice==0}>
              Submit Order
          </Button>
        </Stack>
      </Offcanvas.Body>
    </Offcanvas>
  )
}
