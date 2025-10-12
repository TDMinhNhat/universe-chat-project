import {type JSX, useState} from "react";
import {Stack} from "@mui/material";
import ListChatComponent from "./private_group_chat/ListChatComponent.tsx";
import ChatMessageAreaComponent from "./private_group_chat/ChatMessageAreaComponent.tsx";
import ListRequestOptionComponent from "./request_box/ListRequestOptionComponent.tsx";
import RequestBoxAreaComponent from "./request_box/RequestBoxAreaComponent.tsx";

export default function ChatAreaContainerComponent({ menu }:{ menu: string }): JSX.Element {

    const [request, setRequest] = useState<string>("List Friends");

    function renderOption(menu: string): JSX.Element {
        switch (menu) {
            case "Private Chat": return (
                <>
                    <ListChatComponent />
                    <ChatMessageAreaComponent />
                </>
            );

            case "Request Box": return (
                <>
                    <ListRequestOptionComponent request={request} setRequest={setRequest} />
                    <RequestBoxAreaComponent request={request} />
                </>
            );

            default: return (
                <>
                    <ListChatComponent />
                    <ChatMessageAreaComponent />
                </>
            );
        }
    }

    return (
        <Stack className={"h-100 w-100"} direction={"row"}>
            { renderOption(menu) }
        </Stack>
    )
}