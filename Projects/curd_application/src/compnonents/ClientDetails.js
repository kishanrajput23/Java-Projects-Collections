import React from 'react'

export default function ClientDetails({customerName}) {
  return (
    <>
 <section className="mt-5">
      <h2 className=" font-bold text-xl uppercase">{customerName}</h2>
    </section>
    </>
  )
}
