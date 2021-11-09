import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import { BrowserRouter, Switch, Route } from "react-router-dom";

const Routes = () => {
    //14 min
    return (
        <BrowserRouter>
            <Switch>
                <Route path = "/" exact>
                    <Home />
                </Route>
                <Route path = "/dashboard" exact>
                    <Dashboard />
                </Route>
            </Switch>           
        </BrowserRouter>
    );
}

export default Routes;