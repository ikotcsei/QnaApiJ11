import { Outlet } from 'react-router-dom';
import  MainNavigation  from '../components/MainNavigation.js';
import '../styles.css';

function RootLayout(){
    return(
        <>
            <h1>rootlayout</h1>
            <MainNavigation className="navigation" />
            <Outlet className="navigation" />
        </>
    );
}

export default RootLayout;