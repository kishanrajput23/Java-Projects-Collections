import {useState} from "react";
import ClientDetails from "./compnonents/ClientDetails";
import Dates from "./compnonents/Dates";
import Footer from "./compnonents/Footer";
import Header from "./compnonents/Header";
import MainDetails from "./compnonents/MainDetails";
import Table from "./compnonents/Table";
import TableForm from "./compnonents/TableForm";
function App() {
const [showCrud,setShowCrud]=useState(false)
const [name,setName]=useState("")
const [email,setEmail]=useState("")
const [phone,setPhone]=useState("")
const [customerName,setCustomerName]=useState("")
const [invoiceNumber,setInvoiceNumber]=useState("")
const [invoiceDate,setInvoiceDate]=useState("")
const [itemName,setItemName]=useState("")
const [quantity,setQuantity]=useState("")
const [price,setPrice]=useState("")
const [amount,setAmount]=useState("")
const [list,setList]=useState([])
const handlePrint =()=>{
   window.print()
}
return (
<>
<main className="m-5 p-5 md:max-w-xl md:mx-auto lg:max-w-2xl xl:max-w-4xl bg-white rounded shadow">
   {showCrud ? ( 
   <div>
      <Header handlePrint={handlePrint}/>
      <MainDetails name={name} email={email}/>
      <ClientDetails customerName={customerName}  />
      <Dates invoiceNumber={invoiceNumber} invoiceDate={invoiceDate} />
      <Table 
         itemName={itemName}
         quantity={quantity}
         price={price}
         amount={amount}
         list={list}
         />
      <Footer 
         name={name} 
         email={email}
         phone={phone} 
         />
      <button 
         onClick={()=>setShowCrud(false)}
      className="mt-5 bg-blue-500  text-white font-bold py-2 px-8 rounded shodow border-2 border-blue-500 hover:bg-transparent hover:text-blue-500 transition-all duration-300 ">
      Edit Info
      </button>
   </div>
   ):(
   <>
   {/* name,adress,clientname,client adress, invoice number,email,phone number, */}
   <div className="flex flex-col justify-center">
      <article className="md:grid grid-cols-2 gap-10">
         <div className="flex flex-col">
            <label htmlFor="name">Enter Your Name</label>
            <input
               type="text" 
               name="text" 
               id="name"
               placeholder="Enter Your Name"
               autoComplete="off"
               value={name}
               onChange={(e)=>setName(e.target.value)}
            />
         </div>
         <div className="flex flex-col">
            <label htmlFor="email">Enter Your Email id</label>
            <input type="email"
               name="email"
               id="email"
               placeholder="Enter Your Email id"
               autoComplete="off"
               value={email}
               onChange={(e)=>setEmail(e.target.value)}
            />
         </div>
      </article>
      <article className="md:grid grid-cols-2 gap-10">
         <div className="flex flex-col">
            <label htmlFor="phone">Enter Your phone</label>
            <input type="text"
               name="phone"
               id="phone"
               placeholder="Enter Your phone"
               autoComplete="off"
               value={phone}
               onChange={(e)=>setPhone(e.target.value)}
            />
         </div>
         <div className="flex flex-col">
            <label htmlFor="customerName">Enter Your customer name</label>
            <input type="text"
               name="customerName"
               id="customerName"
               placeholder="Enter Your customer name"
               autoComplete="off"
               value={customerName}
               onChange={(e)=>setCustomerName(e.target.value)}
            />
         </div>
      </article>
      <article className="md:grid grid-cols-2 gap-10">
         <div className="flex flex-col">
            <label htmlFor="invoiceNumber">Enter Your  Invoice number</label>
            <input type="text"
               name="invoiceNumber"
               id="invoiceNumber"
               placeholder="Invoice number"
               autoComplete="off"
               value={invoiceNumber}
               onChange={(e)=>setInvoiceNumber(e.target.value)}
            />
         </div>
         <div className="flex flex-col">
            <label htmlFor="invoiceDate">Enter Your  Invoice date</label>
            <input 
               type="date"
               name="invoiceDate"
               id="invoiceDate"
               placeholder="Invoice date"
               autoComplete="off"
               value={invoiceDate}
               onChange={(e)=>setInvoiceDate(e.target.value)}
            />
         </div>
      </article>
      <article>
         <TableForm 
            itemName={itemName} 
            setItemName={setItemName}
            quantity={quantity}  
            setQuantity={setQuantity} 
            price={price}
            setPrice={setPrice}
            amount={amount}
            setAmount={setAmount}
            list={list}
            setList={setList}                       
            />
      </article>
      <button 
         onClick={()=> setShowCrud(true)} 
      className="bg-blue-500  text-white font-bold py-2 px-8 rounded shodow border-2 border-blue-500 hover:bg-transparent hover:text-blue-500 transition-all duration-300 ">PreView CRUD_APP
      </button>
   </div>
   </>
   )}
</main>
</>
);
}
export default App;