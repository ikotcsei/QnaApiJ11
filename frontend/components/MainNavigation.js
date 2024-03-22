import { Link } from 'react-router-dom';
import Alllinks from '../alllinks.js';
import Start from '../pages/Start.js';
import DesignPatterns from '../pages/DesignPatterns.js';
import JavaBasic from '../pages/JavaBasic.js';
import BasicAlgos from '../pages/BasicAlgos.js';
import SysDesign from '../pages/SysDesign.js';

function MainNavigation(){

    return(
        <nav>
            <ul>
                <li>
                    <Link to="/start">Start</Link>
                </li>
                <li>
                    <Link to="/alllinks">Alllinks</Link>
                </li>
                <h1>
                    <li>
                        <Link to="/designpatterns">designpatterns </Link>
                    </li>
                    <li>
                        <Link to="/basicalgos">basicalgos </Link>
                    </li>
                    <li>
                        <Link to="/sysdesign">sys design </Link>
                    </li>
                    <li>
                        <Link to="/javabasic">java basic </Link>
                    </li>
                </h1>
            </ul>
        </nav>

    );

}

export default MainNavigation;