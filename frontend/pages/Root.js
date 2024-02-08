import { Outlet } from 'react-router-dom';
import  MainNavigation  from '../components/MainNavigation.js';

function RootLayout(){
    return(
        <>
            <h1>rootlayout</h1>
            <MainNavigation />
            <Outlet />
        </>
    );
}

export default RootLayout;