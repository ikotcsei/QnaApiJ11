import { Link } from 'react-router-dom';
import Alllinks from '../alllinks.js';
import Start from '../pages/Start.js';
import DesignPatterns from '../pages/DesignPatterns.js';
import JavaBasic from '../pages/JavaBasic.js';
import BasicAlgos from '../pages/BasicAlgos.js';
import SysDesign from '../pages/SysDesign.js';
import '../styles.css';
import React, { useState } from "react"; // Import useState

function MainNavigation() {
    const [isOpen, setIsOpen] = useState(false);

    const toggleMenu = () => {
        setIsOpen((prev) => !prev);
    };

    return (
            <nav className="navbar">
                <div className="menu-toggle" onClick={toggleMenu}>
                    ☰ {/* Hamburger icon */}
                </div>
                <ul className={`nav-links ${isOpen ? "active" : ""}`}>
                    <li><Link to="/designpatterns" onClick={() => setIsOpen(false)}>Design Patterns</Link></li>
                    <li><Link to="/basicalgos" onClick={() => setIsOpen(false)}>Basic Algos</Link></li>
                    <li><Link to="/sysdesign" onClick={() => setIsOpen(false)}>System Design</Link></li>
                    <li><Link to="/javabasic" onClick={() => setIsOpen(false)}>Java Basics</Link></li>
                </ul>
            </nav>
        );
}

export default MainNavigation;