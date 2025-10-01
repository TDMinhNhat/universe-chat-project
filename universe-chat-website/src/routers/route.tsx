import { createBrowserRouter } from "react-router";
import HomePage from "../pages/HomePage";
import ChatPage from "../pages/ChatPage";
import AuthenPage from "../pages/AuthenPage";
import AdminPage from "../pages/AdminPage";

const route = createBrowserRouter([
    {
        path: "/",
        Component: HomePage
    },
    {
        path: "/authen",
        Component: AuthenPage
    },
    {
        path: "/admin",
        Component: AdminPage
    },
    {
        path: "/chat",
        Component: ChatPage
    }
]);

export default route;