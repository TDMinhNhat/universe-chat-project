import { type JSX} from "react";
import {Box} from "@mui/material";
import ChatAreaContainerComponent from "./chat-area/ChatAreaContainerComponent.tsx";

export default function ChatAreaComponent({ menu }:{ menu: string }): JSX.Element {
    return (
        <Box className={"container-fluid w-100 h-100 p-0"} component={"div"}>
            <ChatAreaContainerComponent menu={menu}/>
        </Box>
    )
}