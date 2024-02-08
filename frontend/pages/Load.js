import { Link } from 'react-router-dom';
import { useLoaderData } from 'react-router-dom';


function Load(){

    // loader kivalasztas : az elso amit talal felfele ??
    //use loader in router defined, a childrenekben elerheto
    const tetel = useLoaderData();
    console.log(tetel);


    return(
        <>
        <h1> RELOAD LINK </h1>
        <h1> fetching api based on incoming parameter </h1>
        </>
    );

}


export default Load;
