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
    const [enabled, setEnabled] = useState(false);

    const toggleMenu = () => {
        setIsOpen((prev) => !prev);
    };

    return (
            <nav className="navbar">
                <div className="menu-toggle" onClick={toggleMenu}>
                    ☰ {/* Hamburger icon */}
                </div>
                <ul className={`nav-links ${isOpen ? "active" : ""}`}>
                    <li><Link to={`/designpatterns?enabled=${enabled}`} onClick={() => setIsOpen(false)}>Design Patterns</Link></li>
                    <li><Link to={`/basicalgos?enabled=${enabled}`} onClick={() => setIsOpen(false)}>Basic Algos</Link></li>
                    <li><Link to={`/sysdesign?enabled=${enabled}`} onClick={() => setIsOpen(false)}>System Design</Link></li>
                    <li><Link to={`/javabasic?enabled=${enabled}`} onClick={() => setIsOpen(false)}>Java Basics</Link></li>
                </ul>

                <button onClick={() => setEnabled(!enabled)}>
                        {enabled ? "Inorder" : "Random"}
                </button>

            </nav>
        );
}

export default MainNavigation;