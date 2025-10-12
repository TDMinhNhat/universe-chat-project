import {type JSX, useState} from "react";
import {Stack} from "@mui/material";
import TabOptionComponent from "../components/chat/TabOptionComponent.tsx";
import ChatAreaComponent from "../components/chat/ChatAreaComponent.tsx";

export default function ChatPage(): JSX.Element {

    const [menu, setMenu] = useState<string>("Private Chat")

    return (
        <Stack className={"container-fluid position-fixed fixed-top fixed-bottom m-0 p-0"} component={"div"} direction={"row"}>
            <TabOptionComponent menu={menu} setMenu={setMenu} />

            <ChatAreaComponent menu={menu}/>
        </Stack>
    )
}