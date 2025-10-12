import { type JSX } from "react";
import {Avatar, Box, Stack} from "@mui/material";
import ChatIcon from '@mui/icons-material/Chat'
import SettingsIcon from '@mui/icons-material/Settings';
import PeopleIcon from '@mui/icons-material/People';

export default function TabOptionComponent({ menu, setMenu }:{ menu: string, setMenu: (menu: string) => void }): JSX.Element {

    function changeMenuOption(option: string): void {
        setMenu(option);
    }

    return (
        <Stack className={"h-100 d-flex flex-column align-items-center justify-content-between bg-warning p-3"} direction={"column"} sx={{
            width: "50px",
        }}>
            <Stack direction={"column"} spacing={4}>
                <Box sx={{
                    cursor: "pointer",
                }}>
                    <Avatar />
                </Box>

                <Stack direction={"column"} spacing={1}>
                    {/* Private Chat Option */}
                    <Box onClick={() => changeMenuOption("Private Chat")} sx={{
                        backgroundColor: menu === "Private Chat" ? "lightgray" : "transparent",
                        borderRadius: "8px",
                        padding: "8px",
                        cursor: "pointer",
                    }}>
                        <ChatIcon />
                    </Box>

                    {/* Request Box Option */}
                    <Box onClick={() => changeMenuOption("Request Box")} sx={{
                        backgroundColor: menu === "Request Box" ? "lightgray" : "transparent",
                        borderRadius: "8px",
                        padding: "8px",
                        cursor: "pointer",
                    }}>
                        <PeopleIcon />
                    </Box>
                </Stack>
            </Stack>

            <Stack direction={"column"}>
                {/* Setting */}
                <Box sx={{
                    cursor: "pointer",
                }}>
                    <SettingsIcon />
                </Box>
            </Stack>
        </Stack>
    )
}