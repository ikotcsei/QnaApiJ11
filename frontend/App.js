import React, { Component } from 'react';
import Alllinks from './alllinks.js';
import axios from 'axios';
import {
    createBrowserRouter,
    RouterProvider,
    BrowserRouter as Router,
    Route,
    Routes,
    Link
} from 'react-router-dom';
import './styles.css';
import Example from './slideshow.js';
import RootLayout from './pages/Root.js';
import Load from './pages/Load.js';
import Start from './pages/Start.js';
import DesignPatterns from './pages/DesignPatterns.js';
import SysDesign from './pages/SysDesign.js';
import BasicAlgos from './pages/BasicAlgos.js';
import JavaBasic from './pages/JavaBasic.js';

import ErrorBoundary from './components/ErrorBoundary.js';

import { currentServerURL } from './globals.js';

const router = createBrowserRouter([
    {
        path : '/',
        element : <RootLayout />,
        children :[
            { path : '/', element: <Start />},
            { path : '/alllinks', element: <Alllinks />},
            { path : '/start', element: <Start />},
            { path : '/designpatterns', element: <DesignPatterns />,
                loader : async ({ request }) => {
                    // if nonrandom marked fetch a
                     //        else fetch b
                    //
                    /* sending requestparam : <Link to="/users?id=123">Users</Link>
                       than
                       loader: async ({ request }) => {
                         const id = new URL(request.url).searchParams.get("id");
                         const res = await fetch(`/api/users?id=${id}`);
                         return res.json();
                       }
                    */
                    const enabled = new URL(request.url).searchParams.get("enabled");
                    const response = await fetch(currentServerURL + `jsontest?enabled=${enabled}`);

                    if (!response.ok){
                        console.log("error in the response.");
                        setError('soma : fetching the data failed .');
                    } else {
                        console.log("else ag fut.");
                        const resData = await response.json();
                        //this data will be auto enabled by router in component
                        console.log("resdata : "  + resData);
                        return resData;
                    }
                },
            },
            { path : '/sysdesign', element: <SysDesign />,
                loader : async ({ request }) => {
                    const enabled = new URL(request.url).searchParams.get("enabled");
                    const response = await fetch(currentServerURL + `sysdesign?enabled=${enabled}`);

                    if (!response.ok){
                        console.log("error in the response.");
                        setError('soma : fetching the data failed .');
                    } else {
                        console.log("else ag fut.");
                        const resData = await response.json();
                        //this data will be auto enabled by router in component
                        console.log("resdata : "  + resData);
                        return resData;
                    }
                },
            },
            { path : '/basicalgos', element: <BasicAlgos />,
                loader : async ({ request }) => {
                    const enabled = new URL(request.url).searchParams.get("enabled");
                    const response = await fetch(currentServerURL + `basicalgos?enabled=${enabled}`);

                    if (!response.ok){
                        console.log("error in the response.");
                        setError('soma : fetching the data failed .');
                    } else {
                        console.log("else ag fut.");
                        const resData = await response.json();
                        //this data will be auto enabled by router in component
                        console.log("resdata : "  + resData);
                        return resData;
                    }
                },
            },
            { path : '/javabasic', element: <JavaBasic />,
                loader : async ({ request }) => {
                    const enabled = new URL(request.url).searchParams.get("enabled");

                    const response = await fetch(currentServerURL + `basicjava?enabled=${enabled}`);

                    if (!response.ok){
                        console.log("error in the response.");
                        setError('soma : fetching the data failed .');
                    } else {
                        console.log("else ag fut.");
                        const resData = await response.json();
                        //this data will be auto enabled by router in component
                        console.log("resdata : "  + resData);
                        return resData;
                    }
                },
            },
            { path : '/load', element: <Load />,
                loader : async () => {
                    const response = await fetch(currentServerURL + 'jsontest');

                    if (!response.ok){
                        console.log("error in the response.");
                        setError('soma : fetching the data failed .');
                    } else {
                        console.log("else ag fut.");
                        const resData = await response.json();
                        //this data will be auto enabled by router in component
                        console.log("resdata : "  + resData);
                        return resData;
                    }
                },
            }
        ]
    }
], { basename: "/QA" });



function App(){
    return <RouterProvider router={router} />;
}



export default App;