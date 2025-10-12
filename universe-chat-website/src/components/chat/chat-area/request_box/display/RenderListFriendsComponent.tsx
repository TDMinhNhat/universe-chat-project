import {type JSX, useState} from "react";
import {Box, MenuItem, Select, Stack, TextField, Typography} from "@mui/material";
import PersonIcon from '@mui/icons-material/Person';

export default function RenderListFriendsComponent(): JSX.Element {

    const [orderName, setOrderName] = useState<string>("ASC");
    const [orderCategory, setOrderCategory] = useState<string>("All");

    return (
        <Stack className={"h-100 ps-3 pt-3 pe-3"} direction={"column"} spacing={4}>
            <Box className={"d-flex flex-row align-items-center"}>
                <PersonIcon/>
                <Typography className={"ms-3"} variant={"h6"}>List friends</Typography>
            </Box>

            <Stack className={"w-100 h-100 bg-success ps-3 pt-3 pe-3"} direction={"column"} spacing={3}>
                <Box>
                    <Typography>Friends (100)</Typography>
                </Box>

                <Stack direction={"row"}>
                    <Box className={"d-flex flex-row align-items-center justify-content-between"}>
                        <TextField className={"flex-1"} size={"small"} variant={"outlined"} placeholder={"Search your friends"} slotProps={{
                            input: {
                                startAdornment: (
                                    <Box className={"me-2"}>
                                        🔍
                                    </Box>
                                )
                            }
                        }}/>

                        <Select
                            className={"ms-3"}
                            size={"small"}
                            value={orderName}
                            onChange={(event) => setOrderName(event.target.value)}
                        >
                            <MenuItem value={"ASC"}>Name (A - Z)</MenuItem>
                            <MenuItem value={"DESC"}>Name (Z - A)</MenuItem>
                        </Select>

                        <Select
                            className={"ms-3"}
                            size={"small"}
                            value={orderCategory}
                            onChange={(event) => setOrderCategory(event.target.value)}
                        >
                            <MenuItem value={"All"}>All Categories</MenuItem>
                        </Select>
                    </Box>

                    <Box>

                    </Box>
                </Stack>
            </Stack>
        </Stack>
    )
}