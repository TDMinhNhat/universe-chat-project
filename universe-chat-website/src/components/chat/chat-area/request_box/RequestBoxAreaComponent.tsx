import { type JSX } from "react";
import RenderListFriendsComponent from "./display/RenderListFriendsComponent.tsx";
import RenderListGroupsComponent from "./display/RenderListGroupsComponent.tsx";
import RenderRequestFriendsComponent from "./display/RenderRequestFriendsComponent.tsx";
import RenderRequestGroupsComponent from "./display/RenderRequestGroupsComponent.tsx";
import {Box} from "@mui/material";

export default function RequestBoxAreaComponent({ request }:{ request: string }): JSX.Element {

    function renderRequestBoxArea(request: string): JSX.Element {
        switch (request) {
            case "List Friends": return (
                <RenderListFriendsComponent />
            );

            case "List Groups": return (
                <RenderListGroupsComponent />
            );

            case "Request Friends": return (
                <RenderRequestFriendsComponent />
            );

            case "Request Groups": return (
                <RenderRequestGroupsComponent />
            )

            default: return (
                <RenderListFriendsComponent />
            )
        }
    }

    return (
        <Box className={"container-fluid w-100 h-100 p-0"}>
            { renderRequestBoxArea(request) }
        </Box>
    )
}