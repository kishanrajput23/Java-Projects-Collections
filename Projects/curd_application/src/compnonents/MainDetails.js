import React from 'react'

export default function MainDetails({name,email}) {
  return (
    <>
       <section className="flex flex-col items-end justify-end">
        <h2 className="font-bold text-xl uppercase">{name}</h2>
        <p>{email}</p>
    </section >
    </>
  )
}
