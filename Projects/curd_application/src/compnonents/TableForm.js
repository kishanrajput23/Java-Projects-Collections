import React,{ useEffect, useState } from "react"
import { v4 as uuidv4 } from "uuid"
import Table from "./Table"

export default function TableForm({itemName,setItemName,quantity,setQuantity,price,setPrice,amount,setAmount,list,setList}) {

  const [IsEditing, setIsEditing] = useState();
     // Submit form function
  const handleSubmit = (e) => {
    e.preventDefault()

    if (!itemName || !quantity || !price) {
      console.log("Please fill in all inputs")
    } else {
      const newItems = {
        id: uuidv4(),
        itemName,
        quantity,
        price,
        amount,
      }
      setItemName("")
      setQuantity("")
      setPrice("")
      setAmount("")
      setList([...list, newItems])
      setIsEditing(false)
    }
  }
    useEffect(() => {
        const calculateAmount = (amount) => {
          setAmount(quantity * price)
        }
        calculateAmount(amount)
    }, [amount, price, quantity, setAmount])

  return (
    <>
  <form onSubmit={handleSubmit}>
  <div className='flex flex-col'>
  <label htmlFor="itemName">Item Name</label>
  <input type="text" name='itemName' id='itemName' placeholder='Item Name' value={itemName} onChange={(e)=>setItemName(e.target.value)}/>
  </div>

  <div className='md:grid grid-cols-3 gap-10'>
  <div className='flex flex-col'>
  <label htmlFor="quantity">Quantity</label>
  <input type="text" name='quantity' id='quantity' placeholder='Quantity' value={quantity} onChange={(e)=>setQuantity(e.target.value)}/>
    
  </div>
  <div className='flex flex-col'>
  <label htmlFor="Price">Price</label>
  <input type="text" name='Price' id='Price' placeholder='Price' value={price} onChange={(e)=>setPrice(e.target.value)}/>
  </div>
  
  <div className='flex flex-col'>
  <label htmlFor="amount">Total Amount</label>
  <p>{amount}</p>
    
  </div>
  </div>
  <button
          type="submit"
          className="mb-5 bg-blue-500 text-white font-bold py-2 px-8 rounded shadow border-2 border-blue-500 hover:bg-transparent hover:text-blue-500 transition-all duration-300"
        >
          {IsEditing ? "Editing Row Item" : "Add Table Item"}
        </button>
  </form>

  <Table />

  </>
  )
}
