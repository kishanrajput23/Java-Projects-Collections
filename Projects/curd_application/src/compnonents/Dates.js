import React from 'react'

export default function Dates({invoiceNumber,invoiceDate}) {
  return (
    <>
  <article className="p-1 bg-gray-10 my-5 flex items-end justify-end">
      <ul>
        <li className="p-1 bg-yellow-100">
            <span className="font-bold">invoice number:</span>{invoiceNumber}
        </li>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <li className="p-1 bg-gray-100">
            <span className="font-bold">invoice date:</span>{invoiceDate}
        </li>
      </ul>
    </article>

    </>
  )
}
