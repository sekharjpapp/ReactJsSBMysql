import React, { useState } from 'react'

const FormValidation = () => {
    const [name,setName] = useState();
    const [email,setEmail] = useState();
    const [nameError,setNameError] = useState(false);
    const [emailError,setEmailError] = useState(false);
    const emailRegEx = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    const handleInput = (e) => {
        let name = e.target.value;
        if(name.length <3){
            setNameError(true);
        }else{
            setNameError(false);
        }
    }
    const handlinEmail= (e) => {
        let email = e.target.value;
        if(!email.match(emailRegEx)) {
            setEmailError(true);
        }else {
            setEmailError(false);
        }
        setEmail(email);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(e.target[0].value + " " + e.target[1].value);
    }
  return (
    <div>
        <h1>FormValidation Sample</h1>
        <form onSubmit={handleSubmit}>
            <label htmlFor="">Enter Name: </label>
            <input type="text" name="name" onChange={handleInput} value={name} />
            <br />
            {nameError ? <span style={{color:'red'}}>Name should be greater than 2 char</span>: ""}
            <br />
            <label htmlFor="">Enter Email: </label>
            <input type="email" name="email" onChange={handlinEmail} value={email} />
            <br />
            {emailError ? <span style={{color:'red'}}>Invalid Email </span> : ""}
            <br />
            <input type="submit" value="Submit" />
        </form>
    </div>
  )
}

export default FormValidation