import { useEffect, useState } from "react";
import { Button, Stack } from "react-bootstrap"
import { useShoppingCart } from "../context/ShoppingCartContext"
import { formatCurrency } from "../utilities/formatCurrency"

type resultProps = {
  id: number
  imageUrl: string
  name: string
  price: number
}

type CartItemProps = {
  id: number
  quantity: number
  }

export function CartItem({ id, quantity }: CartItemProps) {

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

  const { removeFromCart } = useShoppingCart()
  const item = storeItems.find(i => i.id === id)
  if (item == null) return null

  const {
    increaseCartQuantity,
    decreaseCartQuantity,
  } = useShoppingCart()

  return (
    <Stack direction="horizontal" gap={2} className="d-flex align-items-center">
      <img
        src={item.imageUrl}
        style={{ width: "100px", height: "60px", objectFit: "cover" }}
      />
      <div className="me-auto">
        <div>
          {item.name}{" "}
        </div>
        <div className="text-muted" style={{ fontSize: ".75rem" }}>
          {formatCurrency(item.price)}
        </div>
        <div> {formatCurrency(item.price * quantity)}</div>
      </div>
      <Button size="sm" onClick={() => decreaseCartQuantity(id)}>-</Button>
        <div>
            <span className="fs-3">{quantity}</span> in cart
        </div>
      <Button size="sm" onClick={() => increaseCartQuantity(id)}>+</Button>
    </Stack>
  )
}