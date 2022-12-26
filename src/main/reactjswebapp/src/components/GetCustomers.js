import axios from 'axios';
import React, { useEffect, useState } from 'react'

const GetCustomers = () => {
    const [customers,setCustomers] = useState([]);
    useEffect(() => {
        loadCustomers()
    },[])
    const loadCustomers = async () => {
        const result =await axios.get("http://localhost:8080/getAllCustomers")
        setCustomers(result.data)
        console.log(result.data)
    }
  return (
    <div>
    <hr />
    <table className="table">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Username</th>
        <th scope="col">Email</th>
      </tr>
    </thead>
    <tbody>
      {
        customers.map((cust,index)=>(
            <tr>
                <th scope="row">{index+1}</th>
                <td>{cust.name} </td>
                <td>{cust.username} </td>
                <td>{cust.email} </td>
                <td>
                    <button className={"btn btn-primary mx-2"}>View</button>
                    <button className={"btn btn-outline-primary mx-2"}>Edit</button>
                    <button className={"btn btn-danger mx-2"}>Delete</button>
                </td>
            </tr>
        ))
      }
    </tbody>
  </table>
    </div>
  )
}

export default GetCustomers