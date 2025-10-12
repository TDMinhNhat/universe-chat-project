import { type JSX} from "react";
import {Box} from "@mui/material";
import ChatAreaContainerComponent from "./chat-area/ChatAreaContainerComponent.tsx";

export default function ChatAreaComponent({ menu }:{ menu: string }): JSX.Element {
    return (
        <Box component={"div"}>
            <ChatAreaContainerComponent menu={menu}/>
        </Box>
    )
}