import { type JSX } from "react";
import {Box, Stack, TextField, Typography} from "@mui/material";
import PersonIcon from '@mui/icons-material/Person';
import GroupsIcon from '@mui/icons-material/Groups';
import PersonAddIcon from '@mui/icons-material/PersonAdd';
import GroupAddIcon from '@mui/icons-material/GroupAdd';
import InputAdornment from '@mui/material/InputAdornment';
import SearchIcon from '@mui/icons-material/Search';

export default function ListRequestOptionComponent({ request, setRequest }:{ request: string, setRequest(request: string): void }): JSX.Element {

    function changeRequest(request: string): void {
        setRequest(request);
    }

    return (
        <Stack className={"w-25"} direction={"column"} sx={{
            borderRight: "1px solid",
        }}>
            <Stack className={"d-flex flex-row align-items-center p-3"} direction={"row"} sx={{
                borderBottom: "1px solid",
            }}>
                <Box>
                    <TextField placeholder={"Search"} variant={"outlined"} size={"small"} slotProps={{
                        input: {
                            startAdornment: (
                                <InputAdornment position={"start"}>
                                    <SearchIcon/>
                                </InputAdornment>
                            )
                        }
                    }}/>
                </Box>

                <Box className={"ms-4"} onClick={() => {}} sx={{
                    cursor: "pointer"
                }}>
                    <PersonAddIcon/>
                </Box>

                <Box className={"ms-4"} onClick={() => {}} sx={{
                    cursor: "pointer"
                }}>
                    <GroupAddIcon/>
                </Box>
            </Stack>
            <Stack direction={"column"}>
                <Box className={"p-3 d-flex flex-row align-items-center"} component={"div"} onClick={() => changeRequest("List Friends")} sx={{
                    backgroundColor: request === "List Friends" ? "aqua" : "white",
                    cursor: "pointer",
                    padding: "10px",
                }}>
                    <PersonIcon/>
                    <Typography className={"ms-3"}>List friends</Typography>
                </Box>

                <Box className={"p-3 d-flex flex-row align-items-center"} component={"div"} onClick={() => changeRequest("List Groups")} sx={{
                    backgroundColor: request === "List Groups" ? "aqua" : "white",
                    cursor: "pointer",
                    padding: "10px",
                }}>
                    <GroupsIcon/>
                    <Typography className={"ms-3"}>List groups</Typography>
                </Box>

                <Box className={"p-3 d-flex flex-row align-items-center"} component={"div"} onClick={() => changeRequest("Friends Request")} sx={{
                    backgroundColor: request === "Friends Request" ? "aqua" : "white",
                    cursor: "pointer",
                    padding: "10px",
                }}>
                    <PersonAddIcon/>
                    <Typography className={"ms-3"}>List friends request</Typography>
                </Box>

                <Box className={"p-3 d-flex flex-row align-items-center"} component={"div"} onClick={() => changeRequest("Groups Request")} sx={{
                    backgroundColor: request === "Groups Request" ? "aqua" : "white",
                    cursor: "pointer",
                    padding: "10px",
                }}>
                    <GroupAddIcon/>
                    <Typography className={"ms-3"}>List groups request</Typography>
                </Box>
            </Stack>
        </Stack>
    )
}