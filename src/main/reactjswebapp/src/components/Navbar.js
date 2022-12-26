import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';

const Navbar = () => {
  return (
    <div>
    <div className='container-fluid'>
    <nav className='navbar bg-primary' data-bs-theme='dark'>
      <a className='navbar-brand' href='#'>
        Spring Boot ReactJS
      </a>
      <button
        className='navbar-toggler'
        type='button'
        data-bs-toggle='collapse'
        data-bs-target='#navbarSupportedContent'
        aria-controls='navbarSupportedContent'
        aria-expanded='false'
        aria-label='Toggle navigation'
      >
        <span className='navbar-toggler-icon'></span>
      </button>
    </nav>
  </div>
    </div>
  )
}

export default Navbar