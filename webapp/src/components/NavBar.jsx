import React from 'react';
import { Navbar } from 'react-bootstrap';
import  './Navbar.css';

function NavBar(){
    return(
        <Navbar sticky="top" collapseOnSelect expand="md" className="navBarStyle">
            <Navbar.Brand href="/" className="navBarBrand">Imdb Clone</Navbar.Brand>
            <Navbar.Toggle aria-controls="responsive-navbar-nav"></Navbar.Toggle>
        </Navbar>
    )

}
export default NavBar;