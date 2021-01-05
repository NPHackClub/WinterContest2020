import React from "react";
import { Home } from "./pages/Home";
// import { About } from "./pages/About";
import Terminal from "./pages/Terminal";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { NavigationBar } from "./components/NavigationBar";
import Sidebar from "./components/Sidebar";

function App() {
    return (
        <React.Fragment>
            <Router>
                <NavigationBar />
                <Sidebar />
                <Switch>
                    <Route path="/terminal" component={Terminal} />
                </Switch>
            </Router>
        </React.Fragment>
    );
}

export default App;
