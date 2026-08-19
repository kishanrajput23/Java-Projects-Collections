import React from 'react'

export default function Header({handlePrint}) {
  return (
    <>
 <header className="flex flex-col items-center justify-center mb-5 xl:flex-row xl:justify-between">
      <div>
      <h1 className="font-bold uppercase tracking-wide text-4xl mb-3">CRUD_APP</h1>
      </div>
      <div>
        <ul className="flex item -center justify-between flex-wrap">
          <li className= "mt-5 bg-blue-500  text-white font-bold  py-2 px-8 rounded shodow border-2 border-blue-500 hover:bg-transparent hover:text-blue-500 transition-all duration-300"><button onClick={handlePrint}>print</button></li>

        </ul>
      </div>
    </header>
    </>
  )
}
