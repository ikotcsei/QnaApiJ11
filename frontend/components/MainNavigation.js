import { Link } from 'react-router-dom';
import Alllinks from '../alllinks.js';
import Start from '../pages/Start.js';

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
            </ul>
        </nav>

    );

}

export default MainNavigation;