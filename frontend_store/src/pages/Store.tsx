import { useEffect, useState } from "react"
import { Col, Row } from "react-bootstrap"
import { StoreItem } from "../components/StoreItem"

type resultProps = {
  id: number
  imageUrl: string
  name: string
  price: number
}

export function Store() {
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

    console.log(storeItems);

    return (
        <>
          <h1 className="text-light">Store</h1>
          <Row md={2} xs={1} lg={3} className="g-3">
            {storeItems.map(item => (
              <Col key={item.id}>
                <StoreItem {...item} />
              </Col>
            ))}
          </Row>
        </>
      )
  }